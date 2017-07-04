package tests_dominio;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import dominio.Inventario;
import dominio.Item;
import junit.framework.Assert;

public class TestInventario {

	@Test
	public void testCrearInventarioVacio() {
		Inventario inventario = new Inventario();
		Assert.assertTrue(inventario.getItems().isEmpty());
	}

	@Test
	public void testCrearInventarioConItems() {
		HashMap<Integer, Item> items = new HashMap<Integer, Item>();
		Item aux = new Item(1, 1, "mano", "Espada Bastarda", 1, 1, 1, 1, 1, 1, 1, 1);
		items.put(aux.getId(), aux);
		Inventario inventario = new Inventario(items);
		Assert.assertTrue(inventario.getItems() == items);
	}

	@Test
	public void testGetterSetterIDInventario() {
		Inventario inventario = new Inventario();
		inventario.setId(0);
		Assert.assertTrue(inventario.getId() == 0);
	}

	@Test
	public void testAgregarItem() {
		HashMap<Integer, Item> items = new HashMap<Integer, Item>();
		Item aux1 = new Item(-1, 1, "mano", "Espada Bastarda", 1, 1, 1, 1, 1, 1, 1, 1);
		items.put(aux1.getIdTipo(),aux1);
		Inventario inventario = new Inventario(items);
		Item itemQueSiSePuedeAgregar = new Item(1, 1, "mano", "Espada Bastarda", 1, 1, 1, 1, 1, 1, 1, 1);
		Assert.assertTrue(inventario.agregarItem(itemQueSiSePuedeAgregar));
		Item itemQueNoSePuedeAgregar = new Item(1, 1, "mano", "Espada Bastarda", 1, 1, 1, 1, 1, 1, 1, 1);
		Assert.assertFalse(inventario.agregarItem(itemQueNoSePuedeAgregar));
	}
	
	@Test
	public void testBonusInventario(){
		HashMap<Integer, Item> items = new HashMap<Integer, Item>();
		Item aux = new Item(1, 1, "mano", "Espada Bastarda", 1, 1, 1, 1, 1, 1, 1, 1);
		items.put(aux.getIdTipo(), aux);
		Inventario inventario = new Inventario(items);
		Assert.assertTrue(inventario.getItems() == items);
		Assert.assertTrue(inventario.getBonusAtaque() == 1);
		Assert.assertTrue(inventario.getBonusDefensa() == 1);
		Assert.assertTrue(inventario.getBonusEnergia() == 1);
		Assert.assertTrue(inventario.getBonusMagia() == 1);
		Assert.assertTrue(inventario.getBonusSalud() == 1);
	}
	
}
