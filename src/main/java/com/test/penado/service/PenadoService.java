package com.test.penado.service;


import com.test.penado.dto.PenadoDTO;

public interface PenadoService {
	PenadoDTO  create(PenadoDTO body) ;
	
	PenadoDTO read(Integer id);

	Boolean update(PenadoDTO body);
	
	Boolean delete(Integer id);

}
