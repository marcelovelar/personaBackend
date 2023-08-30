package com.example.personaBACKEND.Controller;

import com.example.personaBACKEND.Config.JwtUtils;
import com.example.personaBACKEND.security.JwtRequest;
import com.example.personaBACKEND.security.JwtResponse;
import com.example.personaBACKEND.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager  authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            auntenticar(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Usuario no encontradp");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void auntenticar (String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e){
            throw new Exception("Usuario Deshabilitado" + e.getMessage());
        } catch (BadCredentialsException e){
            throw new Exception("Credenciales Invalidad" + e.getMessage());
        }
    }

}
