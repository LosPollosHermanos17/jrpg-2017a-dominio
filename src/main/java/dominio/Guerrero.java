package dominio;
/**
 * Define las caracteristicas y habilidades de un personaje Guerrero
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public class Guerrero extends Casta {

	public Guerrero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Guerrero";
	}

	public Guerrero() {
		super();
		this.nombreCasta = "Guerrero";

		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Ataque Doble";
		habilidadesCasta[1] = "Aumentar Defensa";
		habilidadesCasta[2] = "Ignorar Defensa";
	}

	/**
	 * Permite que un personaje pueda atacar a otro personaje con el doble de fuerza
	 * @param casta : Es el personaje atacante
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si el personaje pudo atacar al otro personaje.
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
	
	/**
	 * Permite que un personaje pueda aumentar su defensa
	 * @param casta : Es el personaje que aumenta su defensa.
	 * @param atacado : Es el personaje de quien se defiende.
	 * @return True si el personaje pudo atacar al otro personaje.
	 */
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}

	/**
	 * Permite que un personaje pueda atacar a otro personaje anulando su defensa
	 * @param casta : Es el personaje atacante
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si el personaje pudo atacar al otro personaje.
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int defensa_original = ((Personaje) atacado).getDefensa();
				((Personaje) atacado).setDefensa(0);
				if (atacado.serAtacado(caster.ataque) > 0) {
					((Personaje) atacado).setDefensa(defensa_original);
					return true;
				}
			}

		}
		return false;
	}
}
