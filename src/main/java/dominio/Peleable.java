package dominio;
/**
 * Define las caracteristicas y habilidades de un objeto Peleable
 * 
 * @since 21/04/2017
 * @version 1.0
 */
	public abstract class Peleable {
		private int salud;
		private int fuerza;
		private String nombre;
		
		
	public abstract int serAtacado(int daño);
	
	public int getSalud()
	{
		return this.salud;
	}
	
	public void setSalud(int salud)
	{
		this.salud=salud;
	}
	
	public int getFuerza()
	{
		return this.fuerza;
	}
	
	public void setFuerza(int fuerza)
	{
		this.fuerza=fuerza;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	
	public void despuesDeTurno()
	{
		
	}
	
	public abstract int atacar(Peleable atacado);
	
	public abstract int otorgarExp();
	
	public abstract int getAtaque();
	
	public abstract void setAtaque(int ataque);
	
	public boolean estaVivo()
	{
		return salud>0;
	}
	
}
