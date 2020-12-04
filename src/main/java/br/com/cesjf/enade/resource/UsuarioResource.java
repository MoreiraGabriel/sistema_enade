package br.com.cesjf.enade.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.dto.UsuarioDto;
import br.com.cesjf.enade.request.LoginRequest;
import br.com.cesjf.enade.request.UsuarioRequest;
import br.com.cesjf.enade.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("usuario")
@Api(value = "Controller para usuario.")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("listar")
	@ApiOperation(value = "Endpoint para listar todos os usuários.")
	public ResponseEntity<List<UsuarioDto>> listar(){		
		return ResponseEntity.ok(service.obterTodos());
	}
	
	@GetMapping("listar-alunos")
	@ApiOperation(value = "Endpoint para listar todos os alunos.")
	public ResponseEntity<List<UsuarioDto>> listarAlunos(){
		List<UsuarioDto> lista = service.obterAlunos();
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}
	
	@GetMapping("listar-alunos/{id}")
	@ApiOperation(value = "Endpoint para listar aluno por id.")
	public ResponseEntity<UsuarioDto> listarAlunos(@PathVariable Long id){
		UsuarioDto dto = service.obterAlunoDtoPorId(id);
		return dto == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(dto);
	}
	
	@GetMapping("listar/{id}")
	@ApiOperation(value = "Endpoint para listar usuáraio por id.")
	public ResponseEntity<UsuarioDto> obterPorId(@PathVariable Long id){	
		UsuarioDto dto = service.obterPorId(id);
		
		return dto == (null) 
				? ResponseEntity.noContent().build() : ResponseEntity.ok(dto);
	}

	@PostMapping("cadastrar")
	@ApiOperation(value = "Endpoint para cadastrar usuáraio.")
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioRequest request){		
		return ResponseEntity.ok(service.cadastrar(request));
	}
	
	@PutMapping("atualizar/{id}")
	@ApiOperation(value = "Endpoint para atualizar usuáraio.")
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id ,@RequestBody UsuarioRequest request){

		return ResponseEntity.ok(service.atualizar(id, request));
	}
	
	@DeleteMapping("deletar/{id}")
	@ApiOperation(value = "Endpoint para deletar usuáraio por id.")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		
		return service.deletar(id).equals(true)
				? ResponseEntity.ok("Removido com Sucesso!") : ResponseEntity.notFound().build();
	}
	
	@PostMapping("logar")
	@ApiOperation(value = "Endpoint para logar usuáraio.")
	public ResponseEntity<UsuarioDto> logar(@RequestBody LoginRequest request){

		UsuarioDto dto = service.logar(request);
		return dto == null ?  ResponseEntity.notFound().build() 
				: ResponseEntity.ok(dto);
	}
}
