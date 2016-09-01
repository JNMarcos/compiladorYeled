package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class StringLiteral implements Expressao {

	private String stringLiteral;

	public StringLiteral(String stringLiteral) {
		this.stringLiteral = stringLiteral;

	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) {
		boolean stringLiteralOK = true;
		if (stringLiteral == null){
			stringLiteralOK = false;
		}
		return stringLiteralOK;
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
}