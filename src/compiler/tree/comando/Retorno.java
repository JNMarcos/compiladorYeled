package compiler.tree.comando;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;
import compiler.tree.expressao.Expressao;

public class Retorno implements Comando {
	private Expressao expressao;

	public Retorno(Expressao expr) {
		this.expressao = expr;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean retornoOK = true;
		Tipo tipo = expressao.getTipo(tabela);
		if (tipo == Tipo.NULL){
			retornoOK = false;
			throw new ErroCompiladorException("Tipo do retorno está null!");
		}
		return retornoOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return expressao.toString();
	}
}
