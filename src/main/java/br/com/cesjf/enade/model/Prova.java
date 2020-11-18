package br.com.cesjf.enade.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Prova {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProva;
	
	private LocalDateTime dataProva;
	
	@OneToMany(mappedBy = "prova")
	private List<Resultado> resultados;
	
	@ManyToMany
	@JoinTable(
		name = "prova_questao",
		joinColumns = @JoinColumn(name = "prova_id"),
		inverseJoinColumns = @JoinColumn(name = "questao_id"))
	private List<Questao> listaQuestoes;
	
	public Prova() {}

	public Prova(Long idProva, LocalDateTime dataProva, List<Resultado> resultados, List<Questao> listaQuestoes) {
		this.idProva = idProva;
		this.dataProva = dataProva;
		this.resultados = resultados;
		this.listaQuestoes = listaQuestoes;
	}

	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	public LocalDateTime getDataProva() {
		return dataProva;
	}

	public void setDataProva(LocalDateTime dataProva) {
		this.dataProva = dataProva;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}
	
}
