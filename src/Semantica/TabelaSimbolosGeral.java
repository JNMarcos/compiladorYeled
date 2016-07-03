/**
 * 
 */
package Semantica;


import java.util.LinkedList;
import java.util.List;

/**
 * @author JN
 *
 */
public class TabelaSimbolosGeral {
	private LinkedList<TabelaSimbolos> tabela;

	public TabelaSimbolosGeral(){
		this.tabela = new LinkedList<TabelaSimbolos>();	
		//cria a tabela global
		this.adicionarTabelaSimbolos(new TabelaSimbolos());
	}

	public List<TabelaSimbolos> getTabela() {
		return tabela;
	}

	public void adicionarTabelaSimbolos(TabelaSimbolos tabela){
		this.tabela.addLast(tabela);
	}

	//adiciona um simbolo � tabela de escopo global
	// get 0 porque a global sempre ser� a primeira tabela, pois as
	// tabelas sempre s�o adicionadas na �ltima posi��o
	public void adicionarSimboloGlobal(String identificador, InfoSimbolo info){
		this.tabela.get(0).getTabela().put(identificador, info);
	}

	public void removerTabelaSimbolos(TabelaSimbolos tabela){
		this.tabela.remove(tabela);
	}

	//verifica se o s�mbolo existe no escopo global
	public boolean verificarExistenciaSimbolo(String identificador){
		boolean existeSimbolo = true;

		//� get 0 pq a primeira tabela � a tabela global
		//passa o identificador, se retornar null � porque n�o existe e pode us�-lo
		if (this.getTabela().get(0).getTabela().get(identificador) == null){
			existeSimbolo = false;
		}
		return existeSimbolo;
	}

	public boolean verificarExistenciaSimboloTodasTabelas(String identificador){
		boolean existeSimbolo = true;
		for (int i = tabela.size() - 1; i >= 0; i--){
			if (this.getTabela().get(i).getTabela().get(identificador) == null){
				existeSimbolo = false;
			}
		}
		return existeSimbolo;
	}

	//busca em todas as tabelas
	public InfoSimbolo buscarSimbolo(String identificador){
		InfoSimbolo info = null;

		//come�a da �ltima posi��o, pois � o mais recente, � uma pilha
		for (int i = this.tabela.size() - 1; i >= 0; --i){
			info = tabela.get(i).getTabela().get(identificador);
		}
		return info;
	}

	public boolean buscarSimbolo2(String identificador){
		boolean existe = false;
		InfoSimbolo info;

		//come�a da �ltima posi��o, pois � o mais recente, � uma pilha
		for (int i = this.tabela.size() - 1; i >= 0; --i){
			info = tabela.get(i).getTabela().get(identificador);
			if (info != null){
				existe = true;
				break;
			}
		}
		return existe;
	}
}
