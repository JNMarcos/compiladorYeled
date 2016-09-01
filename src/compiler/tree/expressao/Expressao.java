package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.ErroCompiladorException;
import compiler.tree.Tipo;

public interface Expressao {
	Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws ErroCompiladorException;
	Tipo getTipo(TabelaSimbolosGeral tabela) throws ErroCompiladorException;
	String gerarCodigoIntermediario(String filename);
	
}
