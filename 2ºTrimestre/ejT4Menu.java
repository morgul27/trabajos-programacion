import java.util.Scanner;
import java.util.ArrayList;

public class ejT4Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        String palabra = "";
        boolean salirMenu = false;

        do {
            System.out.println("");
            System.out.println("1.Cadena");
            System.out.println("2.¿Cuantas palabras?");
            System.out.println("3.¿Cuantas vocales?");
            System.out.println("4.longitud, mayusculas y minusculas");
            System.out.println("5.caracter --> ¿esta?¿cuantos?");
            System.out.println("6. Introduce la cadena y si esta verla y cual de ellas mayor");
            System.out.println("9.Salir");

            x = sc.nextInt();

            switch (x) {
                case 1:
                    palabra = Palabra();
                    break;
                case 2:
                    NumPalabra(palabra);
                    System.out.println("La matriz aun esta vacia");
                    break;
                case 3:
                    Vocales(palabra);
                    System.out.println("La matriz aun esta vacia");
                    break;
                case 4:
                    ContarCadena(palabra);
                    break;
                case 5:
                    salirMenu = true;
                    break;
                case 9:
                    break;

                default:
                    System.out.println("Debe introducir un numero entre 1 y 4");
            }
        } while (!salirMenu);
    }

    // funcion 1 poner palabra
    public static String Palabra() {
        Scanner sc = new Scanner(System.in);
        String palabra;

        System.out.println("Introduce una cadena de texto");
        palabra = sc.next();

        return palabra;
    }

    // funcion 2 contar numero de palabras
    public static void NumPalabra(String palabra) {
        Scanner sc = new Scanner(System.in);
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
    }

    // funcion 3 contar vocales
    public static void Vocales(String palabra) {
        Scanner sc = new Scanner(System.in);

    }

    // funcion 4 contar cadena
    public static void ContarCadena(String palabra) {
        System.out.println("La cadena de texto tiene " + palabra.length() + " numeros de longitud");
        System.out.println("La cadena de texto en mayusculas es " + palabra.toLowerCase());
        System.out.println("La cadena de texto en minusculas es " + palabra.toUpperCase());
    }

}
