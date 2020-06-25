package com.test.penado.service.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.penado.dto.PenadoDTO;
import com.test.penado.factory.Factory;
import com.test.penado.model.PenadoEntity;
import com.test.penado.repository.PenadoRepository;
import com.test.penado.service.PenadoService;

@Service


public class PenadoServiceImpl implements PenadoService {
	@Autowired
	private PenadoRepository penadoRepository;
	@Override
	public PenadoDTO create(PenadoDTO body) {
		PenadoEntity penadoEntityNew = Factory.getPenadoEntity(body);
		PenadoEntity penadoEntity = this.penadoRepository.save(penadoEntityNew);
		return Factory.getPenadoDTO(penadoEntity);
	}
	@Override
	public PenadoDTO read(Integer id) {
		Optional<PenadoEntity> penadoEntity = this.penadoRepository.findById(id);
		if (!penadoEntity.isPresent()) {
			return null;
		}
		PenadoDTO response = Factory.getPenadoDTO(penadoEntity.get());
		return response;
	}
	@Override
	public Boolean update(PenadoDTO body) {
		PenadoEntity entity = null;
		PenadoEntity penadoEntity = this.penadoRepository.save(entity);
		if (penadoEntity == null) {
			return false;
		}
		return true;
	}
	@Override
	public Boolean delete(Integer id) {
		this.penadoRepository.deleteById(id);
		return true;
	}
}