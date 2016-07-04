package compiler.tree.comando;

import java.util.List;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;
import compiler.tree.expressao.Expressao;

public class Escrita implements Comando {
	private List<Expressao> expressao;

	public Escrita(List<Expressao> expressao) {
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean escritaOK = true;
		for (int i = 0; i < expressao.size(); i++){
				if (expressao.get(i).getTipo(tabela) == Tipo.NULL){
					escritaOK = false;
					throw new LeituraException("O comando de escrita está errado.");
				}	
		}
		return escritaOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
