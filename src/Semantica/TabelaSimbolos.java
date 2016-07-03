package Semantica;

import java.util.Hashtable;

/**
 * 
 */

/**
 * @author JN
 *
 */
public class TabelaSimbolos {


	//dado um símbolo, se obtém um tipo
	private Hashtable<String, InfoSimbolo> tabela;

	public Hashtable<String, InfoSimbolo> getTabela() {
		return tabela;
	}

	public void setTabela(Hashtable<String, InfoSimbolo> tabela) {
		this.tabela = tabela;
	}

	public boolean adicionarSimbolo(String identificador, InfoSimbolo simbolo){
		boolean retornoAdicao = false;
		if(verificarExistenciaSimbolo(identificador) == false){
			this.tabela.put(identificador, simbolo);
			retornoAdicao = true;
		}
		return retornoAdicao;
	}

	public boolean verificarExistenciaSimbolo(String identificador){
		boolean existeSimbolo = true;
		//passa o identificador, se retornar null é porque não existe e pode usá-lo
			if (this.getTabela().get(identificador).equals(null)){
				existeSimbolo = false;
		}
		return existeSimbolo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
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
		if (!(obj instanceof TabelaSimbolos)) {
			return false;
		}
		TabelaSimbolos other = (TabelaSimbolos) obj;
		if (tabela == null) {
			if (other.tabela != null) {
				return false;
			}
		} else if (!tabela.equals(other.tabela)) {
			return false;
		}
		return true;
	}


}
