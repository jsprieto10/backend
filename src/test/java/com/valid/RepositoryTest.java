package com.valid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valid.model.Usuario;
import com.valid.repositoy.IUsuarioRepository;


@SpringBootTest
class RepositoryTest {

	
	@Autowired
	private IUsuarioRepository userRepo;
	
	@Test
	void crearUsuarioTest()
	{
		userRepo.deleteAll();
		
		Usuario user = new Usuario("test1", "last test");
		Usuario respuesta = userRepo.save(user);
		assertTrue(respuesta.getId()>0);
	}
	
	@Test
	void asignacionIdsTest()
	{
		userRepo.deleteAll();
		
		for (int i = 1; i < 20; i++)
		{
			Usuario user = new Usuario("test"+i, "last test");
			Usuario respuesta = userRepo.save(user);
			assertTrue(respuesta.getId()==i);
		}
	}
	
	@Test
	void darListaTest()
	{
		userRepo.deleteAll();
		
		List<Usuario> agregados = new ArrayList<Usuario>();
		for(int i = 1; i < 20; i++)
		{
			Usuario user = new Usuario("test"+i, "last test");
			Usuario respuesta = userRepo.save(user);
			agregados.add(respuesta);
		}
		
		List<Usuario> usuarios = userRepo.findAll();
		assertTrue(usuarios.size() == 19);
		for(int i = 0; i < 19; i++)
		{
			assertEquals(agregados.get(i).getNombre(), usuarios.get(i).getNombre());
		}
	}
	
	@Test
	void update()
	{
		userRepo.deleteAll();
		crearUsuarioTest();
		Usuario user = userRepo.findAll().get(0);
		
		assertFalse(user.isProcesado());
		
		user.setProcesado(true);
		
		Usuario resp = userRepo.save(user);
		
		assertTrue(resp.isProcesado());
		
	}

}
