package ejercicio;

import java.util.*;

public class ejDNInormal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        char l;

        System.out.println("introduce el numero de tu DNI");
        n = sc.nextInt();
        ejDNI n1 = new ejDNI(n);

        n1.mostrar();
    }
}