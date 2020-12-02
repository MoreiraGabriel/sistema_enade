package br.com.cesjf.enade.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Prova;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Dto para prova.")
public class ProvaDto {

	@ApiModelProperty(value = "Id da prova.")
	private Long idProva;
	
	@ApiModelProperty(value = "Data da prova.")
	private LocalDateTime dataProva;
	
	@ApiModelProperty(value = "Lista de questões.")
	private List<QuestaoDto> listaQuestoes;

	public ProvaDto() {}
	
	public ProvaDto(Prova prova) {
		this.idProva = prova.getIdProva();
		this.dataProva = prova.getDataProva();
		this.listaQuestoes = QuestaoDto.converter(prova.getListaQuestoes());
	}
	
	public ProvaDto(Long idProva, LocalDateTime data) {
		this.idProva = idProva;
		this.dataProva = data;
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

	public List<QuestaoDto> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<QuestaoDto> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

}
