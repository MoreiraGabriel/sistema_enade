package br.com.cesjf.enade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesjf.enade.service.UsuarioService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("relatorio")
@Api("Controller para ralatório.")
public class RelatorioResource {
	
	@Autowired
	private UsuarioService serviceUsuario;
	


}
