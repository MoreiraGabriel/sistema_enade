package br.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.dto.UsuarioDto;
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
	
	@GetMapping("listar")
	public ResponseEntity<?> listar(){		
		return ResponseEntity.ok(service.obterTodos());
	}
	
	@GetMapping("listar/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable Long id){	
		UsuarioDto dto = service.obterPorId(id);
		
		return dto == (null) 
				? ResponseEntity.noContent().build() : ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		return service.deletar(id).equals(true)
				? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}
