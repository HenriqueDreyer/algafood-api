/**
 * @Class EstadoController.java
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

import com.dreyer.algafoodapi.domain.model.Estado;
import com.dreyer.algafoodapi.domain.service.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	public List<Estado> list(){
		return service.listAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findBy(@PathVariable Long id) {
		
		Estado estado = service.findBy(id);
		return ResponseEntity.status(HttpStatus.OK).body(estado);
	}
	
	@PostMapping
	public ResponseEntity<Estado> save(@RequestBody Estado entity) {
		Estado estado = service.save(entity);
		return ResponseEntity.ok(estado);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody Estado entity) {
		
			Estado estado = service.findBy(id);
			BeanUtils.copyProperties(entity, estado, "id");
			
			estado = service.save(estado);
			return ResponseEntity.ok(estado);		
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> remove(@PathVariable Long id) {
		
		service.remove(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(String.format("ESTADO ID: %d DELETED", id));
	}

}
