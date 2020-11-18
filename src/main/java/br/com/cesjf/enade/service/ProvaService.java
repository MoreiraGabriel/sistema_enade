package br.com.cesjf.enade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cesjf.enade.repository.ProvaRepository;

@Service
public class ProvaService {

	@Autowired
	private ProvaRepository repository;
}
