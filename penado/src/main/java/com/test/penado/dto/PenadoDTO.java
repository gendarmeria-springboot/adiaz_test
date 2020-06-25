package com.test.penado.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenadoDTO {
	 private Integer id;
	 private String run;
     private String nombres;
     private String apellidos;
     private String direccion;
}
