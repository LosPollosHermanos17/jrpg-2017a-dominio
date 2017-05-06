package dominio;
/**
 *Define las caracteristicas y habilidades de un personaje Orco.
 * @since 21/04/2017
 * @version 1.0
 */
public class Orco extends Personaje {


	/**
	 * Asigna un objeto Orco y lo inicializa de acuerdo a los parámetros recibidos
	 * @param nombre : Nombre del personaje 
	 * @param casta : Casta a la que deberá pertenecer.
	 * @param id : Identificador único del personaje
	 */	
	public Orco(String nombre, Casta casta, int id) {		
		super(nombre, casta, id, 10, 0,"Orco",new String[]{"Golpe Defensa","Mordisco de Vida"});
	}

	/**
	 * Asigna un objeto Orco con los parámetros recibidos.
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
	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje,"Orco",new String[]{"Golpe Defensa","Mordisco de Vida"});
	}	
	/**
	 * Permite atacar a otro personaje usando el golpe defensa.
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si se pudo atacar al otro personaje.
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Permite atacar a otro personaje usando el mordisco de vida.
	 * @param atacado : Es el personaje que recibe el ataque.
	 * @return True si se pudo atacar al otro personaje.
	 */
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int danio = atacado.serAtacado(this.getFuerza());
			if (danio > 0) {
				this.serCurado(danio);
				return true;
			}
		}
		return false;
	}
}
