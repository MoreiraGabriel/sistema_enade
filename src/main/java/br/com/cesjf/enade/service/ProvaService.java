package br.com.cesjf.enade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesjf.enade.dto.ProvaDto;
import br.com.cesjf.enade.model.Prova;
import br.com.cesjf.enade.model.Questao;
import br.com.cesjf.enade.repository.ProvaRepository;
import br.com.cesjf.enade.request.ProvaRequest;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository repository;
	
	@Autowired
	private QuestaoService serviceQuestao;

	public List<ProvaDto> lista() {
		
		return ProvaDto.converter(repository.findAll());
	}

	public ProvaDto obterPorId(Long id) {
		Optional<Prova> optional = repository.findById(id);
		
		return optional.isPresent() 
				? new ProvaDto(optional.get()) : null;
	}
	
	public Boolean deletar(Long id) {
		Optional<Prova> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			repository.deleteById(id);
			return true;
		}				
		return false;
	}

	public ProvaDto cadastrar(ProvaRequest request) {
		List<Questao> quetoes = serviceQuestao.obterAtivas(request.getIdsQuestoes());
		Prova prova = new Prova(request.getDataProva(), quetoes);
		return new ProvaDto(repository.save(prova));
	}

	public ProvaDto atualizar(Long id, ProvaRequest request) {
		Optional<Prova> optional = repository.findById(id);
		if(optional.isPresent()) {
			Prova prova = optional.get();
			prova.setDataProva(request.getDataProva());
			prova.setListaQuestoes(serviceQuestao.obterAtivas(request.getIdsQuestoes()));
			return new ProvaDto(repository.save(prova));
		}
		return null;
	}
	
	public Prova obterProvaCompleta(Long id) {
		Optional<Prova> optional = repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}
}
