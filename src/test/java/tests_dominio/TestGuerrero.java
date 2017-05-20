package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.RandomGenerator;

public class TestGuerrero {

    @Test
    public void testSinEnergia() {
        Humano h = new Humano("Nico", 100, 3, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
        Assert.assertFalse(h.habilidadCasta1(e));
        Assert.assertFalse(h.habilidadCasta2(e));
        Assert.assertFalse(h.habilidadCasta3(e));
    }

    @Test
    public void testDobleGolpe() {
        
    	// GIVEN
    	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
        e.setRandomGenerator(new MyRandomStub(0.43));
        
        // WHEN
        h.habilidadCasta1(e);
        
        
        // THEN
        Assert.assertEquals("No se decremento la salud del atacado", 46, e.getSalud());
    }

    @Test
    public void testAutoDefensa() {
        
    	// GIVEN
    	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);

        // WHEN
    	h.habilidadCasta2(null);
    	
    	// THEN
        Assert.assertEquals("No se incremento el atributo defensa", h.getDefensa(), 65);
    }


    @Test
    public void testIgnoraDefensa() {
        
    	// GIVEN
    	Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1);
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
        e.setRandomGenerator(new MyRandomStub(0.43));

        // WHEN
        h.habilidadCasta3(e);
        
        // THEN
        Assert.assertEquals("No se decremento la salud del atacado", 63, e.getSalud());
    }

}
