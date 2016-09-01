package compiler.tree.comando;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;

public interface Comando {
	Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException;
	String gerarCodigoIntermediario(String filename);
}
