package br.com.cesjf.enade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesjf.enade.repository.QuestaoRepository;

@Service
public class QuestaoService {

	@Autowired
	private QuestaoRepository repository;
}
