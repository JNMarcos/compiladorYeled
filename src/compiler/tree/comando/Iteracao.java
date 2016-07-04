package compiler.tree.comando;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;
import compiler.tree.expressao.Expressao;

public class Iteracao implements Comando {

	private Expressao expressao;
	private Comando comando;

	public Iteracao(Expressao expressao, Comando comando) {
		this.expressao = expressao;
		this.comando = comando;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean iteracaoOK = false;
		if (expressao.getTipo(tabela) == Tipo.BOOLEAN){
			iteracaoOK = true;
		}
		return iteracaoOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
