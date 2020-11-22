package br.com.cesjf.enade.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Questao;

public class QuestaoDto {
	private Long idQuestao;
	
	private String descricao;
	
	private String alternativaA;
	
	private String alternativaB;
	
	private String alternativaC;
	
	private String alternativaD;
	
	private String alternativaE;

	public QuestaoDto(Questao questao) {
		this.idQuestao = questao.getIdQuestao();
		this.descricao = questao.getDescricao();
		this.alternativaA = questao.getAlternativaA();
		this.alternativaB = questao.getAlternativaB();
		this.alternativaC = questao.getAlternativaC();
		this.alternativaD = questao.getAlternativaD();
		this.alternativaE = questao.getAlternativaE();
	}
	
	public static List<QuestaoDto> converter(List<Questao> questoes){
		return questoes.stream().map(QuestaoDto::new).collect(Collectors.toList());
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

}
