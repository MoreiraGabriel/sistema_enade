package br.com.cesjf.enade.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cesjf.enade.model.Resultado;

@Repository
@Transactional
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

	@Query(value = "SELECT * FROM resultado r INNER JOIN usuario u ON r.usuario_id = u.id", nativeQuery = true)
	List<Resultado> relatorioAlunosComProvas();
}
