/**
 * @Class PermissaoRepository.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 6 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.repository;

import org.springframework.stereotype.Repository;

import com.dreyer.algafoodapi.domain.model.Permissao;

@Repository
public interface PermissaoRepository extends CustomRepository<Permissao>{

}
