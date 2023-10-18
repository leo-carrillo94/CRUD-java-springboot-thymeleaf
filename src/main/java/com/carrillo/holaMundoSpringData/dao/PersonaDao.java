package com.carrillo.holaMundoSpringData.dao;

import com.carrillo.holaMundoSpringData.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
}
