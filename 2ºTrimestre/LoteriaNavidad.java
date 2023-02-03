import java.util.Scanner;
import java.util.ArrayList;

public class LoteriaNavidad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numApostado = new ArrayList<Integer>();
        ArrayList<Integer> bolaBombo = new ArrayList<Integer>();
        ArrayList<Integer> milpremioslistado = new ArrayList<Integer>();
        int primerPremio;
        int premios[] = { 3000000, 60000, 20000, 100 };
        int segundoPremios[] = { 0, 0, 0 };
        int tercerPremios[] = { 0, 0, 0, 0, 0 };
        int ran;

        ran = aleatorio(1, 99999);
        numApostado.add(ran);
        System.out.println("Tienes el numero el numero " + numApostado);

        rellenarBombo(bolaBombo);

        // premios
        // ahora los premios
        primerPremio = quitarnumerodelBombo(bolaBombo);

        // segundo premios
        cogerpremios(segundoPremios, bolaBombo, 0, 3);

        // tercer premios
        cogerpremios(tercerPremios, bolaBombo, 0, 5);

        // mil premios
        for (int i = 0; i < 1001; i++) {
            quitarnumerodelBombo(bolaBombo);
        }
    }

    // funcion para rellenar el bombo
    public static void rellenarBombo(ArrayList<Integer> bolaBombo) {
        for (int i = 0; i < 99999; i++) {
            bolaBombo.add(i + 1);
        }
        System.out.println(bolaBombo);
    }

    // funcion para rellenar el bombo
    public static int quitarnumerodelBombo(ArrayList<Integer> bolaBombo) {
        int ran;

        ran = aleatorio(1, 99999);
        bolaBombo.remove(ran);
        bolaBombo.add(ran);

        return ran;
    }

    // funcion aleatorio
    public static int aleatorio(int a, int b) {
        int min;
        int max;
        int ran;

        min = Math.min(a, b);
        max = Math.max(a, b);
        ran = (int) (Math.floor((max - min + 1) * Math.random()) + min);
        return ran;
    }

    // funcion para for premios
    public static void cogerpremios(int Premios[], ArrayList<Integer> bolaBombo, int min, int max) {
        for (int i = min; i < max; i++) {
            Premios[i] = quitarnumerodelBombo(bolaBombo);
        }
    }
}