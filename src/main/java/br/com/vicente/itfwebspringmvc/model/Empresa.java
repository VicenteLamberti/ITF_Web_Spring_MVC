package br.com.vicente.itfwebspringmvc.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "empresa")
public class Empresa implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	
	
	
	public Empresa() {
	}
	
	public Empresa(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome=nome;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	
	
	
	
}
