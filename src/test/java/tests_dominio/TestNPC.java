package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.MyRandomStub;
import dominio.NonPlayableCharacter;
import dominio.RandomGenerator;

public class TestNPC {

	@Test
	public void testOtorgarExp() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
		Assert.assertEquals(30, npc.otorgarExp());
	}

	@Test
	public void testDificultadBaja() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 0);
		Assert.assertEquals(10, npc.getFuerza());
		Assert.assertEquals(30, npc.getSalud());
		Assert.assertEquals(2, npc.getDefensa());
	}
	
	@Test
	public void testDificultadMedia() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 1);
		Assert.assertEquals(20, npc.getFuerza());
		Assert.assertEquals(40, npc.getSalud());
		Assert.assertEquals(5, npc.getDefensa());
	}
	
	@Test
	public void testDificultadAlta() {
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 2);
		Assert.assertEquals(30, npc.getFuerza());
		Assert.assertEquals(50, npc.getSalud());
		Assert.assertEquals(4, npc.getDefensa());
	}		
	
	@Test
	public void testGeneral()
	{
		//TODO: armar correctamente el test. Separar en diferentes casos.
		NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, 2);
		NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante", 1, 2);
        npc.getAtaque();
        npc.getFuerza();
        npc.getDefensa();
        npc.getNivel();
        npc.getNivel();
        npc.getNombre();
        npc.getSalud();
        npc.setAtaque(10);
        npc.setDefensa(10);
        npc.setFuerza(10);
        npc.setNivel(10);
        npc.setNombre("Nombre");
        npc.setSalud(10);
        npc.estaVivo();
        npc.atacar(npc2);
        npc.despuesDeTurno();	
	}
}
