package com.test.penado.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Penadoweb.exception.PenadoWebException;
import com.test.penado.command.AuthCommand;
import com.test.penado.dto.LoginDTO;
import com.test.penado.dto.ProfileDTO;
import com.test.penado.dto.TokenDTO;
import com.test.penado.factory.Factory;
import com.test.penado.feign.request.LoginFeignRequest;
import com.test.penado.service.AuthService;



@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthCommand authCommand;

	@Override
	public TokenDTO login(LoginDTO body) throws PenadoWebException {

		// Mapeo a DTO del MS de destino (LoginDTO(ms challenge-web) -> LoginDTO(ms
		// auth)
		LoginFeignRequest loginFeignRequest = Factory.getLoginFeignRequest(body);

		// Invocando al MS AUTH a través de HystrixCommand
		TokenDTO response = this.authCommand.login(loginFeignRequest);

		// retorno al controlador
		return response;
	}

	@Override
	public List<ProfileDTO> getProfiles(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
