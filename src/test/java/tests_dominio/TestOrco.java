package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.MyRandomStub;
import dominio.Orco;

public class TestOrco {

    @Test
    public void testGolpeDefensivo() {
        Humano h = new Humano("Nicolas", new Guerrero(), 1);
        Orco o = new Orco("Hernan", new Guerrero(), 1);
        o.setRandomGenerator(new MyRandomStub(0.49));   
        Assert.assertTrue(h.getSalud() == 105);
        o.habilidadRaza1(h);
        Assert.assertTrue(h.getSalud() == 95);

    }

    @Test
    public void testNoGolpeDefensivo() {
        Humano h = new Humano("Nicolas", new Guerrero(), 1);
                
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
    	
    	Orco o = new Orco("Hernan", 50, 5, 55, 20, 50, new Guerrero(), 0, 1, 1);
    	
        Assert.assertTrue(h.getSalud() == 105);
        o.habilidadRaza1(h);
        Assert.assertTrue(h.getSalud() == 105);
    }

    @Test
    public void testMordiscoDeVida() {
        Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
        Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
        h.setRandomGenerator(new MyRandomStub(0.49));
        o.setRandomGenerator(new MyRandomStub(0.49));   
        
        Assert.assertTrue(h.getSalud() == 100);
        o.serCurado(100 - o.getSalud());
        o.habilidadRaza2(h);
        Assert.assertEquals(40, h.getSalud());
        Assert.assertTrue(o.getSalud() == 100);

    }

    @Test
    public void testNoMordiscoDeVida() {
        Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
        Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

        Assert.assertTrue(h.getSalud() == 100);
        o.serCurado(100 - o.getSalud());
        o.habilidadRaza2(h);

        Assert.assertTrue(o.getSalud() == 100);
        // Assert.assertTrue(h.getSalud() == 100);
    }

    @Test
    public void habilidadesTest() {
        Orco orco = new Orco("monstruo1", 50, 30, 200, 100, 40, new Guerrero(), 3000, 4, 444);
        Orco orcoSinEnergia = new Orco("monstruo2", 300, 5, 1000, 100, 40, new Guerrero(), 3000, 4, 222);
        Orco orcoSinFuerzaNiDestreza = new Orco("monstruo1", 50, 30, 0, 0, 40, new Guerrero(), 3000, 4, 4434);
        
        
        orco.setRandomGenerator(new MyRandomStub(0.49));
        orcoSinEnergia.setRandomGenerator(new MyRandomStub(0.49));
        orcoSinFuerzaNiDestreza.setRandomGenerator(new MyRandomStub(0.49));
        
        Assert.assertTrue(orco.habilidadRaza1(orcoSinEnergia));
        Assert.assertFalse(orcoSinEnergia.habilidadRaza1(orco));
        Assert.assertTrue(orco.habilidadRaza2(orcoSinEnergia));
        Assert.assertFalse(orcoSinEnergia.habilidadRaza2(orco));
        Assert.assertFalse(orcoSinFuerzaNiDestreza.habilidadRaza2(orco));
        Assert.assertFalse(orcoSinFuerzaNiDestreza.habilidadRaza2(orco));
    }

}
