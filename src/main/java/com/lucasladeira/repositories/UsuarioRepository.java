package com.lucasladeira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
