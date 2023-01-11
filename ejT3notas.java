import java.util.Scanner;
import java.util.ArrayList;

public class ejT3notas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Sus = new ArrayList<String>();
        ArrayList<String> Aprov = new ArrayList<String>();
        ArrayList<String> Not = new ArrayList<String>();
        ArrayList<String> Sobre = new ArrayList<String>();

        int c;
        Double x;
        String a;

        System.out.println("Di cuantos alumnos hay");
        c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            System.out.println("Dime el nombre del alumno");
            a = sc.next();
            System.out.println("Dime la nota de ese alumno");
            x = sc.nextDouble();
            if (x < 5)
                Sus.add(a);
            else if (x < 7)
                Aprov.add(a);
            else if (x < 9)
                Not.add(a);
            else
                Sobre.add(a);
        }
        System.out.println();
        System.out.println("Los que han suspendido son:");
        vernota(Sus);
        System.out.println("Los aprobado son:");
        vernota(Aprov);
        System.out.println("Los que han sacado notable son:");
        vernota(Not);
        System.out.println("Los que han sacado sobresaliente son:");
        vernota(Sobre);

    }

    public static void vernota(ArrayList<String> Arraylista) {
        for (String i : Arraylista) {
            System.out.println(i);
        }
    }
}