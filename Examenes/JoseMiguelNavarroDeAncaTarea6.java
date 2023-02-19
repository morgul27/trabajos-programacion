import java.util.Scanner;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.*;
import java.util.Locale;

public class JoseMiguelNavarroDeAncaTarea6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numApostado = new ArrayList<Integer>();
        ArrayList<Integer> bolaBombo = new ArrayList<Integer>();
        ArrayList<Integer> bolaPremios = new ArrayList<Integer>();
        ArrayList<Integer> Premiosnumero = new ArrayList<Integer>();
        ArrayList<Integer> Premiosdinero = new ArrayList<Integer>();
        ArrayList<Integer> prueba = new ArrayList<Integer>();
        int primerPremio = 0;
        int premios[] = { 3000000, 65000, 20000, 6000, 100, 20 };
        int segundoPremios[] = { 0, 0, 0 };
        int tercerPremios[] = { 0, 0, 0, 0, 0 };
        int CuartosPremios[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
        int novecientos[];
        novecientos = new int[900];
        int x;
        int r = 0;
        boolean salirMenu = false;

        // rellenar la bola con los numeros
        rellenarBombo(bolaBombo);

        // rellenar la bola de premios
        bolaPremios.add(0);
        rellenarBomboPremios(bolaPremios, 3, 1);
        rellenarBomboPremios(bolaPremios, 6, 2);
        rellenarBomboPremios(bolaPremios, 8, 3);
        rellenarBomboPremios(bolaPremios, 900, 4);

        do {
            System.out.println("");
            System.out.println("1. Coger numero");
            System.out.println("9. Ir a ver los premios");

            x = sc.nextInt();
            switch (x) {
                case 1:
                    cogernumero(numApostado);
                case 9:
                    salirMenu = true;
                    break;
                default:
                    System.out.println("Se ha equivocado");

            }
        } while (!salirMenu);

        // premios
        // ahora los premios
        for (int i = 0; i < bolaPremios.size(); i++) {
            Premiosnumero.add(quitarnumerodelBombo(bolaBombo, 0)); // elegir el numero que va a tocar
            Premiosdinero.add(quitarNumeroPremios(bolaPremios, 0));

        }

        // tener un conjunto para ordenarlo luego
        int guardar_posicion = Premiosdinero.get(0);
        int s = 0;
        int t = 0;
        int c = 0;
        int n = 0;

        for (int i = 0; i < 900; i++) {

            switch (guardar_posicion) {
                case 0:
                    primerPremio = Premiosnumero.get(0);
                    break;
                case 1:
                    segundoPremios[s] = Premiosnumero.get(0);
                    s++;
                    break;
                case 2:
                    tercerPremios[t] = Premiosnumero.get(0);
                    t++;
                    break;
                case 3:
                    CuartosPremios[c] = Premiosnumero.get(0);
                    c++;
                    break;
                case 4:
                    novecientos[n] = Premiosnumero.get(0);
                    n++;
                    break;
            }
        }
        ;
        ordenar(segundoPremios);
        ordenar(tercerPremios);
        ordenar(CuartosPremios);
        ordenar(novecientos);

        System.out.print("El primer premio es " + primerPremio);

        System.out.println("El segundo premio es " + segundoPremios);
        mostrarPremios(segundoPremios);

        System.out.println("El tercer premio es ");
        mostrarPremios(tercerPremios);

        System.out.println("El cuarto premio es ");
        mostrarPremios(CuartosPremios);

        System.out.println("El mil premio es " + novecientos);
        mostrarPremios(novecientos);

        // comparaciones
        verPrimerPremio(numApostado, primerPremio);
        comparacionPremios(numApostado, segundoPremios, 1, premios);
        comparacionPremios(numApostado, tercerPremios, 2, premios);
        comparacionPremios(numApostado, CuartosPremios, 3, premios);
        comparacionPremios(numApostado, novecientos, 4, premios);

        reintegro(numApostado, primerPremio);
        System.out.println("Fin");

    }

    // funcion comparacion de premios
    public static int comparacionPremios(ArrayList<Integer> Premios2, int Premios[], int p, int cantidad[]) {
        int c = 0;
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));

        for (int i = 0; i < Premios.length; i++) {
            for (int j = 0; j < Premios2.size(); j++) {
                if (Premios[i] == Premios2.get(j)) {
                    c++;
                    if (c == 1)
                        System.out.println("Los premios ganados son: ");
                    System.out.printf("%1$05d \n", Premios2.get(j));

                }
            }
        }
        System.out.println();
        System.out.printf("Has ganado " + c + " premios de " + nf.format(cantidad[p]));

        return c;
    }

    // funcion para comparar el primer premio
    public static int verPrimerPremio(ArrayList<Integer> PremiosDeJugador, int Premios) {
        int c = 0;
        for (int j = 0; j < PremiosDeJugador.size(); j++) {
            if (Premios == PremiosDeJugador.get(j)) {
                System.out.println("Has ganado 3M");
                c++;
            }
        }
        return c;
    }

    // funcion para mostrar los premios
    public static void mostrarPremios(int Premios[]) {
        for (int i = 0; i < Premios.length; i++)
            System.out.printf("| %1$05d ", Premios[i]);
        System.out.println(" ");
        System.out.println(" ");
    }

    // funcion para ordenar los premios
    public static void ordenar(int Premios[]) {
        int aux;

        for (int i = 0; i < Premios.length; i++) {
            for (int j = 0; j < Premios.length - i - 1; j++) {

                if (Premios[j] > Premios[j + 1]) {
                    aux = Premios[j + 1];
                    Premios[j + 1] = Premios[j];
                    Premios[j] = aux;
                }
            }
        }
    }

    // funcion para quitar numero del bombo
    public static int quitarnumerodelBombo(ArrayList<Integer> bolaBombo, int a) {
        int ran;

        ran = aleatorio(a, bolaBombo.size());
        bolaBombo.remove(ran);

        return ran;
    }

    // funcion para quitar numero del bombo
    public static int quitarNumeroPremios(ArrayList<Integer> bolaBombo, int a) {
        int ran;
        int b;

        ran = aleatorio(a, bolaBombo.size());
        b = bolaBombo.get(ran);
        bolaBombo.remove(ran);

        return b;
    }

    // funcion aleatorio
    public static int aleatorio(int min, int max) {
        int ran;

        ran = (int) (Math.floor((max) * Math.random()));
        return ran;
    }

    // funcion para rellenar el bombo
    public static void rellenarBombo(ArrayList<Integer> bolaBombo) {
        for (int i = 1000; i < 100000; i++) {
            bolaBombo.add(i);
        }
    }

    // funcion para rellenar el bombo de premios
    public static void rellenarBomboPremios(ArrayList<Integer> bolaPremios, int a, int b) {

        for (int i = 0; i < a; i++) {
            bolaPremios.add(b);
        }

    }

    // funcion coger el numero
    public static void cogernumero(ArrayList<Integer> numApostado) {
        Scanner sc = new Scanner(System.in);
        String aceptar;

        do {
            pedirnumero(numApostado, 0, 99999);

            System.out.println("Quieres pedir otro?");
            aceptar = sc.next();
            System.out.println("");

        } while (aceptar.equals("si"));

    }

    // funcion de numero ver arriba loteria
    public static ArrayList<Integer> pedirnumero(ArrayList<Integer> numApostado, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int num;
        int opcion;

        System.out.println("¿Quieres meter numero(0) o que sea aleatorio?(1)");
        opcion = sc.nextInt();
        do {
            if (opcion == 1) {
                numApostado.add(aleatorio(min, max));
                System.out.println("Su numero es: " + numApostado);
            } else if (opcion == 0) {
                do {
                    System.out.println("mete numero");
                    num = sc.nextInt();
                } while (num >= 99999 || num <= 1000);
                numApostado.add(num);
                System.out.println("Sus numero son: " + numApostado);

            } else
                System.out.println("Te has equivocado");

        } while (opcion != 0 && opcion != 1);
        return numApostado;
    }

    // funcion comparacion del primer premio
    public static int reintegro(ArrayList<Integer> PremiosDeJugador, int primerPremio) {
        int c = 0;
        int r = 0;
        System.out.println();
        for (int j = 0; j < PremiosDeJugador.size(); j++) {
            if (primerPremio % 10 == PremiosDeJugador.get(j) % 10) {
                c += 20;
                r++;
            }
        }
        System.out.println("Has ganado de reintegro " + c);
        return r;
    }

}