package com.valid.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valid.model.Usuario;
import com.valid.service.IUsuarioService;


@RestController
@RequestMapping("/usuarios")
public class ValidController {
	

	
	@Autowired
	private IUsuarioService service;
	
	
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public List<Usuario> getAllUsuarios()
	{
		return service.getAllUsuarios();
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public Usuario createUser(@RequestBody Usuario user)
	{	
		return service.createNewUser(user);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping()
	public List<Usuario> updateProcesado(@RequestBody List<Usuario> users)
	{
		return service.updatesAllProcesado(users);
	}
	
	
}
