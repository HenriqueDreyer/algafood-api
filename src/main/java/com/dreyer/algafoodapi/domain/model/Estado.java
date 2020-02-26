/**
 * @Class Estado.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 25 de dez de 2019
 */
package com.dreyer.algafoodapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PRIVATE)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(length = 2, nullable = false)
	private String uf;
}
