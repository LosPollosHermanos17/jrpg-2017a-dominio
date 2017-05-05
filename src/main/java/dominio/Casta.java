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
  protected double probabilidadEvitarDaño;
  protected double dañoCritico;
  protected String nombreCasta;

  protected String[] habilidadesCasta;

  /**
   * Asigna un objeto Hechicero y lo inicializa
   */
  public Casta() {
    this.probabilidadGolpeCritico = 0.2;
    this.probabilidadEvitarDaño = 0.2;
    this.dañoCritico = 1.5;
  }

  /**
   * Asigna un objeto Casta y lo inicializa de acuerdo a los parámetros recibidos
   * 
   * @param prob_crit : Probabilidad de golpe critico.
   * @param evasion : Valor de evasion.
   * @param daño_crit : Valor del daño crítico.
   */
  public Casta(double prob_crit, double evasion, double daño_crit) {
    this.probabilidadGolpeCritico = prob_crit;
    this.probabilidadEvitarDaño = evasion;
    this.dañoCritico = daño_crit;
  }

  public abstract boolean habilidad1(Personaje caster, Peleable atacado);

  public abstract boolean habilidad2(Personaje caster, Peleable atacado);

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

  public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
    this.probabilidadGolpeCritico = probabilidadGolpeCritico;
  }

  public double getProbabilidadEvitarDaño() {
    return probabilidadEvitarDaño;
  }

  public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
    this.probabilidadEvitarDaño = probabilidadEvitarDaño;
  }

	public void setDañoCritico(double dañoCritico) {
		this.dañoCritico = dañoCritico;
	}
	
	public double getDañoCritico() {
    return this.dañoCritico;
  }
}
