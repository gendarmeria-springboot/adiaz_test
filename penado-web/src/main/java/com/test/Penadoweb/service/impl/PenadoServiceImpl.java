package com.test.penado.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Penadoweb.exception.PenadoWebException;
import com.test.penado.command.PenadoCommand;
import com.test.penado.dto.PenadoDTO;
import com.test.penado.factory.Factory;
import com.test.penado.feign.request.PenadoFeignRequest;
import com.test.penado.service.PenadoService;


@Service
public class PenadoServiceImpl implements PenadoService {

	@Autowired
	private PenadoCommand penadoCommand;

	@Override
	public PenadoDTO create(PenadoDTO body) throws PenadoWebException {

		// Mapeo a DTO del MS de destino (LoginDTO(ms challenge-web) -> LoginDTO(ms
		// auth)
		PenadoFeignRequest penadoFeignRequest = Factory.getPenadoFeignRequest(body);

		// Invocando al MS AUTH a través de HystrixCommand
		PenadoDTO response = this.penadoCommand.create(penadoFeignRequest);

		// retorno al controlador
		return response;
	}

	//@Override
	//public List<ProfileDTO> getProfiles(String token) {
		// TODO Auto-generated method stub
	//	return null;
	//}

}
