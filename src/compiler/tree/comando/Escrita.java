package compiler.tree.comando;

import java.util.List;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;
import compiler.tree.expressao.Expressao;

public class Escrita implements Comando {
	private List<Expressao> expressao;

	public Escrita(List<Expressao> expressao) {
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean escritaOK = true;
		for (int i = 0; i < expressao.size(); i++){
				if (expressao.get(i).getTipo(tabela) == Tipo.NULL){
					escritaOK = false;
					throw new ErroCompiladorException("O comando de escrita está errado.");
				}	
		}
		return escritaOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return expressao.toString();
	}
}
