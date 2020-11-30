package br.com.cesjf.enade.request;

import java.util.List;

import br.com.cesjf.enade.dto.QuestaoResultadoDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Request para resultado.")
public class ResultadoRequest {

	@ApiModelProperty(value = "Id do usuario.")
	private Long idUsuario;
	
	@ApiModelProperty(value = "Id da prova.")
	private Long idProva;
	
	@ApiModelProperty(value = "Ids e respostas das questões.")
	private List<QuestaoResultadoDto> questoes;

	public ResultadoRequest(Long idUsuario, Long idProva, List<QuestaoResultadoDto> questoes) {
		this.idUsuario = idUsuario;
		this.idProva = idProva;
		this.questoes = questoes;
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

	public List<QuestaoResultadoDto> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<QuestaoResultadoDto> questoes) {
		this.questoes = questoes;
	}

}
