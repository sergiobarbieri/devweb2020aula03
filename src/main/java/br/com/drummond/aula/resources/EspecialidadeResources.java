package br.com.drummond.aula.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.drummond.aula.domain.Especialidade;
import br.com.drummond.aula.repository.EspecialidadeRepository;

@RestController
@CrossOrigin
public class EspecialidadeResources {

	@Autowired
	EspecialidadeRepository especialidadeRepository;

	/**
	 * CRUD - Read (todos)
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/especialidades", method = RequestMethod.GET)
	public ResponseEntity<?> obterTodos() {
		List<Especialidade> especialidades;
		especialidades = especialidadeRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(especialidades);
	}

	/**
	 * CRUD - Create
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/especialidades", method = RequestMethod.POST)
	public ResponseEntity<?> novo(@RequestBody Especialidade especialidade) {
		Optional<Especialidade> optEspecialidade;

		optEspecialidade = especialidadeRepository.findById(especialidade.getIdFormaPagto());
		if (optEspecialidade.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");

		especialidadeRepository.save(especialidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(especialidade);
	}
}
