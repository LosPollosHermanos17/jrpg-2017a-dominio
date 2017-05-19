package dominio;

import java.util.Random;

public class MyRandomStub extends RandomGenerator {
	private double n;

    /**
     * Asigna un objeto MyRandomStub y lo inicializa.
     * @param n es el numero que devolverán todos sus métodos
     */
	public MyRandomStub(double n)
	{
		this.n = n;
	}

	/**
	 * Devuelve numero entero doble aleatorio
	 * @return numero aleatorio
	 */
	@Override
	public double nextDouble() {
		return this.n;
	}

	/**
	 * Devuelve un numero entero aleatorio basado en un valor inicial 
	 * @param val : valor inicial
	 * @return numero aleatorio
	 */
	@Override
	public int nextInt(final int n) {
		return (int)this.n;
	}
}
