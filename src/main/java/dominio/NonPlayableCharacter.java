package dominio;

/**
 * Establece, de acuerdo a la dificultad deseada, el conjunto de caracter�sticas deseadas para estos personajes
 * controlados en forma automatica.
 */
public class NonPlayableCharacter extends Peleable {

	private int defensa;
	private int nivel;
	private int dificultad;
	private static final int DIFICULTADALEATORIA = -1;

    /**
     * Asigna un objeto Hechicero y lo inicializa.
     * @param nombre  es el nombre del jugador
     * @param nivel es el nivel inicial
     * @param dificultadNPC puede ser 0,1,2 o -1 y asigna una dificultad aleatoria
     */
	public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
		this.setNombre(nombre);
		this.nivel = nivel;
		this.dificultad = dificultadNPC;
		this.setDificultad(dificultadNPC);		
	}
	
	private void setDificultad(int dificultadNPC)
	{
		int dificultad = dificultadNPC == DIFICULTADALEATORIA ? this.random.nextInt(3) : dificultadNPC;

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;
		default:
			break;
		}
	}
	@Override
	public void setRandomGenerator(RandomGenerator random)    {
		super.setRandomGenerator(random);
		this.setDificultad(this.dificultad);
	}			

	public int otorgarExp() {
		return this.nivel * 30;
	}

	public int getNivel() {
		return nivel;
	}

	/**
	 * Permite setear la defensa
	 * @nivel valor de la defensa 
	 */
	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Devuelve la defensa
	 * @return valor de la defensa 
	 */
	public int getDefensa() {
		return defensa;
	}

	/**
	 * Permite setear la defensa
	 * @defensa valor de la defensa 
	 */
	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Permite atacar a otro personaje
	 * @param atacado Personaje a atacar
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int atacar(final Peleable atacado) {
		if (this.random.nextDouble() <= 0.15) {
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}

	/**
	 * Permite que el personaje sea atacado
	 * @param danio : Cantidad que indica el daño a infligir sobre el personaje
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int serAtacado(int danio) {
		if (this.random.nextDouble() >= 0.15) {
			danio -= this.getDefensa() / 2;
			if (danio > 0) {
				this.salud = this.getSalud() - danio;
				return danio;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * Permite que el personaje sea atacado anulando su defensa
	 * @param atacante : Es el personaje que ataca
	 * @return Devuelve si el atacante pudo atacar
	 */
	public boolean serAtacadoSinDefensa(final Personaje atacante) {
		return false;
	}

	/**
	 * Permite que al personaje le den salud
	 * @param caster : Personaje que le va a dar salud
	 */
	public boolean serCurado(final Personaje aliado) {
		return false;
	}

	/**
	 * Permite que al personaje le roben salud y energia
	 * @param atacante : Es el personaje que ataca
	 */
	public boolean serRobadoYDesenergizado(final Personaje atacante) {
		return false;
	}

	public void ganarExperiencia(final int exp) {

	}

	@Override
	public int getAtaque() {
		return this.getFuerza();
	}


	public void incrementarAtaque(int incAtaque){
		
	}
}
