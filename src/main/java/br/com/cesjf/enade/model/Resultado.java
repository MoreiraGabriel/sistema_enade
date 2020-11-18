package br.com.cesjf.enade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resultado {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double valorObtido;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Prova prova;

	public Resultado() {}

	public Resultado(Long id, Double valorObtido, Usuario usuario, Prova prova) {
		this.id = id;
		this.valorObtido = valorObtido;
		this.usuario = usuario;
		this.prova = prova;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorObtido() {
		return valorObtido;
	}

	public void setValorObtido(Double valorObtido) {
		this.valorObtido = valorObtido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
	
	
}
