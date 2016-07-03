package compiler.tree;

import java.util.LinkedList;

import Semantica.InfoFuncao;
import Semantica.InfoSimbolo;
import Semantica.InfoVariavel;
import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.comando.DeclVariavel;

public class Assinatura {
	private LinkedList<DeclVariavel> paramFormais;
	private Tipo tipo;
	private String identificador;

	public Assinatura(String identificador,
			LinkedList<DeclVariavel> paramFormais, Tipo tipo) {
		this.paramFormais = paramFormais;
		this.tipo = tipo;
		this.identificador = identificador;
	}

	public Assinatura(String identificador, LinkedList<DeclVariavel> paramFormais) {
		this.paramFormais = paramFormais;
		this.identificador = identificador;
	}

	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean retornoEscopoGlobal = false;
		boolean retornoEscopoLocal = false;
		InfoVariavel infoV;
		TabelaSimbolos tabelaLocal = new TabelaSimbolos();
		LinkedList<InfoSimbolo> simbolos = new LinkedList<>();
		
		InfoFuncao info;

		for (int i = 0; i < paramFormais.size(); i++){
			infoV = new InfoVariavel(paramFormais.get(i).getTipo());
				simbolos.add(infoV);
		}
		
		for (int i = 0; i < simbolos.size(); i++){
			for (int j = 0; j < paramFormais.get(i).getIdents().size(); j++){
				retornoEscopoGlobal = tabela.verificarExistenciaSimbolo(identificador);
				
				if (retornoEscopoGlobal == false){
					//verifica se par�metro existe
					retornoEscopoLocal = this.paramFormais.get(i).verificarSemantica(tabelaLocal);
							
							//tabelaLocal.adicionarSimbolo(paramFormais.get(i).getIdents().get(j),
							//simbolos.get(i));
					if (retornoEscopoLocal == false) {//param j� existe
						throw new LeituraException("Par�metro " + paramFormais.get(i).getIdents().
								get(j) + " j� existe.");
					}
				} else {
					throw new LeituraException("A assinatura de m�todo " + this.identificador 
							+  " j� existe.");
				}
			}
		}
		
		info = new InfoFuncao(tipo, simbolos);
		
		//adiciona a fun��o na tabela de s�mbolo local
		tabelaLocal.adicionarSimbolo(identificador, info);
		tabela.adicionarTabelaSimbolos(tabelaLocal);
		
		return retornoEscopoGlobal && retornoEscopoLocal;
	}

	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
