package compiler.tree.comando;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;
import compiler.tree.expressao.Expressao;

public class Iteracao implements Comando {

	private Expressao expressao;
	private Comando comando;

	public Iteracao(Expressao expressao, Comando comando) {
		this.expressao = expressao;
		this.comando = comando;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean retornoIteracao = false;
		if (expressao.getTipo(tabela) == Tipo.BOOLEAN){
			retornoIteracao = true;
		}
		return retornoIteracao;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolos tabelaLocal) throws LeituraException {
		return null; 
	}

}
