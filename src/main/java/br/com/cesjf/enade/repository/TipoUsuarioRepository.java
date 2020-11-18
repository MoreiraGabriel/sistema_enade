package br.com.cesjf.enade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cesjf.enade.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

}
