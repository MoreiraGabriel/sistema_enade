package br.com.cesjf.enade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cesjf.enade.dto.ResultadoDto;
import br.com.cesjf.enade.model.Resultado;
import br.com.cesjf.enade.repository.ResultadoRepository;

@Service
public class ResultadoService {

	private ResultadoRepository repository;
	
	public List<ResultadoDto> listar(){
		return ResultadoDto.converter(repository.findAll());
	}

	public ResultadoDto obterPorId(Long id) {
		Optional<Resultado> resultado = repository.findById(id);
		
		return resultado.isPresent() ? new ResultadoDto(resultado.get()) : null;
	}
}
