package br.com.cesjf.enade.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cesjf.enade.model.Questao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DTO para questao.")
public class QuestaoDto {
	@ApiModelProperty(value = "Id da questão.")
	private Long idQuestao;
	
	@ApiModelProperty(value = "Descrição da questão.")
	private String descricao;
	
	@ApiModelProperty(value = "Alternativa A")
	private String alternativaA;
	
	@ApiModelProperty(value = "Alternativa B")
	private String alternativaB;
	
	@ApiModelProperty(value = "Alternativa C")
	private String alternativaC;
	
	@ApiModelProperty(value = "Alternativa D")
	private String alternativaD;
	
	@ApiModelProperty(value = "Alternativa E")
	private String alternativaE;
	
	@ApiModelProperty(value = "Tipo da questão")
	private String tpQuestao;

	public QuestaoDto(Questao questao) {
		this.idQuestao = questao.getIdQuestao();
		this.descricao = questao.getDescricao();
		this.alternativaA = questao.getAlternativaA();
		this.alternativaB = questao.getAlternativaB();
		this.alternativaC = questao.getAlternativaC();
		this.alternativaD = questao.getAlternativaD();
		this.alternativaE = questao.getAlternativaE();
		this.tpQuestao = questao.getTpQuestao().getNomeTipoQuestao();
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

	public String getTpQuestao() {
		return tpQuestao;
	}

	public void setTpQuestao(String tpQuestao) {
		this.tpQuestao = tpQuestao;
	}

}
