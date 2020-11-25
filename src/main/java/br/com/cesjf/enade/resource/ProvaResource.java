package br.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.dto.ProvaDto;
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
	public ResponseEntity<?> listarTodas(){
		return ResponseEntity.ok(service.lista());
	}
	
	@ApiOperation(value = "Endpoint para listar prova por id.")
	public ResponseEntity<?> obterPorId(Long id){
		ProvaDto dto = service.obterPorId(id);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.noContent().build();
	}
}
