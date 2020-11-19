package br.com.cesjf.enade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesjf.enade.dto.UsuarioDto;
import br.com.cesjf.enade.model.Usuario;
import br.com.cesjf.enade.repository.TipoUsuarioRepository;
import br.com.cesjf.enade.repository.UsuarioRepository;
import br.com.cesjf.enade.request.UsuarioRequest;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private TipoUsuarioRepository tpUsuarioRepository;
	
	public UsuarioDto cadastrar(UsuarioRequest request) {
		Usuario usuario = request.converter(tpUsuarioRepository);
		return new UsuarioDto(repository.save(usuario));
	}

	public List<UsuarioDto> obterTodos() {

		return UsuarioDto.converter(repository.findAll());
	}

}
