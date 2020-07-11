package com.test.regiones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionesDTO {
	 private Integer codigo;
	 private String descripcion;
     private String sigla;
     private String orden;
     
}
