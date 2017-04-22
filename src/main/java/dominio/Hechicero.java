package dominio;
/**
 * Define las caracteristicas y habilidades de un personaje Hechicero
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public class Hechicero extends Casta {

	/**
	 * Asigna un objeto Hechicero y lo inicializa de acuerdo a los parámetros recibidos
	 * @param prob_crit : Probabilidad de golpe critico.
	 * @param evasion : Valor de evasion.
	 * @param daño_crit : Valor del daño crítico.
	 */	
	public Hechicero(double prob_crit, double evasion, double daño_crit) {
		super(prob_crit, evasion, daño_crit);
		this.nombreCasta = "Hechicero";
	}

	/**
	 * Asigna un objeto Hechicero y lo inicializa 
	 */	
	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[3];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}	
	
	/**
	 * Permite a un personaje pueda atacar usando una bola de fuego a otro
	 * @param casta : Es el personaje atacante
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si el personaje pudo atacar al otro personaje.
	 */
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Permite que un personaje pueda curar a otro personaje aliado
	 * @param casta : Es el personaje que cura
	 * @param atacado : Es el personaje a curar.
	 * @return True si el personaje pudo curar al otro personaje.
	 */
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	/**
	 * Permite que un personaje pueda robar energia y salud a otro personaje
	 * @param casta : Es el personaje que roba
	 * @param atacado : Es el personaje robado.
	 * @return True si el personaje pudo robar al otro personaje.
	 */
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}
}
