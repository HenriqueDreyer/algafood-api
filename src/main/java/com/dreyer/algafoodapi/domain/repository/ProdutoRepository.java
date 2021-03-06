/**
 * @Class ProdutoRepository.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 18 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.repository;

import org.springframework.stereotype.Repository;

import com.dreyer.algafoodapi.domain.model.Produto;

@Repository
public interface ProdutoRepository extends CustomRepository<Produto>{

}
