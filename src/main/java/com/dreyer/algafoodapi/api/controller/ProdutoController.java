/**
 * @Class ProdutoController.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 21 de jan de 2020
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

import com.dreyer.algafoodapi.domain.exception.ProdutoNotFoundException;
import com.dreyer.algafoodapi.domain.exception.RestauranteNotFoundException;
import com.dreyer.algafoodapi.domain.model.Produto;
import com.dreyer.algafoodapi.domain.model.Restaurante;
import com.dreyer.algafoodapi.domain.service.ProdutoService;
import com.dreyer.algafoodapi.domain.service.RestauranteService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@Autowired
	private RestauranteService restauranteService;
	
	@GetMapping
	public List<Produto> listAll() {
		return service.listAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findBy(@PathVariable Long id) {
		
		Produto produto = service.findBy(id);
		return ResponseEntity.status(HttpStatus.OK).body(produto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto entity){
		
		Produto produto = service.findBy(id);
		Restaurante restaurante = restauranteService.findBy(entity.getRestaurante().getId());
		
		BeanUtils.copyProperties(entity, produto, "id", "restaurante_id");
		service.saveOrUpdate(produto);
		
		return ResponseEntity.ok(produto);	
	}	
	
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto entity){
		Produto produto = service.saveOrUpdate(entity);		
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {		
		service.remove(id);			
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(String.format("PRODUTO ID: %d DELETED", id));
	}

}
