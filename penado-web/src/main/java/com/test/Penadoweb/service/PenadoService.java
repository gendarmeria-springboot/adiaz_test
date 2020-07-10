package com.test.penado.service;
import com.test.Penadoweb.exception.PenadoWebException;
import com.test.penado.dto.PenadoDTO;



public interface PenadoService {

	PenadoDTO create(PenadoDTO body) throws PenadoWebException;

	//List<ProfileDTO> getProfiles(String token);

}





