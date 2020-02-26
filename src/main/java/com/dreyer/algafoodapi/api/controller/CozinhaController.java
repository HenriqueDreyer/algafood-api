/**
 * @Class CozinhaController.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 25 de dez de 2019
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

import com.dreyer.algafoodapi.domain.exception.CozinhaNotFoundException;
import com.dreyer.algafoodapi.domain.model.Cozinha;
import com.dreyer.algafoodapi.domain.model.Restaurante;
import com.dreyer.algafoodapi.domain.service.CozinhaService;
import com.dreyer.algafoodapi.domain.service.RestauranteService;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaService service;
	
	@GetMapping
	public List<Cozinha> list() {
		return service.listAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cozinha> findBy(@PathVariable Long id) {
		
		Cozinha cozinha = service.findBy(id);		
		return ResponseEntity.status(HttpStatus.OK).body(cozinha);
	}

	@PostMapping
	public ResponseEntity<Cozinha> save(@RequestBody Cozinha entity) {
		
		Cozinha cozinha = service.save(entity);		
		return ResponseEntity.status(HttpStatus.CREATED).body(cozinha);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha entity) {
		
		Cozinha cozinha = service.findBy(id);		
		BeanUtils.copyProperties(entity, cozinha, "id");
		service.save(cozinha);
		
		return ResponseEntity.status(HttpStatus.OK).body(cozinha);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> remove(@PathVariable Long id) {
		
		service.remove(id);	
		return ResponseEntity.status(HttpStatus.OK).body("COZINHA ID: %d REMOVED");		
	}

}
