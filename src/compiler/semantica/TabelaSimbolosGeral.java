/**
 * 
 */
package compiler.semantica;


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

	//adiciona um simbolo à tabela de escopo global
	// get 0 porque a global sempre será a primeira tabela, pois as
	// tabelas sempre são adicionadas na última posição
	public void adicionarSimboloGlobal(String identificador, InfoSimbolo info){
		this.tabela.get(0).getTabela().put(identificador, info);
	}

	public void removerTabelaSimbolos(TabelaSimbolos tabela){
		this.tabela.remove(tabela);
	}

	//verifica se o símbolo existe no escopo global
	public boolean verificarExistenciaSimbolo(String identificador){
		boolean existeSimbolo = true;

		//é get 0 pq a primeira tabela é a tabela global
		//passa o identificador, se retornar null é porque não existe e pode usá-lo
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

		//começa da última posição, pois é o mais recente, é uma pilha
		for (int i = this.tabela.size() - 1; i >= 0; i--){
			info = tabela.get(i).getTabela().get(identificador);
			
			if (info != null){
				break;
			}
		}
		return info;
	}

	public boolean buscarSimbolo2(String identificador){
		boolean existe = false;
		InfoSimbolo info;

		//começa da última posição, pois é o mais recente, é uma pilha
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
