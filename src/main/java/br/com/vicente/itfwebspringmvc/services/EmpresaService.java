package br.com.vicente.itfwebspringmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Empresa buscarEmpresaPorId(Integer id) {
		System.out.println("service " + id);
		Optional<Empresa> empresa = empresaRepository.findById(id);
		return empresa.orElse(null);
	}
}
