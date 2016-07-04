package compiler.tree.comando;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;

public interface Comando {
	Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException;
	String gerarCodigoIntermediario(String filename);
}
