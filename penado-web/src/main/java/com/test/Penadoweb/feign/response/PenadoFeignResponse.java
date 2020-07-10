package com.test.penado.feign.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PenadoFeignResponse {
	 private Integer id;
	 private String run;
     private String nombres;
     private String apellidos;
     private String direccion;

}
