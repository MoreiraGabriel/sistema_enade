package br.com.cesjf.enade.enade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class EnadeErro {

	private String mensagem;
	private Object detalhe;
	
	public EnadeErro() {this(null, null);}

	public EnadeErro(String mensagem, Object detalhe) {
		this.mensagem = mensagem;
		this.detalhe = detalhe;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(final String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(final Object detalhe) {
		this.detalhe = detalhe;
	}

	@Override
	public String toString() {
		return String.format("EnadeErro [mensagem=%s, detalhe=%s]", mensagem, detalhe);
	}

}
