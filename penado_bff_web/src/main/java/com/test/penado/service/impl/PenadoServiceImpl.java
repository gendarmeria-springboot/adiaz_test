package com.test.penado.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.penado.command.PenadoCommand;
import com.test.penado.dto.PenadoDTO;
import com.test.penado.factory.Factory;
import com.test.penado.feign.request.PenadoFeignRequest;

import com.test.penado.service.PenadoService;
import com.test.penadoweb.exception.PenadoWebException;

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

	@Override
	public PenadoDTO read(int id) throws PenadoWebException {
		PenadoDTO response = this.penadoCommand.read(id);
		// retorno al controlador
		return response;
	}

	@Override
	public Boolean update(PenadoDTO body) throws PenadoWebException {

		PenadoFeignRequest entity = Factory.getPenadoFeignRequest(body);
		Boolean resp = this.penadoCommand.update(entity);
		return resp;

	}

	@Override
	public Boolean delete(int id) throws PenadoWebException {
		// TODO Auto-generated method stub
		Boolean resp = this.penadoCommand.delete(id);
		return resp;

	}

	// @Override
	// public List<ProfileDTO> getProfiles(String token) {
	// TODO Auto-generated method stub
	// return null;
	// }

}
