package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class FloatLiteral implements Expressao {
	private Float floatLiteral;

	public FloatLiteral(Float floatLiteral) {
		this.floatLiteral = floatLiteral;
	}

	
	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) {
		boolean floatLiteralOK = true;
		if (floatLiteral == null){
			floatLiteralOK = false;
		}
		return floatLiteralOK;
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
