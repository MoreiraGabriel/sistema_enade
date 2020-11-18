package br.com.cesjf.enade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TipoQuestao {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoQuestao;
	
	private String nomeTipoQuestao;
	
	@ManyToOne
	private Questao questao;
	
	public TipoQuestao() {}
	
	public TipoQuestao(Long idTipoQuestao, String nomeTipoQuestao) {
		this.idTipoQuestao = idTipoQuestao;
		this.nomeTipoQuestao = nomeTipoQuestao;
	}
	
	public Long getIdTipoQuestao() {
		return idTipoQuestao;
	}
	public void setIdTipoQuestao(Long idTipoQuestao) {
		this.idTipoQuestao = idTipoQuestao;
	}
	public String getNomeTipoQuestao() {
		return nomeTipoQuestao;
	}
	public void setNomeTipoQuestao(String nomeTipoQuestao) {
		this.nomeTipoQuestao = nomeTipoQuestao;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
	
}
