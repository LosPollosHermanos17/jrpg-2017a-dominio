package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Elfo
 * @since 21/04/2017
 * @version 1.0
 */

public class Elfo extends Personaje {

    /**
     * Consumo de energia al ejecutar una habilidad.
     */
	private final int CONSUMO_DE_ENERGIA = 10;
	
	/**
     * Asigna un objeto Elfo y lo inicializa de acuerdo a los parámetros recibidos
     * @param nombre : Nombre del personaje
     * @param casta : Casta a la que pertenece el personaje
     * @param id : Identificador único del personaje
     */
    public Elfo(final String nombre, final Casta casta, final int id) {
        super(nombre, casta, id, 0, 10, "Elfo", new String[] { "Golpe Level", "Ataque Bosque" });
    }

    /**
     * Asigna un objeto Elfo y lo inicializa de acuerdo a los parámetros recibidos
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
    public Elfo(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
            final int inteligencia, final Casta casta, final int experiencia, final int nivel,
            final int idPersonaje, final Inventario inventario) {
        super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje,
                "Elfo", new String[] { "Golpe Level", "Ataque Bosque" }, inventario);
    }

    /**
     * Permite atacar a otro personaje utilizando el golpe level
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si se pudo atacar al otro personaje.
     */
    public boolean habilidadRaza1(final Peleable atacado) {
        if (tieneEnergia(CONSUMO_DE_ENERGIA)) {
        	consumirEnergia(CONSUMO_DE_ENERGIA);
            if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite atacar a otro personaje utilizando el golpe level
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si se pudo atacar al otro personaje.
     */
    public boolean habilidadRaza2(final Peleable atacado) {
    	if (tieneEnergia(CONSUMO_DE_ENERGIA)) {
    		consumirEnergia(CONSUMO_DE_ENERGIA);
            if (atacado.serAtacado((int) (this.magia)) > 0) {
                return true;
            }
        }
        return false;
    }
}
