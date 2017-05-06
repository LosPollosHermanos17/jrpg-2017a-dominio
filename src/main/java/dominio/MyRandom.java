package dominio;

public class MyRandom {
    /**
     * Devuelve una constante
     * @return valor 0.49
     */
    public static double nextDouble() {
        return 0.49;
    }

    /**
     * Resta uno al valor recibido
     * @param val : valor
     * @return numero restado
     */
    public static int nextInt(final int val) {
        return val - 1;
    }
}
