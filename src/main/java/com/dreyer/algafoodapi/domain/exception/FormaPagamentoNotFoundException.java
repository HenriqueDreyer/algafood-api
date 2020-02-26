/**
 * @Class FormaPagamentoNotFoundException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 2 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

public class FormaPagamentoNotFoundException extends Exception{

	private static final long serialVersionUID = -3319575273861426246L;
	
	public FormaPagamentoNotFoundException(String message) {
		super(message);
	}

}
