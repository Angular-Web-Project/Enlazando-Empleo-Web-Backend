package com.backend.enlazandoempleoweb.services.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.enlazandoempleoweb.entidades.Usuario;
import com.backend.enlazandoempleoweb.entidades.UsuarioRol;
import com.backend.enlazandoempleoweb.repositories.RolRepository;
import com.backend.enlazandoempleoweb.repositories.UsuarioRepository;
import com.backend.enlazandoempleoweb.services.UsuarioService;

@Service
public class UsuarioServiceImplementation implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception{
		Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
		if (usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
		}else {
			for (UsuarioRol usuarioRol:usuarioRoles) {
				rolRepository.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = usuarioRepository.save(usuario);
		}
		
		return usuarioLocal;
	}
	
}
