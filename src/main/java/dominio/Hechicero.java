package dominio;

public class Hechicero extends Casta {

	/**
	 * Constructor
	 * @param prob_crit double Probabilidad de golpe critico
	 * @param evasion double Valor de evasion 
	 * @param daÃ double Daño critico
	 */
	
	public Hechicero(double prob_crit, double evasion, double daÃ±o_crit) {
		super(prob_crit, evasion, daÃ±o_crit);
		this.nombreCasta = "Hechicero";
	}

	/**
	 * Constructor
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
	 * Calcula el efecto causado entre un objeto del tipo Personaje y otro del tipo Peleable
	 * En funcion de los valores de sus parametros 
	 *@param caster Persobaje El personaje atacante
|	 *@param atacado Peleable El personaje atacado
	 *@return retorna un boolean en funcion del resultado calculado
	 */
	
	// Bola de Fuego
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Calcula el efecto causado entre un objeto del tipo Personaje y otro del tipo Peleable
	 * En funcion de los valores de sus parametros 
	 *@param caster Persobaje El personaje atacante
|	 *@param atacado Peleable El personaje atacado
	 *@return retorna un boolean en funcion del resultado calculado
	 */
	
	// Curar Aliado
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
	 * Calcula el efecto causado entre un objeto del tipo Personaje y otro del tipo Peleable
	 * En funcion de los valores de sus parametros 
	 *@param caster Persobaje El personaje atacante
|	 *@param atacado Peleable El personaje atacado
	 *@return retorna un boolean en funcion del resultado calculado
	 */
	
	// Robar Energia y Salud
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
