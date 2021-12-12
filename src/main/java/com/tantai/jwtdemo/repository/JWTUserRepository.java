package com.tantai.jwtdemo.repository;

import com.tantai.jwtdemo.domain.JWTUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface JWTUserRepository extends CrudRepository<JWTUser, Long> {
    Optional<JWTUser> findByEmail(String email);
}
