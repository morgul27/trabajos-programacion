import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.*;
import java.util.Locale;
import java.io.*;

public class prueba {

	public static void main(String[] args) {
		ArrayList<String> mujeres = new ArrayList<String>();
		ArrayList<String> hombres = new ArrayList<String>();
		ArrayList<String> apellidos = new ArrayList<String>();

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("fichero1.txt"));
			int gen;

			Object array[] = { mujeres, hombres, apellidos };

			lectura("mujeres.txt", mujeres);
			lectura("hombres.txt", hombres);
			lectura("apellidos.txt", apellidos);

			for (int i = 0; i < 3000; i++) {
				// gen es el genero, que sale aleatoriamente sin tener que preguntar más tarde
				// cual es
				gen = aleatorio(0, 1);

				// estoy cogiendo dentro del array, el nombre aleatoriamente del Arraylist
				String nombres = ((ArrayList<String>) array[gen])
						.get(aleatorio(0, (((ArrayList<String>) array[gen]).size())));

				// Aqui estoy escribiendo el nombre de la persona y los dos apellidos con un
				// salto de linea al final
				bw.write(nombres + " " + apellidos.get(aleatorio(0, apellidos.size())) + " "
						+ apellidos.get(aleatorio(0, apellidos.size())) + "\n");

			}
			bw.close();

		} catch (IOException ioe) {
			System.out.println("Se ha producido un error de lectura/escritura");
			System.err.println(ioe.getMessage());
		}
	}

	// leer fichero y guardando los nombre o el apellido en un ArrayList
	public static void lectura(String texto, ArrayList<String> nombres) {
		String linea1 = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(texto));

			while ((linea1 != null)) {
				linea1 = br.readLine();
				nombres.add(linea1);
			}
			br.close();
		} catch (IOException ioe) {
			System.out.println("Se ha producido un error de lectura/escritura");
			System.err.println(ioe.getMessage());
		}

	}

	// Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
	public static int aleatorio(int menor, int mayor) {
		int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
		return n;
	}

}