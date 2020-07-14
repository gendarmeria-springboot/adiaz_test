package com.test.penado.service;


import com.test.penado.dto.PenadoDTO;
import com.test.penadoweb.exception.PenadoWebException;



public interface PenadoService {

	PenadoDTO create(PenadoDTO body) throws PenadoWebException;
	
	PenadoDTO read( int id) throws PenadoWebException;

	Boolean update(PenadoDTO body) throws PenadoWebException;
	
	Boolean delete(int id) throws PenadoWebException;
}
