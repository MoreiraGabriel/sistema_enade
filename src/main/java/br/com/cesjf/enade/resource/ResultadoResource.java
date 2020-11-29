package br.com.cesjf.enade.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.dto.ResultadoDto;
import br.com.cesjf.enade.service.ResultadoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("resultado")
public class ResultadoResource {

	@Autowired
	private ResultadoService service;
	
	@GetMapping("listar")
	@ApiOperation(value = "Endpoint para listar os resultados")
	public ResponseEntity<List<ResultadoDto>> listar(){
		return ResponseEntity.ok(service.listar());
	}
}
