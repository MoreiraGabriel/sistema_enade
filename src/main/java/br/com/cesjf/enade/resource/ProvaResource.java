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

import br.com.cesjf.enade.dto.ProvaDto;
import br.com.cesjf.enade.exception.EnadeException;
import br.com.cesjf.enade.request.ProvaRequest;
import br.com.cesjf.enade.service.ProvaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("prova")
@Api(value = "Controller para prova.")
public class ProvaResource {

	@Autowired
	private ProvaService service;
	
	@ApiOperation(value = "Endpoint para listar todas as provas.")
	@GetMapping("listar")
	public ResponseEntity<List<ProvaDto>> listarTodas(){
		return ResponseEntity.ok(service.lista());
	}
	
	@ApiOperation(value = "Endpoint para listar prova por id.")
	@GetMapping("listar/{id}")
	public ResponseEntity<ProvaDto> obterPorId(@PathVariable Long id){
		ProvaDto dto = service.obterPorId(id);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Endpoint para deletar prova por id.")
	@DeleteMapping("deletar")
	public ResponseEntity<String> deletar(@PathVariable Long id){

		if (Boolean.TRUE.equals(service.deletar(id))) {
			return ResponseEntity.ok("Prova removida com sucesso");
		}
		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Endpoint para cadastrar prova.")
	@PostMapping("cadastrar")
	public ResponseEntity<ProvaDto> cadastrar(@RequestBody ProvaRequest request) throws Exception{

		return ResponseEntity.ok(service.cadastrar(request));
	}
	
	@ApiOperation(value = "Endpoint para atualizar prova.")
	@PutMapping("atualizar/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, 
			@RequestBody ProvaRequest request) {

		try {
			ProvaDto dto = service.atualizar(id, request);
			if(dto != null){ return ResponseEntity.ok(dto); }
			
		} catch (EnadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.notFound().build();
	}
}
