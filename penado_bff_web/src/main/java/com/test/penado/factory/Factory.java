package com.test.penado.factory;

import com.test.penado.dto.LoginDTO;
import com.test.penado.dto.PenadoDTO;
import com.test.penado.dto.TokenDTO;
import com.test.penado.feign.request.LoginFeignRequest;
import com.test.penado.feign.request.PenadoFeignRequest;
import com.test.penado.feign.response.PenadoFeignResponse;
import com.test.penado.feign.response.TokenFeignResponse;

public class Factory {

	public static PenadoFeignRequest getPenadoFeignRequest(PenadoDTO penadodto) 
	{
		if (penadodto == null) {
			return null;
		}
	
		PenadoFeignRequest response = new PenadoFeignRequest();
		response.setId(penadodto.getId());
		response.setRun(penadodto.getRun());
		response.setNombres(penadodto.getNombres());
		response.setApellidos(penadodto.getApellidos());
		response.setDireccion(penadodto.getDireccion());
		return response;
	}

	public static PenadoDTO getPenadoDTO(PenadoFeignResponse penadodto) 
	{
		if (penadodto == null) {
			return null;
		}
	
		PenadoDTO response = new PenadoDTO();
		response.setId(penadodto.getId());
		response.setRun(penadodto.getRun());
		response.setNombres(penadodto.getNombres());
		response.setApellidos(penadodto.getApellidos());
		response.setDireccion(penadodto.getDireccion());
		return response;
	}
	
	public static LoginFeignRequest getLoginFeignRequest(LoginDTO login) {
		if (login == null) {
			return null;
		}
		LoginFeignRequest response = new LoginFeignRequest();
		response.setPassword(login.getPassword());
		response.setUserName(login.getUserName());
		return response;
	}

	public static TokenDTO getTokenDTO(TokenFeignResponse token) {
		if (token == null) {
			return null;
		}
		TokenDTO response = new TokenDTO();
		response.setToken(token.getToken());
		return response;
	}

}
