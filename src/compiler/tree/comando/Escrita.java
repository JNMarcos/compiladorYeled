package compiler.tree.comando;

import java.util.List;

import compiler.tree.expressao.Expressao;

public class Escrita implements Comando {
	private List<Expressao> expressao;

	public Escrita(List<Expressao> expressao) {
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
