package dominio;
/**
 * Define las caracteristicas y habilidades de un objeto Peleable
 * 
 * @since 21/04/2017
 * @version 1.0
 */
public interface Peleable {
	public int serAtacado(int daño);
	public int getSalud();
	public void despuesDeTurno();
	public int atacar(Peleable atacado);
	public int otorgarExp();
	public int getAtaque();
	public void setAtaque(int ataque);
	public boolean estaVivo();
	public String getNombre();
}
