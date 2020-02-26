/**
 * @Class RestauranteService.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 4 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreyer.algafoodapi.domain.exception.RestauranteNotFoundException;
import com.dreyer.algafoodapi.domain.model.Restaurante;
import com.dreyer.algafoodapi.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

	private static final String MSG_NOT_FOUND = "RESTAURANTE ID: %d NOT FOUND";
	
	@Autowired
	private RestauranteRepository repository;

	public List<Restaurante> listAll() {
		return repository.findAll();
	}

	public Restaurante save(Restaurante entity) {
		return repository.save(entity);
	}

	public Restaurante findBy(Long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new RestauranteNotFoundException(String.format(MSG_NOT_FOUND, id)));
	}

	public void remove(Long id) {
		Restaurante entity = findBy(id);
		repository.delete(entity);
	}
}
