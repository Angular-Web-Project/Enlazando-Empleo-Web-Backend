package com.backend.enlazandoempleoweb.services;

import java.util.Set;

import com.backend.enlazandoempleoweb.entidades.Usuario;
import com.backend.enlazandoempleoweb.entidades.UsuarioRol;

public interface UsuarioService {

	public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles);
}
