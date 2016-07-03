package compiler.tree.expressao;

import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;

public class FloatLiteral implements Expressao {
	private Float floatLiteral;

	public FloatLiteral(Float floatLiteral) {
		this.floatLiteral = floatLiteral;
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
