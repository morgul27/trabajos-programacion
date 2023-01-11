import java.util.Scanner;

public class registrobien {
	public static void main(String args[]) {
		String con1;

		con1 = pedircon();

		if (simulacion(con1, 3))
			System.out.println("ENHORABUENA!");
		else
			System.out.println("FIN: Intentos agotados");
	}

	// funcion para pedir contraseña
	public static String pedircon() {

		String a, b;
		do {
			a = pedirpalabra("Introduce contraseña");
			b = pedirpalabra("Repite contraseña");

			if (!a.equals(b))
				System.out.println("Las contrasenas no coinciden");
		} while (!a.equals(b));
		return a;
	}

	// funcion para la contraseña simulada
	public static boolean simulacion(String con1, int max) {
		String con2;
		System.out.println("Simulacion de registro");
		int i;

		for (i = 1; i <= max; i++) {
			con2 = pedirpalabra("Introduce la contrasena. Intento " + i + " de " + max);

			if (con1.equals(con2))
				break;
			else
				System.out.println("Contrasena incorrecta");
		}

		if (i == 4)
			return false;
		else
			return true;
	}

	// funcion para pedircon y meter texto
	public static String pedirpalabra(String Texto) {
		Scanner sc = new Scanner(System.in);
		System.out.println(Texto);
		return (sc.next());
	}
}