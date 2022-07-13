package com.DHC35.Resolution.Service.Security;

import com.DHC35.Resolution.Entities.Usuario;
import com.DHC35.Resolution.Entities.UsuarioRole;
import com.DHC35.Resolution.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UsuarioRepository usuarioRepository;
    @Autowired
    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashUser = passwordEncoder.encode("testeruser");
        String hashAdmin = passwordEncoder.encode("testeradmin");

        Usuario usuario = new Usuario("Tester","User","testeruser@dh.com",hashUser , UsuarioRole.ROLE_USER);
        Usuario admin = new Usuario("Tester","Admin","testeradmin@dh.com",hashAdmin , UsuarioRole.ROLE_ADMIN);

        usuarioRepository.save(usuario);
        usuarioRepository.save(admin);
    }
}
