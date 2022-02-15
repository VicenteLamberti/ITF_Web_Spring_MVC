package br.com.vicente.itfwebspringmvc.controller;

import java.lang.management.PlatformLoggingMXBean;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vicente.itfwebspringmvc.form.FormLancamento;
import br.com.vicente.itfwebspringmvc.model.Empresa;
import br.com.vicente.itfwebspringmvc.model.Lancamento;
import br.com.vicente.itfwebspringmvc.model.TipoLancamento;
import br.com.vicente.itfwebspringmvc.services.EmpresaService;
import br.com.vicente.itfwebspringmvc.services.LancamentoService;

@RequestMapping("/lancamento")
@Controller
public class LancamentoController {
	
	@Autowired
	LancamentoService lancamentoService;
	
	@Autowired
	EmpresaService empresaService;

	@GetMapping("/cadastrar")
	public String cadastrar(Model model, FormLancamento formLancamento) {
		List<Empresa> empresas = empresaService.buscarEmpresas();
		TipoLancamento[] tiposLancamentos = TipoLancamento.values();
		
		model.addAttribute("tiposLancamentos",tiposLancamentos);
		model.addAttribute("empresas",empresas);
		
		return "lancamento/formulario";
	}

	@PostMapping("/lancamento/novo")
	public String novo(@Valid FormLancamento formLancamento, BindingResult result) throws ParseException {
		System.out.println(formLancamento.getEmpresa());
	
		
		
		lancamentoService.salvarLancamento(formLancamento);
		return "lancamento/formulario";
		
		
	}
	
}
