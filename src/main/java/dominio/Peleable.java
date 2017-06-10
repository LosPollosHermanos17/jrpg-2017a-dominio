package dominio;

/**
 * Define las caracteristicas y habilidades de un objeto Peleable
 * @since 21/04/2017
 * @version 1.0
 */
public abstract class Peleable {
	protected int salud;
	protected int fuerza;
	protected String nombre;
	protected RandomGenerator random;
	protected Inventario inventario;

	public Peleable() {
		this.setRandomGenerator(new MyRandom());
	}

	public void setRandomGenerator(RandomGenerator random) {
		this.random = random;
	}

	public abstract int serAtacado(int danio);

	public int getSalud() {
		return this.salud;
	}

	public int getFuerza() {
		return this.fuerza;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public Inventario getInventario() {
		return this.inventario;
	}

	public void despuesDeTurno() {

	}

	public abstract boolean serAtacadoSinDefensa(Personaje atacante);

	public abstract boolean serCurado(Personaje caster);

	public abstract boolean serRobadoYDesenergizado(Personaje atacante);

	public abstract int atacar(Peleable atacado);

	public abstract int otorgarExp();

	public abstract int getAtaque();

   
	public boolean estaVivo() {
		return salud > 0;
	}

	public abstract void incrementarAtaque(int incAtaque);

}
