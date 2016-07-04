package compiler.tree;

import java.util.LinkedList;

import compiler.semantica.InfoFuncao;
import compiler.semantica.InfoSimbolo;
import compiler.semantica.InfoVariavel;
import compiler.semantica.TabelaSimbolos;
import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.comando.DeclVariavel;

public class Assinatura {
	private ParamFormais paramFormais;
	private Tipo tipo;
	private String identificador;

	public Assinatura(String identificador,
			ParamFormais paramFormais, Tipo tipo) {
		this.paramFormais = paramFormais;
		this.tipo = tipo;
		this.identificador = identificador;
	}

	public Assinatura(String identificador, ParamFormais paramFormais) {
		this.paramFormais = paramFormais;
		this.identificador = identificador;
	}

	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean retornoEscopoGlobal = false;
		boolean retornoEscopoLocal = false;
		InfoVariavel infoV;
		TabelaSimbolos tabelaLocal = new TabelaSimbolos();
		LinkedList<InfoSimbolo> simbolos = new LinkedList<InfoSimbolo>();
		
		InfoFuncao info;

		for (int i = 0; i < paramFormais.getParamFormais().size(); i++){
			infoV = new InfoVariavel(paramFormais.getParamFormais().get(i).getTipo());
				simbolos.add(infoV);
		}
		
		for (int i = 0; i < simbolos.size(); i++){
			for (int j = 0; j < paramFormais.getParamFormais().get(i).getIdents().size(); j++){
				//verifica apenas no escopo global
				retornoEscopoGlobal = tabela.verificarExistenciaSimbolo(identificador);
				
				if (retornoEscopoGlobal == false){
					//verifica se parâmetro existe
					retornoEscopoLocal = this.paramFormais.verificarSemantica(tabela, tabelaLocal);
							
							//tabelaLocal.adicionarSimbolo(paramFormais.get(i).getIdents().get(j),
							//simbolos.get(i));
					if (retornoEscopoLocal == false) {//param já existe
						throw new LeituraException("Parâmetro " + paramFormais.getParamFormais().get(i).getIdents().
								get(j) + " já existe.");
					}
				} else {
					throw new LeituraException("A assinatura de método " + this.identificador 
							+  " já existe.");
				}
			}
		}
		
		info = new InfoFuncao(tipo, simbolos);
		
		//adiciona a função na tabela de símbolo local
		tabelaLocal.adicionarSimbolo(identificador, info);
		tabela.adicionarTabelaSimbolos(tabelaLocal);
		
		return retornoEscopoGlobal && retornoEscopoLocal;
	}

	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
