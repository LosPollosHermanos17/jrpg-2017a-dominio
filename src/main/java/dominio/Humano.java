package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Humano
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public class Humano extends Personaje {

	private final int ENERGIAMINIMA = 10;

	/**
	 * Asigna un objeto Humano y lo inicializa de acuerdo a los parámetros
	 * recibidos
	 * 
	 * @param nombre : Nombre del personaje
	 * @param casta : Casta a la que deberá pertenecer.
	 * @param id : Identificador único del personaje
	 */
	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id, 5, 5, "Humano", null);
	}

	/**
	 * Asigna un objeto Humano y lo inicializa de acuerdo a los parámetros
	 * recibidos
	 * 
	 * @param nombre : Nombre del personaje.
	 * @param salud : Cantidad de salud inicial del personaje [0 a 100].
	 * @param energia : Cantidad de energia inicial del personaje [0 a 100].
	 * @param fuerza : Cantidad de fuerza inicial del personaje.
	 * @param destreza : Cantidad de destreza inicial del personaje.
	 * @param inteligencia : Cantidad de inteligencia inicial del personaje.
	 * @param casta : Casta a la que el personaje deberá pertenecer.
	 * @param experiencia : Cantidad de experiencia inicial del personaje.
	 * @param nivel : Nivel inicial del personaje.
	 * @param idPersonaje : Identificador único del personaje
	 */
	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje, "Humano",
				new String[] { "Incentivar", "Golpe Fatal" });
	}

	/**
	 * Permite atacar a otro personaje utilizando la habilidad de incentivar
	 * 
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si se pudo atacar al otro personaje.
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 * Permite atacar a otro personaje utilizando el golpe fatal
	 * 
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si se pudo atacar al otro personaje.
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > ENERGIAMINIMA) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - ENERGIAMINIMA);
		return false;
	}
}
