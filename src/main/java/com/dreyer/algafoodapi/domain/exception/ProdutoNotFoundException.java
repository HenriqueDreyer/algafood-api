/**
 * @Class ProdutoNotFoundException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 18 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1878243204777364325L;
	
	public ProdutoNotFoundException(String message) {
		super(message);
	}

}
