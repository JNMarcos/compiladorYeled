package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
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
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean exprRelacionalOK = true;
		switch (operador){
		case ">":
		case "<":
		case ">=":
		case "<=":
			if ((expr1.getTipo(tabela) == Tipo.INT && expr2.getTipo(tabela) == Tipo.FLOAT)
					|| (expr1.getTipo(tabela) == Tipo.FLOAT && expr2.getTipo(tabela) == Tipo.INT)){
				exprRelacionalOK = false;
				throw new LeituraException("Os tipos das variáveis na expressão relacional " +
				expr1 + "  " + operador + "  " + expr2 + " são diferentes.");
			}
			break;
		case "==":
		case "!=":
			if (expr1.getTipo(tabela) != expr2.getTipo(tabela)){
				exprRelacionalOK = false;
				throw new LeituraException("Os tipos das variáveis na expressão relacional " +
				expr1 + "  " + operador + "  " + expr2 + " são diferentes.");
			}
		}
		return exprRelacionalOK;
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
