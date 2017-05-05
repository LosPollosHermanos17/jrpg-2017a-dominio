package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Personaje;


public class TestAlianza {
	
	@Test
	public void testEliminarPersonaje()
	{	
		// Para eliminar un personaje, debo tener uno agregado
		// en el vector de aliados perteneciente a la clase.
		// Voy a setear un vector de aliados y luego voy a
		// eliminarlo, en vez de usar el método "añadirPersonaje".
		// De esta manera, logro pruebas atómicas.
		
		// GIVEN
		Alianza alianzaPrueba = new Alianza("Alianza Prueba");
		LinkedList<Personaje> aliadosPrueba = new LinkedList<Personaje>();
		Humano guerreroPrueba = new Humano("Guerrero Prueba", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		Humano hechiceroPrueba = new Humano("Hechicero Prueba", 100, 100, 100, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);		
		aliadosPrueba.add(guerreroPrueba);
		aliadosPrueba.add(hechiceroPrueba);
		alianzaPrueba.setAliados(aliadosPrueba);
		
		// WHEN
		alianzaPrueba.eliminarPersonaje(guerreroPrueba);
		
		// THEN
		Assert.assertEquals("No se elimino Personaje", 1, aliadosPrueba.size());
		Assert.assertEquals("No se elimino Personaje indicado", hechiceroPrueba, aliadosPrueba.getFirst());
	}
	
	
	@Test
	public void testAñadirPersonaje()
	{
		// GIVEN
		Alianza alianzaPrueba = new Alianza("Alianza Prueba");
		LinkedList<Personaje> aliadosPrueba = new LinkedList<Personaje>();
		alianzaPrueba.setAliados(aliadosPrueba);
		Humano guerreroPrueba = new Humano("Guerrero Prueba", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
		
		// WHEN
		alianzaPrueba.añadirPersonaje(guerreroPrueba);
		
		// THEN
		Assert.assertEquals("No se añadió Personaje", 1, aliadosPrueba.size());
		Assert.assertEquals("No se añadió Personaje de manera correcta", guerreroPrueba, aliadosPrueba.getFirst());
	}



}
