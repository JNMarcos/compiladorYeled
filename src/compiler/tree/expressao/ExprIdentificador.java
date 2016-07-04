package compiler.tree.expressao;

import compiler.semantica.InfoSimbolo;
import compiler.semantica.InfoVariavel;
import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
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
	public Tipo getTipo(TabelaSimbolosGeral tabela) throws LeituraException {
		Tipo tipoRetorno = Tipo.NULL; 
		InfoSimbolo info;
		
		if(tabela.verificarExistenciaSimboloTodasTabelas(identificador)){// se existe � global
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
			throw new LeituraException("O identificador " + identificador + " n�o existe!"); 
		} 
		return tipoRetorno; 
	}

}
