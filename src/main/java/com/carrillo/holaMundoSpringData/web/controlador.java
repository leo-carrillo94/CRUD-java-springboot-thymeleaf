package com.carrillo.holaMundoSpringData.web;


import com.carrillo.holaMundoSpringData.domain.Persona;
import com.carrillo.holaMundoSpringData.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class controlador {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model){

         List<Persona> personas = personaService.listarPersonas();

        log.info("Ejecutando Controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardarPersona(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
        persona = personaService.buscarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";

    }

    @GetMapping("/eliminar")
    public String eliminar (Persona persona){
        personaService.eliminarPersona(persona);
        return "redirect:/";
    }
}
