package br.com.cesjf.enade.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("questao")
@Api(value = "Controller para questão.")
public class QuestaoResource {

}
