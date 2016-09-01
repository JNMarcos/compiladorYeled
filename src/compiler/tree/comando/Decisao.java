package compiler.tree.comando;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;
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
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean decisaoOK = false;
		if (expressao.getTipo(tabela) == Tipo.BOOLEAN){
			decisaoOK = comandoIf.verificarSemantica(tabela);
			// se há um else
			if (comandoElse != null){
				decisaoOK = comandoElse.verificarSemantica(tabela);
			}
		} else {
			decisaoOK = false;
			throw new ErroCompiladorException("A " + expressao + " não é do tipo boolean.");
		}
		return decisaoOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
