package Funcion;


import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Leer {
	public static String LeerCadernaconvalidar(String textoimp,String regrex) {
		String texto="";
		String validadtexto="";
		do {	Scanner teclado = new Scanner(System.in);
		System.out.println(textoimp);
			 texto=teclado.nextLine();
			if (texto.matches(regrex)) {
				validadtexto=texto;
				break;
			} else {
				System.out.println("erros");
			}
		} while (true);
		return validadtexto;
	}
	public static GregorianCalendar lerdia_hora() {
		return new GregorianCalendar(Utilidad.leer().leerEntero("ANIO2"), Utilidad.leer().leerEntero("MES2"),
				Utilidad.leer().leerEntero("DIAS2"), Utilidad.leer().leerEntero("HORA"),
				Utilidad.leer().leerEntero("MINUNTO2"));
	}

	public static Calendar lerhora() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, Utilidad.leer().leerEntero("aï¿½o"));
		c.set(Calendar.MINUTE, Utilidad.leer().leerEntero("mes") - 1);
		c.set(Calendar.HOUR, Utilidad.leer().leerEntero("dia"));
		return c;
	}

	public static Calendar leDia() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, Utilidad.leer().leerEntero("aï¿½o"));
		int mes_introduci = Utilidad.leer().leerEntero("mes")-1;
		c.set(Calendar.MONTH, mes_introduci);
		c.set(Calendar.DAY_OF_MONTH, Utilidad.leer().leerEntero("dia"));
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.HOUR, 0);
		return c;
	}


public static Calendar leDia1() {
	Calendar c = Calendar.getInstance();
	c.set(Calendar.YEAR, Utilidad.leer().leerEntero("aï¿½o"));
	int mes_introduci = Utilidad.leer().leerEntero("mes")-1;
	c.set(Calendar.MONTH, mes_introduci);
	c.set(Calendar.DAY_OF_MONTH, Utilidad.leer().leerEntero("dia"));
	c.set(Calendar.HOUR, 0);
	c.set(Calendar.MINUTE, 0);
	c.set(Calendar.HOUR, 0);
	return c;
}

	public static Calendar lerhora(Calendar c) {
		c = Calendar.getInstance();
		c.set(Calendar.HOUR, Utilidad.leer().leerEntero("HORA"));
		c.set(Calendar.MINUTE, Utilidad.leer().leerEntero("HORA"));
		c.set(Calendar.HOUR, Utilidad.leer().leerEntero("HORA"));
		return c;
	}

	public static Calendar leDia(Calendar c) {
		c = Calendar.getInstance();
		c.set(Calendar.YEAR, Utilidad.leer().leerEntero("HORA"));
		c.set(Calendar.MONTH, Utilidad.leer().leerEntero("HORA"));
		c.set(Calendar.DAY_OF_MONTH, Utilidad.leer().leerEntero("HORA"));
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.HOUR, 0);
		return c;
	}
	// Clase Leer que leerï¿½ diferentes tipos

	// Mï¿½todo leerEntero devuelve el entero leido
	public static int leerEntero(String str) {
		int valor;
		Scanner teclado = new Scanner(System.in);
		System.out.print(str);
		valor = teclado.nextInt();

		// teclado.close();
		return valor;
	}

	public static double leerDouble(String str) {

		double valor;
		String valorSTR;
		Scanner teclado = new Scanner(System.in);

		System.out.print(str);
		// valor = teclado.nextDouble();
		valorSTR = teclado.next();
		if (valorSTR.indexOf(".") > 0) {
			valorSTR.replace(".", ",");
		}
		valor = Double.parseDouble(valorSTR);

		return valor;
	}

	public static String leerCadena(String str) {

		String valor;
		Scanner teclado = new Scanner(System.in);

		System.out.print(str);
		valor = teclado.nextLine();

		return valor;
	}

	public static int leer_opcion_menu(String str_mi, String[] menu) {
		int opcion = -1;
		String[] menu2 = menu;
		// Comparator<String> c = (a, b) -> a.length() - b.length();
		// Arrays.sort(menu2, c.reversed());
		do {
				for (int i = 1; i < menu.length; i++) {
					System.out.printf("\n%d.- %" + menu[0].length() + "s ", i, menu[i]);
				}
				System.out.println("\n0.-" + menu[0]);
				String str = str_mi;
				opcion = leerEntero(str);
		} while ((opcion >menu.length) && (opcion<-1));
		return opcion;
	}

	
	public static boolean esPrimo(int num) {
		boolean valor = // false
				true;
//		
//		if ((num%2 !=0 && num%3 !=0 && num%5 != 0) || (num == 2 || num == 3 || num == 5) )
//			valor = true;
		int num2 = num;
		for (int i = 2; i <= num2 / 2; i++) {
			if (num % i == 0) {
				valor = false;
				break;
			}
		}
		return valor;
	}

	/**
	 * 
	 * @param num
	 * @return valor
	 */
	public static int miFactorial(int num) {
		int valor = 0;

		if (num > 0) {
			valor = 1;
			for (int i = 1; i <= num; i++) {
				valor *= i;
			}
		} else {
			valor = 1;
		}

		return valor;
	}
	/**
	 * 
	 * @param num
	 */
	public static void tablaMultiplicar(int num) {
		System.out.println("Tabla de multiplicar de " + num);
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%4d x %02d = %3d\n", num, i, (num * i));
		}

	}
	/**
	 *************************************************************************
	 * @param vector
	 * @return
	 *************************************************************************
	 */

	public static double miMedia(double[] vector) {
		double valor = 0.0, suma = 0.0;

		for (int i = 0; i < vector.length; i++) {
			suma = suma + vector[i];
		}

		valor = suma / vector.length;

		return valor;
	}
