package br.com.cesjf.enade.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.TipoUsuario;

public class TipoUsuarioDto {

	private Long idTipoUsuario;
	
	private String nomeUsuario;

	public TipoUsuarioDto(TipoUsuario tpUsuario) {
		this.idTipoUsuario = tpUsuario.getIdTipoUsuario();
		this.nomeUsuario = tpUsuario.getNomeUsuario();
	}
	
	public static List<TipoUsuarioDto> converter(List<TipoUsuario> lista){
		return lista.stream().map(TipoUsuarioDto::new).collect(Collectors.toList());
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
	
}
