package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
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
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean exprUnaria = true;
		switch (operacao){
		case "not":
			if (expr.getTipo(tabela) != Tipo.BOOLEAN){
				exprUnaria = false;
				throw new LeituraException("N�o � do tipo boolean a express�o " + expr);
			}
			break;
		case "-":
			//quer dizer que nem � int nem float
			if (expr.getTipo(tabela) != Tipo.INT && expr.getTipo(tabela) != Tipo.FLOAT){
				exprUnaria = false;
				throw new LeituraException("N�o � do tipo boolean a express�o " + expr);
			}
		}
		return exprUnaria;
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