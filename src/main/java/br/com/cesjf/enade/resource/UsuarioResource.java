package br.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.request.UsuarioRequest;
import br.com.cesjf.enade.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;

	@PostMapping("cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody UsuarioRequest request){
		
		return ResponseEntity.ok(service.cadastrar(request));
	}
	
}
