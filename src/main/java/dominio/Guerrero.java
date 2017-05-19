package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Guerrero
 * @since 21/04/2017
 * @version 1.0
 */
public class Guerrero extends Casta {

   /**
    * Bonus de atributo <b>fuerza</b> que se otorga al personaje creado por pertenecer a la casta Guerrero.
    */
   private final int BONUS_FUERZA = 5;

   /**
    * Bonus de atributo <b>inteligencia</b> que se otorga al personaje creado por pertenecer a la casta Guerrero.
    */
   private final int BONUS_INTELIGENCIA = 0;

   /**
    * Bonus de atributo <b>destreza</b> que se otorga al personaje creado por pertenecer a la casta Guerrero.
    */
   private final int BONUS_DESTREZA = 0;

    /**
     * Constructor de tipo Gerrero.
     * @param probCritico : Probabilidad de golpe critico.
     * @param evasion : Porcentaje de evasion.
     * @param danioCritico : Daño critico a realizar.
     */
    public Guerrero(final double probCritico, final double evasion, final double danioCritico) {
        super(probCritico, evasion, danioCritico);
        this.nombreCasta = "Guerrero";
    }

    /**
     * Constructor no parametrizado Gerrero.
     */
    public Guerrero() {
        super();
        this.nombreCasta = "Guerrero";
        habilidadesCasta = new String[] { "Ataque Doble", "Aumentar Defensa", "Ignorar Defensa" };
    }

    /**
     * Permite que un personaje pueda atacar a otro personaje con el doble de fuerza.
     * @param caster : Es el personaje atacante
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si el personaje pudo atacar al otro personaje.
     */
    public boolean habilidad1(final Personaje caster, final Peleable atacado) {
    	if (caster.tieneEnergiaMinima()) {
            caster.consumirEnergiaMinima();
            if (atacado.serAtacado(caster.ataque * 2) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite que un personaje pueda aumentar su defensa.
     * @param caster : Es el personaje que aumenta su defensa.
     * @param atacado : Es el personaje de quien se defiende.
     * @return True si el personaje pudo atacar al otro personaje.
     */
    public boolean habilidad2(final Personaje caster, final Peleable atacado) {
    	if (caster.tieneEnergiaMinima()) {
            caster.consumirEnergiaMinima();
            caster.aumentarDefensa(caster.magia);
            return true;
        }
        return false;
    }

    /**
     * Permite que un personaje pueda atacar a otro personaje anulando su defensa.
     * @param caster : Es el personaje atacante
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si el personaje pudo atacar al otro personaje.
     */
    public boolean habilidad3(final Personaje caster, final Peleable atacado) {
    	if (caster.tieneEnergiaMinima()) {
            caster.consumirEnergiaMinima();
            return atacado.serAtacadoSinDefensa(caster);
        }
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
