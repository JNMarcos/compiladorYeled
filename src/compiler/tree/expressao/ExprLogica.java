package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class ExprLogica implements Expressao {
	public Expressao exp1;
	public Expressao exp2;
	public String operLogico;

	public ExprLogica(Expressao e1, Expressao e2, String oper) {
		this.exp1 = e1;
		this.exp2 = e2;
		this.operLogico = oper;
	}
	
	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean retornoLogicaOK = false;
		if (operLogico == "and" || operLogico == "or"){
			if (exp1.getTipo(tabela) == Tipo.BOOLEAN && exp2.getTipo(tabela) == Tipo.BOOLEAN){
				retornoLogicaOK = true;
			} else {
				throw new ErroCompiladorException("Não é um tipo boolean um dos argumentos.");
			}
		}
		return retornoLogicaOK;
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
		return "" + operLogico;
	}

}
