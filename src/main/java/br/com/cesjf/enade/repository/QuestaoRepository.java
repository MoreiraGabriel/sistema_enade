package br.com.cesjf.enade.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cesjf.enade.model.Questao;

@Repository
@Transactional
public interface QuestaoRepository extends JpaRepository<Questao, Long> {

}
