package compiler.tree.expressao;

import java.util.LinkedList;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;
import compiler.tree.comando.Comando;

public class ChamadaFunc implements Expressao, Comando {
	private String identificador;
	private LinkedList<Expressao> listaExprs;

	public ChamadaFunc(String identificador, LinkedList<Expressao> listaExprs) {
		this.identificador = identificador;
		this.listaExprs = listaExprs;
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

	@Override
	public Tipo getTipo(TabelaSimbolosGeral tabela) throws LeituraException {
		// TODO Auto-generated method stub
		return null;
	}
}
