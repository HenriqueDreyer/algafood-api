/**
 * @Class CidadeService.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 4 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreyer.algafoodapi.domain.exception.CidadeIntegrityViolationException;
import com.dreyer.algafoodapi.domain.exception.CidadeNotFoundException;
import com.dreyer.algafoodapi.domain.model.Cidade;
import com.dreyer.algafoodapi.domain.repository.CidadeRepository;

@Service
public class CidadeService {

	private static final String MSG_NOT_FOUND = "CIDADE ID: %d NOT FOUND";
		
	@Autowired
	private CidadeRepository repository;

	public List<Cidade> listAll() {
		return repository.findAll();
	}

	public Cidade findBy(Long id) {		
		return repository.findById(id)
				.orElseThrow(() -> new CidadeNotFoundException(String.format(MSG_NOT_FOUND, id)));		
	}

	public Cidade save(Cidade entity) {
		return repository.save(entity);
	}
	
	public void remove(Long id) {
		Cidade entity = findBy(id);		
		
		try {
			repository.delete(entity);
		}catch (IllegalArgumentException e) {
			throw new CidadeIntegrityViolationException(String.format("CIDADE ID: %d ESTÁ SENDO UTILIZADA EM OUTRA ENTIDADE", id), e);
		}
	}

}
