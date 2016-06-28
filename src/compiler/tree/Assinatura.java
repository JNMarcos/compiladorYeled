package compiler.tree;

import java.util.LinkedList;
import compiler.tree.comando.DeclVariavel;

public class Assinatura {
	private LinkedList<DeclVariavel> paramFormais;
	private Tipo tipo;
	private String identificador;

	public Assinatura(String identificador,
			LinkedList<DeclVariavel> paramFormais, Tipo tipo) {
		this.paramFormais = paramFormais;
		this.tipo = tipo;
		this.identificador = identificador;
	}

	public Assinatura(String identificador, LinkedList<DeclVariavel> paramFormais) {
		this.paramFormais = paramFormais;
		this.identificador = identificador;
	}

	public Boolean verificarSemantica() {
		return null;
	}

	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
