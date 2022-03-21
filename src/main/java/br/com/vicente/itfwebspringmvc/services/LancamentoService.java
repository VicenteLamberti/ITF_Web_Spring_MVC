package br.com.vicente.itfwebspringmvc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vicente.itfwebspringmvc.form.FormLancamento;
import br.com.vicente.itfwebspringmvc.model.Empresa;
import br.com.vicente.itfwebspringmvc.model.Lancamento;
import br.com.vicente.itfwebspringmvc.model.TipoLancamento;
import br.com.vicente.itfwebspringmvc.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private final LancamentoRepository lancamentoRepository;
	
	@Autowired
	private final EmpresaService empresaService;
	
	
	
	public LancamentoService(LancamentoRepository lancamentoRepository, EmpresaService empresaService) {
		this.lancamentoRepository = lancamentoRepository;
		this.empresaService = empresaService;
	}
	
	
	
	public Lancamento salvarLancamento(FormLancamento formLancamento) throws ParseException {
		Lancamento lancamento = toLancamento(formLancamento);
		return lancamentoRepository.save(lancamento);
	}
	
	
	
	private Lancamento toLancamento(FormLancamento formLancamento) throws ParseException {
		Lancamento lancamento = new Lancamento();
		lancamento.setDescricao(formLancamento.getDescricao());
		lancamento.setValor(Double.parseDouble(formLancamento.getValor()));
		
		Empresa empresa = empresaService.buscarEmpresaPorId(formLancamento.getEmpresa());
		lancamento.setEmpresa(empresa);
		
		Date dateVencimento = new SimpleDateFormat("yyyy-MM-dd").parse(formLancamento.getDataVencimento());
		lancamento.setDataVencimento(dateVencimento);
		
		Date datePagamento = new SimpleDateFormat("yyyy-MM-dd").parse(formLancamento.getDataPagamento());
		lancamento.setDataPagamento(datePagamento);
		
		lancamento.setPago(formLancamento.getContaPaga());

		System.out.println(TipoLancamento.valueOf(formLancamento.getTipoLancamento()));
		lancamento.setTipo(TipoLancamento.valueOf(formLancamento.getTipoLancamento()));
		
		
		return lancamento;
	}
	
	
}
