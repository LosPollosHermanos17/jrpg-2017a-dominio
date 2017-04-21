package dominio;

public class Humano extends Personaje {

	/**
	 * Constructor
	 * @param nombre Nombre del personaje
	 * @param casta Casta del personaje
	 * @param id iD del personaje
	 */
	
	public Humano(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	/**
	 * Constructor
	 * @param nombre String Nombre del personaje
	 * @param salud int Salud del personaje
	 * @param energia int Energia del personaje
	 * @param fuerza int Fuerza del personaje
	 * @param destreza int Destreza del personaje
	 * @param inteligencia int Inteligencia del personaje
	 * @param casta Casta Casta del personaje
	 * @param experiencia int Experiencia del personaje
	 * @param nivel int Nivel del personaje
	 * @param idPersonaje int iD del personaje
	 */
	
	public Humano(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	/**
	 *Devuelve un boolean en funcion del resultado del calculo de los parametros
	 *@param atacado Peleable El personaje atacado
	 *@return retorna un boolean en funcion del resultado calculado
	 */
	
	// Incentivar
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	/**
	 *Devuelve un boolean en funcion del resultado del calculo de los parametros
	 *@param atacado Peleable El personaje atacado
	 *@return retorna un boolean en funcion del resultado calculado
	 */
	
	// Golpe Fatal
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - 10);
		return false;
	}
}
