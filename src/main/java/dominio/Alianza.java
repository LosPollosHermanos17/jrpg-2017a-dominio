package dominio;

import java.util.LinkedList;

/**
 * Define las caracteristicas y habilidades para poder crear Alianzas entre personajes.
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
     * Array de tipo LinkedList<Personaje> que contiene los personajes que forman parte de dicha alianza.
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
     * Inicializa un objeto Alianza con el nombre y el array de aliados especificado.
     * @param nombre - nombre de la alianza.
     * @param aliados - array de tipo LinkedList<Personaje> con los integrantes de la nueva alianza.
     */
    public Alianza(final String nombre, final LinkedList<Personaje> aliados) {
        this.nombre = nombre;
        this.aliados = aliados;
    }

    /**
     * Devuelve array que contiene los integrantes de la alianza.
     * @return copia superficial del array de tipo LinkedList<Personaje> con los integrantes de la alianza.
     */
    public LinkedList<Personaje> getAliados() {
        LinkedList<Personaje> aux = new LinkedList<Personaje>(aliados);
        return aux;
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
    public void agregarPersonaje(final Personaje pj) {
        aliados.add(pj);
    }

}
