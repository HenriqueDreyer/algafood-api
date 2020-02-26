/**
 * @Class CozinhaService.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 3 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dreyer.algafoodapi.domain.exception.CozinhaIntegrityViolationException;
import com.dreyer.algafoodapi.domain.exception.CozinhaNotFoundException;
import com.dreyer.algafoodapi.domain.model.Cozinha;
import com.dreyer.algafoodapi.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	private CozinhaRepository repository;

	public Cozinha save(Cozinha entity) {
		return repository.save(entity);
	}

	public Cozinha findBy(Long id) {
		Cozinha cozinha = repository.findById(id)
				.orElseThrow(() -> new CozinhaNotFoundException(String.format("COZINHA ID: %d NOT FOUND", id)));
		
		return cozinha;
	}
		
	public List<Cozinha> listAll() {
		return repository.findAll();
	}

	public void remove(Long id) {
		Cozinha entity = findBy(id);
		try {
			repository.delete(entity);
		}catch (DataIntegrityViolationException e) {
			throw new CozinhaIntegrityViolationException(String.format("COZINHA ID: %d ESTA EM USO EM OUTRA ENTIDADE", id), e);
		}
		
	}
}
