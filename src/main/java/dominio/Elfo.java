package dominio;

/**
 * Define las caracteristicas y habilidades de un personaje Elfo
 * 
 * @since 21/04/2017
 * @version 1.0
 */

public class Elfo extends Personaje {

  /**
   * Asigna un objeto Elfo y lo inicializa de acuerdo a los parámetros recibidos
   * 
   * @param nombre : Nombre del personaje
   * @param casta : Casta a la que pertenece el personaje
   * @param id : Identificador único del personaje
   */
  public Elfo(String nombre, Casta casta, int id) {
    super(nombre, casta, id, 0, 10, "Elfo", new String[] { "Golpe Level", "Ataque Bosque" });
  }

  /**
   * Asigna un objeto Elfo y lo inicializa de acuerdo a los parámetros recibidos
   * 
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
   */
  public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia,
      Casta casta, int experiencia, int nivel, int idPersonaje) {
    super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel,
        idPersonaje, "Elfo", new String[] { "Golpe Level", "Ataque Bosque" });
  }

  /**
   * Permite atacar a otro personaje utilizando el golpe level
   * 
   * @param atacado : Es el personaje que recibe el ataque.
   * @return True si se pudo atacar al otro personaje.
   */
  public boolean habilidadRaza1(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0) {
        return true;
      }
    }
    return false;
  }

  /**
   * Permite atacar a otro personaje utilizando el golpe level
   * 
   * @param atacado : Es el personaje que recibe el ataque.
   * @return True si se pudo atacar al otro personaje.
   */
  public boolean habilidadRaza2(Peleable atacado) {
    if (this.getEnergia() > 10) {
      this.setEnergia(this.getEnergia() - 10);
      if (atacado.serAtacado((int) (this.magia)) > 0) {
        return true;
      }    
    }
    return false;
  }
}
