package dominio;

import java.io.Serializable;

/**
 * Define las caracteristicas y habilidades de un objeto Casta.
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
     * Asigna un objeto Hechicero y lo inicializa.
     */
    public Casta() {
        final double gp = 0.2;
        final double ed = 0.2;
        final double dc = 1.5;
    	this.probabilidadGolpeCritico = gp;
        this.probabilidadEvitarDanio = ed;
        this.danioCritico = dc;
    }

    /**
     * Asigna un objeto Casta y lo inicializa de acuerdo a los parámetros recibidos.
     * @param probCritico : Probabilidad de golpe critico.
     * @param evasion : Valor de evasion.
     * @param danio : Valor del daño crítico.
     */
    public Casta(final double probCritico, final double evasion, final double danio) {
        this.probabilidadGolpeCritico = probCritico;
        this.probabilidadEvitarDanio = evasion;
        this.danioCritico = danio;
    }

    /**
     * Aplica habilidad 1 de un personaje a otro.
     * @param caster : Personaje atacante.
     * @param atacado : Personaje atacado.
     * @return true si pudo usar habilidad.
     */
    public abstract boolean habilidad1(Personaje caster, Peleable atacado);

    /**
     * Aplica habilidad 2 de un personaje a otro.
     * @param caster : Personaje atacante.
     * @param atacado : Personaje atacado.
     * @return true si pudo usar habilidad.
     */
    public abstract boolean habilidad2(Personaje caster, Peleable atacado);

    /**
     * Aplica habilidad 3 de un personaje a otro.
     * @param caster : Personaje atacante.
     * @param atacado : Personaje atacado.
     * @return true si pudo usar habilidad.
     */
    public abstract boolean habilidad3(Personaje caster, Peleable atacado);

    /**
     * Inicializa el personaje.
     * @param p : Personaje a inicializar.
     */
    public abstract void inicializarPersonaje(Personaje p);

    /**
     * Devuelve el nombre casta.
     * @return nombreCasta : Nombre de la casta.
     */
    public String getNombreCasta() {
        return this.nombreCasta;
    }

    /**
     * Devuelve el nombre de las habilidades.
     * @return habilidadesCasta : Habilidades de la casta.
     */
    public String[] getHabilidadesCasta() {
        return habilidadesCasta;
    }

    /**
     * Devuelve la probabilidad de golpe crítico.
     * @return probabilidadDeGolpeCritico
     */
    public double getProbabilidadGolpeCritico() {
        return probabilidadGolpeCritico;
    }

    /**
     * Setea la probabilidad de golpe crítico.
     * @param probabilidadGolpeCritico : Valor que indica la probabilidad de golpe crítico.
     */
    public void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
        this.probabilidadGolpeCritico = probabilidadGolpeCritico;
    }

    /**
     * Setea la probabilidad de evitar daño.
     * @return probabilidadEvitarDanio.
     */
    public double getProbabilidadEvitarDaño() {
        return probabilidadEvitarDanio;
    }

    /**
     * Setea la probabilidad de evitar daño.
     * @param probabilidadEvitarDanio : Valor que indica la probabilidad de evitar daño.
     */
    public void setProbabilidadEvitarDaño(final double probabilidadEvitarDanio) {
        this.probabilidadEvitarDanio = probabilidadEvitarDanio;
    }

    /**
     * Setea el valor del daño crítico.
     * @param danioCritico : Valor que indica el daño crítico
     */
    public void setDañoCritico(final double danioCritico) {
        this.danioCritico = danioCritico;
    }

    /**
     * Devuelve el daño crítico.
     * @return danioCritico.
     */
    public double getDañoCritico() {
        return this.danioCritico;
    }
}
