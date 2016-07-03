package compiler.tree.expressao;

import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;

public class ExprRelacional implements Expressao {

	private Expressao expr1;
	private Expressao expr2;
	private String operador;

	public ExprRelacional(Expressao expr1, Expressao expr2, String operador) {
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operador = operador;
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
	public Tipo getTipo(TabelaSimbolosGeral tabela) throws LeituraException {
		// TODO Auto-generated method stub
		return null;
	}

}
