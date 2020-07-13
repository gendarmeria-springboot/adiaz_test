package com.test.penado.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.test.penado.dto.PenadoDTO;
import com.test.penadoweb.exception.PenadoWebException;



public interface PenadoService {

	PenadoDTO create(PenadoDTO body) throws PenadoWebException;
	
	PenadoDTO read(@PathVariable(required = false) int id) throws PenadoWebException;

	String update(PenadoDTO body) throws PenadoWebException;
	
	Boolean delete(@PathVariable(required = false) int id) throws PenadoWebException;
}
