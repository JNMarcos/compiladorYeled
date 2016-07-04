package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;

public class IntLiteral implements Expressao {
	private Integer intLiteral;

	public IntLiteral(Integer intLiteral) {
		this.intLiteral = intLiteral;
	}
	
	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) {
		boolean intLiteralOK = true;
		if (intLiteral == null){
			intLiteralOK = false;
		}
		return intLiteralOK;
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
