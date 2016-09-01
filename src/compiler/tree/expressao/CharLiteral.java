package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class CharLiteral implements Expressao {
	private String charLiteral;

	public CharLiteral(String charLiteral) {
		this.charLiteral = charLiteral;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) {
		boolean charLiteralOK = false;
		if (charLiteral.length() == 1){
			charLiteralOK = true;
		}
		return charLiteralOK;
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
