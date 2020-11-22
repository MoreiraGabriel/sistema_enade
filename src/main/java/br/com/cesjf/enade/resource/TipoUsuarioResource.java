package br.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.dto.TipoUsuarioDto;
import br.com.cesjf.enade.repository.TipoUsuarioRepository;

@RestController
@RequestMapping("tipo-usuario")
public class TipoUsuarioResource {

	@Autowired
	private TipoUsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<?> lista(){
		return ResponseEntity.ok(TipoUsuarioDto.converter(repository.findAll()));
	}
}
