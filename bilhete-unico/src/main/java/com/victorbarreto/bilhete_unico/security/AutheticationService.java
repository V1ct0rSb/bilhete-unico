package com.victorbarreto.bilhete_unico.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutheticationService {

    private JwtService jwtService;

    public AutheticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authenticate(Authentication authetication) {
        return jwtService.generateToken(authetication);
    }
}
