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

import br.com.drummond.aula.domain.FormaPagamento;

import br.com.drummond.aula.repository.FormaPagamentoRepository;

@RestController
@CrossOrigin
public class FormaPagamentoResources {

	@Autowired
	FormaPagamentoRepository formaPagamentoRepository;

	/**
	 * CRUD - Read (todos)
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/formaPagamentos", method = RequestMethod.GET)
	public ResponseEntity<?> obterTodos() {
		List<FormaPagamento> formaPagamentos;
		formaPagamentos = formaPagamentoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(formaPagamentos);
	}

	/**
	 * CRUD - Create
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/formaPagamentos", method = RequestMethod.POST)
	public ResponseEntity<?> novo(@RequestBody FormaPagamento formaPagamento) {
		Optional<FormaPagamento> optFormaPagamento;

		optFormaPagamento = formaPagamentoRepository.findById(formaPagamento.getIdFormaPagto());
		if (optFormaPagamento.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");

		formaPagamentoRepository.save(formaPagamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamento);
	}
}
