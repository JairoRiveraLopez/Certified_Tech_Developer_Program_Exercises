package com.DHC35.Resolution.Service.Security;

import com.DHC35.Resolution.Entities.Usuario;
import com.DHC35.Resolution.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado=usuarioRepository.findByUserName(username);
        if (usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }
        else{
            throw new UsernameNotFoundException("El username ingresado no existe en la BD. Error.");
        }
    }
}
