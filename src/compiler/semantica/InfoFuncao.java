package compiler.semantica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import compiler.tree.Tipo;

public class InfoFuncao implements InfoSimbolo, Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Tipo tipoRetorno;
		private LinkedList<InfoSimbolo> parametrosFuncao;
		
		public InfoFuncao(Tipo tipoRetorno, LinkedList<InfoSimbolo> paramFormais){
			this.setTipoRetorno(tipoRetorno);
			this.setParametrosFuncao(paramFormais);
		}
		
		public Tipo getTipoRetorno() {
			return tipoRetorno;
		}
		public void setTipoRetorno(Tipo tipoRetorno) {
			this.tipoRetorno = tipoRetorno;
		}
		public List<InfoSimbolo> getParametrosFuncao() {
			return parametrosFuncao;
		}
		public void setParametrosFuncao(LinkedList<InfoSimbolo> parametrosFuncao) {
			this.parametrosFuncao = parametrosFuncao;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((parametrosFuncao == null) ? 0 : parametrosFuncao.hashCode());
			result = prime * result + ((tipoRetorno == null) ? 0 : tipoRetorno.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof InfoFuncao)) {
				return false;
			}
			InfoFuncao other = (InfoFuncao) obj;
			if (parametrosFuncao == null) {
				if (other.parametrosFuncao != null) {
					return false;
				}
			} else if (!parametrosFuncao.equals(other.parametrosFuncao)) {
				return false;
			}
			if (tipoRetorno != other.tipoRetorno) {
				return false;
			}
			return true;
		}
		
		public int compareTo(InfoFuncao f){
			return this.getTipoRetorno().compareTo(f.getTipoRetorno());
		}
		
		
}
