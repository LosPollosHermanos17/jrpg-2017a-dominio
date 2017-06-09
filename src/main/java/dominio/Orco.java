package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Orco.
 * @since 21/04/2017
 * @version 1.0
 */
public class Orco extends Personaje {

    /**
     * Consumo de energia al ejecutar una habilidad.
     */
	private final int CONSUMO_DE_ENERGIA = 10;
	
	/**
     * Asigna un objeto Orco y lo inicializa de acuerdo a los parámetros recibidos
     * @param nombre : Nombre del personaje
     * @param casta : Casta a la que deberá pertenecer.
     * @param id : Identificador único del personaje
     */
    public Orco(final String nombre, final Casta casta, final int id) {
        super(nombre, casta, id, 10, 0, "Orco", new String[] { "Golpe Defensa", "Mordisco de Vida" });
    }

    /**
     * Asigna un objeto Orco con los parámetros recibidos.
     * @param nombre : Nombre del personaje.
     * @param salud : Cantidad de salud inicial del personaje [0 a 100].
     * @param energia : Cantidad de energia inicial del personaje [0 a 100].
     * @param fuerza : Cantidad de fuerza inicial del personaje.
     * @param destreza : Cantidad de destreza inicial del personaje.
     * @param inteligencia : Cantidad de inteligencia inicial del personaje.
     * @param casta : Casta a la que el personaje deberá pertenecer.
     * @param experiencia : Cantidad de experiencia inicial del personaje.
     * @param nivel : Nivel inicial del personaje.
     * @param idPersonaje : Identificador único del personaje
     * @param inventario - Inventario del personaje con los items que posee.
     */
    public Orco(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
            final int inteligencia, final Casta casta, final int experiencia, final int nivel,
            final int idPersonaje, final Inventario inventario) {
        super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje,
                "Orco", new String[] { "Golpe Defensa", "Mordisco de Vida" }, inventario);
    }

    /**
     * Permite atacar a otro personaje usando el golpe defensa.
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si se pudo atacar al otro personaje.
     */
    public boolean habilidadRaza1(final Peleable atacado) {
    	if (tieneEnergia(CONSUMO_DE_ENERGIA)) {
    		consumirEnergia(CONSUMO_DE_ENERGIA);
            if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite atacar a otro personaje usando el mordisco de vida.
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si se pudo atacar al otro personaje.
     */
    public boolean habilidadRaza2(final Peleable atacado) {
    	if (tieneEnergia(CONSUMO_DE_ENERGIA)) {
    		consumirEnergia(CONSUMO_DE_ENERGIA);
            int danio = atacado.serAtacado(this.getFuerza());
            if (danio > 0) {
                this.serCurado(danio);
                return true;
            }
        }
        return false;
    }
}
