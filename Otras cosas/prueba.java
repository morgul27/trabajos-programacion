import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.*;
import java.util.Locale;

public class prueba {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numApostado = new ArrayList<Integer>();
		ArrayList<Integer> bolaBombo = new ArrayList<Integer>();
		ArrayList<Integer> bolaPremios = new ArrayList<Integer>();
		ArrayList<Integer> Premiosnumero = new ArrayList<Integer>();
		ArrayList<Integer> Premiosdinero = new ArrayList<Integer>();
		int primerPremio;
		int premios[] = { 3000000, 60000, 20000, 100, 20 };
		int segundoPremios[] = { 0, 0, 0 };
		int tercerPremios[] = { 0, 0, 0, 0, 0 };
		int milpremios[];
		milpremios = new int[1000];
		double saldo = 0.0;
		int ran;
		int x;
		int s, t, m, p;
		int r = 0;
		boolean salirMenu = false;

		rellenarBombo(bolaBombo);

		// rellenar la bola de premios
		bolaPremios.add(1);
		rellenarBomboPremios(bolaPremios, 3, 2);
		rellenarBomboPremios(bolaPremios, 5, 3);
		rellenarBomboPremios(bolaPremios, 1000, 4);
		System.out.println(bolaPremios);
		System.out.println(bolaPremios.size());

		do {
			System.out.println("");
			System.out.println("1. Coger numero");
			System.out.println("2. Meter saldo");
			System.out.println("3. Sacar saldo");
			System.out.println("9. Ir a ver los premios");

			x = sc.nextInt();
			switch (x) {
				case 1:
					cogernumero(saldo, numApostado);
					break;
				case 2:
					saldo = saldo(saldo, x);
					break;
				case 3:
					saldo = saldo(saldo, x);
					break;
				case 9:
					salirMenu = true;
					break;
				default:
					System.out.println("Se ha equivocado");

			}
		} while (!salirMenu);

		// premios
		// ahora los premios
		System.out.println("ofu");
		for (int i = 0; i < 1009; i++) {
			Premiosnumero.add(quitarnumerodelBombo(bolaBombo)); // elegir el numero que va a tocar
			System.out.print(i + "|");

		}

		System.out.println();
		System.out.println();
		int i = 0;

		// no borra todos los numeros
		for (i = 0; i < 1009; i++) {
			Premiosdinero.add(quitarnumerodelBombo(bolaPremios)); // elegir el tipo de premio

			bolaPremios.size();
		}

		Premiosdinero.sort(null);
		System.out.println(Premiosdinero);

		// mostrar los premios

		// ver el dinero ganado
		System.out.println();

