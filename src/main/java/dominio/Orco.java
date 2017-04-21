package dominio;
/**
 * Clase derivada de Personaje. se define las habilidades y la raza correspondiente dentro de Orco.
 * @version ultimate
 */
public class Orco extends Personaje {

	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel, int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}
	/**
	 * Establece ataque por habilidad, de ser posible, causando da�o equivalente al doble de la propia defensa.
	 * @param atacado La instancia de Personaje es enviada en pos de efectivizar el ataque.
	 * @return true si da�o infligido > 0, al mismo tiempo que el objeto llamador disponga de energ�a suficiente.
	 */
	// Golpe Defensa
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0)
				return true;
		}
		return false;
	}
	/**
	 * Establece ataque por habilidad, de ser posible, causando da�o y curando al personaje en valores equivalentes al da�o efectivo causado.
	 * @param atacado La instancia de Personaje es enviada en pos de efectivizar el ataque.
	 * @return true si da�o causado > 0, al mismo tiempo que el objeto llamador disponga de energ�a suficiente. En otro caso, false
	 */
	// Mordisco de Vida
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int daño_causado = atacado.serAtacado(this.getFuerza());
			if (daño_causado > 0) {
				this.serCurado(daño_causado);
				return true;
			}
		}
		return false;
	}
}
