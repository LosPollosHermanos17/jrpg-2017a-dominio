package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Hechicero
 * @since 21/04/2017
 * @version 1.0
 */
public class Hechicero extends Casta {

    private final int ENERGIAMINIMA = 10;

    /**
     * Asigna un objeto Hechicero y lo inicializa de acuerdo a los parámetros recibidos
     * @param probCritico : Probabilidad de golpe critico.
     * @param evasion : Valor de evasion.
     * @param danioCritico : Valor del daño crítico.
     */
    public Hechicero(final double probCritico, final double evasion, final double danioCritico) {
        super(probCritico, evasion, danioCritico);
        this.nombreCasta = "Hechicero";
    }

    /**
     * Asigna un objeto Hechicero y lo inicializa
     */
    public Hechicero() {
        super();
        this.nombreCasta = "Hechicero";
        habilidadesCasta = new String[] { "Bola de Fuego", "Curar Aliado", "Robar Energia y Salud" };
    }

    /**
     * Permite a un personaje pueda atacar usando una bola de fuego a otro
     * @param caster : Es el personaje atacante
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si el personaje pudo atacar al otro personaje.
     */
    public boolean habilidad1(final Personaje caster, final Peleable atacado) {
        if (caster.getEnergia() > ENERGIAMINIMA) {
            caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
            if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite que un personaje pueda curar a otro personaje aliado
     * @param caster : Es el personaje que cura
     * @param aliado : Es el personaje a curar.
     * @return True si el personaje pudo curar al otro personaje.
     */
    public boolean habilidad2(final Personaje caster, final Peleable aliado) {
        if (caster.getEnergia() > ENERGIAMINIMA) {
            caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
            return aliado.serCurado(caster);           
        }
        return false;
    }

    /**
     * Permite que un personaje pueda robar energia y salud a otro personaje
     * @param caster : Es el personaje que roba
     * @param atacado : Es el personaje robado.
     * @return True si el personaje pudo robar al otro personaje.
     */
    public boolean habilidad3(final Personaje caster, final Peleable atacado) {
        if (caster.getEnergia() > ENERGIAMINIMA) {
            caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
            return atacado.serRobadoYDesenergizado(caster);           
        }
        return false;
    }

	@Override
	public int getBonusFuerza() {
		return 0;
	}

	@Override
	public int getBonusInteligencia() {
		return 5;
	}

	@Override
	public int getBonusDestreza() {
		return 0;
	}
}
