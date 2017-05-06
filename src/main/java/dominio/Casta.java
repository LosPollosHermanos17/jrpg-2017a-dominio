package dominio;

import java.io.Serializable;

/**
 * Define las caracteristicas y habilidades de un objeto Casta
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public abstract class Casta implements Serializable {
	protected double probabilidadGolpeCritico;
	protected double probabilidadEvitarDanio;
	protected double danioCritico;
	protected String nombreCasta;

	protected String[] habilidadesCasta;

	/**
	 * Asigna un objeto Hechicero y lo inicializa
	 */
	public Casta() {
		this.probabilidadGolpeCritico = 0.2;
		this.probabilidadEvitarDanio = 0.2;
		this.danioCritico = 1.5;
	}

	/**
	 * Asigna un objeto Casta y lo inicializa de acuerdo a los parámetros
	 * recibidos
	 * 
	 * @param probCritico : Probabilidad de golpe critico.
	 * @param evasion : Valor de evasion.
	 * @param danio : Valor del daño crítico.
	 */
	public Casta(final double probCritico, final double evasion,
			final double danio) {
		this.probabilidadGolpeCritico = probCritico;
		this.probabilidadEvitarDanio = evasion;
		this.danioCritico = danio;
	}

	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	public abstract void inicializarPersonaje(Personaje p);

	public String getNombreCasta() {
		return this.nombreCasta;
	}

	public String[] getHabilidadesCasta() {
		return habilidadesCasta;
	}

	public double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	public void setProbabilidadGolpeCritico(
			final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	public double getProbabilidadEvitarDaño() {
		return probabilidadEvitarDanio;
	}

	public void setProbabilidadEvitarDaño(
			final double probabilidadEvitarDanio) {
		this.probabilidadEvitarDanio = probabilidadEvitarDanio;
	}

	public void setDañoCritico(final double danioCritico) {
		this.danioCritico = danioCritico;
	}

	public double getDañoCritico() {
		return this.danioCritico;
	}
}
