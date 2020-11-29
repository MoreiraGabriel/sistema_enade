package br.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.dto.ResultadoDto;
import br.com.cesjf.enade.service.ResultadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("resultado")
@Api("Controller para resultado.")
public class ResultadoResource {

	@Autowired
	private ResultadoService service;
	
	@GetMapping("listar")
	@ApiOperation(value = "Endpoint para listar os resultados")
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("listar/{id}")
	@ApiOperation(value = "Endpoint para listar os resultados")
	public ResponseEntity<?> obterPorId(@PathVariable Long id){
		
		ResultadoDto dto = service.obterPorId(id);
		return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.noContent().build();
	}
}
