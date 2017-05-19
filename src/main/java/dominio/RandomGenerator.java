package dominio;

public abstract class RandomGenerator {
	/**
     * Devuelve numero entero doble aleatorio
     * @return numero aleatorio
     */
    public abstract double nextDouble();

    /**
     * Devuelve un numero entero aleatorio entre 0 y n
     * @param n : valor maximo posible
     * @return numero aleatorio
     */
    public abstract int nextInt(final int n);
}
