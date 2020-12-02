package br.com.cesjf.enade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DTO para resposta da questão.")
public class QuestaoResultadoDto {

	@ApiModelProperty(value = "Id da questão")
	private Long idQuestao;
	
	@ApiModelProperty(value = "Resposta do aluno.")
	private String resposta;

	public QuestaoResultadoDto(Long idQuestao, String resposta) {
		this.idQuestao = idQuestao;
		this.resposta = resposta;
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
}
