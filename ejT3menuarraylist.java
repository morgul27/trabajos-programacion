import java.util.Scanner;
import java.util.ArrayList;

public class ejT3menuarraylist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ArrayLista = new ArrayList<Integer>();

        boolean salirMenu = true;
        boolean check = false;
        int x;
        int a;
        do {
            System.out.println("");
            System.out.println("1.Rellenar ArrayList");
            System.out.println("2.Ver ArrayList");
            System.out.println("3.Sumar y media de la ArrayList");
            System.out.println("4.Salir");
            x = sc.nextInt();

            switch (x) {
                case 1:
                    ArrayLista = rellenar(ArrayLista);
                    break;
                case 2:
                    if (ArrayLista.size() > 0)
                        pintar(ArrayLista);
                    else
                        System.out.println("La matriz aun esta vacia");
                    break;
                case 3:
                    if (ArrayLista.size() > 0)
                        sumedia(ArrayLista);
                    else
                        System.out.println("La matriz aun esta vacia");
                    break;
                case 4:
                    salirMenu = false;
                    break;
                default:
                    System.out.println("Debe introducir un numero entre 1 y 4");
            }

        } while (salirMenu);

    }

    // funcion 1 para rellenar la arraylist
    public static ArrayList<Integer> rellenar(ArrayList<Integer> ArrayLista) {
        Scanner sc = new Scanner(System.in);
        int dato;

        do {
            System.out.println("Añada un entero, para salir pulse -1");
            dato = sc.nextInt();
            if (dato > 0) {
                ArrayLista.add(dato);
            } else {
                System.out.println("Introduzca solo numeros positivos");
            }
        } while (dato != (-1));
        return (ArrayLista);
    }

    // funcion 2 para pintar la arraylist
    public static void pintar(ArrayList<Integer> ArrayLista) {
        for (int i : ArrayLista) {
            System.out.println(i);
        }
    }

    // funcion 3 parasumar y hacer media de la arraylist
    public static void sumedia(ArrayList<Integer> ArrayLista) {
        int suma = 0;
        int c = 0;

        for (int i : ArrayLista) {
            suma = suma + i;
            c++;
        }
        System.out.println("la sauma total es " + suma + " y la media total es " + (suma / c));
    }

}