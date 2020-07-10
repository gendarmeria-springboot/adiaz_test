package com.test.penado.service;

import com.test.penado.dto.PenadoDTO;
import com.test.penadoweb.exception.PenadoWebException;



public interface PenadoService {

	PenadoDTO create(PenadoDTO body) throws PenadoWebException;

	//List<ProfileDTO> getProfiles(String token);

}
