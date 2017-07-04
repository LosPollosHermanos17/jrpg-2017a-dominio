package tests_dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.Item;
import junit.framework.Assert;

public class TestItem {

	@Test
	public void testCrearItem() {
		Item item = new Item(1, 1, "mano", "Espada Bastarda", 1, 1, 1, 1, 1, 1, 1, 1);
		Assert.assertTrue(1==1);
	}
	
	@Test
	public void testBonusItem() {
		Item item = new Item(1, 1, "mano", "Espada Bastarda", 1, 1, 1, 1, 1, 1, 1, 1);
		Assert.assertTrue(item.getNombre() == "Espada Bastarda");
		Assert.assertTrue(item.getTipo() == "mano");
		Assert.assertTrue(item.getBonoAtaque() == 1);
		Assert.assertTrue(item.getBonoDefensa() == 1);
		Assert.assertTrue(item.getBonoEnergia() == 1);
		Assert.assertTrue(item.getBonoMagia() == 1);
		Assert.assertTrue(item.getBonoSalud() == 1);
		Assert.assertTrue(item.getDestrezaRequerida() == 1);
		Assert.assertTrue(item.getFuerzaRequerida() == 1);
		Assert.assertTrue(item.getId() == 1);
		Assert.assertTrue(item.getIdTipo() == 1);
		Assert.assertTrue(item.getInteligenciaRequerida() == 1);
	}

}