		/*
		 * System.out.println("En total has ganado " + nf.format(
		 * +((premios[0] * p) + (premios[1] * s) + (premios[2] * t) + (premios[3] * m)
		 * + (premios[4] * r))));
		 */
	}

	// funcion coger el numero
	public static double cogernumero(Double saldo, ArrayList<Integer> numApostado) {
		Scanner sc = new Scanner(System.in);
		String aceptar;

		if (saldo >= 20) {
			do {
				pedirnumero(numApostado, 0, 99999);
				saldo = saldo - 20;

				System.out.println("Quieres pedir otro? Di si para aceptar, tienes " + saldo + " euros");
				aceptar = sc.next();
				System.out.println("");

			} while (aceptar.equals("si") && saldo >= 20);
		}
		return saldo;
	}

	// funcion de numero ver arriba loteria
	public static ArrayList<Integer> pedirnumero(ArrayList<Integer> numApostado, int min, int max) {
		Scanner sc = new Scanner(System.in);
		int num;
		int opcion;

		System.out.println("¿Quieres meter numero(0) o que sea aleatorio?(1)");
		opcion = sc.nextInt();
		do {
			if (opcion == 1) {
				numApostado.add(aleatorio(min, max));
				System.out.println("Su numero es: " + numApostado);
			} else if (opcion == 0) {
				do {
					System.out.println("mete numero");
					num = sc.nextInt();
				} while (num > 99999 || num < 0);
				numApostado.add(num);
				System.out.println("Sus numero son: " + numApostado);

			} else
				System.out.println("Gilipollas");

		} while (opcion != 0 && opcion != 1);

		return numApostado;
	}

	// funcion para rellenar el bombo
	public static void rellenarBombo(ArrayList<Integer> bolaBombo) {
		for (int i = 0; i < 100000; i++) {
			bolaBombo.add(i);
		}
	}

	// funcion para rellenar el bombo
	public static void rellenarBomboPremios(ArrayList<Integer> bolaPremios, int a, int b) {

		for (int i = 0; i < a; i++) {
			bolaPremios.add(b);
		}

	}

	// funcion para quitar numero del bombo
	public static int quitarnumerodelBombo(ArrayList<Integer> bola) {
		int ran;
		int b;

		ran = aleatorio(0, (bola.size()));
		b = bola.get(ran);
		bola.remove(ran);

		return b;
	}

	// funcion aleatorio
	public static int aleatorio(int min, int max) {
		int ran;

		ran = (int) (Math.floor((max) * Math.random()) + min);
		return ran;
	}

	// funcion para for premios
	public static void cogerbola(int Premios[], ArrayList<Integer> bolaBombo, int min, int max) {
		for (int i = min; i < max; i++) {
			Premios[i] = quitarnumerodelBombo(bolaBombo);
		}
	}

	// funcion para ordenar los premios
	public static void ordenar(int Premios[]) {
		int aux;

		for (int i = 0; i < Premios.length; i++) {
			for (int j = 0; j < Premios.length - i - 1; j++) {

				if (Premios[j] > Premios[j + 1]) {
					aux = Premios[j + 1];
					Premios[j + 1] = Premios[j];
					Premios[j] = aux;
				}
			}
		}
	}

	// funcion para mostrar los premios
	public static void mostrarPremios(int Premios[]) {
		for (int i = 0; i < Premios.length; i++)
			System.out.printf("| %1$05d ", Premios[i]);
		System.out.println(" ");
		System.out.println(" ");
	}

	// funcion para el meter o sacar saldo
	public static double saldo(Double saldo, int marcar) {
		Scanner sc = new Scanner(System.in);
		double pedir = 0;

		if (marcar == 2) {
			System.out.println("Introduzca el dinero que quiera meter");
			pedir = sc.nextDouble();
			pedir += saldo;
		} else if (marcar == 3) {
			System.out.println("Introduzca el dinero que quiera sacar");
			pedir = sc.nextDouble();
			pedir = saldo - pedir;
		}

		System.out.println("Su saldo es " + pedir);
		return pedir;
	}

	// funcion para comparar el primer premio
	public static int verPrimerPremio(ArrayList<Integer> PremiosDeJugador, int Premios) {
		int c = 0;
		for (int j = 0; j < PremiosDeJugador.size(); j++) {
			if (Premios == PremiosDeJugador.get(j)) {
				System.out.println("Has ganado 3M");
				c++;
			}
		}
		return c;
	}

	// funcion comparacion de premios
	public static int comparacionPremios(ArrayList<Integer> Premios2, int Premios[], int p, int cantidad[]) {
		int c = 0;
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));

		for (int i = 0; i < Premios.length; i++) {
			for (int j = 0; j < Premios2.size(); j++) {
				if (Premios[i] == Premios2.get(j)) {
					c++;
					if (c == 1)
						System.out.println("Los premios ganados son: ");
					System.out.printf("%1$05d \n", Premios2.get(j));

				}
			}
		}
		System.out.println();
		System.out.printf("Has ganado " + c + " premios de " + nf.format(cantidad[p]));

		return c;
	}

	// funcion comparacion del primer premio
	public static int reintegro(ArrayList<Integer> PremiosDeJugador, int primerPremio) {
		int c = 0;
		int r = 0;
		System.out.println();
		for (int j = 0; j < PremiosDeJugador.size(); j++) {
			if (primerPremio % 10 == PremiosDeJugador.get(j) % 10) {
				c += 20;
				r++;
			}
		}
		System.out.println("Has ganado de reintegro " + c);
		return r;
	}

}