package dominio;
/*
 * Se definen las habilidades especiales de la clase Guerrero 
 * que tiene los atributos definidos por la clase Casta
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
	/*
	 * Permite que un Personaje Peleable Guerrero ataque y le saque
	 * el doble de daño a otro Personaje Peleable
	 * @return Boolean: True en caso de que la variable energia sea
	 * mayor a 10 y false en caso contrario 
	 * @param Un Personaje ya definido con sus atributos al cual
	 * atacar y un Peleable que son las acciones a utilizar para 
	 * atacar
	 */
	// Ataque Doble
	public boolean habilidad1(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado(caster.ataque * 2) > 0)
				return true;
		}
		return false;
	}
	
	// Aumentar Defensa
	public boolean habilidad2(Personaje caster, Peleable atacado) { 
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			caster.setDefensa(caster.getDefensa() + caster.magia);
			return true;
		}
		return false;
	}
	/*
	 * Permite que un Personaje Peleable Guerrero iguale la defensa
	 * a cero y ataque al otro Personaje Peleable
	 * @return Boolean: True en caso de que la variable energia sea
	 * mayor a 10 y false en caso contrario 
	 * @param Un Personaje ya definido con sus atributos al cual
	 * atacar y un Peleable que son las acciones a utilizar para 
	 * atacar
	 */
	// Ignorar Defensa
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
