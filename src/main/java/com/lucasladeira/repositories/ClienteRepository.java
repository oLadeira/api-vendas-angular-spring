package com.lucasladeira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
