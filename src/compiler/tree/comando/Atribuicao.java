package compiler.tree.comando;

import compiler.semantica.InfoSimbolo;
import compiler.semantica.InfoVariavel;
import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.expressao.Expressao;

public class Atribuicao implements Comando {
	private String identificador;
	private Expressao expressao;

	public Atribuicao(String ident, Expressao expressao) {
		this.identificador = ident;
		this.expressao = expressao;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean atribuicaoOK = false;
		InfoSimbolo info = tabela.buscarSimbolo(identificador);
		if (info != null && info instanceof InfoVariavel){
			if (((InfoVariavel) info).getTipo() == this.expressao.getTipo(tabela)) {
				atribuicaoOK = true;
			} else { 
				atribuicaoOK = false;
				throw new ErroCompiladorException("Tipo incorreto!"); 
			} 
		} else {
			atribuicaoOK = false;
			throw new ErroCompiladorException("Tipo incorreto!"); 
		}
		return atribuicaoOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		_t1 : expressao.toString();
		_t2 : (ExprLogica) expressao;
		identificador : _t1;
		return null;
	}
}
