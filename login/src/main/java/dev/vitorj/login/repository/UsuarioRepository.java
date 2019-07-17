package dev.vitorj.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.vitorj.login.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

}
