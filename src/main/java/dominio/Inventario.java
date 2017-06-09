package dominio;

import java.util.HashMap;
import java.util.Map;

public class Inventario {

	private int id;
	private Map<Integer, Item> items;

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
		for(Item item : items.values())
			bonus += item.getBonoSalud();
		return bonus;
	}

	public int getBonusEnergia() {
		int bonus = 0;
		for(Item item : items.values())
			bonus += item.getBonoEnergia();
		return bonus;
	}

	public int getBonusDefensa() {
		int bonus = 0;
		for(Item item : items.values())
			bonus += item.getBonoDefensa();
		return bonus;
	}

	public int getBonusAtaque() {
		int bonus = 0;
		for(Item item : items.values())
			bonus += item.getBonoAtaque();
		return bonus;
	}

	public int getBonusMagia() {
		int bonus = 0;
		for(Item item : items.values())
			bonus += item.getBonoMagia();
		return bonus;
	}

	public void addItem(Item item) {
		if(item != null)
			this.items.put(item.getId(), item);		
	}
}
