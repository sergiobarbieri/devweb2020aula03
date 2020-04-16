package br.com.drummond.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.drummond.aula.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>  {

}
