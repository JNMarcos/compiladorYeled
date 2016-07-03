/**
 * 
 */
package compiler.syntax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java_cup.runtime.Symbol;
import java_cup.runtime.Scanner;

/**
 * @author JN
 *
 */
public class Lexer implements Scanner {
	private InputStream input;
	private int nextChar;
	private Hashtable<String, Integer> palavras_reservadas;

	//iniciand o lexer com as palavras-chaves reconhecidas
	// pelo compilador e nextChar = -1
	public Lexer(FileInputStream arquivo){
		this.nextChar = -1;
		
		palavras_reservadas = new Hashtable<>();
		palavras_reservadas.put("if", sym.SE);
		palavras_reservadas.put("then", sym.ENTAO);
		palavras_reservadas.put("else", sym.SENAO);
		palavras_reservadas.put("while", sym.ENQUANTO);
		palavras_reservadas.put("return", sym.RETORNAR);
		palavras_reservadas.put("void", sym.VOID);
		palavras_reservadas.put("prnt", sym.PRINTAR);
		palavras_reservadas.put("char", sym.CARACTERE);
		palavras_reservadas.put("float", sym.PONTO_FLUTUANTE);
		palavras_reservadas.put("int", sym.INTEIRO);
		palavras_reservadas.put("and", sym.E);
		palavras_reservadas.put("or", sym.OU);
		palavras_reservadas.put("not", sym.NAO);
		
		try {
			this.reset(arquivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reset(InputStream in) throws Exception {
		try {
			// contem o codigo fonte a ser analisado
			this.input = in;
			// anda para o primeiro byte da entrada 
			this.nextChar = in.read();

		} catch (IOException e) {
			throw new LeituraException(e.getMessage());
		}
	}

	private int readByte() throws LeituraException {
		int theByte;

		try {
			theByte = input.read();
		} catch (IOException e) {
			throw new LeituraException(e.getMessage());
		}

		return theByte;
	}

	public Symbol next_token() throws LeituraException {
		StringBuilder lexema = new StringBuilder();
		int tipo = -1;

		while (this.nextChar == ' ' || this.nextChar == '\n' || this.nextChar == '\t'
				|| this.nextChar == '\r'){
			this.nextChar = readByte();
		}

		if (this.nextChar == -1) {
			return new Symbol(sym.EOF);
		}

		if (Character.isLetter(nextChar)) {
			do {
				lexema.append((char)nextChar);
				nextChar = this.readByte();
			} while (Character.isLetter(nextChar));

			if (palavras_reservadas.containsKey(lexema)) {
				tipo = palavras_reservadas.get(lexema);
			} else {
				tipo = sym.IDENTIFICADOR;
			}
		} else if (Character.isDigit(nextChar)){
			do {
				lexema.append((char)nextChar);
				nextChar = this.readByte();
			} while (Character.isDigit(nextChar));

			if (nextChar == '.'){
				tipo = sym.PONTO_FLUTUANTE;
				do {
					lexema.append((char)nextChar);
					nextChar = this.readByte();
				} while (Character.isDigit(nextChar));
			} else if (nextChar == ' '){
				tipo = sym.INTEIRO;
			} else {
				throw new LeituraException("Caracter inesperado: " + (char)nextChar);
			}
		} else{


			switch(nextChar){
			case '.':
				tipo = sym.PONTO_FLUTUANTE;
				do {
					lexema.append((char)nextChar);
					nextChar = this.readByte();
				} while (Character.isDigit(nextChar));
				break;

			case '\'':
				tipo = sym.CARACTERE;
				lexema.append((char)nextChar);
				nextChar = this.readByte();
				if (Character.isDigit(nextChar) ||
						Character.isLetter(nextChar) ||
						Character.isWhitespace(nextChar) ||
						nextChar == '(' || nextChar == ')' ||
						nextChar == ':' || nextChar == ',') {
					lexema.append((char)nextChar);
					nextChar = this.readByte();

					if (nextChar != '\''){
						throw new LeituraException("Caracter inesperado: " + (char)nextChar);
					}

				} else if (nextChar == '\\'){
					lexema.append((char)nextChar);
					nextChar = this.readByte();
					// o r é para ter?
					if (nextChar == 'n' || nextChar == 't'){
						lexema.append((char)nextChar);
						nextChar = this.readByte();

						if (nextChar != '\''){
							throw new LeituraException("Caracter inesperado: " + (char)nextChar);
						}
					} else {
						throw new LeituraException("Caracter inesperado: " + (char)nextChar);
					}				
				}
				break;

			case ';':
				tipo = sym.PONTO_VIRGULA;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case ':':
				tipo = sym.DOIS_PONTOS;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case ',':
				tipo = sym.VIRGULA;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '(':
				tipo = sym.ABRE_PARENTESE;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case ')':
				tipo = sym.FECHA_PARENTESE;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;
				
			case '{':
				tipo = sym.ABRE_CHAVE;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '}':
				tipo = sym.FECHA_CHAVE;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '+':
				tipo = sym.MAIS;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '-':
				tipo = sym.MENOS;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '*':
				tipo = sym.VEZES;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '/':
				tipo = sym.DIVIDIDO;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '%':
				tipo = sym.RESTO;
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				break;

			case '>':
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				if (this.nextChar == '='){
					lexema.append((char)nextChar);
					tipo = sym.MAIOR_OU_IGUAL_QUE;
					this.nextChar = readByte();
				} else {
					//não passa para o próximo token pois já passou lá em cima
					tipo = sym.MAIOR_QUE; 
				}	
				break;

			case '<':
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				if (this.nextChar == '='){
					lexema.append((char)nextChar);
					tipo = sym.MENOR_OU_IGUAL_QUE;
					this.nextChar = readByte();
				} else {
					//não passa para o próximo token pois já passou lá em cima
					tipo = sym.MENOR_QUE; 
				}	
				break;

			case '=':
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				if (this.nextChar == '='){
					lexema.append((char)nextChar);
					tipo = sym.IGUAL;
					this.nextChar = readByte();
				} else {
					//não passa para o próximo token pois já passou lá em cima
					tipo = sym.ATRIBUICAO; 
				}	
				break;

			case '!':
				lexema.append((char)nextChar);
				this.nextChar = readByte();
				if (this.nextChar == '='){
					lexema.append((char)nextChar);
					tipo = sym.DIFERENTE;
					this.nextChar = readByte();
				} else {
					//deveria retornar uma exceção pois se vier qualquer outro símbolo
					// ou caractere em branco está incorreto
				}	
				break;
				
			default:
				throw new LeituraException("Caracter inesperado: " + (char)nextChar);
			}
		}
		return new Symbol(tipo, lexema.toString());
	}
}
