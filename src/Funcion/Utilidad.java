package Funcion;





/**
 * 
 * @author Mohamed el Derkaoui Merzouk Bendoukha 1iN_DAWD
 *
 */
public class Utilidad {

	/**
	 * 
	 * @param width
	 * @param s
	 * @return
	 */
	public static String c(int width, String s) {
		return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}

	public static String c(int width, int s) {
		return String.format("%-" + width + "s",String.format("%" + (("" + s).length() + (width - ("" + s).length()) / 2) + "s", s));
	}
	public static String c1(int width, int s) {
		return String.format("%-" + width + "s|",String.format("%" + (("" + s).length() + (width - ("" + s).length()) / 2) + "s", s));
	}

	/**
	 * @param d2
	 * @param d3
	 * @return boolean d2 * boolean d3
	 */
	public static boolean y(boolean d2, boolean d3) {
		return d2 && d3;
	}

	/**
	 * @param d2
	 * @param d3
	 * @return boolean d2+boolean d3
	 */
	public static boolean o(boolean d2, boolean d3) {
		return d2 || d3;
	}

	/**
	 * 
	 * @return leer
	 */
	public static Leer leer() {
		Leer leer = new Leer();
		return leer;

	}

	/**
	 * +int[] ordernadore(int[] vector)
	 * 
	 * @param vector
	 */
	public static int[] ordernadore(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < (vector.length - 1); j++) {
				int apoyo;
				if (vector[j] > vector[j + 1]) {
					apoyo = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = apoyo;
				}
			}
		}
		return vector;
	}

	/**
	 * 
	 * @param numero
	 * @param i
	 * @param j
	 * @return i>numero>j
	 */
	public static boolean intervalo(int numero, int i, int j) {
		return (numero < i) || (numero > j);
	}

	/**
	 * 
	 * @param numero
	 * @param i
	 * @param j
	 * @return i>numero>j
	 */
	public static boolean iintervalo1(int numero, int i, int j) {
		boolean b = (numero < i) || (numero > j);
		return !b;
	}

	/**
	 * 
	 * @param numero
	 * @param i
	 * @param j
	 * @return i>numero>j
	 */

	public static boolean no_o_intervalo(int numero, int i, int j) {
		boolean b = (numero < i) && (numero > j);
		return !b;
	}

	/**
	 * 
	 * @param numero
	 * @param i
	 * @param j
	 * @return i>numero>j
	 */

	public static boolean o_intervalo(int numero, int i, int j) {
		boolean b = (numero < i) && (numero > j);
		return b;
	}

	/**
	 * @param numero
	 * @param i
	 * @param j
	 * @return i>numero>j
	 */
	public static boolean intervalo(int numero, int i) {
		return (numero < i);
	}
}
