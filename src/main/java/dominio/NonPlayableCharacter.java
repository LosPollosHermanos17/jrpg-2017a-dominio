package dominio;
/**
 * Establece, de acuerdo a la dificultad deseada, el conjunto de características deseadas para estos personajes controlados en forma automática.
 */
public class NonPlayableCharacter implements Peleable {

	private int salud;
	private int fuerza;
	private int defensa;
	private String nombre;
	private int nivel;
	private static final int dificultadAleatoria = -1;

	public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
		this.nombre = nombre;
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria)
			dificultad = MyRandom.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;// 30%
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;// 50%
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;// 50%
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;

		}
	}

	public int otorgarExp() {
		return this.nivel * 30;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}
	/**
	 * Establece el ataque por parte del NPC a otro personaje teniendo en cuenta la posibilidad de causar golpe crítico.
	 * @param atacado Recibe una instancia de otra clase, la cual representa al personaje que ha de recibir el daño.
	 * @return Daño infligido real, o 0 de no ser posible provocar daño.
	 */
	public int atacar(Peleable atacado) {
		if (MyRandom.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else
			return atacado.serAtacado(this.getAtaque());
	}
	/**
	 * Calcula el daño efectivo sufrido a partir las características del personaje en cuestión y el daño recibido.
	 * @param daño Representa el daño, previamente calculado, que el rival está habilitado a infligir.
	 * @return Devuelve 0 en caso de no ser posible producir daño o si daño<defensa. De haber sido efectivo el ataque, devuelve el valor del daño. 
	 */
	public int serAtacado(int daÃ±o) {
		if (MyRandom.nextDouble() >= 0.15) {
			daÃ±o -= this.getDefensa() / 2;
			if (daÃ±o > 0) {
				salud -= daÃ±o;
				return daÃ±o;
			}
			return 0;// no le hace daÃ±o ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	public void despuesDeTurno() { }

	public void ganarExperiencia(int exp) {

	}

	@Override
	public int getAtaque() {
		return fuerza;
	}

	@Override
	public void setAtaque(int ataque) {
		this.fuerza = ataque;
	}
}
