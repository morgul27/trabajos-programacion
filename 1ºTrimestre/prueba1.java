import java.util.Scanner;

public class prueba1 {
	public static void main(String args[]) {
		String con;
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
			a = escribircon("Pon contraseña");
			b = escribircon("Repite contraseña");

			if (!a.equals(b))
				System.out.println("Contraseña no coinciden");
		} while (!a.equals(b));
		return a;
	}

	// funcion para la contraseña simulada
	public static boolean simulacion(String con1, int max) {
		int i;
		String a;

		for (i = 0; i <= max; i++) {
			a = escribircon("Intento " + i + " de 3");
			if (con1.equals(a))
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
	public static String escribircon(String texto) {
		Scanner sc = new Scanner(System.in);
		System.out.println(texto);
		return (sc.next());
	}
}