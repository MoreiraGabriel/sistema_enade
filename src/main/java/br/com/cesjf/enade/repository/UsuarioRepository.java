package br.com.cesjf.enade.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cesjf.enade.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
