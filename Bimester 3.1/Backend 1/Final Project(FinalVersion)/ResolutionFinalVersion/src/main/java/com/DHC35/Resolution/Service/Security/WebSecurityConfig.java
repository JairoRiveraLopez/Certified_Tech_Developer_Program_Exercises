package com.DHC35.Resolution.Service.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UsuarioService usuarioService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public WebSecurityConfig(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index.html", "/guardarTurno.html","/obtenerTurnos.html","/turnos").hasAnyRole("USER","ADMIN")
                .antMatchers("/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .csrf().disable()
                .httpBasic()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied.html");
    }
}