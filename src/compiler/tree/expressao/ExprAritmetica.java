package compiler.tree.expressao;

import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
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
