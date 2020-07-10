package com.test.penado.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.penado.dto.PenadoDTO;
import com.test.penado.factory.Factory;
import com.test.penado.feign.client.PenadoFeignClient;
import com.test.penado.feign.request.PenadoFeignRequest;
import com.test.penado.feign.response.PenadoFeignResponse;
import com.test.penadoweb.exception.PenadoWebException;

@Component
public class PenadoCommand {

	@Autowired
	private PenadoFeignClient penadoFeignClient;

	@HystrixCommand(fallbackMethod = "penadoError")
	public PenadoDTO create(PenadoFeignRequest penadoFeignRequest) throws PenadoWebException {

		// Invocando al end point penado/ -> (ms auth)
		ResponseEntity<PenadoFeignResponse> responseEntity = this.penadoFeignClient.create(penadoFeignRequest);
		// Retorno del mapeo de respuesta al service.
		return Factory.getPenadoDTO(responseEntity.getBody());
	}

	public PenadoDTO penadoError(PenadoFeignRequest penadoFeignRequest) throws PenadoWebException {
		throw new PenadoWebException("Error en la comunicación con Penado MS", HttpStatus.NOT_FOUND);
	}
}
