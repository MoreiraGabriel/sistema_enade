package br.com.cesjf.enade.request;

import java.util.Optional;

import br.com.cesjf.enade.model.Questao;
import br.com.cesjf.enade.model.TipoQuestao;
import br.com.cesjf.enade.repository.TipoQuestaoRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Request para questao.")
public class QuestaoRequest {
	
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
	
	@ApiModelProperty(value = "Alternativa correta")
	private String correta;
	
	@ApiModelProperty(value = "Estado da questao")
	private Boolean estadoQuestao;
	
	@ApiModelProperty(value = "Id do tipo da questão")
	private Long idTpQuestao;

	public QuestaoRequest() {}

	public QuestaoRequest(String descricao, String alternativaA, String alternativaB, String alternativaC,
			String alternativaD, String alternativaE, String correta, Boolean estadoQuestao, Long idTpQuestao) {
		this.descricao = descricao;
		this.alternativaA = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.alternativaE = alternativaE;
		this.correta = correta;
		this.estadoQuestao = estadoQuestao;
		this.idTpQuestao = idTpQuestao;
	}

	public Questao converter(TipoQuestaoRepository tpQuestaoRepository) {
		Optional<TipoQuestao> tpQuestao = tpQuestaoRepository.findById(idTpQuestao);
		if(tpQuestao.isPresent()) {
			return new Questao(descricao, alternativaA, alternativaB, alternativaC, alternativaD, alternativaE, 
					correta, estadoQuestao, tpQuestao.get());
		}
		return null;
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

	public Long getIdTpQuestao() {
		return idTpQuestao;
	}

	public void setIdTpQuestao(Long idTpQuestao) {
		this.idTpQuestao = idTpQuestao;
	}
	
}
