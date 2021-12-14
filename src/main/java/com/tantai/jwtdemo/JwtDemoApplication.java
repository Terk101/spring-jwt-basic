package com.tantai.jwtdemo;

import com.tantai.jwtdemo.domain.JWTUser;
import com.tantai.jwtdemo.repository.JWTUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class JwtDemoApplication implements CommandLineRunner {
	@Autowired
	private JWTUserRepository jwtUserRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JWTUser user1 = new JWTUser();
		user1.setUserName("Dummy1");
		user1.setEmail("Dummy1@mail.com");
		user1.setPassword(bCryptPasswordEncoder.encode("password"));
		user1.setRoles(List.of("ADMIN"));
		jwtUserRepository.save(user1);
	}
}
