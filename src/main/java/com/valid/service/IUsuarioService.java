package com.valid.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.valid.model.Usuario;


public interface IUsuarioService {
	
	public Usuario updateProcesado(Usuario u);
	
	public List<Usuario> getAllUsuarios();
	
	public Usuario createNewUser(Usuario user);
	
	public List<Usuario> updatesAllProcesado(List<Usuario> toProcess);
	
	public void deleteAll();


}
