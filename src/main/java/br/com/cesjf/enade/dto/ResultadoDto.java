package br.com.cesjf.enade.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Resultado;

public class ResultadoDto {

	private Long id;
	
	private Double valorObtido;
	
	private UsuarioDto usuarioDto;
	
	private ProvaDto provaDto;

	public ResultadoDto(Resultado resultado) {
		this.id = resultado.getId();
		this.valorObtido = resultado.getValorObtido();
		this.usuarioDto = new UsuarioDto(resultado.getUsuario());
		this.provaDto = new ProvaDto(resultado.getProva());
	}
	
	public static List<ResultadoDto> converter(List<Resultado> resultados){
		return resultados.stream().map(ResultadoDto::new).collect(Collectors.toList());
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

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public ProvaDto getProvaDto() {
		return provaDto;
	}

	public void setProvaDto(ProvaDto provaDto) {
		this.provaDto = provaDto;
	}
	
}
