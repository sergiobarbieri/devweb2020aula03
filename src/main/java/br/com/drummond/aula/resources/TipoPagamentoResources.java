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

import br.com.drummond.aula.domain.TipoPagamento;

import br.com.drummond.aula.repository.TipoPagamentoRepository;

@RestController
@CrossOrigin
public class TipoPagamentoResources {

	@Autowired
	TipoPagamentoRepository tipoPagamentoRepository;

	/**
	 * CRUD - Read (todos)
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/tipoPagamentos", method = RequestMethod.GET)
	public ResponseEntity<?> obterTodos() {
		List<TipoPagamento> tipoPagamentos;
		tipoPagamentos = tipoPagamentoRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(tipoPagamentos);
	}

	/**
	 * CRUD - Create
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/tipoPagamentos", method = RequestMethod.POST)
	public ResponseEntity<?> novo(@RequestBody TipoPagamento tipoPagamento) {
		Optional<TipoPagamento> optTipoPagamento;

		optTipoPagamento = tipoPagamentoRepository.findById(tipoPagamento.getIdTpPgto());
		if (optTipoPagamento.isPresent())
			return ResponseEntity.status(HttpStatus.CONFLICT).body("");

		tipoPagamentoRepository.save(tipoPagamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoPagamento);
	}
}
