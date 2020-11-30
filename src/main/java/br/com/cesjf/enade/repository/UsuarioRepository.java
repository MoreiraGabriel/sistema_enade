package br.com.cesjf.enade.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cesjf.enade.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value = "SELECT * FROM usuario WHERE id_tp_usuario = 2", nativeQuery = true)
	List<Usuario> listarAlunos();

	@Query(value = "SELECT * FROM usuario WHERE id_tp_usuario = 2 AND id = :id", nativeQuery = true)
	Usuario obterAlunoPorId(@Param("id") Long id);
	
	@Query(value = "SELECT u.* FROM usuario u LEFT JOIN resultado r "
			+ "ON r.usuario_id = u.id WHERE r.usuario_id IS NULL "
			+ "AND u.id_tp_usuario = 2", nativeQuery = true)
	List<Usuario> relatorioAlunosSemProva();
}
