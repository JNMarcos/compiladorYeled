package compiler.tree.expressao;

import compiler.semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.Tipo;

public interface Expressao {
	Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException;
	Tipo getTipo(TabelaSimbolosGeral tabela) throws LeituraException;
	String gerarCodigoIntermediario(String filename);
}
