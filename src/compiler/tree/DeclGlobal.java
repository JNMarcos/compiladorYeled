package compiler.tree;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;

public interface DeclGlobal {
	Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException ;
	String gerarCodigoIntermediario(String filename);
	//Boolean verificarSemantica(TabelaSimbolosGeral tabela, TabelaSimbolos tabelaLocal) throws LeituraException;
}
