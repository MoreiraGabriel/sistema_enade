package br.com.cesjf.enade.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoUsuario {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoUsuario;
	
	private String nomeUsuario;
	
	@OneToMany(mappedBy = "tipoUsuario")
	private List<Usuario> listaUsuarios;

	public TipoUsuario() {}

	public TipoUsuario(Long idTipoUsuario, String nomeUsuario, List<Usuario> usuarios) {
		this.idTipoUsuario = idTipoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.listaUsuarios = usuarios;
	}

	public Long getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public List<Usuario> getUsuario() {
		return listaUsuarios;
	}

	public void setUsuario(List<Usuario> usuarios) {
		this.listaUsuarios = usuarios;
	}

}
