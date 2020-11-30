package br.com.cesjf.enade.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.dto.ResultadoDto;
import br.com.cesjf.enade.dto.UsuarioDto;
import br.com.cesjf.enade.service.ResultadoService;
import br.com.cesjf.enade.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("relatorio")
@Api(value = "Controller para ralatório.")
public class RelatorioResource {
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private ResultadoService serviceResultado;
	
	@GetMapping("alunos-sem-prova")
	@ApiOperation(value = "Endpoint para trazer alunos que não fizeram prova.")
	public ResponseEntity<?> alunosSemProva(){
		List<UsuarioDto> listaAlunos = serviceUsuario.obterAlunosSemProva();
		
		return listaAlunos.isEmpty() ? ResponseEntity.noContent().build() 
				: ResponseEntity.ok(listaAlunos);
	}
	
	@GetMapping("alunos-com-prova")
	@ApiOperation(value = "Endpoint para trazer alunos que fizeram prova.")
	public ResponseEntity<?> alunosComProva(){
		List<ResultadoDto> listaResultados = serviceResultado.obterAlunosComProva();
		
		return listaResultados.isEmpty() ? ResponseEntity.noContent().build() 
				: ResponseEntity.ok(listaResultados);
	}
	
	@GetMapping("alunos")
	@ApiOperation(value = "Endpoint para trazer todos os alunos.")
	public ResponseEntity<?> obterAlunos(){
		List<UsuarioDto> listaAlunos = serviceUsuario.obterAlunos();
		
		return listaAlunos.isEmpty() ? ResponseEntity.noContent().build() 
				: ResponseEntity.ok(listaAlunos);
	}

}
