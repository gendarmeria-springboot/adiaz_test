package com.test.penado.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Penado")
public class PenadoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "run", nullable = false)
	private String run;
	@Column(name = "nombres", nullable = false)
	private String nombres;
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	@Column(name = "direccion", nullable = false)
	private String direccion;
}




