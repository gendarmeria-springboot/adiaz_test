package com.test.penado.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.penado.dto.PenadoDTO;
import com.test.penado.service.PenadoService;
import com.test.penadoweb.exception.PenadoWebException;

@RestController
@RequestMapping(value = "/penado")
@CrossOrigin("*")
public class PenadoController {
	@Autowired
	private PenadoService penadoService;
	
	// http://localhost:10000/auth/login : -> body {userName:<username>, password:
	// <password>}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PenadoDTO> create(@RequestBody PenadoDTO body) throws PenadoWebException {
		PenadoDTO response = this.penadoService.create(body);
		return new ResponseEntity<PenadoDTO>(response, HttpStatus.CREATED);
	}

	// @GetMapping(value = "/busca/{id}", produces =
	// MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/{idParam}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PenadoDTO> read(@PathVariable(required = false) int id) throws PenadoWebException {
		PenadoDTO response = this.penadoService.read(id);
		return new ResponseEntity<PenadoDTO>(response, HttpStatus.OK);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> update(@RequestBody PenadoDTO body) throws PenadoWebException {
		Boolean response = this.penadoService.update(body);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	// @DeleteMapping(value = "/eliminar/{id}", produces =
	// MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping(value = "/{idParam}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> delete(@PathVariable(required = false) int id) throws PenadoWebException {
		Boolean response = this.penadoService.delete(id);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}

}
