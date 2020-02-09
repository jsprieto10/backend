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
import com.valid.service.IUsuarioService;


@SpringBootTest
class ServiceTest {

	
	@Autowired
	private IUsuarioService userService;
	
	@Test
	void crearUsuarioTest()
	{
		userService.deleteAll();
		
		Usuario user = new Usuario("test1", "last test");
		Usuario respuesta = userService.createNewUser(user);
		assertTrue(respuesta.getId()>0);
	}
	
	
	@Test
	void darListaTest()
	{
		userService.deleteAll();
		
		List<Usuario> agregados = new ArrayList<Usuario>();
		for(int i = 1; i < 20; i++)
		{
			Usuario user = new Usuario("test"+i, "last test");
			Usuario respuesta = userService.createNewUser(user);
			agregados.add(respuesta);
		}
		
		List<Usuario> usuarios = userService.getAllUsuarios();
		assertTrue(usuarios.size() == 19);
		for(int i = 0; i < 19; i++)
		{
			assertEquals(agregados.get(i).getNombre(), usuarios.get(i).getNombre());
		}
	}
	
	@Test
	void update()
	{
		userService.deleteAll();
		crearUsuarioTest();
		Usuario user = userService.getAllUsuarios().get(0);
		
		assertFalse(user.isProcesado());
		
		
		Usuario resp =  userService.updateProcesado(user);
		
		assertTrue(resp.isProcesado());
	}
	
	@Test 
	void updateAll()
	{
		userService.deleteAll();
		
		List<Usuario> agregados = new ArrayList<Usuario>();
		for(int i = 1; i < 20; i++)
		{
			Usuario user = new Usuario("test"+i, "last test");
			Usuario respuesta = userService.createNewUser(user);
			agregados.add(respuesta);
			assertFalse(respuesta.isProcesado());
		}
		
		List<Usuario> resp = userService.updatesAllProcesado(agregados);
		for(Usuario u: resp)
		{
			assertTrue(u.isProcesado());
		}
	}

}
