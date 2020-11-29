package br.com.cesjf.enade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cesjf.enade.dto.ResultadoDto;
import br.com.cesjf.enade.repository.ResultadoRepository;

@Service
public class ResultadoService {

	private ResultadoRepository repository;
	
	public List<ResultadoDto> listar(){
		return ResultadoDto.converter(repository.findAll());
	}
}
