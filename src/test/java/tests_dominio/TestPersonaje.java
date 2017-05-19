package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;
import dominio.Personaje;

public class TestPersonaje {

    @Test
    public void testPersonaje() {
        
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
    	
    	Humano p1 = new Humano("Personaje", 100, 100, 100, 100, 100, new Hechicero(), 100, 100, 100);
        Humano p2 = new Humano("Personaje", 100, 100, 100, 100, 100, new Hechicero(), 100, 0, 100);
        Humano p3 = new Humano("Personaje", 0, 0, 0, 0, 0, new Hechicero(), 10, 0, 0);
        Personaje.cargarTablaNivel();
        p1.subirNivel();
        p3.subirNivel();
        Assert.assertTrue(p3.getNivel() == 1);
        p3.ganarExperiencia(10);
        Assert.assertTrue(p3.getExperiencia() == 20);
        p3.setNombre("Nombre");
        Assert.assertTrue(p3.getNombre() == "Nombre");
        p3.setNombreRaza("Raza");
        Assert.assertTrue(p3.getNombreRaza() == "Raza");
        p3.getCasta();
        p1.getClan();
        p1.golpe_critico();
        p3.setMagia(10);
        Assert.assertTrue(p3.getMagia() == 10);
        p3.setSalud(10);
        Assert.assertTrue(p3.getSalud() == 10);
        p3.setFuerza(10);
        Assert.assertTrue(p3.getFuerza() == 10);
        p3.serEnergizado(10);
        Assert.assertTrue(p3.getEnergia() == 20);
        Assert.assertTrue(p3.otorgarExp() == 40);
        p2.crearAlianza("Nombre");
        Assert.assertTrue(p2.getClan().obtenerNombre() == "Nombre");

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

        h3.AsignarPuntosSkills(100, 100, 100);
        Assert.assertTrue(h3.getFuerza() == 110);
        Assert.assertTrue(h3.getInteligencia() == 110);
        Assert.assertTrue(h3.getDestreza() == 115);

        h3.atacar(h2);

        h3.aliar(h2);

        Assert.assertTrue(h3.getFuerza() * 1.5 == h3.calcularPuntosDeAtaque());
        Assert.assertTrue(h3.getDestreza() == h3.calcularPuntosDeDefensa());
        Assert.assertTrue(h3.getInteligencia() * 1.5 == h3.calcularPuntosDeMagia());

        h3.despuesDeTurno();

        h3.distanciaCon(h2);

        h3.equals(h3);
        Assert.assertTrue(h3.getNombre() == h3.getNombre());

        h3.equals(h2);
        Assert.assertTrue(h3.getNombre() != h2.getNombre());

        h3.estaVivo();
        Assert.assertTrue(h3.getSalud() > 0);

        h3.getHabilidadesCasta();

        h3.habilidadCasta1(h2);

        h3.habilidadCasta2(h2);

        h3.habilidadCasta3(h2);

        h3.habilidadRaza1(h2);

        h3.habilidadRaza2(h2);

        h3.getHabilidadesRaza();

        Assert.assertTrue(h3.puedeAtacar());

        h3.restablecerEnergia();
        Assert.assertTrue(h3.getEnergia() == h3.getEnergiaTope());

        h3.restablecerSalud();
        Assert.assertTrue(h3.getSalud() == h3.getSaludTope());

        h3.salirDeAlianza();
        Assert.assertTrue(h3.getClan() == null);

        h3.serAtacado(1000);

        h3.serCurado(1000);
        Assert.assertTrue(h3.getSalud() == h3.getSaludTope());

        h3.serDesernegizado(1000);
        Assert.assertTrue(h3.getEnergia() == 0);

        h3.serRobadoSalud(1);
        Assert.assertTrue(h3.getSalud() == h3.getSaludTope());
        h3.serRobadoSalud(150);
        Assert.assertTrue(h3.getSalud() == 70);
        h3.serRobadoSalud(1500);
        Assert.assertTrue(h3.getSalud() == 0);

    }

    @Test
    public void testElfo() {
        Elfo e1 = new Elfo("Personaje", 0, 0, 0, 0, 0, new Hechicero(), 0, 0, 0);

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

        Assert.assertTrue(e3.habilidadRaza1(e2));
        Assert.assertTrue(e3.habilidadRaza2(e2));

        Assert.assertTrue(!e1.habilidadRaza1(e2));
        Assert.assertTrue(!e1.habilidadRaza2(e2));

    }

    @Test
    public void testOrco() {
        Orco o1 = new Orco("Personaje", 0, 0, 0, 0, 0, new Hechicero(), 0, 0, 0);

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

        Assert.assertTrue(o3.habilidadRaza1(o2));
        Assert.assertTrue(!o3.habilidadRaza2(o2));

        Assert.assertTrue(!o1.habilidadRaza1(o2));
        Assert.assertTrue(!o1.habilidadRaza2(o2));
    }
}
