package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;

public class TestHechicero {

    @Test
    public void testSinEnergia() {
        Humano h = new Humano("Nico", 100, 3, 25, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
        Assert.assertFalse(h.habilidadCasta1(e));
        Assert.assertFalse(h.habilidadCasta2(e));
        Assert.assertFalse(h.habilidadCasta3(e));
    }

    @Test
    public void testHechiceroPorDefecto() {
        Hechicero h = new Hechicero();
    }

    @Test
    public void testCurar() {
        Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

        Assert.assertTrue(e.getSalud() == 100);
        e.serCurado(65 - e.getSalud());
        Assert.assertTrue(e.getSalud() == 65);
        h.habilidadCasta2(e);
        Assert.assertTrue(e.getSalud() > 65);
    }

    @Test
    public void testBolaDeFuego() {
        Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

        Assert.assertTrue(e.getSalud() == 100);
        Assert.assertTrue(h.habilidadCasta1(e));
        Assert.assertTrue(e.getSalud() < 100);

    }

    @Test
    public void testRobarEnergiaYSalud() {
        
        // Parametros constructor Personaje:
        // String nombre
        // int salud
        // int energia
        // int fuerza
        // int destreza
        // int inteligencia
        // Casta casta
        // int experiencia
        // int nivel
        // int idPersonaje
    	
    	Humano h = new Humano("Nico", 50, 50, 55, 20, 50, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);

        Assert.assertTrue(e.getSalud() == 100);

        Assert.assertTrue(h.habilidadCasta3(e));
        Assert.assertTrue(e.getSalud() < 100);
        Assert.assertTrue(h.getEnergia() > 50);
        Assert.assertTrue(h.getSalud() > 50);

    }

}
