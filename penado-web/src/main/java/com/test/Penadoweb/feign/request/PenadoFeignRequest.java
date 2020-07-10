package com.test.penado.feign.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class PenadoFeignRequest {
	 private Integer id;
	 private String run;
     private String nombres;
     private String apellidos;
     private String direccion;
}


