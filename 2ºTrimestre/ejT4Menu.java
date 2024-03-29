import java.util.Scanner;

public class ejT4Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        String palabra = "";
        String letra = "";
        boolean salirMenu = false;
        boolean tenercadena = false;

        do {
            System.out.println("");
            System.out.println("1. Cadena");
            System.out.println("2. ¿Cuantas palabras?");
            System.out.println("3. ¿Cuantas vocales?");
            System.out.println("4. longitud, mayusculas y minusculas");
            System.out.println("5. Pedir caracter --> ¿esta?¿cuantos?");
            System.out.println("6. Introduce la cadena y si esta verla y cual de ellas mayor");
            System.out.println("7. Contar letras, numeros y espacios");
            System.out.println("9. Salir");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    palabra = Palabra();
                    tenercadena = true;
                    break;
                case 2:
                    if (tenercadena == true)
                        NumPalabra(palabra);
                    else
                        System.out.println("No has añadido ninguna palabra");
                    break;
                case 3:
                    if (tenercadena == true)
                        Vocales(palabra);
                    else
                        System.out.println("No has añadido ninguna palabra");
                    break;
                case 4:
                    if (tenercadena == true)
                        ContarCadena(palabra);
                    else
                        System.out.println("No has añadido ninguna palabra");
                    break;
                case 5:
                    if (tenercadena == true)
                        llamarcaracter(palabra, letra);
                    else
                        System.out.println("No has añadido ninguna palabra");
                    break;
                case 6:
                    if (tenercadena == true)
                        iguales(palabra);
                    else
                        System.out.println("No has añadido ninguna palabra");
                    break;
                case 7:
                    if (tenercadena == true)
                        contar(palabra);
                    else
                        System.out.println("No has añadido ninguna palabra");
                    break;
                case 9:
                    salirMenu = true;
                    break;
                default:
                    System.out.println("Debe introducir un numero entre 1 y 9");
            }
        } while (!salirMenu);
    }

    // funcion 1 poner palabra
    public static String Palabra() {
        Scanner sc = new Scanner(System.in);
        String palabra;

        System.out.println("Introduce una cadena de texto");
        palabra = sc.nextLine();

        return palabra;
    }

    // funcion 2 contar cuantas palabras hay
    public static void NumPalabra(String palabra) {

        char cad = ' ';
        int contador = 1, pos;

        palabra = palabra.trim();// eliminar los posibles espacios en blanco al principio y al final
        if (palabra.isEmpty()) { // si la cadena está vacía
            contador = 0;
        } else {
            pos = palabra.indexOf(" "); // se busca el primer espacio en blanco
            while (pos != -1) { // mientras que se encuentre un espacio en blanco
                contador++; // se cuenta una palabra
                pos = palabra.indexOf(" ", pos + 1);// se busca el siguiente espacio en blanco a continuación del actual
            }
        }
        System.out.println("Hay " + contador + " palabras");
    }

    // funcion 3 contar vocales
    public static void Vocales(String palabra) {
        char vocales[] = { 'a', 'e', 'i', 'o', 'u' };
        int nuVocales = 0;
        String voc = "";

        for (int i = 0; i < palabra.length(); i++) {
            for (int j = 0; j < vocales.length; j++) {
                if (palabra.charAt(i) == vocales[j]) {
                    nuVocales++;
                    voc += palabra.charAt(i);
                }
            }
        }
        System.out.println("La palabra " + palabra + " tiene " + nuVocales + " vocales, y son " + voc);

    }

    // funcion 4 contar cadena
    public static void ContarCadena(String palabra) {
        System.out.println("La cadena de texto tiene " + palabra.length() + " numeros de longitud");
        System.out.println("La cadena de texto en mayusculas es " + palabra.toLowerCase());
        System.out.println("La cadena de texto en minusculas es " + palabra.toUpperCase());
    }

    // funcion 5 para solicitar un caracter y indicar si esta en la cadena
    public static String llamarcaracter(String palabra, String introducir) {
        Scanner sc = new Scanner(System.in);
        int caracter = 0;

        System.out.println("Mete un caracter");
        introducir = sc.nextLine();
        int mayor = (palabra.length() > introducir.length()) ? palabra.length() : introducir.length();
        int menor = (palabra.length() < introducir.length()) ? palabra.length() : introducir.length();

        for (int i = 0; i < mayor; i++) {
            for (int j = 0; j < menor; j++) {
                if (palabra.charAt(i) == introducir.charAt(j)) {
                    caracter++;
                    System.out.println(caracter);
                }
            }
        }
        System.out.println("La palabra " + palabra + " contiene " + caracter + " caracteres introducidos de la palabra "
                + introducir);

        return introducir;
    }

    // funcion 6 introducir una cadena para saber si son iguales, si esta contenida
    public static void iguales(String palabra) {
        Scanner sc = new Scanner(System.in);
        String introducir = "";
        introducir = llamarcaracter(palabra, introducir);

        if (palabra.equalsIgnoreCase(introducir))
            System.out.println("Son iguales");
        else
            System.out.println("Son distintos");

    }

    // funcion 7 contar letras, numeros y espacios
    public static void contar(String palabra) {
        Scanner sc = new Scanner(System.in);
        palabra.toCharArray();
        int c = 0;

        // palabra.isLetter(a);

        for (int i = 0; i < palabra.length(); i++) {
            c++;
        }
        System.out.println("hay " + c + " caracteres");

    }

    // funcion goyo ahora la complemento
    // esta funcion sirve para enviar un caracter y ver cuantos hay de este
    public static int contarCaracter(String cad, char c) {
        int p = -1;
        int cont = 0;

        do {
            p = cad.indexOf(c, ++p); // la funcion de "p" es saltar despues del caracter y luego el valor es
                                     // sustituido por otro que este más adelante
            if (p >= 0)
                cont++;
        } while (p >= 0 && p < cad.length());
        return cont;
    }

}