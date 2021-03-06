package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Humano
 * @since 21/04/2017
 * @version 1.0
 */
public class Humano extends Personaje {

    /**
     * Consumo de energia al ejecutar una habilidad.
     */
	private final int CONSUMO_DE_ENERGIA = 10;
	
	/**
     * Asigna un objeto Humano y lo inicializa de acuerdo a los parámetros recibidos
     * @param nombre : Nombre del personaje
     * @param casta : Casta a la que deberá pertenecer.
     * @param id : Identificador único del personaje
     */
    public Humano(final String nombre, final Casta casta, final int id) {
        super(nombre, casta, id, 5, 5, "Humano", null);
    }

    /**
     * Asigna un objeto Humano y lo inicializa de acuerdo a los parámetros recibidos
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
    public Humano(final String nombre, final int salud, final int energia, final int fuerza, final int destreza,
            final int inteligencia, final Casta casta, final int experiencia, final int nivel,
            final int idPersonaje, final Inventario inventario) {
        super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje,
                "Humano", new String[] { "Incentivar", "Golpe Fatal" }, inventario);
    }

    /**
     * Permite incrementar el ataque de un aliado
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si se pudo atacar al otro personaje.
     */
    public boolean habilidadRaza1(final Peleable aliado) {
        if (tieneEnergia(CONSUMO_DE_ENERGIA)) {
            consumirEnergia(CONSUMO_DE_ENERGIA);
            aliado.incrementarAtaque(this.getMagia());
            return true;
        }
        return false;
    }

    /**
     * Permite atacar a otro personaje utilizando el golpe fatal
     * @param atacado : Es el personaje que recibe el ataque.
     * @return True si se pudo atacar al otro personaje.
     */
    public boolean habilidadRaza2(final Peleable atacado) {
    	if (tieneEnergia(CONSUMO_DE_ENERGIA)) {
            if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
                consumirEnergia(getEnergia()/2);
                return true;
            }
        }
    	consumirEnergia(CONSUMO_DE_ENERGIA);
        return false;
    }
}
