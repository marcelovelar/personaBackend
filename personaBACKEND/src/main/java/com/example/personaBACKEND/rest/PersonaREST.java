package com.example.personaBACKEND.rest;

import com.example.personaBACKEND.model.Persona;
import com.example.personaBACKEND.service.PersonaService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persona/")
public class PersonaREST {

    @Autowired
    private PersonaService personaService;
    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersona(){
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    private ResponseEntity<Persona> savePersona (@RequestBody Persona persona){
        Persona personaGuardada = personaService.save(persona);

        try {
            return  ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value="delete/{id}")
    private ResponseEntity<Boolean> deletePersona(@PathVariable("id") Long idPersona){
        personaService.deleteById(idPersona);
        return ResponseEntity.ok((personaService.findById(idPersona)!=null));
    }
}
