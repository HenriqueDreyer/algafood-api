/**
 * @Class ProdutoService.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 18 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreyer.algafoodapi.domain.exception.ProdutoNotFoundException;
import com.dreyer.algafoodapi.domain.model.Produto;
import com.dreyer.algafoodapi.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto saveOrUpdate(Produto entity) {
		return produtoRepository.save(entity);
	}

	public Produto findBy(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ProdutoNotFoundException(String.format("PRODUTO ID: %d NOT FOUND", id)));
	}
			
	public void remove(Long id) {
		Produto produto = findBy(id);
		produtoRepository.delete(produto);
	}
	
	public List<Produto> listAll(){
		return produtoRepository.findAll();
	}
}
