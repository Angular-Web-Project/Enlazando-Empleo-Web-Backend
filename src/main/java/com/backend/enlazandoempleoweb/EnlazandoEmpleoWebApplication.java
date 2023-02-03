package com.backend.enlazandoempleoweb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.enlazandoempleoweb.entidades.Rol;
import com.backend.enlazandoempleoweb.entidades.Usuario;
import com.backend.enlazandoempleoweb.entidades.UsuarioRol;
import com.backend.enlazandoempleoweb.services.UsuarioService;

@SpringBootApplication
public class EnlazandoEmpleoWebApplication implements CommandLineRunner{

	@Autowired
	private UsuarioService usuarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(EnlazandoEmpleoWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Edison");
		usuario.setApellido("Salinas");
		usuario.setUsername("edisal");
		usuario.setPassword("123");
		usuario.setEmail("salinas@gmail.com");
		usuario.setTelefono("0964223585");
		usuario.setPerfil("foto.png");
		
		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("Admin");
		
		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);
		
		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());
		
		
	}

}
