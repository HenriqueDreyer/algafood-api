/**
 * @Class CidadeController.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 5 de jan de 2020
 */
package com.dreyer.algafoodapi.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dreyer.algafoodapi.domain.model.Cidade;
import com.dreyer.algafoodapi.domain.model.Estado;
import com.dreyer.algafoodapi.domain.service.CidadeService;
import com.dreyer.algafoodapi.domain.service.EstadoService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public List<Cidade> listAll() {
		return cidadeService.listAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findBy(@PathVariable Long id) {

		Cidade cidade = cidadeService.findBy(id);
		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}

	@PostMapping
	public ResponseEntity<Cidade> save(@RequestBody Cidade entity) {
		Cidade cidade = cidadeService.save(entity);
		return ResponseEntity.ok(cidade);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cidade> update(@PathVariable Long id, @RequestBody Cidade entity) {

		Cidade cidade = cidadeService.findBy(id);
		Estado estado = estadoService.findBy(entity.getEstado().getId());

		BeanUtils.copyProperties(entity, cidade, "id");
		cidadeService.save(cidade);

		return ResponseEntity.status(HttpStatus.OK).body(cidade);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> remove(@PathVariable Long id) {
		
		cidadeService.remove(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(String.format("CIDADE ID: %d DELETED", id));
	}

}
