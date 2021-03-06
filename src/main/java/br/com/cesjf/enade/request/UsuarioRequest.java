package br.com.cesjf.enade.request;

import java.util.Optional;

import br.com.cesjf.enade.model.TipoUsuario;
import br.com.cesjf.enade.model.Usuario;
import br.com.cesjf.enade.repository.TipoUsuarioRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Request para usuário.")
public class UsuarioRequest {
		
	@ApiModelProperty(value = "Nome do usuario.")
	private String nomeUsuario;	
	
	@ApiModelProperty(value = "E-mail do usuario.")
	private String emailUsuario;
	
	@ApiModelProperty(value = "Senha do usuario.")
	private String senhaUsuario;
	
	@ApiModelProperty(value = "Tipo do usuario.")
	private Long idTipoUsuario;

	public UsuarioRequest() {}
	
	public UsuarioRequest(String nomeUsuario, String emailUsuario, String senhaUsuario, Long idTipoUsuario) {
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
		this.senhaUsuario = senhaUsuario;
		this.idTipoUsuario = idTipoUsuario;
	}
	
	public Usuario converter(TipoUsuarioRepository repository) {
		Optional<TipoUsuario> tpUsuario = repository.findById(idTipoUsuario);
		
		return tpUsuario.isPresent() ? 
				new Usuario(nomeUsuario, emailUsuario, senhaUsuario, tpUsuario.get()) : null;
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
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	
}
