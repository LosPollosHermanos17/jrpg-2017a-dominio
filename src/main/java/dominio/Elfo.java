package dominio;

/**
 * Clase que define las caracteristicas y habilidades 
 * de el tipo de personaje "Elfo"
 */

public class Elfo extends Personaje {

	/**
	 * Método que define el nombre, la casta y el id del
	 * personaje de tipo "Elfo"
	 * @param nombre de tipo string, es el nombre de un personaje creado
	 * @param casta de tipo Casta, es la casta a la que pertenece el personaje
	 * @param id de tipo int, define el id del personaje
	 */
	
	public Elfo(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		energiaTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}
    
	/**
	 * Método que define las habilidades de la raza de personaje "Elfo",
	 * no tiene retorno
	 * @param nombre de tipo string, nombre de un personaje creado
	 * @param salud de tipo int, cantidad de salud del personaje al que se le 
	 * quiere determinar su habilidad.
	 * @param energia de tipo int, cantidad de energia  del personaje al que se le 
	 * quiere determinar su habilidad.
	 * @param fuerza de tipo int, cantidad de fuerza  del personaje al que se le 
	 * quiere determinar su habilidad.
	 * @param destreza de tipo int, cantidad de destreza  del personaje al que se le 
	 * quiere determinar su habilidad.
	 * @param inteligencia de tipo int, cantidad de inteligencia del personaje al que se le 
	 * quiere determinar su habilidad.
	 * @param casta de tipo Casta, corresponde a el tipo de casta del personaje.
	 * @param experiencia de tipo int, es la cantidad de experiencia  del personaje al que se le 
	 * quiere determinar su habilidad.
	 * @param nivel de tipo int, corresponde a el nivel del personaje al que se le 
	 * quiere determinar su habilidad.
	 * @param idPersonaje de tipo int, nivel del personaje al que se le 
	 * quiere determinar su habilidad.
	 */
	
	public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * Método que determina el resultado de una pelea
	 * que utilice la habilidad "Golpe Level".
	 * @param atacado : De tipo Peleable, es el personaje que recibe el ataque.
	 * @return boolean : Retorna verdadero o falso dependiendo de la cantidad de energia
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0)
				return true;
		}
		return false;
	}

	/**
	 * Método que determina el resultado de una pelea
	 * que utilice la habilidad "Ataque Bosque".
	 * @param atacado : De tipo Peleable, es el personaje que recibe el ataque.
	 * @return boolean : Retorna verdadero o falso dependiendo de la cantidad de energia
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado((int) (this.magia)) > 0)
				return true;
		}
		return false;
	}
}
