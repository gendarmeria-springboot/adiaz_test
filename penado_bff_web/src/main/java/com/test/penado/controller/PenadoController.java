package com.test.penado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//http://localhost:10000/auth/login : -> body {userName:<username>, password: <password>}
	@PostMapping(value = "/penado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PenadoDTO> create(@RequestBody PenadoDTO body) throws PenadoWebException {
		PenadoDTO response = this.penadoService.create(body);
		return new ResponseEntity<PenadoDTO>(response,HttpStatus.CREATED);
	}

}
