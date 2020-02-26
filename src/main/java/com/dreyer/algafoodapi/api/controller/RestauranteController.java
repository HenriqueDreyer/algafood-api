/**
 * @Class RestauranteController.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 4 de jan de 2020
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

import com.dreyer.algafoodapi.domain.model.Cozinha;
import com.dreyer.algafoodapi.domain.model.Restaurante;
import com.dreyer.algafoodapi.domain.service.CozinhaService;
import com.dreyer.algafoodapi.domain.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@Autowired
	private CozinhaService cozinhaService;

	@GetMapping
	public List<Restaurante> listAll() {
		return restauranteService.listAll();
	}

	@PostMapping
	public ResponseEntity<Restaurante> save(@RequestBody Restaurante entity) {
		Restaurante restaurante = restauranteService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Restaurante> update(@PathVariable Long id, @RequestBody Restaurante entity) {

		Restaurante restaurante = restauranteService.findBy(id);
		Cozinha cozinha = cozinhaService.findBy(entity.getCozinha().getId());

		BeanUtils.copyProperties(entity, restaurante, "id");
		restauranteService.save(restaurante);

		return ResponseEntity.ok(restaurante);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Restaurante> findBy(@PathVariable Long id) {

		Restaurante restaurante = restauranteService.findBy(id);
		return ResponseEntity.status(HttpStatus.OK).body(restaurante);

	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> remove(@PathVariable Long id) {

		restauranteService.remove(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(String.format("RESTAURANTE ID: %d DELETED", id));
	}

}
