package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class ExprRelacional implements Expressao {

	public Expressao expr1;
	public Expressao expr2;
	public String operador;

	public ExprRelacional(Expressao expr1, Expressao expr2, String operador) {
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operador = operador;
	}
	
	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean exprRelacionalOK = true;
		switch (operador){
		case ">":
		case "<":
		case ">=":
		case "<=":
			if ((expr1.getTipo(tabela) == Tipo.INT && expr2.getTipo(tabela) == Tipo.FLOAT)
					|| (expr1.getTipo(tabela) == Tipo.FLOAT && expr2.getTipo(tabela) == Tipo.INT)){
				exprRelacionalOK = false;
				throw new ErroCompiladorException("Os tipos das variáveis na expressão relacional " +
				expr1 + "  " + operador + "  " + expr2 + " são diferentes.");
			}
			break;
		case "==":
		case "!=":
			if (expr1.getTipo(tabela) != expr2.getTipo(tabela)){
				exprRelacionalOK = false;
				throw new ErroCompiladorException("Os tipos das variáveis na expressão relacional " +
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
	public Tipo getTipo(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return expr1 + " " + operador + " " + expr2;
	}

}
