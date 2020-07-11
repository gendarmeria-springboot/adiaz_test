package com.test.penado.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.penado.dto.TokenDTO;
import com.test.penado.factory.Factory;
import com.test.penado.feign.client.AuthFeignClient;
import com.test.penado.feign.request.LoginFeignRequest;
import com.test.penado.feign.response.TokenFeignResponse;
import com.test.penadoweb.exception.PenadoWebException;

//se puede acceder de todos lados
@Component
public class AuthCommand {
  	
	@Autowired
	private AuthFeignClient authFeignClient;
		
	@HystrixCommand(fallbackMethod = "loginError")
	public TokenDTO login(LoginFeignRequest loginFeignRequest) throws PenadoWebException {

		// Invocando al end point auth/login -> (ms auth)
		ResponseEntity<TokenFeignResponse> responseEntity = this.authFeignClient.login(loginFeignRequest);

		// Obteniendo el json de respuesta (DTO) del endpoint auth/login -> (ms auth)
		TokenFeignResponse tokenFeingResponse = responseEntity.getBody();

		// Retorno del mapeo de respuesta al service.
		return Factory.getTokenDTO(tokenFeingResponse);
	}

	public TokenDTO loginError(LoginFeignRequest loginFeignRequest) throws PenadoWebException {
		throw new PenadoWebException("Error en la comunicación con Auth MS", HttpStatus.NOT_FOUND);
	}
}
