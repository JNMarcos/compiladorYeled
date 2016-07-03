package compiler.tree;

import java.util.LinkedList;

import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.comando.DeclVariavel;

public class Programa {
	private LinkedList<DeclGlobal> declaracoes;
	private TabelaSimbolosGeral tabela;

	public Programa() {
		declaracoes = new LinkedList<DeclGlobal>();
		tabela = new TabelaSimbolosGeral();
	}

	public void addLast(DeclGlobal dec) {
		this.declaracoes.addLast(dec);
	}
	
	public Boolean verificarSemantica() throws LeituraException{
		boolean retorno = false;
		for (int i = 0; i < declaracoes.size(); i++){
			if (declaracoes.get(i) instanceof DeclFuncao){
				retorno = declaracoes.get(i).verificarSemantica(tabela);
				if (retorno == false){
					break;
				}
			}
			
			if (declaracoes.get(i) instanceof DeclVariavel){
				retorno = declaracoes.get(i).verificarSemantica(tabela);
				if (retorno == false){
					break;
				}
			}
		}
		return retorno;
	}
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}