/**
 * 
 * @param vector
 * @return
 */
	public static double misuma(double[] vector) {
		double valor = 0.0, suma = 0.0;

		for (int i = 0; i < vector.length; i++) {
			suma = suma + vector[i];
		}

		valor = suma;

		return valor;
	}

	public static double miMedia(int[] vector) {
		double valor = 0.0, suma = 0.0;

		for (int i = 0; i < vector.length; i++) {
			suma = suma + vector[i];
		}

		valor = suma / vector.length;

		return valor;
	}

	public static int miBusca(double[] vector, double nota) {
		int valor = -1;
		boolean encontrado = false;

		for (int i = 0; i < vector.length; i++) {
			// if(vector[i] == nota && encontrado == false) {
			if (vector[i] == nota && !encontrado) {
				valor = i + 1;
				encontrado = true;
			}

		}

		return valor;
	}
/**
 *  ************************************************************************
 * @param vector
 * @param nota
 * @return
 *  ************************************************************************
 */
	public static int miBusca(String[] vector, String nota) {
		int valor = -1;
		boolean encontrado = false;

		for (int i = 0; i < vector.length; i++) {
			// if(vector[i] == nota && encontrado == false) {
			if (vector[i].compareTo(nota) == 0 && !encontrado) {
				valor = i + 1;
				encontrado = true;
			}

		}

		return valor;
	}

	public static int miBusca1(String[] vector, String nota) {
		int valor = -1;
		boolean encontrado = false;

		for (int i = 0; i < vector.length; i++) {
			// if(vector[i] == nota && encontrado == false) {
			if (vector[i].compareToIgnoreCase(nota) == 0 && !encontrado) {
				valor = i + 1;
				encontrado = true;
			}

		}

		return valor;
	}

	public static int miBusca(int[] vector, int nota) {
		int valor = -1;
		boolean encontrado = false;

		for (int i = 0; i < vector.length; i++) {
			// if(vector[i] == nota && encontrado == false) {
			if (vector[i] == nota && !encontrado) {
				valor = i + 1;
				encontrado = true;
			}

		}

		return valor;
	}

	/**
	 * 
	 * String name = "";
	 * 
	 * @param String[] miles = { "", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM",
	 *                 "MMMMMMM", "MMMMMMMMM", "M" };
	 * @param String[] cienes = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC",
	 *                 "DCCC", "CM" };
	 * @param String[] diezes = { "", "X","XX", "XXX", "XL", "L", "LX", "LXX",
	 *                 "LXXX", "XC" };
	 * @param String[] unidades = {"", "i", "ii", "iii", "iv", "v", "vi", "vii",
	 *                 "viii", "iv" };
	 * 
	 * @param num
	 * @return
	 */
	public static String name(int num) {
		String name = "";
		String[] miles = { "", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMMM", "MMMMMMMMM" };
		String[] cienes = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] diezes = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] unidades = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return miles[num / 1000] + cienes[(num % 1000) / 100] + diezes[(num % 100) / 10] + unidades[num % 10];
	}

	/************************************************************************
	 * @param vector
	 * 
	 ************************************************************************
	 */
	public static void ordernar_str(String[] vector) {
		// Ordenar
		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = 0; j < vector.length - 1; j++) {

				if (vector[j].compareTo(vector[j + 1]) > 0) {

					String aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;

				}

			}

		}
	}

	/************************************************************************
	 * @param vector
	 * 
	 ************************************************************************
	 */
	public static void ordernar_int(int[] vector) {
		// Ordenar
		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = 0; j < vector.length - 1; j++) {

				if (("" + vector[j]).compareTo("" + vector[j + 1]) > 0) {

					int aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;

				}

			}

		}
	}

	/************************************************************************
	 * @param vector
	 * 
	 ************************************************************************
	 */
	public static void ordernar_int_reversed(int[] vector) {
		// Ordenar
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector.length - 1; j++) {

				if (("" + vector[j]).compareTo("" + vector[j + 1]) < 0) {

					int aux = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = aux;

				}

			}

		}
	}
	/**
	 * @param d
	 * @param x
	 * @param regrex
	 * @param sdf
	 * @return d
	 * @throws ParseException
	 */
	public Calendar LeerCadernaconvalidar(Calendar d, String x, String regrex, SimpleDateFormat sdf) throws ParseException {
		// TODO Auto-generated method stub
		String texto;
		String validadtexto;
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println(x);
			texto = teclado.nextLine();
			if (texto.matches(regrex)) {
				validadtexto = texto;

				d = Calendar.getInstance();
				d.setTime(sdf.parse(validadtexto));

				break;
			} else {
				System.out.println("erros");
			}
		} while (true);
		return d;
	}

}

