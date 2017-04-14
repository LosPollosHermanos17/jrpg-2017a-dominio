package dominio;

import java.util.LinkedList;

/*
 * Se crea una lista de personajes relacionados denominado Alianza
 * @param Creacion de una LinkedList denominada Aliados
 */

public class Alianza {

	String nombre;
	LinkedList<Personaje> aliados;

	public Alianza(String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList <Personaje>();
	}

	/*
	 * Muestra los aliados de un personaje
	 * Se retorna una lista de "Aliados"
	 *@return retorna una lista de Aliados de un personaje
	 *@param Getter de la funcion de aliados
	 */
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}
	
	/*
	*Se encarga de definir las alianzas entre personajes
	*
	*Se retorna un Personaje
	*@param Setter de la funcion aliados
	 */
	public void setAliados(LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

	/*
	 * Define un metodo string para el nombre de la alianza
	 * 
	 * Se retorna un string
	 * @return devuelve un string
	 * @param Muestra nombre de alianza
	 */
	public String obtenerNombre(){
		return nombre;
	}
	/*
	 * Borra un personaje de la lista de alianza
	 * Se le pasa el personaje
	 
	 * 
	 * @param Elimina un personaje de la lista de alianza
	 */
	public void eliminarPersonaje(Personaje pj){
		aliados.remove(pj);
	}
	
	/*
	 * Agrega un personaje a la lista de alianza
	 * Se le pasa el personaje
	 
	 * 
	 * @param Agrega un personaje a la lista de alianza
	 */
	public void añadirPersonaje(Personaje pj){
		aliados.add(pj);
	}
}
