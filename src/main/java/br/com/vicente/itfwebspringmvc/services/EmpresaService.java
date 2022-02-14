package br.com.vicente.itfwebspringmvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.vicente.itfwebspringmvc.model.Empresa;
import br.com.vicente.itfwebspringmvc.repositories.EmpresaRepository;

@Service
public class EmpresaService {


	
	private EmpresaRepository empresaRepository;
	
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public List<Empresa> buscarEmpresas(){
		return empresaRepository.findAll();
	}
	
}
