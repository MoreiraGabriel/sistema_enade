package br.com.cesjf.enade.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Questao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idQuestao;
	
	private String descricao;
	
	private String alternativaA;
	
	private String alternativaB;
	
	private String alternativaC;
	
	private String alternativaD;
	
	private String alternativaE;
	
	private String correta;
	
	private Boolean estadoQuestao;
	
	@ManyToOne
	@JoinColumn(name = "tp_questao_id")
	private TipoQuestao tpQuestao;
	
	@ManyToMany(mappedBy = "listaQuestoes")
	private List<Prova> listaProvas;
	
	public Questao() {}

	public Questao(Long idQuestao, String descricao, String alternativaA, String alternativaB, String alternativaC,
			String alternativaD, String alternativaE, String correta, Boolean estadoQuestao, TipoQuestao tpQuestao,
			List<Prova> listaProvas) {
		this.idQuestao = idQuestao;
		this.descricao = descricao;
		this.alternativaA = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.alternativaE = alternativaE;
		this.correta = correta;
		this.estadoQuestao = estadoQuestao;
		this.tpQuestao = tpQuestao;
		this.listaProvas = listaProvas;
	}

	public Questao(String descricao, String alternativaA, String alternativaB, String alternativaC, String alternativaD,
			String alternativaE, String correta, Boolean estadoQuestao, TipoQuestao tpQuestao) {
		this.descricao = descricao;
		this.alternativaA = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.alternativaE = alternativaE;
		this.correta = correta;
		this.estadoQuestao = estadoQuestao;
		this.tpQuestao = tpQuestao;
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

	public TipoQuestao getTpQuestao() {
		return tpQuestao;
	}

	public void setTpQuestao(TipoQuestao tpQuestao) {
		this.tpQuestao = tpQuestao;
	}

	public List<Prova> getProva() {
		return listaProvas;
	}

	public void setProva(List<Prova> listaProvas) {
		this.listaProvas = listaProvas;
	}

}
