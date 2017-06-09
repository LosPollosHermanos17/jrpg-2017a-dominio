package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Inventario;

public class TestCasta {

    Hechicero h = new Hechicero();
    Humano p = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(), 0, 1, 1,new Inventario());
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1,new Inventario());

    @Test
    public void testCasta() {

        Assert.assertTrue(h.getNombreCasta() == "Hechicero");
    }

    @Test
    public void testGetHabilidadesCasta() {

        String[] cadena = p.getHabilidadesCasta();
        String[] cadena2 = { "Golpe Critico", "Aumentar Evasion", "Robar" };

        for (int i = 0; i < cadena.length; i++) {
            Assert.assertTrue(cadena[i] == cadena2[i]);
        }
    }

    @Test
    public void testGetProbabilidadGolpeCritico() {

        Assert.assertTrue(0.2 == h.getProbabilidadGolpeCritico());
    }

    @Test
    public void testSetProbabilidadGolpeCritico() {
        h.setProbabilidadGolpeCritico(0.5);
        Assert.assertTrue(0.5 == h.getProbabilidadGolpeCritico());
    }

    @Test
    public void testGetProbabilidadEvitarDaño() {

        Assert.assertTrue(0.2 == h.getProbabilidadEvitarDaño());
    }

    @Test
    public void testSetProbabilidadEvitarDaño() {
        h.setProbabilidadEvitarDaño(0.5);
        Assert.assertTrue(0.5 == h.getProbabilidadEvitarDaño());
    }

    @Test
    public void testGetDañoCritico() {

        Assert.assertTrue(1.5 == h.getDañoCritico());
    }

    @Test
    public void testSetDañoCritico() {
        h.setDañoCritico(0.5);
        Assert.assertTrue(0.5 == h.getDañoCritico());
    }

}
