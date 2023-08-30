package com.example.personaBACKEND.service;

import com.example.personaBACKEND.model.Usuario;
import com.example.personaBACKEND.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us = this.repo.findByNombre(username);
        if (us == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

//        List<GrantedAuthority> roles = new ArrayList<>();
//        roles.add(new SimpleGrantedAuthority("Admin"));
//
//        UserDetails userDetails = new User(us.getNombre(), us.getClave(), roles);
//        //return userDetails;
        return us;

    }
}
