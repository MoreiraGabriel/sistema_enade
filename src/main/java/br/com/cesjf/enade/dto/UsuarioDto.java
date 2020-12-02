package br.com.cesjf.enade.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Usuario;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DTO para usuário.")
public class UsuarioDto {

	@ApiModelProperty(value = "Id do usuário.")
	private Long id;	
	
	@ApiModelProperty(value = "Nome do usuario.")
	private String nomeUsuario;	
	
	@ApiModelProperty(value = "E-mail do usuario.")
	private String emailUsuario;
	
	@ApiModelProperty(value = "Tipo do usuario.")
	private String tipoUsuario;
	
	public UsuarioDto() {}

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.emailUsuario = usuario.getEmailUsuario();
		this.tipoUsuario = usuario.getTipoUsuario().getNomeUsuario();
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
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

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
