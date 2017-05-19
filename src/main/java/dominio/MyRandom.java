package dominio;

import java.util.*;
public class MyRandom extends RandomGenerator{
	private Random random;
	
    /**
     * Asigna un objeto MyRandom y lo inicializa.
     */
	public MyRandom()
	{
		this.random = new Random();
	}
	
	/**
     * Devuelve numero entero doble aleatorio
     * @return numero aleatorio
     */
	@Override
	public double nextDouble() {
        return random.nextDouble();
    }

    /**
     * Devuelve un numero entero aleatorio basado en un valor inicial
     * @param val : valor inicial
     * @return numero aleatorio
     */
	@Override
	public int nextInt(final int n) {
        return random.nextInt(n);
    }
}
