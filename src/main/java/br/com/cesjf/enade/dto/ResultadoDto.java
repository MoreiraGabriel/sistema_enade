package br.com.cesjf.enade.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Resultado;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DTO para resultado.")
public class ResultadoDto {

	@ApiModelProperty(value = "Id do resultado.")
	private Long id;
	
	@ApiModelProperty(value = "Valor obtido pelo aluno.")
	private Double valorObtido;
	
	@ApiModelProperty(value = "Aluno.")
	private UsuarioDto usuarioDto;
	
	@ApiModelProperty(value = "Prova que foi realizada.")
	private ProvaDto provaDto;

	public ResultadoDto(Resultado resultado) {
		this.id = resultado.getId();
		this.valorObtido = resultado.getValorObtido();
		this.usuarioDto = new UsuarioDto(resultado.getUsuario());
		this.provaDto = new ProvaDto(resultado.getId(), resultado.getProva().getDataProva());
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
