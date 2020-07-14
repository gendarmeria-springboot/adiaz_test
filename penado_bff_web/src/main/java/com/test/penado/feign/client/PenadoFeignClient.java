package com.test.penado.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.penado.feign.request.PenadoFeignRequest;
import com.test.penado.feign.response.PenadoFeignResponse;

@FeignClient(name = "penado") // nombre del microservicio

//name = "api-penado",url ="${api-penado.url}"

public interface PenadoFeignClient {
	// Llamando al endpoint login del controlador auth del ms auth.
	@PostMapping(value = "/penado/crear", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PenadoFeignResponse> create(@RequestBody PenadoFeignRequest body);

	@GetMapping(value = "/penado/busca/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PenadoFeignResponse> read(@PathVariable(required = false) int id);

	@PostMapping(value = "/penado/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> update(@RequestBody PenadoFeignRequest body);

	@DeleteMapping(value = "/penado/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> delete(@PathVariable(required = false) int id);

}
