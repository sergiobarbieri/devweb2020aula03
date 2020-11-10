package br.com.drummond.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.drummond.aula.domain.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer>  {

}
