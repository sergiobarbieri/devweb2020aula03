package br.com.drummond.aula.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.drummond.aula.domain.Aluno;
import br.com.drummond.aula.repository.AlunoRepository;

@RestController
public class CRUDAlunosResources {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	/**
	 * CRUD - Read (todos)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/alunos", method = RequestMethod.GET)
	public ResponseEntity<?> obterTodosAlunos()
	{
		List<Aluno> alunos;
		alunos = alunoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}
	

	/**
	 * CRUD - Read (especifico)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/alunos/{RA}", method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunosPorRA(@PathVariable("RA") Integer RA)
	{
		Optional<Aluno> optAluno;
		Aluno aluno;
		
		optAluno = alunoRepository.findById(RA);
		if (!optAluno.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		
		aluno = optAluno.get();

		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	/**
	 * CRUD - Create
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/alunos", method = RequestMethod.POST)
	public ResponseEntity<?> novoAluno(@RequestBody Aluno aluno)
	{
		Optional<Aluno> optAluno;
		
		optAluno = alunoRepository.findById(aluno.getRA());
		if (optAluno.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");
		
		alunoRepository.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	/**
	 * CRUD - Update
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/alunos/{RA}", method = RequestMethod.PUT)
	public ResponseEntity<?> alteraAluno(@PathVariable("RA") Integer RA, @RequestBody Aluno aluno)
	{
		Optional<Aluno> optAluno;
		optAluno = alunoRepository.findById(aluno.getRA());
		if (!optAluno.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		
		aluno.setRA(RA);
		alunoRepository.save(aluno);
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	/**
	 * CRUD - Delete
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/alunos/{RA}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAluno(@PathVariable("RA") Integer RA)
	{
		Optional<Aluno> optAluno;
		optAluno = alunoRepository.findById(RA);
		if (!optAluno.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
		
		alunoRepository.deleteById(RA);
		return ResponseEntity.status(HttpStatus.OK).body(optAluno.get());
	}
}
