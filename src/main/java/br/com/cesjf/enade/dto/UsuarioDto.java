package br.com.cesjf.enade.dto;

import br.com.cesjf.enade.model.Usuario;

public class UsuarioDto {

	private Long id;	
	private String nomeUsuario;	
	private String emailUsuario;
	
	public UsuarioDto() {}

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeUsuario = usuario.getEmailUsuario();
		this.emailUsuario = usuario.getEmailUsuario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
}
