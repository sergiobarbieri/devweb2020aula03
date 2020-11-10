package br.com.drummond.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.drummond.aula.domain.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {

}
