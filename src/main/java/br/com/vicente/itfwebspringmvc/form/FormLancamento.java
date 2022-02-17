package br.com.vicente.itfwebspringmvc.form;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.vicente.itfwebspringmvc.model.Empresa;
import br.com.vicente.itfwebspringmvc.model.Lancamento;
import br.com.vicente.itfwebspringmvc.services.EmpresaService;

public class FormLancamento {
	
	@Autowired
	private EmpresaService empresaService;
	
	private String tipoLancamento;
	private Integer empresa;
	private String descricao;
	private String valor;
	private String dataVencimento;
	private Boolean contaPaga;
	private String dataPagamento;
	
	
	

	public String getTipoLancamento() {
		return tipoLancamento;
	}




	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}




	public Integer getEmpresa() {
		return empresa;
	}




	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public String getValor() {
		return valor;
	}




	public void setValor(String valor) {
		this.valor = valor;
	}




	public String getDataVencimento() {
		return dataVencimento;
	}




	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}




	







	public Boolean getContaPaga() {
		return contaPaga;
	}




	public void setContaPaga(Boolean contaPaga) {
		this.contaPaga = contaPaga;
	}




	public String getDataPagamento() {
		return dataPagamento;
	}




	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}




	

	
}
