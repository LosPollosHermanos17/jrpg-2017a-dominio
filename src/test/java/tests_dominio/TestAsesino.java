package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Elfo;
import dominio.Humano;
import dominio.Inventario;
import dominio.MyRandomStub;

public class TestAsesino {

    @Test
    public void testHabilidad1() {
        boolean resPrueba1;
        boolean resPrueba2;

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

        Humano asesino = new Humano("Asesino Prueba", 100, 100, 100, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1, new Inventario());
        asesino.setRandomGenerator(new MyRandomStub(0.43));

        // String nombre = "Asesino Prueba"
        // int salud = 100
        // int energia = 100
        // int fuerza = 100
        // int destreza = 20
        // int inteligencia = 30
        // Casta casta = Asesino
        // int experiencia = 0
        // int nivel = 1
        // int idPersonaje = 1

        Elfo elfo = new Elfo("Elfo Prueba", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 2, new Inventario());
        elfo.setRandomGenerator(new MyRandomStub(0.43));

        // String nombre = "Elfo Prueba"
        // int salud = 100
        // int energia = 100
        // int fuerza = 25
        // int destreza = 20
        // int inteligencia = 30
        // Casta casta = Asesino
        // int experiencia = 0
        // int nivel = 3
        // int idPersonaje = 2

        resPrueba1 = asesino.habilidadCasta1(elfo);

        // public boolean habilidad1(final Personaje caster, final Peleable atacado) {
        // if (caster.getEnergia() > cantEnergiaMinima) {
        // caster.setEnergia(caster.getEnergia() - cantEnergiaMinima);
        // if (atacado.serAtacado((int) (caster.ataque
        // * caster.getCasta().getDañoCritico())) > 0) {
        // return true;
        // }

        // Para que entre en los 2 IF:
        // caster.getEnergia() = 100
        // cantEnergiaMinima = 10
        // caster.setEnergia(caster.getEnergia() - cantEnergiaMinima) -> caster.energia = 90
        // caster.ataque = caster.fuerza * 1.5 = 25 * 1.5 = 37.5
        // caster.getCasta().getDañoCritico() = 1.5

        Assert.assertEquals("Debe entrar en segundo IF y no lo hace", resPrueba1, true);

        // Para que entre solo al primer IF:
        // creo un objeto "asesino2" igual a "asesino" pero con daño crítico en 0
        // (el daño critico es el tercer parametro del constructor de Casta)

        Humano asesino2 = new Humano("Asesino Prueba 2", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 0), 0, 3, 2, new Inventario());
        asesino2.setRandomGenerator(new MyRandomStub(0.43));

        resPrueba2 = asesino2.habilidadCasta1(elfo);

        Assert.assertEquals("Debe entrar sólo en primer IF y no lo hace", resPrueba2, false);
        Assert.assertEquals("Debe entrar sólo en primer IF y no lo hace", asesino2.getEnergia(), 90);

        // Para que no entre ni siquiera al primer IF:
        // creo un objeto "asesino3" igual a "asesino" pero con energía en 0
        // (la energía es el tercer parámetro del constructor de Personaje)

        Humano asesino3 = new Humano("Asesino Prueba 3", 100, 0, 25, 20, 30, new Asesino(0.2, 0.3, 0), 0, 3, 2, new Inventario());
        asesino3.setRandomGenerator(new MyRandomStub(0.43));
        Elfo elfo3 = new Elfo("Elfo Prueba 3", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 2, new Inventario());
        elfo3.setRandomGenerator(new MyRandomStub(0.43));

        asesino3.habilidadCasta1(elfo3);

        Assert.assertEquals("No debe entrar en primer IF y si lo hace", elfo3.getSalud(), 100);

    }

    @Test
    public void testHabilidad2() {

        // public boolean habilidad2(final Personaje caster, final Peleable atacado) {
        // if (caster.getEnergia() > cantEnergiaMinima) {
        // caster.setEnergia(caster.getEnergia() - cantEnergiaMinima);
        // if (this.getProbabilidadEvitarDaño()
        // + probEvitarDanioAIncrementar < probEvitarDanioMaxima) {
        // this.probabilidadEvitarDaño += probEvitarDanioAIncrementar;
        // } else {
        // this.probabilidadEvitarDaño = probEvitarDanioMaxima;
        // }
        // return true;
        // }
        // return false;
        // }

        // Para que no entre a ningun IF:
        // la energia del asesino no es mayor que la energia minima
        Humano asesino = new Humano("Asesino Prueba 1", 100, 0, 25, 20, 30, new Asesino(0.2, 0.3, 0), 0, 3, 2, new Inventario());
        Elfo elfo = new Elfo("Elfo Prueba 1", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 2, new Inventario());
        elfo.setRandomGenerator(new MyRandomStub(0.43));

        asesino.habilidadCasta2(elfo);

        Assert.assertEquals("No debe entrar en primer IF y si lo hace", elfo.getSalud(), 100);

        // Para que entre en primer IF pero no en el segundo:
        // -> probabilidadEvitarDaño se tiene que mantener igual
        // -> debe devolver true

        // this.getProbabilidadEvitarDaño() + probEvitarDanioAIncrementar < probEvitarDanioMaxima
        // 0.6 + 0.15 < 0.5
        Humano asesino2 = new Humano("Asesino Prueba 2", 100, 100, 25, 20, 30, new Asesino(0.2, 0.6, 0), 0, 3, 2, new Inventario());
        Elfo elfo2 = new Elfo("Elfo Prueba 2", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 2, new Inventario());
        elfo2.setRandomGenerator(new MyRandomStub(0.43));

        boolean resPrueba2 = asesino2.habilidadCasta2(elfo2);

        Assert.assertEquals("No debe entrar en segundo IF y si lo hace",
                asesino2.getCasta().getProbabilidadEvitarDaño(), 0.5, 0.1);
        Assert.assertEquals("No debe entrar en segundo IF y si lo hace", resPrueba2, true);

    }

}
