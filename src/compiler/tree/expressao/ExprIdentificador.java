package compiler.tree.expressao;

import compiler.semantica.InfoSimbolo;
import compiler.semantica.InfoVariavel;
import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public class ExprIdentificador implements Expressao {
	private String identificador;

	public ExprIdentificador(String identificador) {
		this.identificador = identificador;
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
	public Tipo getTipo(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		Tipo tipoRetorno = Tipo.NULL; 
		InfoSimbolo info;
		
		if(tabela.verificarExistenciaSimboloTodasTabelas(identificador)){// se existe é global
			info = tabela.buscarSimbolo(identificador);
			if (info instanceof InfoVariavel){
				tipoRetorno = ((InfoVariavel) info).getTipo();
			}
		}else if(tabela.verificarExistenciaSimboloTodasTabelas(identificador)){ 
			info = tabela.buscarSimbolo(identificador);
			if (info instanceof InfoVariavel){
				tipoRetorno = ((InfoVariavel) info).getTipo();
			}
		}else{ 
			throw new ErroCompiladorException("O identificador " + identificador + " não existe!"); 
		} 
		return tipoRetorno; 
	}

	@Override
	public String toString() {
		return identificador;
	}
}
