package br.com.cesjf.enade.exception;

import br.com.cesjf.enade.enade.EnadeErro;

public class EnadeException extends RuntimeException {

	private static final long serialVersionUID = -5822208905529591995L;
	
	private final transient EnadeErro erro;

	public EnadeException() {
		super();
		erro = new EnadeErro(null, null);
	}
	
	public EnadeException(final String mensagem) {
		super(mensagem);
		erro = new EnadeErro(mensagem, mensagem);
	}
	
	public EnadeException(final String mensagem, final Object detalhe) {
		super(mensagem);
		erro = new EnadeErro(mensagem, detalhe);
	}

	public EnadeErro getErro() {
		return erro;
	}

	@Override
	public String toString() {
		return String.format("EnadeException [erro=%s]", erro);
	}

}
