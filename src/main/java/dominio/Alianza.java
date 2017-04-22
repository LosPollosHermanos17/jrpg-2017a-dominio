package dominio;

import java.util.LinkedList;

/**
 * Define las caracteristicas y habilidades para poder crear Alianzas entre personajes
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;
	
	/**
	 * Asigna un objeto Alianza y lo inicializa
	 * @param nombre : Nombre de la alianza
	 */
	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	/**
	 * Devuelve la lista de personajes aliados
	 * @return Lista de personajes aliados
	 */
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}
	
	/**
	 * Permite añadir una lista de personajes aliados
	 * @param aliados : Personajes aliados 
	 */	
	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	/**
	 * Devuelve el nombre de la alianza
	 * @return Nombre de la alianza
	 */
	public String obtenerNombre(){
		return nombre;
	}
	
	/**
	 * Elimina a un personaje de la alianza
	 * @param pj Personaje a eliminar
	 */
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}	

	/**
	 * Añade un personaje a la alianza
	 * @param pj Personaje a añadir
	 */
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
