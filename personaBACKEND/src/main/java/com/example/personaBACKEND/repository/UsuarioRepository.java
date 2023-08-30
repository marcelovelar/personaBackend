package com.example.personaBACKEND.repository;

import com.example.personaBACKEND.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombre(String nombre);

    Usuario findById(String id);
}
