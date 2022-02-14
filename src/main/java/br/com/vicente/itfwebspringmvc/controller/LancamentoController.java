package br.com.vicente.itfwebspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.vicente.itfwebspringmvc.model.Empresa;
import br.com.vicente.itfwebspringmvc.model.TipoLancamento;
import br.com.vicente.itfwebspringmvc.services.LancamentoService;


@Controller
public class LancamentoController {
	
	@Autowired
	LancamentoService lancamentoService;

	@GetMapping("/lancamento/cadastrar")
	public String cadastrar(Model model) {
		List<Empresa> empresas = lancamentoService.buscarEmpresas();
		
		empresas.forEach(System.out::println);
		
	
		TipoLancamento[] tiposLancamentos = TipoLancamento.values();
		
		for(TipoLancamento tipo : tiposLancamentos) {
			System.out.println(tipo.getDescricao());
		}
		model.addAttribute("tiposLancamentos",tiposLancamentos);
		model.addAttribute("empresas",empresas);
		
		return "lancamento/formulario";
	}
	
}
