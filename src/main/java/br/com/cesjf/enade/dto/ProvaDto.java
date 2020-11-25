package br.com.cesjf.enade.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Prova;
import br.com.cesjf.enade.model.Questao;

public class ProvaDto {

	private Long idProva;
	
	private LocalDateTime dataProva;
	
	private List<Questao> listaQuestoes;

	public ProvaDto() {}
	
	public ProvaDto(Prova prova) {
		this.idProva = prova.getIdProva();
		this.dataProva = prova.getDataProva();
		this.listaQuestoes = prova.getListaQuestoes();
	}
	
	public static List<ProvaDto> converter(List<Prova> provas){
		return provas.stream().map(ProvaDto::new).collect(Collectors.toList());
	}

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	public LocalDateTime getDataProva() {
		return dataProva;
	}

	public void setDataProva(LocalDateTime dataProva) {
		this.dataProva = dataProva;
	}

	public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

}
