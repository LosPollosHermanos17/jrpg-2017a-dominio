package tests_dominio;

import java.lang.reflect.Field;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Guerrero;
import dominio.Orco;
import dominio.Personaje;


public class TestAlianza {
	

	@Test
	public void testGetAliados()
	{
		Alianza a = new Alianza("Alianza de Prueba");
		Assert.assertNotNull("El atributo de tipo LinkedList<Personaje> \"aliados\" no debe ser null", a.getAliados());
		
	}
	
	@Test
	public void testSetAliados() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
	{
		//given
		Alianza alianzaTest = new Alianza("Alianza de Prueba");		
		LinkedList<Personaje> aliadosTest = new LinkedList<Personaje>();
		aliadosTest.add(new Orco("Orco Prueba", new Guerrero(), 1));
		
        //when
		alianzaTest.setAliados(aliadosTest);

        //then
        final Field field = alianzaTest.getClass().getField("aliados");
        field.setAccessible(true);
        Object obj = null;
		Assert.assertSame(field.get(obj ), alianzaTest);		
	}

}
