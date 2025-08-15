package com.victorbarreto.bilhete_unico.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.victorbarreto.bilhete_unico.usuario.dto.LoginRequest;

@RestController
public class AuthenticationController {
    private AutheticationService autheticationService;

    public AuthenticationController(AutheticationService autheticationService) {
        this.autheticationService = autheticationService;
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginRequest loginRequest) {
        Authentication auth = new UsernamePasswordAuthenticationToken(
            loginRequest.username(), loginRequest.password()
        );
        return autheticationService.authenticate(auth);
    }

}
