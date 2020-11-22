package br.com.cesjf.enade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesjf.enade.dto.QuestaoDto;
import br.com.cesjf.enade.model.Questao;
import br.com.cesjf.enade.model.TipoQuestao;
import br.com.cesjf.enade.repository.QuestaoRepository;
import br.com.cesjf.enade.repository.TipoQuestaoRepository;
import br.com.cesjf.enade.request.QuestaoRequest;

@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository repository;
	
	@Autowired
	private TipoQuestaoRepository tpQuestaoRepository;
	
	public List<QuestaoDto> listar() {
		return QuestaoDto.converter(repository.findAll());
	}
	
	public QuestaoDto listarPorId(Long id) {
		Optional<Questao> questao = repository.findById(id);
		return questao.isPresent() ? new QuestaoDto(questao.get()) : null;
	}
	
	public QuestaoDto cadastrar(QuestaoRequest request) {
		Questao questao = request.converter(tpQuestaoRepository);
		if(questao != null) {
			return new QuestaoDto(repository.save(questao));
		}
		return null;
	}
	
	public QuestaoDto atualizar(Long id, QuestaoRequest request) {
		Optional<Questao> optionalQuestao = repository.findById(id);
		Optional<TipoQuestao> tpQuestao = tpQuestaoRepository.findById(request.getIdTpQuestao());
		
		if(optionalQuestao.isPresent() && tpQuestao.isPresent()) {
			Questao questao = request.converter(tpQuestaoRepository);
			questao.setIdQuestao(id);
			return new QuestaoDto(repository.save(questao));
		}
		return null;
	}
	
	public Boolean deletar(Long id) {
		Optional<Questao> questao = repository.findById(id);
		Boolean res = false;
		if(questao.isPresent()){
			repository.deleteById(id); 
			res = true;
		}
		return res;
	}
}
