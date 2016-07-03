package compiler.tree.expressao;

import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;

public class ExprUnaria implements Expressao {
	private Expressao expr;
	private String operacao;

	public ExprUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	
	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) {
		return null;
	}
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}


	@Override
	public Tipo getTipo(TabelaSimbolosGeral tabela) throws LeituraException {
		// TODO Auto-generated method stub
		return null;
	}
}