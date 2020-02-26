/**
 * @Class EstadoService.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 4 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dreyer.algafoodapi.domain.exception.EstadoIntegrityViolationException;
import com.dreyer.algafoodapi.domain.exception.EstadoNotFoundException;
import com.dreyer.algafoodapi.domain.model.Estado;
import com.dreyer.algafoodapi.domain.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> listAll() {
		return repository.findAll();
	}

	public Estado save(Estado entity) {
		return repository.save(entity);
	}

	public Estado findBy(Long id) {
		Estado estado = repository.findById(id)
				.orElseThrow(() -> new EstadoNotFoundException(String.format("ESTADO ID: %d NOT FOUND", id)));

		return estado;
	}

	public void remove(Long id) {		
		Estado entity = findBy(id);
		
		try {
			repository.delete(entity);
		}catch (DataIntegrityViolationException e) {
			throw new EstadoIntegrityViolationException(String.format("ESTADO ID: %d ESTA SENDO UTILIZADO EM OUTRA ENTIDADE", id), e);
		}
		
	}
}
