package dominio;

public class MyRandom {

	/**
	 * Devuelve el valor 0.49
	 * @return 0.49 int Devuelve el valor 0.49
	 */
	
	public static double nextDouble() {
		return 0.49;
	}
	
	/**
	 * Recive un valor entero, le resta 1 y lo devuelve.
	 * @param val int Recive el valor val
	 * @return val -1 Devuelve el valor val - 1
	 */
	
	public static int nextInt(int val) {
		return val - 1;
	}
	
}
