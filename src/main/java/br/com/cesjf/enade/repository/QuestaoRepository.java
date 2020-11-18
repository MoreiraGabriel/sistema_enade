package br.com.cesjf.enade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cesjf.enade.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

}
