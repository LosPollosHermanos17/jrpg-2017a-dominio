package dominio;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Inventario {

	private int id;
	private Map<Integer, Item> items;

	public Inventario(Map<Integer, Item> auxItems) {
		this.items = auxItems;
	}

	public Inventario() {
		this.items = new HashMap<Integer, Item>();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Map<Integer, Item> getItems() {
		return items;
	}

	public int getBonusSalud() {
		int bonus = 0;
		for (Item item : items.values())
			bonus += item.getBonoSalud();
		return bonus;
	}

	public int getBonusEnergia() {
		int bonus = 0;
		for (Item item : items.values())
			bonus += item.getBonoEnergia();
		return bonus;
	}

	public int getBonusDefensa() {
		int bonus = 0;
		for (Item item : items.values())
			bonus += item.getBonoDefensa();
		return bonus;
	}

	public int getBonusAtaque() {
		int bonus = 0;
		for (Item item : items.values())
			bonus += item.getBonoAtaque();
		return bonus;
	}

	public int getBonusMagia() {
		int bonus = 0;
		for (Item item : items.values())
			bonus += item.getBonoMagia();
		return bonus;
	}

	/*
	 * Agrega los items a su posición de acuerdo al tipo de item
	 */
	public boolean agregarItem(Item nuevoItem) {

		Item i = this.items.get(nuevoItem.getIdTipo());
		if (i.getId() < 0) {
			this.items.put(nuevoItem.getIdTipo(), nuevoItem);
			return true;
		}
		return false;
	}
}
