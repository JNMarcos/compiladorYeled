package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class ExprAritmetica implements Expressao {

	private Expressao exp1;
	private Expressao exp2;
	private String operacao;

	public ExprAritmetica(Expressao exp1, Expressao exp2, String operacao) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operacao = operacao;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean exprAritmOK = true;
		switch(operacao){
		case "+":
		case "-":
		case "*":
		case "/":
			if (exp1.getTipo(tabela) != exp2.getTipo(tabela)){
				exprAritmOK = false;
				throw new ErroCompiladorException("Os tipos da(s) variável(is) é diferente de inteiro. "
						+ exp1 + "  " + operacao + "  " + exp2);	
			}
			break;
		case "%":
			if (exp1.getTipo(tabela) != Tipo.INT && exp2.getTipo(tabela) != Tipo.INT){
				exprAritmOK = false;
				throw new ErroCompiladorException("Os tipos da(s) variável(is) é diferente de inteiro. "
						+ exp1 + "  " + operacao + "  " + exp2);
			}
			break;
		}
		return exprAritmOK;
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
		// TODO Auto-generated method stub
		return exp1 + " " + operacao + " " + exp2 ;
	}

}
