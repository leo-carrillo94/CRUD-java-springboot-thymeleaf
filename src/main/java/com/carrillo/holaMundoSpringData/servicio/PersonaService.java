package com.carrillo.holaMundoSpringData.servicio;

import com.carrillo.holaMundoSpringData.domain.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> listarPersonas();

    public void guardarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
    public Persona buscarPersona(Persona persona);
}
