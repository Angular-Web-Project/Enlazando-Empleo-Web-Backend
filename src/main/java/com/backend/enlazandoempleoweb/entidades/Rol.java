package com.backend.enlazandoempleoweb.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	private Long rolId;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	private Set<UsuarioRol> usuarioRolea = new HashSet<>();

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<UsuarioRol> getUsuarioRolea() {
		return usuarioRolea;
	}

	public void setUsuarioRolea(Set<UsuarioRol> usuarioRolea) {
		this.usuarioRolea = usuarioRolea;
	}

	public Rol() {
		
	}
}
