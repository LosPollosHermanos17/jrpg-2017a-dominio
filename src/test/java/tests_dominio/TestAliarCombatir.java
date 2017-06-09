package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Asesino;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Inventario;
import dominio.MyRandomStub;

public class TestAliarCombatir {

    @Test
    public void testCrearAlianza() {
        Humano h = new Humano("Nicolas", new Guerrero(), 1);
        h.setRandomGenerator(new MyRandomStub(0.43));
        
        Humano h2 = new Humano("Lautaro", new Guerrero(), 1);
        h2.setRandomGenerator(new MyRandomStub(0.43));

        Assert.assertNull(h.getClan());
        Assert.assertNull(h2.getClan());
        h.aliar(h2);
        Assert.assertNotNull(h.getClan());
        Assert.assertNotNull(h2.getClan());
    }

    @Test
    public void testDañar() {
        Humano h = new Humano("Nicolas", new Guerrero(), 1);
        h.setRandomGenerator(new MyRandomStub(0.43));
        
        Humano h2 = new Humano("Lautaro", new Asesino(), 1);
        h2.setRandomGenerator(new MyRandomStub(0.43));
        
        h.setRandomGenerator(new MyRandomStub(0.43));   
        
        Assert.assertTrue(h2.getSalud() == 105);
        h.atacar(h2);
        Assert.assertTrue(h2.getSalud() < 105);
    }

    @Test
    public void testNoDañar() {
        Humano h = new Humano("Lautaro", 0, 5, 100, 20, 100, new Asesino(), 10, 10, 1, new Inventario());
        h.setRandomGenerator(new MyRandomStub(0.43));
        
        Humano h2 = new Humano("Nicolas", new Guerrero(), 1);
        h2.setRandomGenerator(new MyRandomStub(0.43));

        Assert.assertTrue(h2.getSalud() == 105);
        h.atacar(h2);
        Assert.assertTrue(h2.getSalud() == 105);
    }

    @Test
    public void testAliar() {
        Humano h = new Humano("Nicolas", new Guerrero(), 1);
        h.setRandomGenerator(new MyRandomStub(0.43));
        
        Humano h2 = new Humano("Lautaro", new Guerrero(), 1);
        h2.setRandomGenerator(new MyRandomStub(0.43));
        
        Alianza a1 = new Alianza("Los CacheFC");

        Assert.assertNull(h2.getClan());
        Assert.assertNull(h.getClan());
        h.setClan(a1);
        Assert.assertNotNull(h.getClan());
        h.aliar(h2);
        Assert.assertTrue(h.getClan() == h2.getClan());
    }

}
