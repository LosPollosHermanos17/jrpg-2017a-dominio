package tests_dominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.NonPlayableCharacter;

public class TestNPC {

    @Test
    public void testOtorgarExp() {
        NonPlayableCharacter npc = new NonPlayableCharacter("Gigante", 1, -1);
        Assert.assertTrue(30 == npc.otorgarExp());
        NonPlayableCharacter npc1 = new NonPlayableCharacter("Gigante", 1, 0);
        NonPlayableCharacter npc2 = new NonPlayableCharacter("Gigante", 1, 1);
        NonPlayableCharacter npc3 = new NonPlayableCharacter("Gigante", 1, 2);

        npc.getAtaque();
        npc.getFuerza();
        npc.getDefensa();
        npc.getNivel();
        npc.getNivel();
        npc.getNombre();
        npc.getSalud();

        npc.setAtaque(10);
        npc.setDefensa(10);
        npc.setFuerza(10);
        npc.setNivel(10);
        npc.setNombre("Nombre");
        npc.setSalud(10);

        npc.estaVivo();

        npc.atacar(npc2);

        npc.despuesDeTurno();

    }
}
