package dominio;
/**
 * Establece, de acuerdo a la dificultad deseada, el conjunto de caracter�sticas deseadas para estos personajes controlados en forma autom�tica.
 */
public class NonPlayableCharacter extends Peleable {

	private int defensa;
	private int nivel;
	private static final int dificultadAleatoria = -1;

	public NonPlayableCharacter(String nombre, int nivel, int dificultadNPC) {
		this.setNombre(nombre);
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria)
			dificultad = MyRandom.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			this.setFuerza(10 + (nivel - 1) * 3);// 30%
			this.setSalud(30 + (nivel - 1) * 15);
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.setFuerza(20 + (nivel - 1) * 6);// 50%
			this.setSalud(40 + (nivel - 1) * 20);
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.setFuerza(30 + (nivel - 1) * 10);// 50%
			this.setSalud(50 + (nivel - 1) * 25);
			this.defensa = 4 + (nivel - 1) * 4;
			break;

		}
	}

	public int otorgarExp() {
		return this.nivel * 30;
	}


	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Permite atacar a otro personaje
	 * @param atacado Personaje a atacar
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int atacar(Peleable atacado) {
		if (MyRandom.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else
			return atacado.serAtacado(this.getAtaque());
	}
	
	/**
	 * Permite que el personaje sea atacado
	 * @param daño : Cantidad que indica el daño a infligir sobre el personaje
	 * @return Devuelve el daño efectivo infligido al personaje
	 */
	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= 0.15) {
			daño -= this.getDefensa() / 2;
			if (daño > 0) {
				this.setSalud(this.getSalud()-daño);
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	

	public void ganarExperiencia(int exp) {

	}

	@Override
	public int getAtaque() {
		return this.getFuerza();
	}

	@Override
	public void setAtaque(int ataque) {
		this.setFuerza(ataque);;
	}
}
