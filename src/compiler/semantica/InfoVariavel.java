/**
 * 
 */
package compiler.semantica;

import java.io.Serializable;

import compiler.tree.Tipo;

/**
 * @author JN
 *
 */
public class InfoVariavel implements InfoSimbolo, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tipo tipo;
	
	public InfoVariavel(Tipo tipo){
		this.setTipo(tipo);
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof InfoVariavel)) {
			return false;
		}
		InfoVariavel other = (InfoVariavel) obj;
		if (tipo != other.tipo) {
			return false;
		}
		return true;
	}
	
	public int compareTo(InfoVariavel v){
		return this.getTipo().compareTo(v.getTipo());
	}
	
	
}
