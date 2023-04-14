import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.*;
import java.util.Locale;
import java.io.*;

public class prueba {
	private static String[] mujeres;

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("mujeres.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("hombres.txt"));
			BufferedReader br3 = new BufferedReader(new FileReader("apellidos.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("fichero1.txt"));

			String linea1 = "";
			String linea2 = "";
			String linea3 = "";

			mujeres = lectura("mujeres.txt");

			while ((linea1 != null)) {
				linea1 = br.readLine();
				linea2 = br2.readLine();
				linea3 = br3.readLine();
				if (linea1 != null) {
					bw.write(linea1 + "\n");
				}
				if (linea2 != null) {
					bw.write(linea2 + "\n");
				}
				if (linea3 != null) {
					bw.write(linea3 + "\n");
				}

				String[] hombres = linea1.split(" ");
				String[] apellidos = linea1.split(" ");
				for (int i = 0; i < mujeres.length; i++)
					System.out.println(mujeres[i]);

			}

			br.close();
			br2.close();
			bw.close();

		} catch (IOException ioe) {
			System.out.println("Se ha producido un error de lectura/escritura");
			System.err.println(ioe.getMessage());
		}
	}

	// leer fichero
	public static String[] lectura(String texto) {
		String linea1 = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(texto));

			while ((linea1 != null)) {
				linea1 = br.readLine();

				String[] mujeres = linea1.split(" ");
			}
			br.close();
		} catch (IOException ioe) {
			System.out.println("Se ha producido un error de lectura/escritura");
			System.err.println(ioe.getMessage());
		}

		return mujeres;
	}

	// Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
	public static int aleatorio(int menor, int mayor) {
		int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
		return n;
	}

}