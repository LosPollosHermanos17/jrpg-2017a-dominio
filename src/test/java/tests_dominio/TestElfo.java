package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Humano;

public class TestElfo {

  @Test
  public void testGolpeLevelTrue() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

    Assert.assertTrue(h.getSalud() == 100);
    if (e.habilidadRaza1(h)) {
      Assert.assertTrue(h.getSalud() < 100);
    }
  }

  @Test
  public void testGolpeLevelFalse() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

    Assert.assertTrue(h.getSalud() == 100);
    if (!e.habilidadRaza1(h)) {
      Assert.assertTrue(h.getSalud() == 100);
      Assert.assertTrue(e.getEnergia() > 10);
    }
  }
  
  @Test
  public void testAtaqueBosque() {
    Elfo e = new Elfo("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
    Humano h = new Humano("Nico", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

    Assert.assertTrue(h.getSalud() == 100);
    if (e.habilidadRaza2(h)) {
      Assert.assertTrue(h.getSalud() < 100);
    } 
  }   
}
