package br.com.vicente.itfwebspringmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vicente.itfwebspringmvc.model.Empresa;
import br.com.vicente.itfwebspringmvc.repositories.EmpresaRepository;
import br.com.vicente.itfwebspringmvc.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private final LancamentoRepository lancamentoRepository;
	
	private final EmpresaRepository empresaRepository;
	
	public LancamentoService(LancamentoRepository lancamentoRepository, EmpresaRepository empresaRepository) {
		this.lancamentoRepository = lancamentoRepository;
		this.empresaRepository = empresaRepository;
	}
	
	public List<Empresa> buscarEmpresas(){
		return empresaRepository.findAll();
	}
}
