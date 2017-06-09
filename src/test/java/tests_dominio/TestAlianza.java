package tests_dominio;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Inventario;
import dominio.Personaje;

public class TestAlianza {

    @Test
    public void testEliminarPersonaje() {
        // Para eliminar un personaje, debo tener uno agregado
        // en el vector de aliados perteneciente a la clase.
        // Voy a setear un vector de aliados y luego voy a
        // eliminarlo, en vez de usar el método "añadirPersonaje".
        // De esta manera, logro pruebas atómicas.

        // GIVEN        
        LinkedList<Personaje> aliadosPrueba = new LinkedList<Personaje>();
        Humano guerreroPrueba = new Humano("Guerrero Prueba", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());
        Humano hechiceroPrueba = new Humano("Hechicero Prueba", 100, 100, 100, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1,new Inventario());
        aliadosPrueba.add(guerreroPrueba);
        aliadosPrueba.add(hechiceroPrueba);
        Alianza alianzaPrueba = new Alianza("Alianza Prueba", aliadosPrueba);

        // WHEN
        alianzaPrueba.eliminarPersonaje(guerreroPrueba);

        // THEN
        Assert.assertEquals("No se elimino Personaje", 1, alianzaPrueba.getAliados().size());
        Assert.assertEquals("No se elimino Personaje indicado", hechiceroPrueba, alianzaPrueba.getAliados().getFirst());
    }

    @Test
    public void testAgregarPersonaje() {
        // GIVEN
        Alianza alianzaPrueba = new Alianza("Alianza Prueba");
        Humano guerreroPrueba = new Humano("Guerrero Prueba", 100, 100, 100, 20, 30, new Guerrero(0.2, 0.3, 1.5), 0, 1, 1,new Inventario());

        // WHEN
        alianzaPrueba.agregarPersonaje(guerreroPrueba);

        // THEN
        Assert.assertEquals("No se añadió Personaje", 1, alianzaPrueba.getAliados().size());
        Assert.assertEquals("No se añadió Personaje de manera correcta", guerreroPrueba, alianzaPrueba.getAliados().getFirst());
    }

}
