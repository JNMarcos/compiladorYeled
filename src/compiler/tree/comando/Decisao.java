package compiler.tree.comando;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.expressao.Expressao;

public class Decisao implements Comando {
	private Expressao expressao;
	private Comando comandoIf;
	private Comando comandoElse;

	/**
	 * Construtor para if-else completo.
	 */
	public Decisao(Expressao expr, Comando cmdIf, Comando cmdElse) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
		this.comandoElse = cmdElse;
	}

	/**
	 * Construtor para if sem else.
	 */
	public Decisao(Expressao expr, Comando cmdIf) {
		this.expressao = expr;
		this.comandoIf = cmdIf;
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
