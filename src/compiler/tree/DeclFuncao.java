package compiler.tree;

import Semantica.TabelaSimbolos;
import Semantica.TabelaSimbolosGeral;
import compiler.syntax.LeituraException;
import compiler.tree.comando.Bloco;

public class DeclFuncao implements DeclGlobal {
	private Assinatura assinatura;
	private Bloco bloco;
	
	public DeclFuncao(Assinatura assinatura, Bloco bloco) {
		this.assinatura = assinatura;
		this.bloco = bloco;
	}

	@Override
	public Boolean verificarSemantica(TabelaSimbolosGeral tabela) throws LeituraException{
		boolean retornoAssinaturaOK = false;
		boolean retornoBlocoOK = false;
		
		retornoAssinaturaOK = assinatura.verificarSemantica(tabela);
		retornoBlocoOK = bloco.verificarSemantica(tabela);
		
		return (retornoAssinaturaOK && retornoBlocoOK);
	}

	@Override
	public String gerarCodigoIntermediario(String filename) {
		return null;
	}
}
