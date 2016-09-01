package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class ExprUnaria implements Expressao {
	private Expressao expr;
	private String operacao;

	public ExprUnaria(String operacao, Expressao expr) {
		this.operacao = operacao;
		this.expr = expr;
	}

	
	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean exprUnaria = true;
		switch (operacao){
		case "not":
			if (expr.getTipo(tabela) != Tipo.BOOLEAN){
				exprUnaria = false;
				throw new ErroCompiladorException("Não é do tipo boolean a expressão " + expr);
			}
			break;
		case "-":
			//quer dizer que nem é int nem float
			if (expr.getTipo(tabela) != Tipo.INT && expr.getTipo(tabela) != Tipo.FLOAT){
				exprUnaria = false;
				throw new ErroCompiladorException("Não é do tipo boolean a expressão " + expr);
			}
		}
		return exprUnaria;
	}
	
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
		return operacao + " " + expr;
	}
}