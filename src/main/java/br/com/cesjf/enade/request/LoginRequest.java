package br.com.cesjf.enade.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Request para login.")
public class LoginRequest {

	@ApiModelProperty(value = "E-mail do usuario.")
	private String emailUsuario;
	
	@ApiModelProperty(value = "Senha do usuario.")
	private String senhaUsuario;

	public LoginRequest(String emailUsuario, String senhaUsuario) {
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

}
