package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;

public class ExprLogica implements Expressao {
	private Expressao exp1;
	private Expressao exp2;
	private String operLogico;

	public ExprLogica(Expressao e1, Expressao e2, String oper) {
		this.exp1 = e1;
		this.exp2 = e2;
		this.operLogico = oper;
	}
	
	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean retornoLogicaOK = false;
		if (operLogico == "and" || operLogico == "or"){
			if (exp1.getTipo(tabela) == Tipo.BOOLEAN && exp2.getTipo(tabela) == Tipo.BOOLEAN){
				retornoLogicaOK = true;
			} else {
				throw new LeituraException("Não é um tipo boolean um dos argumentos.");
			}
		}
		return retornoLogicaOK;
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
