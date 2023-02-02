package com.backend.enlazandoempleoweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.enlazandoempleoweb.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

	public Usuario findByUsername(String username);
	
}
