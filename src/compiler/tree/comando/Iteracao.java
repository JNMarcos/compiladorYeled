package compiler.tree.comando;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;
import compiler.tree.expressao.ExprLogica;
import compiler.tree.expressao.ExprRelacional;
import compiler.tree.expressao.Expressao;

public class Iteracao implements Comando {

	private Expressao expressao;
	private Comando comando;

	public Iteracao(Expressao expressao, Comando comando) {
		this.expressao = expressao;
		this.comando = comando;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean iteracaoOK = false;
		if (expressao.getTipo(tabela) == Tipo.BOOLEAN){
			iteracaoOK = true;
		}
		return iteracaoOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		boolean x;
		ExprLogica expr;
		if (expressao instanceof ExprRelacional){
			x = ((ExprRelacional) expressao).expr1.toString(); ((ExprRelacional) expressao).operador
		} 
		
		if 
		labelInicio:
			x = (ExprLogica)expressao expressao.expr1
			if 
		labelResto:
		return null;
	}
}
