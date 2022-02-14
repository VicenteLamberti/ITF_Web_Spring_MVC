package br.com.vicente.itfwebspringmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vicente.itfwebspringmvc.model.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{
}
