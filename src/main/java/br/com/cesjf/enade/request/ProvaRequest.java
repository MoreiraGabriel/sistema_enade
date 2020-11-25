package br.com.cesjf.enade.request;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Request para prova.")
public class ProvaRequest {

	@ApiModelProperty(value = "Data da prova.")
	private LocalDateTime dataProva;
	
	@ApiModelProperty(value = "Lista com os ids das questões da prova.")
	private List<Long> idsQuestoes;

	public ProvaRequest() {}

	public ProvaRequest(LocalDateTime dataProva, List<Long> idsQuestoes) {
		this.dataProva = dataProva;
		this.idsQuestoes = idsQuestoes;
	}

	public LocalDateTime getDataProva() {
		return dataProva;
	}

	public void setDataProva(LocalDateTime dataProva) {
		this.dataProva = dataProva;
	}

	public List<Long> getIdsQuestoes() {
		return idsQuestoes;
	}

	public void setIdsQuestoes(List<Long> idsQuestoes) {
		this.idsQuestoes = idsQuestoes;
	}

}
