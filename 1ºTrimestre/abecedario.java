
public class abecedario {
	public static void main(String[] arg) {

		char letra = 'A'; // se pone '' cuando se usa char, si uso "" es para cuando uso los Strings
		// char es cuando se usa variable de texto, en vez de int, que es numerico
		while (letra <= 'Z') {
			System.out.println(letra++);
		}

	}
}
