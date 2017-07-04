package tests_dominio;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Humano;
import dominio.Inventario;
import dominio.Personaje;

public class TestAsignarPuntos {

    @Test 
    public void testActualizarAtributos(){
    	HashMap<String,Integer> act = new HashMap<String,Integer>();
    	act.put("salud", 1);
    	act.put("energia", 5);
    	Humano h = new Humano("Nicolas", 4, 4, 199, 0, 199, new Asesino(0.2, 0.3, 1.5), 0, 1, 1,new Inventario());
    	h.actualizarAtributos(act);
    	Assert.assertTrue(h.getEnergia() == 5);
    	Assert.assertTrue(h.getSalud() == 1);
    }
    
	@Test
    public void testAumentarSalud_tope() {
        Personaje.cargarTablaNivel();

        Humano h = new Humano("Nicolas", new Guerrero(), 1);
        Assert.assertTrue(h.getSaludTope() == 105);
        h.ganarExperiencia(50);
        Assert.assertTrue(h.getSaludTope() == 130);
    }

    @Test
    public void testAumentarEnergiaTope() {
        Personaje.cargarTablaNivel();

        Humano h = new Humano("Nicolas", new Guerrero(), 1);
        Assert.assertTrue(h.getEnergiaTope() == 105);
        h.ganarExperiencia(50);
        Assert.assertTrue(h.getEnergiaTope() == 125);
    }

    @Test
    public void testMasDe200Puntos() {
        
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
    	
    	Humano h = new Humano("Nicolas", 100, 100, 199, 199, 199, new Asesino(0.2, 0.3, 1.5), 0, 1, 1,new Inventario());
    	
        h.AsignarPuntosSkills(2, 2, 2);
        Assert.assertTrue(h.getFuerza() == 199);
        Assert.assertTrue(h.getDestreza() == 199);
        Assert.assertTrue(h.getInteligencia() == 199);
    }
}
