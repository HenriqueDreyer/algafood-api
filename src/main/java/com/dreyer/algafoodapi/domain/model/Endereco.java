/**
 * @Class Endereco.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 13 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Embeddable
@Data
public class Endereco {
	
	@Column(name = "endereco_cep", nullable = false)
	private String cep;
	
	@Column(name = "endereco_logradouro", nullable = false)
	private String logradouro;
	
	@Column(name = "endereco_numero", nullable = false)
	private String numero;
	
	@Column(name = "endereco_complemento", nullable = true)
	private String complemento;
	
	@Column(name = "endereco_bairro", nullable = false)
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id", nullable = false)
	private Cidade cidade;

}
