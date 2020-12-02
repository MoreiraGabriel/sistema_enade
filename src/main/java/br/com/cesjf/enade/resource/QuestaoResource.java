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

import br.com.cesjf.enade.dto.QuestaoDto;
import br.com.cesjf.enade.request.QuestaoRequest;
import br.com.cesjf.enade.response.QuestaoResponse;
import br.com.cesjf.enade.service.QuestaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("questao")
@Api(value = "Controller para questão.")
public class QuestaoResource {

	@Autowired
	private QuestaoService service;
	
	@ApiOperation(value = "Endpoint para listar questão.")
	@GetMapping("listar")
	public ResponseEntity<List<QuestaoDto>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@ApiOperation(value = "Endpoint para listar questão por id.")
	@GetMapping("listar/{id}")
	public ResponseEntity<QuestaoDto> listarPorId(@PathVariable Long id){

		QuestaoDto dto = service.listarPorId(id);
		if(dto == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(dto);
	}
	
	@ApiOperation(value = "Endpoint para cadastrar questão.")
	@PostMapping("cadastrar")
	public ResponseEntity<QuestaoDto> cadastrar(@RequestBody QuestaoRequest request){
		QuestaoDto res = service.cadastrar(request);
		
		return res != null ? ResponseEntity.ok(res) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Endpoint para cadastrar questão.")
	@PutMapping("atualizar/{id}")
	public ResponseEntity<QuestaoDto> atualizaar(@PathVariable Long id, @RequestBody QuestaoRequest request){
		QuestaoDto res = service.atualizar(id, request);
		
		return res != null ? ResponseEntity.ok(res) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Endpoint para deletar questão por id.")
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		boolean res = service.deletar(id);
		
		return res ? ResponseEntity.ok("Removido com sucesso") : ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Endpoint para listar questão(completa).")
	@GetMapping("listar-all")
	public ResponseEntity<List<QuestaoResponse>> listarAll(){
		List<QuestaoResponse> lista = service.obterTodas();
		return lista.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(lista) ;
	}
	
}
