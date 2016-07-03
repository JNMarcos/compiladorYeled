package compiler.tree.comando;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;
import compiler.tree.expressao.Expressao;

public class Atribuicao implements Comando {
	private String identificador;
	private Expressao expressao;

	public Atribuicao(String ident, Expressao expressao) {
		this.identificador = ident;
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		if (tabela.buscarSimbolo2(identificador) 
				== this.expressao.getTipo(tabela)) { 
		} else { 
				throw new LeituraException("Tipo incorreto!"); 
		} 

		return null;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolos tabelaLocal) throws LeituraException {
		// TODO Auto-generated method stub
		if (tabelaSimbolos.buscarTabelaLocal(identificador) 
				== this.expressao.getTipo(tabela)) { 
		} else { 
			verif = false; 
			throw new CompiladorException("Tipo incorreto!"); 
		} 
		return null;
	}

}
