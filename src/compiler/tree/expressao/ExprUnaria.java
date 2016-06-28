package compiler.tree.expressao;

import compiler.tree.Tipo;

public class ExprUnaria implements Expressao {
	private Expressao expr;
	private String operacao;

	public ExprUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	
	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public Tipo getTipo() {
		return null;
	}
	
	
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}