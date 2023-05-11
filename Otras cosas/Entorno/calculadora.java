package Entorno;
import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int num1=0;
        int num2=2;

        operacion b = new operacion();

        //operacion
        System.out.println("Si quieres sumar(1), restar(2), mult(3), div(4)");
        x=sc.nextInt();

        if(x==1){
            operacion.sumar(num1,num2);
        }
    }
}
