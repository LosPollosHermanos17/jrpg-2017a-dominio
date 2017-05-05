package dominio;

import java.util.LinkedList;

/**
 * Define las caracteristicas y habilidades para poder
 * crear Alianzas entre personajes.
 *
 * @since 21/04/2017
 * @version 1.0
 */
public class Alianza {

    /**
     * Nombre de la Alianza.
     */
    private String nombre;

    /**
     * Vector de tipo LinkedList<Personaje> que contiene
     * los personajes que forman parte de dicha alianza.
     */
    private LinkedList<Personaje> aliados;

    /**
     * Inicializa un objeto Alianza con el nombre especificado.
     * @param nombre - nombre de la alianza.
     */
    public Alianza(final String nombre) {
      this.nombre = nombre;
      this.aliados = new LinkedList<Personaje>();
    }

    /**
     * Devuelve la lista de personajes aliados.
     * @return un array de tipo LinkedList<Personaje> con los
     *         integrantes de la alianza.
     */
     public LinkedList<Personaje> getAliados() {
       return aliados;
     }

    /**
     * Setea el array de tipo LinkedList<Personaje> con los
     * integrantes de la alianza.
     * @param aliados - personajes que formaran parte de la alianza.
     */
     public void setAliados(final LinkedList<Personaje> aliados) {
       this.aliados = aliados;
     }

    /**
     * Devuelve el nombre de la alianza.
     * @return variable String que representa el nombre de la alianza.
     */
     public String obtenerNombre() {
       return nombre;
     }

    /**
     * Remueve el Personaje especificado del array <b>aliados</b>.
     * @param pj - Personaje a eliminar del array.
     */
     public void eliminarPersonaje(final Personaje pj) {
       aliados.remove(pj);
     }

    /**
     * Agrega el Personaje especificado al array <b>aliados</b>.
     * @param pj - Personaje a añadir al array.
     */
     public void añadirPersonaje(final Personaje pj) {
       aliados.add(pj);
     }

}
