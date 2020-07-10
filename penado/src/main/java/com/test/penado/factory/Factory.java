package com.test.penado.factory;

import com.test.penado.dto.PenadoDTO;
import com.test.penado.model.PenadoEntity;


public class Factory {
	public static PenadoEntity getPenadoEntity(PenadoDTO body) {
		if (body == null) {
			return null;
		}
		PenadoEntity response = new PenadoEntity();
		response.setId(body.getId());
		response.setRun(body.getRun());
		response.setNombres(body.getNombres());
		response.setApellidos(body.getApellidos());
		response.setDireccion(body.getDireccion());
		return response;
	}
	public static PenadoDTO getPenadoDTO(PenadoEntity penadoEntity) {
		if (penadoEntity == null) {
			return null;
		}
		PenadoDTO response = new PenadoDTO();
		response.setId(penadoEntity.getId());
		response.setRun(penadoEntity.getRun());
		response.setNombres(penadoEntity.getNombres());
		response.setApellidos(penadoEntity.getApellidos());
		response.setDireccion(penadoEntity.getDireccion());
		return response;
	}


}
