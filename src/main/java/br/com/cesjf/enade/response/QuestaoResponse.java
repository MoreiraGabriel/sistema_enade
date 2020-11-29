package br.com.cesjf.enade.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Questao;

public class QuestaoResponse {

private Long idQuestao;
	
	private String descricao;
	
	private String alternativaA;
	
	private String alternativaB;
	
	private String alternativaC;
	
	private String alternativaD;
	
	private String alternativaE;
	
	private String tpQuestao;
	
	private String correta;
	
	private Boolean estadoQuestao;

	public QuestaoResponse(Questao questao) {
		this.idQuestao = questao.getIdQuestao();
		this.descricao = questao.getDescricao();
		this.alternativaA = questao.getAlternativaA();
		this.alternativaB = questao.getAlternativaB();
		this.alternativaC = questao.getAlternativaC();
		this.alternativaD = questao.getAlternativaD();
		this.alternativaE = questao.getAlternativaE();
		this.tpQuestao = questao.getTpQuestao().getNomeTipoQuestao();
		this.correta = questao.getCorreta();
		this.estadoQuestao = questao.getEstadoQuestao();
		
	}
	
	public static List<QuestaoResponse> converter(List<Questao> questoes){
		return questoes.stream().map(QuestaoResponse::new).collect(Collectors.toList());
	}

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	public String getAlternativaD() {
		return alternativaD;
	}

	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}

	public String getAlternativaE() {
		return alternativaE;
	}

	public void setAlternativaE(String alternativaE) {
		this.alternativaE = alternativaE;
	}

	public String getTpQuestao() {
		return tpQuestao;
	}

	public void setTpQuestao(String tpQuestao) {
		this.tpQuestao = tpQuestao;
	}

	public String getCorreta() {
		return correta;
	}

	public void setCorreta(String correta) {
		this.correta = correta;
	}

	public Boolean getEstadoQuestao() {
		return estadoQuestao;
	}

	public void setEstadoQuestao(Boolean estadoQuestao) {
		this.estadoQuestao = estadoQuestao;
	}
	
}
