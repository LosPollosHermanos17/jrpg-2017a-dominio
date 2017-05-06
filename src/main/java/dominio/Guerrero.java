package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Guerrero
 * @since 21/04/2017
 * @version 1.0
 */
public class Guerrero extends Casta {

    private final int ENERGIAMINIMA = 10;

    public Guerrero(final double probCritico, final double evasion, final double danioCritico) {
        super(probCritico, evasion, danioCritico);
        this.nombreCasta = "Guerrero";
    }

    public Guerrero() {
        super();
        this.nombreCasta = "Guerrero";
        habilidadesCasta = new String[] { "Ataque Doble", "Aumentar Defensa", "Ignorar Defensa" };
    }

    /**
     * Permite que un personaje pueda atacar a otro personaje con el doble de fuerza
     * @param caster : Es el personaje atacante
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si el personaje pudo atacar al otro personaje.
     */
    public boolean habilidad1(final Personaje caster, final Peleable atacado) {
        if (caster.getEnergia() > ENERGIAMINIMA) {
            caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
            if (atacado.serAtacado(caster.ataque * 2) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite que un personaje pueda aumentar su defensa
     * @param caster : Es el personaje que aumenta su defensa.
     * @param atacado : Es el personaje de quien se defiende.
     * @return True si el personaje pudo atacar al otro personaje.
     */
    public boolean habilidad2(final Personaje caster, final Peleable atacado) {
        if (caster.getEnergia() > ENERGIAMINIMA) {
            caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
            caster.setDefensa(caster.getDefensa() + caster.magia);
            return true;
        }
        return false;
    }

    /**
     * Permite que un personaje pueda atacar a otro personaje anulando su defensa
     * @param caster : Es el personaje atacante
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si el personaje pudo atacar al otro personaje.
     */
    public boolean habilidad3(final Personaje caster, final Peleable atacado) {
        if (caster.getEnergia() > ENERGIAMINIMA) {
            caster.setEnergia(caster.getEnergia() - ENERGIAMINIMA);
            return atacado.serAtacadoSinDefensa(caster);
        }
        return false;
    }

    /**
     * Inicializa un Personaje de tipo Guerrero, incrementando su atributo <b>fuerza</b>.
     * @param p - objeto Personaje a inicializar.
     */
    public void inicializarPersonaje(final Personaje p) {
        p.setFuerza(p.getFuerza() + 5);
    }

}
