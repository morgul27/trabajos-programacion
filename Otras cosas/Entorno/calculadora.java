package Entorno;

import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int num1;
        int num2;

        // El debug para antes de que se ejecute el punto de ruptura, es decir, el punto
        // rojo
        // Ctrl+k+c comentar, Ctrl+k+u quitar comentario
        //
        try {
            System.out.println("Introduce un numero");
            num1 = sc.nextInt();
            System.out.println("Introduce el siguiente numero");
            num2 = sc.nextInt();
            // operacion
            System.out.println("Si quieres sumar(1), restar(2), mult(3), div(4)");
            x = sc.nextInt();

            // if (x == 1) {
            // x = Operacion.sumar(num1, num2);
            // } else if (x == 2) {
            // x = Operacion.restar(num1, num2);
            // } else if (x == 3) {
            // x = Operacion.mult(num1, num2);
            // } else {
            // x = Operacion.dividir(num1, num2);
            // }

            switch (x) {
                case 1:
                    x = Operacion.sumar(num1, num2);
                    System.out.println("eeeeeee");
                    break;
                case 2:
                    x = Operacion.restar(num1, num2);
                    break;
                case 3:
                    x = Operacion.mult(num1, num2);
                    break;
                case 4:
                    x = Operacion.dividir(num1, num2);
                    break;
                default:
                    break;
            }

            sc.close();

            System.out.println("El resultado de la operacion es " + x);

        } catch (Exception e) {
            System.out.println("te has equivocado al poner un numero");
        }
    }
}