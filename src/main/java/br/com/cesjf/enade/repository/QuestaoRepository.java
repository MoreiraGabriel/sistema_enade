package br.com.cesjf.enade.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cesjf.enade.model.Questao;

@Repository
@Transactional
public interface QuestaoRepository extends JpaRepository<Questao, Long> {
	
	@Query(value = "SELECT * FROM questao q where q.estado_questao = true "
			+"AND q.id_questao IN(:idsQuestoes)", nativeQuery = true)
	List<Questao> questoesAtivasPorId(@Param("idsQuestoes") List<Long> idsQuestoes);
}
