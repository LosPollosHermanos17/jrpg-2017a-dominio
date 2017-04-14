package dominio;


 /*
 * Define las acciones de las clases que 
 * implementen esta interfaz
 * 
 * 
 * @param Se definen los metodos a implementar
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
