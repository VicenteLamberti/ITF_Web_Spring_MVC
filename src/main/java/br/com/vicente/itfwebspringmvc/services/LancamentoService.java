package br.com.vicente.itfwebspringmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vicente.itfwebspringmvc.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private final LancamentoRepository lancamentoRepository = null;
}
