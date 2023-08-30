package com.example.personaBACKEND;

import com.example.personaBACKEND.model.Usuario;
import com.example.personaBACKEND.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PersonaBackendApplicationTests {

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(3);
		us.setNombre("codex");
		us.setClave(encoder.encode("123"));
		Usuario retorno = repo.save(us);

		assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
	}

}
