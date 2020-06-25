package com.test.penado.repository;
import org.springframework.data.repository.CrudRepository;
import com.test.penado.model.PenadoEntity;

public interface PenadoRepository extends CrudRepository<PenadoEntity, Integer> {

}