package br.com.cesjf.enade.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoQuestao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoQuestao;
	
	private String nomeTipoQuestao;
	
	@OneToMany(mappedBy = "tpQuestao")
	private List<Questao> questoes;
	
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
	public List<Questao> getQuestao() {
		return questoes;
	}
	public void setQuestao(List<Questao> questao) {
		this.questoes = questao;
	}
	
}
