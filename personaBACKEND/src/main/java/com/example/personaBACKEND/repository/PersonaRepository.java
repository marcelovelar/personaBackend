package com.example.personaBACKEND.repository;

import com.example.personaBACKEND.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
