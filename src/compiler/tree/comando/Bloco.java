package compiler.tree.comando;

import java.util.ArrayList;
import java.util.List;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;


public class Bloco implements Comando {
	private List<Comando> comandos;

	public Bloco() {
		this.comandos = new ArrayList<Comando>();
	}

	public Bloco(List<Comando> comandos) {
		this.comandos = comandos;
	}

	public void add(Comando cmd) {
		this.comandos.add(cmd);
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException{
		boolean retornoComandosOK = false;
		for (int i = 0; i < comandos.size(); i++){
			retornoComandosOK = comandos.get(i).verificarSemantica(tabela);
			if (retornoComandosOK == false){
				retornoComandosOK = false;
				break;
			}
		}
		return retornoComandosOK;
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
}
