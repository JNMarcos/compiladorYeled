package compiler.tree.comando;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.expressao.Expressao;

public class Retorno implements Comando {
	private Expressao expressao;

	public Retorno(Expressao expr) {
		this.expressao = expr;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) {
		return null;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolos tabelaLocal) throws LeituraException {
		// TODO Auto-generated method stub
		return null;
	}

}
