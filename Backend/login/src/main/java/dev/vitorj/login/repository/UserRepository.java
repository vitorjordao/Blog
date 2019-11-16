package dev.vitorj.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.vitorj.login.modelo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
