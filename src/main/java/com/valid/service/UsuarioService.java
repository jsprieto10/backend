package com.valid.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valid.model.Usuario;
import com.valid.repositoy.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	
	@Autowired
	private IUsuarioRepository repository;
	
	
	public UsuarioService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario updateProcesado(Usuario u){
		// TODO Auto-generated method stub
		
		Usuario user = repository.findById(u.getId()).get();
		user.setProcesado(true);
		
		return repository.save(user);
	}
	
	public List<Usuario> updatesAllProcesado(List<Usuario> toProcess){
		
		List<Usuario> processed = new ArrayList<Usuario>();
		for (Usuario u : toProcess)
		{
			try 
			{
				processed.add(updateProcesado(u));
			}
			catch(Exception e) 
			{
				
			}
		}
		
		return processed;
	}
	
	
	public void deleteAll()
	{
		repository.deleteAll();
	}
	
	

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Usuario createNewUser(Usuario user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}
	

	

}
