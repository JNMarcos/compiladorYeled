package compiler.tree;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;

public interface DeclGlobal {
	Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException ;
	String gerarCodigoIntermediario(String filename);
	//Boolean verificarSemantica(TabelaSimbolosGeral tabela, TabelaSimbolos tabelaLocal) throws LeituraException;
}
