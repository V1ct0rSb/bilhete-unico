package com.victorbarreto.bilhete_unico.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;

public class UserAuthenticated implements UserDetails {
    private UsuarioModel usuarioModel;

    public UserAuthenticated(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "read");
    }

    @Override
    public String getPassword() {
        return usuarioModel.getCpf();
    }

    @Override
    public String getUsername() {
        return usuarioModel.getNome();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
