package br.com.drummond.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.drummond.aula.domain.TipoPagamento;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Integer>  {

}
