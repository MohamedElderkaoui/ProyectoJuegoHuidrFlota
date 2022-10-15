import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import Funcion.Utilidad;

/**
 * 
 */

/**
 * @author mohamed Derkaoui Merzouk benkhadou
 *
 */
public class Principal {
	private static String agua = "≋≋";
	private static String brocle = "🛥🛥";
	private static String toco = "≋🛥";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][][] miflota = mapa();
		int length = miflota.length;
		int length2 = 1;
		cargar(miflota, length);
		int mipunto = 1;
		int cpupunto = 1;

		String[] menu = { "salir", "Facil", "dificu" };
		int opcion = -1;
		do {
			if (opcion == 1) {
				ponenmi(miflota);
				generetmapacpu(miflota);
				mipunto = 6;
				cpupunto = 6;
				List<String> apuntadoList = juegarList(miflota, mipunto, cpupunto);

				apuntadoList.forEach((i) -> System.out.println(i));
				mapa(miflota);

			} else if (opcion == 2) {
				ponenmi3(miflota);
				ponencpu3(miflota);
				mipunto = 7;
				cpupunto = 7;
				List<String> apuntadoList = juegarList(miflota, mipunto, cpupunto);
				apuntadoList.forEach((i) -> System.out.println(i));
				mapa(miflota);

			} else if (opcion == 0) {
				break;
			}
			opcion = Utilidad.leer().leer_opcion_menu("", menu);
		} while (true);
		mapa(miflota);

		/*
		 * String t = ""; t+=imprimir(miflota); System.out.println(t);
		 */

	}

	public static String[][][] mapa() {
		String[][][] miflota = new String[4][8][8];
		return miflota;
	}

	/**
	 * @param miflota
	 * @param mipunto
	 * @param cpupunto
	 * @return
	 */
	public static List<String> juegarList(String[][][] miflota, int mipunto, int cpupunto) {
		String pont = "";
		List<String> apuntadoListmi = new ArrayList<>();
		List<String> apuntadoListcpu = new ArrayList<>();
		int splitpont_x = -1;
		int splitpont_y = -1;
		/**
		 * 
		 * String[][] mb = tablerios[0]; String[][] mdisparo = tablerios[1]; String[][]
		 * Cpub = tablerios[2]; String[][] cpudisparo = tablerios[3];
		 */
		do {

			mipunto = miturno(miflota, mipunto, apuntadoListmi);

			cpupunto = turnoncpu(miflota, cpupunto, apuntadoListcpu);

			if (mipunto == 0) {
				System.out.println("gana tu");
				break;
			}
			if (cpupunto == 0) {
				System.out.println("game over");
				break;
			}
		} while (true);
		return apuntadoListmi;
	}

	public static int turnoncpu(String[][][] miflota, int cpupunto, List<String> apuntadoListcpu) {
		System.out.println("");
		String pont;
		int splitpont_x;
		int splitpont_y;
		pont = String.format("(%d,%d)", (int) (Math.random() * 8), (int) (Math.random() * 8));
		if (!apuntadoListcpu.contains(pont)) {
			if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
				String[] splitpont = pont.split("[\\(\\,\\)]");

				System.out.println(1);
				splitpont_x = Integer.parseInt(splitpont[1]);
				splitpont_y = Integer.parseInt(splitpont[2]);
				if (miflota[2][splitpont_y][splitpont_x].compareTo("x") != 0) {
					if (miflota[0][splitpont_y][splitpont_x].compareTo(brocle) == 0) {
						miflota[0][splitpont_y][splitpont_x] = toco;
						miflota[2][splitpont_y][splitpont_x] = "x";
						cpupunto--;
						cpupunto = turnoncpu(miflota, cpupunto, apuntadoListcpu);

					} else {
						miflota[1][splitpont_y][splitpont_x] = "x";

					}
				}
			}
		}
		return cpupunto;
	}

	public static int miturno(String[][][] miflota, int mipunto, List<String> apuntadoListmi) {
		System.out.println("");
		String pont;
		int splitpont_x;
		int splitpont_y;
		do {
			pont = Utilidad.leer().leerCadena("TU");
			if (!apuntadoListmi.contains(pont)) {
				if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
					String[] splitpont = pont.split("[\\(\\,\\)]");

					splitpont_x = Integer.parseInt(splitpont[1]);
					splitpont_y = Integer.parseInt(splitpont[2]);
					if (miflota[3][splitpont_y][splitpont_x].compareTo(brocle) == 0) {
						if (miflota[1][splitpont_y][splitpont_x].compareTo("x") != 0) {
							miflota[3][splitpont_y][splitpont_x] = toco;
							miflota[1][splitpont_y][splitpont_x] = "x";
							apuntadoListmi.add(pont);
							mipunto = miturno(miflota, mipunto, apuntadoListmi);

							mipunto--;
							break;
						} else {
							miflota[1][splitpont_y][splitpont_x] = "x";
							apuntadoListmi.add(pont);
						}
					}
				}
			}
			mapa(miflota);
			return mipunto;
		} while (!apuntadoListmi.contains(pont));
		return mipunto;
	}

	/**
	 * @param miflota
	 * @param mipunto
	 * @param cpupunto
	 * @return
	 */
	public static List<String> juegarList_4(String[][][] miflota, int mipunto, int cpupunto) {
		String pont = "";
		List<String> apuntadoListmi = new ArrayList<>();
		List<String> apuntadoListcpu = new ArrayList<>();
		int splitpont_x = -1;
		int splitpont_y = -1;
		/**
		 * 
		 * String[][] mb = tablerios[0]; String[][] mdisparo = tablerios[1]; String[][]
		 * Cpub = tablerios[2]; String[][] cpudisparo = tablerios[3];
		 */
		for (int h = 0; h <= 1; h++) {
			for (int i = 0; i <= 1; i++) {
				pont = Utilidad.leer().leerCadena("(#,#)");
				if (!apuntadoListmi.contains(pont)) {
					if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
						String[] splitpont = pont.split("[\\(\\,\\)]");

						splitpont_x = Integer.parseInt(splitpont[1]);
						splitpont_y = Integer.parseInt(splitpont[2]);
						if (miflota[1][splitpont_y][splitpont_x].compareTo("x") != 0) {
							if (miflota[3][splitpont_y][splitpont_x].compareTo(brocle) == 0) {
								miflota[3][splitpont_y][splitpont_x] = toco;
								miflota[1][splitpont_y][splitpont_x] = "x";
								i--;
								mipunto--;
							} else {
								miflota[1][splitpont_y][splitpont_x] = "x";
							}
						}
					}
				}
			}
			for (int i = 0; i <= 1; i++) {
				pont = String.format("(%d,%d)", (int) (Math.random() * 8), (int) (Math.random() * 8));
				if (!apuntadoListcpu.contains(pont)) {
					if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
						String[] splitpont = pont.split("[\\(\\,\\)]");

						splitpont_x = Integer.parseInt(splitpont[1]);
						splitpont_y = Integer.parseInt(splitpont[2]);
						if (miflota[2][splitpont_y][splitpont_x].compareTo("x") != 0) {
							if (miflota[0][splitpont_y][splitpont_x].compareTo(brocle) == 0) {
								miflota[0][splitpont_y][splitpont_x] = toco;
								miflota[2][splitpont_y][splitpont_x] = "x";
								cpupunto--;
								i--;

							} else {
								miflota[1][splitpont_y][splitpont_x] = "x";
							}
						}
					}
				}
			}
			if (mipunto == 0) {
				System.out.println("gana tu");
				return apuntadoListmi;
			}
			if (cpupunto == 0) {
				System.out.println("game over");
				return apuntadoListmi;

			}
		}
		while (true)
			;
	}

	public static void ponencpu3(String[][][] miflota) {
		String pont = "";
		List<String> apuntadoList = new ArrayList<>();
		int splitpont_x = -1;
		int splitpont_y = -1;
		for (int i = 0; i < 2; i++) {
			do {
				pont = String.format("(%d,%d)", (int) (Math.random() * 8), (int) (Math.random() * 8));
				if (!apuntadoList.contains(pont)) {
					if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
						String[] splitpont = pont.split("[\\(\\,\\)]");

						splitpont_x = Integer.parseInt(splitpont[1]);
						splitpont_y = Integer.parseInt(splitpont[2]);
						if (miflota[2][splitpont_y][splitpont_x].compareTo(brocle) != 0) {
							miflota[2][splitpont_y][splitpont_x] = brocle;
							int opcion = -1;
							apuntadoList.add(pont);
							do {
								if (opcion == 1) {
									if (splitpont_y - 1 > -1) {
										if (miflota[2][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[2][splitpont_y - 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 1));
											break;
										}
									}
								} else if (opcion == 2) {
									if (splitpont_y + 1 < miflota[2].length) {
										if (miflota[2][splitpont_y + 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[2][splitpont_y + 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 1));
											break;
										}
									}
								} else if (opcion == 3) {
									if (splitpont_x - 1 > -1) {
										if (miflota[2][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[2][splitpont_y][splitpont_x - 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));
											break;
										}
									}
								} else if (opcion == 4) {
									if (splitpont_x + 1 < miflota[2][splitpont_y].length) {
										if (miflota[2][splitpont_y][splitpont_x + 1].compareTo(brocle) != 0) {
											miflota[2][splitpont_y][splitpont_x + 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));
											break;
										}
									}

								}
								opcion = (int) ((Math.random() * 4) + 1);
							} while (true);
							break;
						}

					}
				}
			} while (true);
		} // for (int i = 0; i < 2; i++)
		do {
			pont = String.format("(%d,%d)", (int) (Math.random() * 8), (int) (Math.random() * 8));
			if (!apuntadoList.contains(pont)) {
				if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
					String[] splitpont = pont.split("[\\(\\,\\)]");

					splitpont_x = Integer.parseInt(splitpont[1]);
					splitpont_y = Integer.parseInt(splitpont[2]);
					if (miflota[2][splitpont_y][splitpont_x].compareTo(brocle) != 0) {
						miflota[2][splitpont_y][splitpont_x] = brocle;
						int opcion = -1;
						apuntadoList.add(pont);
						do {
							if (opcion == 1) {
								if (splitpont_y - 1 > -1) {
									if (miflota[2][splitpont_y - 2][splitpont_x].compareTo(brocle) != 0) {
										if (miflota[2][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[2][splitpont_y - 2][splitpont_x] = brocle;
											miflota[2][splitpont_y - 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 2));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 1));
											break;
										}
									}
								}
							} else if (opcion == 2) {
								if (splitpont_y + 1 < miflota[2].length) {
									if (miflota[2][splitpont_y + 2][splitpont_x].compareTo(brocle) != 0) {
										if (miflota[2][splitpont_y + 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[2][splitpont_y + 2][splitpont_x] = brocle;
											miflota[2][splitpont_y + 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 2));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 1));
											break;
										}
									}
								}
							} else if (opcion == 3) {
								if (splitpont_x - 2 < -1) {
									if (miflota[2][splitpont_y][splitpont_x - 2].compareTo(brocle) != 0) {
										if (miflota[2][splitpont_y][splitpont_x - 1].compareTo(brocle) != 0) {
											miflota[2][splitpont_y][splitpont_x - 2] = brocle;
											miflota[2][splitpont_y][splitpont_x - 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 2, splitpont_y));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));
											break;
										}
									}
								}
							} else if (opcion == 4) {
								if (splitpont_x + 2 > miflota[2][splitpont_y].length) {
									if (miflota[2][splitpont_y][splitpont_x + 2].compareTo(brocle) != 0) {
										if (miflota[2][splitpont_y][splitpont_x + 1].compareTo(brocle) != 0) {
											miflota[2][splitpont_y][splitpont_x + 1] = brocle;
											miflota[2][splitpont_y][splitpont_x + 2] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x + 2, splitpont_y));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x + 1, splitpont_y));
											break;
										}
									}
								}

							}
							opcion = (int) ((Math.random() * 4) + 1);
						} //
						while (true);
						break;
					}

				}
			}
		} while (true);

	}

	public static void ponenmi3(String[][][] miflota) {
		String pont = "";
		List<String> apuntadoList = new ArrayList<>();
		int splitpont_x = -1;
		int splitpont_y = -1;
		for (int i = 0; i < 2; i++) {
			do {
				pont = Utilidad.leer().leerCadena("(#,#)");
				if (!apuntadoList.contains(pont)) {
					if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
						String[] splitpont = pont.split("[\\(\\,\\)]");

						splitpont_x = Integer.parseInt(splitpont[1]);
						splitpont_y = Integer.parseInt(splitpont[2]);
						if (miflota[0][splitpont_y][splitpont_x].compareTo(brocle) != 0) {
							miflota[0][splitpont_y][splitpont_x] = brocle;
							String t = "";
							t += imprimir(miflota);
							System.out.print(t);
							miflota[0][splitpont_y][splitpont_x] = brocle;
							String[] menu = { " ", "arriba", "abajo", "derecha", "izquiedad" };
							int opcion = -1;
							apuntadoList.add(pont);
							do {
								if (opcion == 1) {
									if (splitpont_y - 1 > -1) {
										if (miflota[0][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											System.out.println("arriba");
											miflota[0][splitpont_y - 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 1));
											mapa(miflota);
											break;
										} else {
											System.out.println("error posicion");
										}
									}
								} else if (opcion == 2) {
									if (splitpont_y + 1 < miflota[0].length) {
										if (miflota[0][splitpont_y + 1][splitpont_x].compareTo(brocle) != 0) {
											System.out.println("abajo");
											miflota[0][splitpont_y + 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 1));
											mapa(miflota);
											break;
										} else {
											System.out.println("error posicion");
										}
									}
								} else if (opcion == 3) {
									if (splitpont_x - 1 > -1) {
										if (miflota[0][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											System.out.println("derecha");
											miflota[0][splitpont_y][splitpont_x - 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));
											apuntadoList.forEach((i2) -> System.out.println(i2));
											mapa(miflota);
											break;
										} else {
											System.out.println("error posicion");
										}
									}
								} else if (opcion == 4) {
									if (splitpont_x + 1 < miflota[0][splitpont_y].length) {
										if (miflota[0][splitpont_y][splitpont_x + 1].compareTo(brocle) != 0) {
											System.out.println("derecha");
											miflota[0][splitpont_y][splitpont_x + 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));
											apuntadoList.forEach((i2) -> System.out.println(i2));
											mapa(miflota);
											break;
										} else {
											System.out.println("error posicion");
										}
									}

								}
								opcion = (int) (Math.random() * 4);
							} while (true);
							break;
						}

					}
				}
			} while (true);
		} // for (int i = 0; i < 2; i++)
		do {
			pont = Utilidad.leer().leerCadena("(#,#)");
			if (!apuntadoList.contains(pont)) {
				if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
					String[] splitpont = pont.split("[\\(\\,\\)]");

					splitpont_x = Integer.parseInt(splitpont[1]);
					splitpont_y = Integer.parseInt(splitpont[2]);
					if (miflota[0][splitpont_y][splitpont_x].compareTo(brocle) != 0) {
						String t = "";
						t += imprimir(miflota);
						System.out.print(t);
						miflota[0][splitpont_y][splitpont_x] = brocle;
						String[] menu = { " ", "arriba", "abajo", "derecha", "izquiedad" };
						int opcion = -1;
						apuntadoList.add(pont);
						apuntadoList.forEach((i) -> System.out.println(i));
						mapa(miflota);
						do {
							if (opcion == 1) {
								if (splitpont_y - 1 > -1) {
									if (miflota[0][splitpont_y - 2][splitpont_x].compareTo(brocle) != 0) {
										if (miflota[0][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[0][splitpont_y - 2][splitpont_x] = brocle;
											miflota[0][splitpont_y - 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 2));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 1));
											apuntadoList.forEach((i) -> System.out.println(i));
											mapa(miflota);
											break;
										} else {
											System.out.println("error posicion");
										}
									} else {
										System.out.println("error posicion");
									}
								}
							} else if (opcion == 2) {
								if (splitpont_y + 1 < miflota[0].length) {
									if (miflota[0][splitpont_y + 2][splitpont_x].compareTo(brocle) != 0) {
										if (miflota[0][splitpont_y + 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[0][splitpont_y + 2][splitpont_x] = brocle;
											miflota[0][splitpont_y + 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 2));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 1));
											apuntadoList.forEach((i) -> System.out.println(i));
											mapa(miflota);
											break;
										}
									} else {
										System.out.println("error posicion");
									}
								}
							} else if (opcion == 3) {
								if (splitpont_x - 2 < -1) {
									if (miflota[0][splitpont_y][splitpont_x - 2].compareTo(brocle) != 0) {
										if (miflota[0][splitpont_y][splitpont_x - 1].compareTo(brocle) != 0) {
											miflota[0][splitpont_y][splitpont_x - 2] = brocle;
											miflota[0][splitpont_y][splitpont_x - 2] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 2, splitpont_y));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));
											apuntadoList.forEach((i) -> System.out.println(i));
											mapa(miflota);
											break;
										} else {
											System.out.println("error posicion");
										}
									} else {
										System.out.println("error posicion");
									}
								}
							} else if (opcion == 4) {
								if (splitpont_x + 2 > miflota[0][splitpont_y].length) {
									if (miflota[0][splitpont_y][splitpont_x + 2].compareTo(brocle) != 0) {
										if (miflota[0][splitpont_y][splitpont_x + 1].compareTo(brocle) != 0) {
											miflota[0][splitpont_y][splitpont_x + 1] = brocle;
											miflota[0][splitpont_y][splitpont_x + 2] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x + 2, splitpont_y));
											apuntadoList.add(String.format("(%d,%d)", splitpont_x + 1, splitpont_y));
											apuntadoList.forEach((i) -> System.out.println(i));
											mapa(miflota);
											break;
										} else {
											System.out.println("error posicion");
										}
									} else {
										System.out.println("error posicion");
									}
								}

							}
							opcion = (int) (Math.random() * 4);
						} while (true);
						break;
					}

				}
			}
		} while (true);
		apuntadoList.forEach((i) -> System.out.println(i));
		String t = "";
		t += imprimir(miflota);
		System.out.print(t);
	}

	public static void mapa(String[][][] miflota) {
		String tt = "";
		tt += imprimirmi(miflota);
		System.out.print(tt);
	}

	/* drtt(),8,8 */
	/**
	 * imprimir tabla
	 * 
	 * @param tablerios
	 * @return
	 */
	public static String imprimir(String[][][] tablerios) {
		// TODO Auto-generated method stub

		String[][] mb = tablerios[0];
		String[][] mdisparo = tablerios[1];
		String[][] Cpub = tablerios[2];
		String[][] cpudisparo = tablerios[3];
		String t = "";
		String tl = "";
		int length = tl.length();
		for (int i = 0; i < mb.length; i++) {
			tl = "";
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < mb[i].length; j++) {
				String casilla_mb = mb[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_mb));
			}
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < mdisparo[i].length; j++) {
				String casilla_mdisparo = mdisparo[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_mdisparo));
			}
			tl += String.format("%s|", Utilidad.c(10, ""));
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < Cpub[i].length; j++) {
				String casilla_Cpub = Cpub[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_Cpub));
			}
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));

			for (int j = 0; j < cpudisparo[i].length; j++) {
				String casilla_cpudisparo = cpudisparo[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_cpudisparo));
			}
			length = tl.length();
			tl += "\n";

			tl += Utilidad.c(length, " ").replace(" ", "-");
			tl += "\n";

			t += tl;
		}

		tl = ddd(tl);
		tl += "\n";
		t += tl;
		return t;
	}/* drtt(),8,8 */

	public static void generetmapacpu(String[][][] miflota) {
		String pont = "";
		List<String> apuntadoList = new ArrayList<>();
		int splitpont_x = -1;
		int splitpont_y = -1;
		for (int i = 0; i < 3; i++) {
			do {
				pont = String.format("(%d,%d)", (int) (Math.random() * 8), (int) (Math.random() * 8));
				if (!apuntadoList.contains(pont)) {
					if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {
						String[] splitpont = pont.split("[\\(\\,\\)]");

						splitpont_x = Integer.parseInt(splitpont[1]);
						splitpont_y = Integer.parseInt(splitpont[2]);
						if (miflota[2][splitpont_y][splitpont_x].compareTo(brocle) != 0) {
							miflota[2][splitpont_y][splitpont_x] = brocle;
							String[] menu = { " ", "arriba", "abajo", "derecha", "izquiedad" };
							int opcion = -1;
							apuntadoList.add(pont);
							do {
								if (opcion == 1) {
									if (splitpont_y - 1 > -1) {
										if (miflota[2][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[2][splitpont_y - 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 1));
											break;
										}
									}
								} else if (opcion == 2) {
									if (splitpont_y + 1 < miflota[2].length) {
										if (miflota[2][splitpont_y + 1][splitpont_x].compareTo(brocle) != 0) {
											miflota[2][splitpont_y + 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 1));
											break;
										}
									}
								} else if (opcion == 3) {
									if (splitpont_x - 1 > -1) {
										if (miflota[2][splitpont_y][splitpont_x - 1].compareTo(brocle) != 0) {
											miflota[2][splitpont_y][splitpont_x - 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));
											break;
										}
									}
								} else if (opcion == 4) {
									if (splitpont_x + 1 < miflota[2][splitpont_y].length) {
										if (miflota[2][splitpont_y][splitpont_x + 1].compareTo(brocle) != 0) {
											miflota[2][splitpont_y][splitpont_x + 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x + 1, splitpont_y));
											break;
										}
									}

								}
								opcion = ((int) (Math.random() * 4)) + 1;
							} while (true);
							break;
						}

					}
				}
			} //
			while (true);
		}
		apuntadoList.forEach((i) -> System.out.println(i));
	}

	/**
	 * 
	 * @param miflota
	 */
	public static void ponenmi(String[][][] miflota) {
		String pont = "";
		List<String> apuntadoList = new ArrayList<>();
		int splitpont_x = -1;
		int splitpont_y = -1;
		for (int i = 0; i < 3; i++) {
			do {
				pont = Utilidad.leer().leerCadena("(#,#)");// escribi con coordernada
				if (!apuntadoList.contains(pont)) {// si no hay estacoordernada lisr
					if (pont.matches("\\([0-7]{1}\\,[0-7]{1}\\)")) {// valida
						String[] splitpont = pont.split("[\\(\\,\\)]"); // saca losd

						splitpont_x = Integer.parseInt(splitpont[1]);//
						splitpont_y = Integer.parseInt(splitpont[2]);
						if (miflota[0][splitpont_y][splitpont_x].compareTo(brocle) != 0) {// valida si no hay barco
							miflota[0][splitpont_y][splitpont_x] = brocle;
							mapa(miflota);// imprimir
							String[] menu = { " ", "arriba", "abajo", "derecha", "izquiedad" };
							int opcion = -1;
							apuntadoList.add(pont);// añidir
							do {
								if (opcion == 1) {
									if (splitpont_y - 1 > -1) {
										if (miflota[0][splitpont_y - 1][splitpont_x].compareTo(brocle) != 0) {
											System.out.println("arriba");
											miflota[0][splitpont_y - 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y - 1));// añidir
											mapa(miflota);// imprimir
											break;
										} else {
											System.out.println("error posicion");
										}
									}
								} else if (opcion == 2) {
									if (splitpont_y + 1 < miflota[0].length) {
										if (miflota[0][splitpont_y + 1][splitpont_x].compareTo(brocle) != 0) {
											System.out.println("abajo");
											miflota[0][splitpont_y + 1][splitpont_x] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x, splitpont_y + 1));// añidir
											mapa(miflota);// imprimir
											break;
										} else {
											System.out.println("error posicion");
										}
									}
								} else if (opcion == 3) {
									if (splitpont_x - 1 > -1) {
										if (miflota[0][splitpont_y][splitpont_x - 1].compareTo(brocle) != 0) {
											System.out.println("derecha");
											miflota[0][splitpont_y][splitpont_x - 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x - 1, splitpont_y));// añidir
											mapa(miflota);// imprimir
											break;
										} else {
											System.out.println("error posicion");
										}
									}
								} else if (opcion == 4) {
									if (splitpont_x + 1 < miflota[0][splitpont_y].length) {
										if (miflota[0][splitpont_y][splitpont_x + 1].compareTo(brocle) != 0) {
											System.out.println("derecha");
											miflota[0][splitpont_y][splitpont_x + 1] = brocle;
											apuntadoList.add(String.format("(%d,%d)", splitpont_x + 1, splitpont_y));// añidir
											mapa(miflota);// imprimir
											break;
										} else {
											System.out.println("error posicion");
										}
									}

								}
								opcion = Utilidad.leer().leer_opcion_menu("", menu);
							} while (true);
							break;
						} else {
							System.out.println("error posicion");
						}

					}
				}
			} while (true);
		}
		apuntadoList.forEach((i) -> System.out.println(i));
		mapa(miflota);
	}

	/**
	 * para i
	 * 
	 * @param tablerios
	 * @return
	 */
	public static String imprimirmi(String[][][] tablerios) {
		// TODO Auto-generated method stub

		String[][] mb = tablerios[0];
		String[][] mdisparo = tablerios[1];
		String[][] Cpub = tablerios[2];
		String[][] cpudisparo = tablerios[3];
		String t = "";
		String tl = "";

		int length = tl.length();
		for (int i = 0; i < mb.length; i++) {
			tl = "";
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < mb[i].length; j++) {
				String casilla_mb = mb[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_mb));
			}
			tl += String.format("%s|", Utilidad.c(10, ""));
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < mdisparo[i].length; j++) {
				String casilla_mdisparo = mdisparo[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_mdisparo));
			}

			length = tl.length();
			tl += "\n";

			tl += Utilidad.c(length, " ").replace(" ", "-");
			tl += "\n";

			t += tl;
		}

		tl += String.format("%s|", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));

		tl += String.format("%s|", Utilidad.c(10, ""));
		tl += String.format("%s|", Utilidad.c(drtt(), ""));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));
		;
		tl += "\n";
		t += tl;
		return t;
	}/* drtt(),8,8 */

	/**
	 * imprime parte cup pc
	 * 
	 * @param tablerios
	 * @return
	 */
	public static String i2mprimircpu(String[][][] tablerios) {
		// TODO Auto-generated method stub

		String[][] mb = tablerios[0];
		String[][] mdisparo = tablerios[1];
		String[][] Cpub = tablerios[2];
		String[][] cpudisparo = tablerios[3];
		String t = "";
		String tl = "";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		int length = tl.length();
		for (int i = 0; i < mb.length; i++) {
			tl = "";

			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < Cpub[i].length; j++) {
				String casilla_Cpub = Cpub[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_Cpub));
			}
			tl += String.format("%s|", Utilidad.c(10, ""));
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < cpudisparo[i].length; j++) {
				String casilla_cpudisparo = cpudisparo[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_cpudisparo));
			}

			length = tl.length();
			tl += "\n";

			tl += Utilidad.c(length, " ").replace(" ", "-");
			tl += "\n";

			t += tl;
		}

		tl += String.format("%s|", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));

		tl += String.format("%s|", Utilidad.c(10, ""));
		tl += String.format("%s|", Utilidad.c(drtt(), ""));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));
		;
		tl += "\n";
		t += tl;
		return t;
	}

	/* drtt(),8,8 */ /**
						 * imprime parte cup pc
						 * 
						 * @param tablerios
						 * @return
						 */
	public static String imprimircpu(String[][][] tablerios) {
		// TODO Auto-generated method stub

		String[][] mb = tablerios[0];
		String[][] mdisparo = tablerios[1];
		String[][] Cpub = tablerios[2];
		String[][] cpudisparo = tablerios[3];
		String t = "";
		String tl = "";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		int length = tl.length();
		for (int i = 0; i < mb.length; i++) {
			tl = "";
			/*
			 * tl += String.format("%s|", Utilidad.c(drtt(), i + 1)); for (int j = 0; j <
			 * mb[i].length; j++) { String casilla_mb = mb[i][j]; tl += String.format("%s|",
			 * Utilidad.c(drtt(), casilla_mb)); }
			 * 
			 * tl += String.format("%s|", Utilidad.c(drtt(), i + 1)); for (int j = 0; j <
			 * mdisparo[i].length; j++) { String casilla_mdisparo = mdisparo[i][j]; tl +=
			 * String.format("%s|", Utilidad.c(drtt(), casilla_mdisparo)); }
			 */

			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < Cpub[i].length; j++) {
				String casilla_Cpub = Cpub[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_Cpub));
			}
			tl += String.format("%s|", Utilidad.c(10, ""));
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < cpudisparo[i].length; j++) {
				String casilla_cpudisparo = cpudisparo[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_cpudisparo));
			}

			length = tl.length();
			tl += "\n";

			tl += Utilidad.c(length, " ").replace(" ", "-");
			tl += "\n";

			t += tl;
		}

		tl += String.format("%s|", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));

		tl += String.format("%s|", Utilidad.c(drtt(), ""));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));
		;
		tl += "\n";
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "p"));
		tl += String.format("%s|", Utilidad.c(drtt(), "u"));
		tl += String.format("%s|", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(drtt(), "m"));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "p"));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), " "));

		tl += String.format("%s|", Utilidad.c(10, ""));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "p"));
		tl += String.format("%s|", Utilidad.c(drtt(), "u"));
		tl += String.format("%s|", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(drtt(), "m"));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "p"));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), " "));

		t += tl;
		return t;
	}

	/* drtt(),8,8 */ /**
						 * imprime parte cup pc
						 * 
						 * @param tablerios
						 * @return
						 */
	public static String imprimircpu_MI(String[][][] tablerios) {

		String[][] mb = tablerios[0];
		String[][] mdisparo = tablerios[1];
		String[][] Cpub = tablerios[2];
		String[][] cpudisparo = tablerios[3];
		String t = "";
		String tl = "";

		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		tl += "\n";
		int length = tl.length();
		for (int i = 0; i < mb.length; i++) {
			tl = "";

			/**
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			tl += String.format("%s|", Utilidad.c(drtt(), i + 1));
			for (int j = 0; j < Cpub[i].length; j++) {
				String casilla_Cpub = Cpub[i][j];
				tl += String.format("%s|", Utilidad.c(drtt(), casilla_Cpub));
			}
			/**
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			length = tl.length();
			tl += "\n";

			tl += Utilidad.c(length, " ").replace(" ", "-");
			tl += "\n";

			t += tl;
		}

		tl += String.format("%s|", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));

		/*
		 * tl += String.format("%s|", Utilidad.c(10, "")); tl += String.format("%s|",
		 * Utilidad.c(drtt(), "")); tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		 * tl += String.format("%s|", Utilidad.c(drtt(), "b")); tl +=
		 * String.format("%s|", Utilidad.c(drtt(), "c")); tl += String.format("%s|",
		 * Utilidad.c(drtt(), "d")); tl += String.format("%s|", Utilidad.c(drtt(),
		 * "e")); tl += String.format("%s|", Utilidad.c(drtt(), "f")); tl +=
		 * String.format("%s|", Utilidad.c(drtt(), "g")); tl += String.format("%s|",
		 * Utilidad.c(drtt(), "h")); ;
		 */
		tl += "\n";
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), "m"));
		tl += String.format("%s", Utilidad.c(drtt(), "i"));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), "m"));
		tl += String.format("%s", Utilidad.c(drtt(), "a"));
		tl += String.format("%s", Utilidad.c(drtt(), "p"));
		tl += String.format("%s", Utilidad.c(drtt(), "a"));
		tl += String.format("%s", Utilidad.c(drtt(), " "));

		t += tl;
		return t;
	}/* drtt(),8,8 */

	/**
	 * peid de tablero
	 * 
	 * @param tl
	 * @return
	 */
	public static String ddd(String tl) {
		tl += String.format("%s|", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));
		tl += String.format("%s", Utilidad.c(drtt(), ""));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));
		tl += String.format("%s|", Utilidad.c(10, ""));
		tl += String.format("%s|", Utilidad.c(drtt(), ""));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));
		tl += String.format("%s", Utilidad.c(drtt(), ""));
		tl += String.format("%s|", Utilidad.c(drtt(), "a"));
		tl += String.format("%s|", Utilidad.c(drtt(), "b"));
		tl += String.format("%s|", Utilidad.c(drtt(), "c"));
		tl += String.format("%s|", Utilidad.c(drtt(), "d"));
		tl += String.format("%s|", Utilidad.c(drtt(), "e"));
		tl += String.format("%s|", Utilidad.c(drtt(), "f"));
		tl += String.format("%s|", Utilidad.c(drtt(), "g"));
		tl += String.format("%s|", Utilidad.c(drtt(), "h"));
		tl += String.format("%s", Utilidad.c(drtt(), ""));
		tl += "\n";
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), "m"));
		tl += String.format("%s", Utilidad.c(drtt(), "i"));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), "m"));
		tl += String.format("%s", Utilidad.c(drtt(), "a"));
		tl += String.format("%s", Utilidad.c(drtt(), "p"));
		tl += String.format("%s", Utilidad.c(drtt(), "a"));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), ""));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), "m"));
		tl += String.format("%s", Utilidad.c(drtt(), "i"));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), "m"));
		tl += String.format("%s", Utilidad.c(drtt(), "a"));
		tl += String.format("%s", Utilidad.c(drtt(), "p"));
		tl += String.format("%s", Utilidad.c(drtt(), "a"));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s", Utilidad.c(drtt(), " "));
		tl += String.format("%s|", Utilidad.c(10, ""));

		return tl;
	}

	/**
	 * 
	 * @return
	 */
	public static int drtt() {
		return 4;
	}

	/**
	 * 
	 * @param miflota
	 * @param length
	 */

	public static void cargar(String[][][] miflota, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < miflota[i].length; j++) {
				for (int j2 = 0; j2 < miflota[i][j].length; j2++) {
					miflota[i][j][j2] = ((i == 0) ? agua : ((i == 1) ? "" : ((i == 2) ? agua : ((i == 3) ? "" : ""))));
					// System.out.printf("%5s", miflota[i][j][j2]);🛥
				}

			}
		}
	}

}
