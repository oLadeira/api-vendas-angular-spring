package com.lucasladeira.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByUsername(String username);
	
	//select count (*) > 0 from usuarios where usuarios.username = username
	boolean existsByUsername(String username);
}
