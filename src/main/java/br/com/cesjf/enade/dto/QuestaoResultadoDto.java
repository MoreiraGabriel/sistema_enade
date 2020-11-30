package br.com.cesjf.enade.dto;

public class QuestaoResultadoDto {

	private Long idQuestao;
	
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
