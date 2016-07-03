package compiler.tree;

import java.util.LinkedList;

import Semantica.InfoSimbolo;
import Semantica.InfoVariavel;
import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.comando.DeclVariavel;

public class ParamFormais {
	private LinkedList<DeclVariavel> paramFormais;

	public ParamFormais(LinkedList<DeclVariavel> paramFormais) {
		this.paramFormais = paramFormais;
	}

	public ParamFormais() {
		paramFormais = new LinkedList<DeclVariavel>();
	}

	public void add(DeclVariavel d) {
		paramFormais.addLast(d);
	}
	
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela, TabelaSimbolos tabelaLocal) throws LeituraException{
		boolean retornoParametrosOK = false;
		InfoSimbolo simbolo;
		for (int i = 0; i < paramFormais.size(); i++){
			for (int j = 0; j < paramFormais.get(i).getIdents().size(); j++){
				simbolo = new InfoVariavel(paramFormais.get(i).getTipo());
				retornoParametrosOK = tabelaLocal.adicionarSimbolo(paramFormais.get(i).getIdents().get(j), simbolo);
				if (retornoParametrosOK == false){
					throw new LeituraException("");
				}
			}
		}
		
		return retornoParametrosOK;
	}
	
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
