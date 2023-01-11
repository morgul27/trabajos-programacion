public class ejfinal {
	public static void main(String[] arg) {
		int m[][] = { { 9, 5, 10, 15, 50 }, { 10, 25, 66, 78, 40 }, { 11, 65, 4, 80, 2 }, { 7, 2, 10, 11, 20 } };
		int suma = 0;

		// ver la matriz
		System.out.println("Matriz");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}

		// sumar las celdas impares
		System.out.println();
		System.out.println("Los numeros sumados son:");

		for (int i = 0; i < m.length; i++) {
			for (int j = (i + 1) % 2; j < m[i].length; j += 2) {
				suma += m[i][j];
				System.out.print(m[i][j] + " ");
			}
			System.out.println(" ");
		}

		System.out.println();
		System.out.println("La suma total de celdas impares es " + suma);
		System.out.println("Las dos últimas cifras es " + suma % 100);
		mes(suma);
		bisiesto(suma);
		System.out.println();
	}

	// funcion del mes
	public static void mes(int suma) {
		String v[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Obtubre", "Noviembre", "Diciembre" };

		if (suma % 100 <= 12)
			System.out.println("El mes obtenido es " + (v[(suma % 100) - 1]));
		else
			System.out.println("El número del mes es incorrecto");
	}

	// funcion de año bisiesto
	public static void bisiesto(int suma) {
		if ((suma % 4 == 0) && ((suma % 100 != 0) || (suma % 400 == 0)))
			System.out.println("El año es bisiesto");
		else
			System.out.println("El año no es bisiesto");
	}
}