package compiler.tree.comando;

import compiler.tree.Tipo;
import compiler.tree.expressao.Expressao;

public class Escrita implements Comando {
	private Expressao expressao;

	public Escrita(Expressao expressao) {
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica() {
		return null;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
