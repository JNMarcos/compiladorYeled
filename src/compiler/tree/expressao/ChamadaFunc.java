package compiler.tree.expressao;

import java.util.LinkedList;

import compiler.semantica.InfoFuncao;
import compiler.semantica.InfoSimbolo;
import compiler.semantica.InfoVariavel;
import compiler.semantica.TabelaSimbolosGeral;
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
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException {
		boolean chamadaOK = true;
		InfoSimbolo info = tabela.buscarSimbolo(identificador); 
		if (info instanceof InfoVariavel){
			throw new LeituraException("N�o � uma fun��o, � uma vari�vel.");
		} else if (info instanceof InfoFuncao){
			if (listaExprs.size() != ((InfoFuncao) info).getParametrosFuncao().size()){
				throw new LeituraException("Os par�metros n�o coincidem.");
			} else {
				InfoFuncao infoF;
				for (int i = 0; i < listaExprs.size(); i++){
					infoF = (InfoFuncao) ((InfoFuncao)info).getParametrosFuncao().get(i);
					if (listaExprs.get(i).getTipo(tabela) != infoF.getTipoRetorno()){
						chamadaOK = false;
						throw new LeituraException("Um dos tipos " + identificador + " n�o corresponde.");
					}
				}
			}
			
		} else {
			throw new LeituraException("Deu ruim.");
		}
		return chamadaOK;
	}
	
	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}

	@Override
	public Tipo getTipo(TabelaSimbolosGeral tabela) throws LeituraException {
		
		return null;
	}
}
