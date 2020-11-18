package br.com.cesjf.enade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cesjf.enade.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
