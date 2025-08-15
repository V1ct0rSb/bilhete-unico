package com.victorbarreto.bilhete_unico.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.victorbarreto.bilhete_unico.usuario.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        return usuarioRepository.findByNome(nome)
            .map(UserAuthenticated::new)
            .orElseThrow(() -> new UsernameNotFoundException("usuario não encontrado"));
    }
}
