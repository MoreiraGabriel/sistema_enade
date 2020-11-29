package br.com.cesjf.enade.request;

public class ResutadoRequest {

	private Double valorObtido;
	
	private Long idUsuario;
	
	private Long idProva;

	public ResutadoRequest(Double valorObtido, Long idUsuario, Long idProva) {
		this.valorObtido = valorObtido;
		this.idUsuario = idUsuario;
		this.idProva = idProva;
	}

	public Double getValorObtido() {
		return valorObtido;
	}

	public void setValorObtido(Double valorObtido) {
		this.valorObtido = valorObtido;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}
	
}
