package br.com.cesjf.enade.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesjf.enade.dto.QuestaoResultadoDto;
import br.com.cesjf.enade.dto.ResultadoDto;
import br.com.cesjf.enade.model.Prova;
import br.com.cesjf.enade.model.Questao;
import br.com.cesjf.enade.model.Resultado;
import br.com.cesjf.enade.model.Usuario;
import br.com.cesjf.enade.repository.ResultadoRepository;
import br.com.cesjf.enade.request.ResultadoRequest;

@Service
public class ResultadoService {

	@Autowired
	private ResultadoRepository repository;
	
	@Autowired
	private ProvaService serviceProva;
	
	@Autowired
	private UsuarioService serviceUsuario;
	
	public List<ResultadoDto> listar(){
		return ResultadoDto.converter(repository.findAll());
	}

	public ResultadoDto obterPorId(Long id) {
		Optional<Resultado> resultado = repository.findById(id);
		
		return resultado.isPresent() ? new ResultadoDto(resultado.get()) : null;
	}

	public ResultadoDto cadastrar(ResultadoRequest request) {
		Prova prova = serviceProva.obterProvaCompleta(request.getIdProva());
		Usuario usuario = serviceUsuario.obterAlunoPorId(request.getIdUsuario());
		
		List<Questao> questoes = prova.getListaQuestoes();
		List<QuestaoResultadoDto> questoesRequest = request.getQuestoes();
		Double valorObtido = 0.00;
		
		Iterator<Questao> iterator = questoes.iterator();
		
		while (iterator.hasNext()) {
			Questao q2 = iterator.next();
			if (q2.getTpQuestao().getIdTipoQuestao() == (1) 
					|| q2.getTpQuestao().getIdTipoQuestao() == (3)) {
				
				iterator.remove();
				valorObtido++;
			}			
		}	

		for (Questao questao : questoes) {	

			for (QuestaoResultadoDto questaoResultadoDto : questoesRequest) {			
				
				if(questaoResultadoDto.getIdQuestao().equals(questao.getIdQuestao()) && 
						questaoResultadoDto.getResposta().equals(questao.getCorreta())) {	
					
					valorObtido++;					
				}
			}
		}
		
		Resultado resultado = new Resultado(valorObtido, usuario, prova);
	
		return new ResultadoDto(repository.save(resultado));

	}

	public List<ResultadoDto> obterAlunosComProva() {
		
		return ResultadoDto.converter(repository.relatorioAlunosComProvas());
	}
}
