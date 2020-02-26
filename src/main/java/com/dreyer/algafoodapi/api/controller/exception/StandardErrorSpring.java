/**
 * @Class StandardErrorSpring.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 18 de fev de 2020
 */
package com.dreyer.algafoodapi.api.controller.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Builder
public class StandardErrorSpring {
	
	private Integer status;
	private String type;
	private String title;
	private String detail;

}
