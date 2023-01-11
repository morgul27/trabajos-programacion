import java.util.Scanner;
import java.util.ArrayList;

public class ejT3colores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ArrayLista = new ArrayList<String>();

        boolean salirMenu = true;
        boolean check = false;
        int x;
        int a;
        do {
            System.out.println("");
            System.out.println("1.Rellenar ArrayList");
            System.out.println("2.Ver ArrayList");
            System.out.println("3.Para saber y devolver posicion ArrayList");
            System.out.println("4.Introducir color hasta comprobar si existe el color de la arraylist ");
            System.out.println("5.Pedir un color y eliminarlo");
            System.out.println("6.Pedir una posicion y eliminarla");
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
                        pedirColor(ArrayLista);
                    else
                        System.out.println("La matriz aun esta vacia");
                    break;
                case 4:
                    if (ArrayLista.size() > 0)
                        comprobar(ArrayLista);
                    else
                        System.out.println("La matriz aun esta vacia");
                    break;
                case 5:
                    if (ArrayLista.size() > 0)
                        eliminarcolor(ArrayLista);
                    else
                        System.out.println("La matriz aun esta vacia");
                    break;
                case 6:
                    if (ArrayLista.size() > 0)
                        eliminarposicion(ArrayLista);
                    else
                        System.out.println("La matriz aun esta vacia");
                    break;
                default:
                    System.out.println("Debe introducir un numero entre 1 y 6");
            }

        } while (salirMenu);

    }

    // funcion 1 para rellenar la arraylist
    public static ArrayList<String> rellenar(ArrayList<String> ArrayLista) {
        Scanner sc = new Scanner(System.in);
        String dato;

        System.out.println();
        do {
            System.out.println("Añada un color, para salir introduzca blanco");
            dato = sc.nextLine();

            ArrayLista.add(dato);

        } while (!dato.equals("blanco"));
        return (ArrayLista);
    }

    // funcion 2 para pintar la arraylist
    public static void pintar(ArrayList<String> ArrayLista) {
        System.out.println();
        System.out.println(ArrayLista);

    }

    // funcion 3 para pedir color de la arraylist
    public static void pedirColor(ArrayList<String> ArrayLista) {
        Scanner sc = new Scanner(System.in);
        String color;
        System.out.println();

        System.out.println("Introduce color para saber y devolver posicion");
        color = sc.nextLine();
        if (ArrayLista.indexOf(color) != -1) {
            int a;
            a = ArrayLista.indexOf(color);
            System.out.println("el color exite y su posicion es " + (a + 1));
        } else
            System.out.println("no existe");
    }

    // funcion 4 para introducir color hasta comprobar si existe el color de la
    // arraylist
    public static void comprobar(ArrayList<String> ArrayLista) {
        Scanner sc = new Scanner(System.in);
        String color;
        System.out.println();

        do {
            System.out.println("Introduce color para comprobar si existe");
            color = sc.nextLine();
            System.out.println(ArrayLista.contains(color));
        } while (ArrayLista.contains(color) != false);
        System.out.println("El color no existe");
    }

    // funcion 5 pedir un color y eliminarlo
    public static void eliminarcolor(ArrayList<String> ArrayLista) {
        Scanner sc = new Scanner(System.in);
        String color;

        System.out.println();
        System.out.println("Introduce color para eliminarlo");
        color = sc.nextLine();
        System.out.println();
        System.out.println("El color introducido es " + color);
        ArrayLista.remove(color);
    }

    // funcion 5 pedir una posicion y eliminarlo
    public static void eliminarposicion(ArrayList<String> ArrayLista) {
        Scanner sc = new Scanner(System.in);
        int posicion;

        System.out.println();
        System.out.println("Introduce color para eliminarlo");
        posicion = sc.nextInt();
        posicion = posicion - 1;
        System.out.println();
        System.out.println("La posicion introducida es " + posicion);
        ArrayLista.remove(posicion);
    }
}