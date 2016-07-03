package compiler.tree.comando;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;

public interface Comando {
	Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException;
	String gerarCodigoIntermediario(String filename);
	Boolean verificarSemantica(TabelaSimbolos tabelaLocal) throws LeituraException;
}
