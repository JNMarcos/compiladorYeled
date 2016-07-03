package compiler.tree.comando;

import java.util.List;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.expressao.Expressao;

public class Escrita implements Comando {
	private List<Expressao> expressao;

	public Escrita(List<Expressao> expressao) {
		this.expressao = expressao;
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
	public Boolean verificarSemantica(TabelaSimbolos tabelaLocal) throws LeituraException {
		// TODO Auto-generated method stub
		return null;
	}
}
