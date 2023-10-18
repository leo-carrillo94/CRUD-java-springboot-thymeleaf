package com.carrillo.holaMundoSpringData.servicio;

import com.carrillo.holaMundoSpringData.dao.PersonaDao;
import com.carrillo.holaMundoSpringData.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PersonaServicioImp  implements PersonaService {

    @Autowired
    private PersonaDao personaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {

        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarPersona(Persona persona) {
        personaDao.save(persona);

    }

    @Override
    @Transactional
    public void eliminarPersona(Persona persona) {
        personaDao.delete(persona);

    }

    @Override
    @Transactional(readOnly = true)
    public Persona buscarPersona(Persona persona) {

        return personaDao.findById(persona.getId_persona()).orElse(null);
    }
}
