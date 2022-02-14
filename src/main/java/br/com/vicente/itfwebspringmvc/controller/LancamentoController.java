package br.com.vicente.itfwebspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LancamentoController {

	@GetMapping("/lancamento/cadastrar")
	public String cadastrar() {
		return "lancamento/formulario";
	}
	
}
