package compiler.tree.comando;

import java.util.LinkedList;

import compiler.semantica.InfoSimbolo;
import compiler.semantica.InfoVariavel;
import compiler.semantica.TabelaSimbolos;
import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.DeclGlobal;
import compiler.tree.Tipo;

public class DeclVariavel implements Comando, DeclGlobal {
	private LinkedList<String> idents;
	private Tipo tipo;

	public DeclVariavel() {
		this.idents = new LinkedList<String>();
	}

	public DeclVariavel(LinkedList<String> ids, Tipo tipo) {
		this.idents = ids;
		this.tipo = tipo;
	}

	public DeclVariavel(String id, Tipo tipo)  {
		this.idents = new LinkedList<String>();
		idents.addLast(id);
		this.tipo = tipo;
	}

	public LinkedList<String> getIdents() {
		return idents;
	}

	public Tipo getTipo(){
		return tipo;
	}

	public Boolean verificarSemantica(TabelaSimbolos tabelaLocal) throws ErroCompiladorException{
		boolean retornoDeclaracaoOK = false;
		InfoSimbolo simbolo;
		for(int i = 0; i < this.idents.size(); i++ ){ 
			if(tabelaLocal.verificarExistenciaSimbolo(idents.get(i)) == false){ 
				simbolo = new InfoVariavel(this.tipo); 
				tabelaLocal.adicionarSimbolo(idents.get(i), simbolo); 
			} else{ 
				retornoDeclaracaoOK = false; 
				throw new ErroCompiladorException("O identificador "+ this.idents.get(i) + " já foi declarado."); 
			} 
		} 
		return retornoDeclaracaoOK;
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException {
		boolean retornoDeclaracaoOK = false;
		InfoSimbolo info;
		
		for(int i = 0; i < this.idents.size(); i++ ){ 
			//só verifica no escopo geral
			if(tabela.verificarExistenciaSimbolo(this.idents.get(i)) == false){ 
				info = new InfoVariavel(this.tipo); 
				tabela.adicionarSimboloGlobal(idents.get(i), info);
			} else{ 
				retornoDeclaracaoOK = false; 
				throw new ErroCompiladorException("O identificador "+ this.idents.get(i) + " já foi declarado.");
			} 
		} 
		return retornoDeclaracaoOK;
	}
}
