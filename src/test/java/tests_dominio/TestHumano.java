package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Inventario;
import dominio.MyRandomStub;

public class TestHumano {

    @Test
    public void testCostructorHumano() {
        Humano h = new Humano("Nico", new Hechicero(), 1);
    }

    @Test
    public void testSinEnergia() {
        Humano h = new Humano("Nico", 100, 0, 55, 20, 30, new Hechicero(), 0, 1, 1,new Inventario());
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1,new Inventario());
        Assert.assertFalse(h.habilidadRaza1(e));
        Assert.assertFalse(h.habilidadRaza2(e));
    }

    @Test
    public void testIncentivar() {
        Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1,new Inventario());
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1,new Inventario());

        Assert.assertTrue(e.getAtaque() == 37);
        h.habilidadRaza1(e);
        Assert.assertTrue(e.getAtaque() > 37);
    }

    @Test
    public void testGolpeFatal() {
        Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1,new Inventario());
        Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1,new Inventario());
        h.setRandomGenerator(new MyRandomStub(0.43));
        e.setRandomGenerator(new MyRandomStub(0.43));

        Assert.assertTrue(h.getEnergia() == 100);
        Assert.assertTrue(e.getSalud() == 100);
        Assert.assertTrue(h.habilidadRaza2(e));
        Assert.assertTrue(e.getSalud() == 70);
        Assert.assertTrue(h.getEnergia() == 50);
    }
}
