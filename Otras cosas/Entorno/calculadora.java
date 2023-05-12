package Entorno;

import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int num1;
        int num2;

        //
        try {
            System.out.println("Introduce un numero");
            num1 = sc.nextInt();
            System.out.println("Introduce el siguiente numero");
            num2 = sc.nextInt();
            // operacion
            System.out.println("Si quieres sumar(1), restar(2), mult(3), div(4)");
            x = sc.nextInt();

            if (x == 1) {
                x = Operacion.sumar(num1, num2);
            } else if (x == 2) {
                x = Operacion.restar(num1, num2);
            } else if (x == 3) {
                x = Operacion.mult(num1, num2);
            } else {
                x = Operacion.dividir(num1, num2);
            }

            System.out.println("El resultado de la operacion es " + x);

        } catch (Exception e) {
            System.out.println("te has equivocado al poner un numero");
        }
    }
}
