package com.tantai.jwtdemo.service;

import com.tantai.jwtdemo.domain.JWTUser;
import com.tantai.jwtdemo.repository.JWTUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JWTUserService implements UserDetailsService {

    private JWTUserRepository jwtUserRepository;

    public JWTUserService(JWTUserRepository jwtUserRepository) {
        this.jwtUserRepository = jwtUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return jwtUserRepository.findByEmail(username).map(p -> {
            Set<GrantedAuthority> userRoles = new HashSet<>();
            p.getRoles().forEach(role -> {
                userRoles.add(new SimpleGrantedAuthority(role));
            });
            return new User(p.getUserName(), p.getPassword(), userRoles);
        }).orElseThrow(() -> new UsernameNotFoundException("Not found user " + username));
    }

    public Optional<JWTUser> getByEmail(String email) {
        return jwtUserRepository.findByEmail(email);
    }

    public Optional<JWTUser> getByUserName(String userName) {
        return jwtUserRepository.findByUserName(userName);
    }
}
