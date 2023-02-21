package DNI;

import java.util.Scanner;

public class ejDNI {
    int numero;

    public ejDNI(int n) {
        numero = n;
    }

    public ejDNI() {

    }

    public int getnumeroDNI() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("introduce el numero de tu DNI");
        n = sc.nextInt();
        return n;
    }

    private int calculo(int n) {
        String l;
        n = n / 23;
        return n;
    }

    public void recuperar() {

    }

}
