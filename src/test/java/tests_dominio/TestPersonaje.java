package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.*;

public class TestPersonaje {

	@Test
	public void testPersonaje(){
		Humano p1 = new Humano("Personaje",100,100,100,100,100,new Hechicero(),100,100,100);
		Humano p2 = new Humano("Personaje",100,100,100,100,100,new Hechicero(),100,0,100);
		p1.cargarTablaNivel();
		p1.subirNivel();
		p2.subirNivel();
		p2.ganarExperiencia(100);
	}
	
	@Test
	public void testHumano() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(h.getSalud() == 105);
		Assert.assertTrue(h.getEnergia() == 105);
		Assert.assertTrue(h.getFuerza() == 15);
		Assert.assertTrue(h.getDestreza() == 10);
		Assert.assertTrue(h.getInteligencia() == 10);

		Humano h2 = new Humano("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(h2.getSalud() == 105);
		Assert.assertTrue(h2.getEnergia() == 105);
		Assert.assertTrue(h2.getFuerza() == 10);
		Assert.assertTrue(h2.getDestreza() == 10);
		Assert.assertTrue(h2.getInteligencia() == 15);

		Humano h3 = new Humano("Hernan", new Asesino(), 3);
		Assert.assertTrue(h3.getSalud() == 105);
		Assert.assertTrue(h3.getEnergia() == 105);
		Assert.assertTrue(h3.getFuerza() == 10);
		Assert.assertTrue(h3.getDestreza() == 15);
		Assert.assertTrue(h3.getInteligencia() == 10);
		
		h3.AsignarPuntosSkills(100, 1, 1);
		
		h3.atacar(h2);
		
		h3.aliar(h2);
		
		h3.calcularPuntosDeAtaque();
		
		h3.calcularPuntosDeDefensa();
		
		h3.calcularPuntosDeMagia();
		
		h3.crearAlianza("Alianza");
		
		h3.despuesDeTurno();
		
		h3.distanciaCon(h2);
		
		h3.equals(h3);
		
		h3.equals(h2);
		
		h3.estaVivo();
		
		h3.getHabilidadesCasta();
		
		h3.habilidadCasta1(h2);
		
		h3.habilidadCasta2(h2);
		
		h3.habilidadCasta3(h2);
		
		h3.habilidadRaza1(h2);
		
		h3.habilidadRaza2(h2);
		
		h3.getHabilidadesRaza();
		
		h3.puedeAtacar();
		
		h3.restablecerEnergia();
		
		h3.restablecerSalud();
		
		h3.salirDeAlianza();
		
		h3.serAtacado(1000);
		
		h3.serCurado(1000);
		
		h3.serDesernegizado(1000);
		
		h3.serRobadoSalud(20);
		
		
	}

	
	
	@Test
	public void testElfo() {
		Elfo e1 = new Elfo("Personaje",100,100,100,100,100,new Hechicero(),100,100,100);
		
		
		Elfo e = new Elfo("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(e.getSalud() == 100);
		Assert.assertTrue(e.getEnergia() == 110);
		Assert.assertTrue(e.getFuerza() == 15);
		Assert.assertTrue(e.getDestreza() == 10);
		Assert.assertTrue(e.getInteligencia() == 10);

		Elfo e2 = new Elfo("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(e2.getSalud() == 100);
		Assert.assertTrue(e2.getEnergia() == 110);
		Assert.assertTrue(e2.getFuerza() == 10);
		Assert.assertTrue(e2.getDestreza() == 10);
		Assert.assertTrue(e2.getInteligencia() == 15);

		Elfo e3 = new Elfo("Hernan", new Asesino(), 3);
		Assert.assertTrue(e3.getSalud() == 100);
		Assert.assertTrue(e3.getEnergia() == 110);
		Assert.assertTrue(e3.getFuerza() == 10);
		Assert.assertTrue(e3.getDestreza() == 15);
		Assert.assertTrue(e3.getInteligencia() == 10);
		
		e3.AsignarPuntosSkills(100, 1, 1);
		
		e3.atacar(e2);
		
		e3.aliar(e2);
		
		e3.calcularPuntosDeAtaque();
		
		e3.calcularPuntosDeDefensa();
		
		e3.calcularPuntosDeMagia();
		
		e3.crearAlianza("Alianza");
		
		e3.despuesDeTurno();
		
		e3.distanciaCon(e2);
		
		e3.equals(e3);
		
		e3.equals(e2);
		
		e3.estaVivo();
		
		e3.getHabilidadesCasta();
		
		e3.habilidadCasta1(e2);
		
		e3.habilidadCasta2(e2);
		
		e3.habilidadCasta3(e2);
		
		e3.habilidadRaza1(e2);
		
		e3.habilidadRaza2(e2);
		
		e3.puedeAtacar();
		
		e3.restablecerEnergia();
		
		e3.restablecerSalud();
		
		e3.salirDeAlianza();
		
		e3.serAtacado(1000);
		
		e3.serCurado(1000);
		
		e3.serDesernegizado(1000);
		
		e3.serRobadoSalud(20);
		
		
	}

	@Test
	public void testOrco() {
		Orco o1 = new Orco("Personaje",100,100,100,100,100,new Hechicero(),100,100,100);
		
		Orco o = new Orco("Nicolas", new Guerrero(), 1);
		Assert.assertTrue(o.getSalud() == 110);
		Assert.assertTrue(o.getEnergia() == 100);
		Assert.assertTrue(o.getFuerza() == 15);
		Assert.assertTrue(o.getDestreza() == 10);
		Assert.assertTrue(o.getInteligencia() == 10);

		Orco o2 = new Orco("Lautaro", new Hechicero(), 2);
		Assert.assertTrue(o2.getSalud() == 110);
		Assert.assertTrue(o2.getEnergia() == 100);
		Assert.assertTrue(o2.getFuerza() == 10);
		Assert.assertTrue(o2.getDestreza() == 10);
		Assert.assertTrue(o2.getInteligencia() == 15);

		Orco o3 = new Orco("Hernan", new Asesino(), 3);
		Assert.assertTrue(o3.getSalud() == 110);
		Assert.assertTrue(o3.getEnergia() == 100);
		Assert.assertTrue(o3.getFuerza() == 10);
		Assert.assertTrue(o3.getDestreza() == 15);
		Assert.assertTrue(o3.getInteligencia() == 10);
		
		o3.AsignarPuntosSkills(100, 1, 1);
		
		o3.atacar(o2);
		
		o3.aliar(o2);
		
		o3.calcularPuntosDeAtaque();
		
		o3.calcularPuntosDeDefensa();
		
		o3.calcularPuntosDeMagia();
		
		o3.crearAlianza("Alianza");
		
		o3.despuesDeTurno();
		
		o3.distanciaCon(o2);
		
		o3.equals(o3);
		
		o3.equals(o2);
		
		o3.estaVivo();
		
		o3.getHabilidadesCasta();
		
		o3.habilidadCasta1(o2);
		
		o3.habilidadCasta2(o2);
		
		o3.habilidadCasta3(o2);
		
		o3.habilidadRaza1(o2);
		
		o3.habilidadRaza2(o2);
		
		o3.puedeAtacar();
		
		o3.restablecerEnergia();
		
		o3.restablecerSalud();
		
		o3.salirDeAlianza();
		
		o3.serAtacado(1000);
		
		o3.serCurado(1000);
		
		o3.serDesernegizado(1000);
		
		o3.serRobadoSalud(20);
	}
}
