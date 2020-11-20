package br.com.cesjf.enade.service;

import java.util.List;
import java.util.Optional;

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

	public UsuarioDto obterPorId(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		
		return usuario.isPresent() ? new UsuarioDto(usuario.get()) : null;
	}
	


	public UsuarioDto atualizar(Long id, UsuarioRequest request) {
		Optional<Usuario> optional = repository.findById(id);
		Usuario usuario = null;
		if(optional.isPresent()) {
			usuario = optional.get();
			usuario.setNomeUsuario(request.getNomeUsuario());
			usuario.setEmailUsuario(request.getEmailUsuario());
			usuario.setSenhaUsuario(request.getSenhaUsuario());
			return new UsuarioDto(repository.save(usuario));
		}
		
		return null;		
	}

	public Boolean deletar(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		Boolean retorno = false;
		if (usuario.isPresent()) {
			repository.deleteById(id);
			retorno = true;
		}
		return  retorno;
	}

}
