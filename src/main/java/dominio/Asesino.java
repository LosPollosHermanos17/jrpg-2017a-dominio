package dominio;

/**
 * Define las habilidades de un Asesino.
 * @author desconocido
 */

public class Asesino extends Casta {
   
    /**
     * Consumo de energia al ejecutar una habilidad.
     */
	private final int CONSUMO_DE_ENERGIA = 10;
	
	/**
     * Bonus de atributo <b>fuerza</b> que se otorga al personaje creado por pertenecer a la casta Asesino.
     */
    private final int BONUS_FUERZA = 0;

    /**
     * Bonus de atributo <b>inteligencia</b> que se otorga al personaje creado por pertenecer a la casta Asesino.
     */
    private final int BONUS_INTELIGENCIA = 0;

    /**
     * Bonus de atributo <b>destreza</b> que se otorga al personaje creado por pertenecer a la casta Asesino.
     */
    private final int BONUS_DESTREZA = 5;

    /**
     * Maxima probabilidad de evitar daño.
     */
    private final double PROB_EVITAR_DANIO_MAXIMA = 0.5;

    /**
     * Probabilidad de evitar daño a incrementar con la ejecución de la habilidad.
     */
    private final double PROB_EVITAR_DANIO_A_INCREMENTAR = 0.15;

    /**
     * Constructor por defecto. Inicializa un objeto Asesino asignandole las habilidades.
     */
    public Asesino() {
        super();
        this.nombreCasta = "Asesino";
        habilidadesCasta = new String[] {"Golpe Critico", "Aumentar Evasion", "Robar"};  
    }

    /**
     * Inicializa un objeto Asesino con los parametros especificados, utilizando el constructor de la clase padre
     * "Casta".
     * @param probCrit - probabilidad de golpe crítico inicial.
     * @param evasion - probabilidad de evitar daño inicial.
     * @param danioCrit - cantidad de daño al realizar un golpe crítico.
     */
    public Asesino(final double probCrit, final double evasion, final double danioCrit) {
        super(probCrit, evasion, danioCrit);
        this.nombreCasta = "Asesino";
    }

    /**
     * Define la habilidad1 para la clase Asesino.
     * @param caster - objeto de tipo Personaje atacante.
     * @param atacado - objeto que implementa Peleable atacado.
     * @return true si se puede realizar el ataque o false en caso contrario
     */
    public boolean habilidad1(final Personaje caster, final Peleable atacado) {
    	if (caster.tieneEnergia(CONSUMO_DE_ENERGIA)) {
            caster.consumirEnergia(CONSUMO_DE_ENERGIA);
            if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDañoCritico())) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Define la habilidad2 para la clase Asesino.
     * @param caster - objeto de tipo Personaje que aumenta su probabilidad de evasión.
     * @param atacado - objeto que implementa Peleable atacado.
     * @return true si el personaje pudo aumentar su probabilidad de evasion o false en caso contrario.
     */
    public boolean habilidad2(final Personaje caster, final Peleable atacado) {
    	if (caster.tieneEnergia(CONSUMO_DE_ENERGIA)) {
            caster.consumirEnergia(CONSUMO_DE_ENERGIA);
            if (this.getProbabilidadEvitarDaño() + PROB_EVITAR_DANIO_A_INCREMENTAR < PROB_EVITAR_DANIO_MAXIMA) {
                this.probabilidadEvitarDanio += PROB_EVITAR_DANIO_A_INCREMENTAR;
            } else {
                this.probabilidadEvitarDanio = PROB_EVITAR_DANIO_MAXIMA;
            }
            return true;
        }
        return false;
    }

    /**
     * Permite que un personaje pueda robar a otro personaje.
     * @param caster - personaje que roba.
     * @param atacado - personaje robado.
     * @return false siempre.
     */
    public boolean habilidad3(final Personaje caster, final Peleable atacado) {
        return false;
    }

    @Override
    public int getBonusFuerza() {
        return BONUS_FUERZA;
    }

    @Override
    public int getBonusInteligencia() {
        return BONUS_INTELIGENCIA;
    }

    @Override
    public int getBonusDestreza() {
        return BONUS_DESTREZA;
    }

}
