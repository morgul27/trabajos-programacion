package prisma;

import java.util.Arrays;

public class prismaPrueba {

    public static void main(String[] args) {

        prisma p1 = new prisma();
        prisma p2 = new prisma();
        prisma p3 = new prisma();
        prisma p4 = new prisma();

        prisma array1[] = { p1, p2, p3, p4 };

        p1.setlargo(15);
        p1.setalto(45);
        p1.setancho(7);

        p2.setlargo(8);
        p2.setalto(5);
        p2.setancho(4);

        p3.setlargo(6);
        p3.setalto(6);
        p3.setancho(6);

        p4.setlargo(10);
        p4.setalto(10);
        p4.setancho(10);

        System.out.println("p1 volumen " + p1.volumen());
        System.out.println("p2 volumen " + p2.volumen());

        System.out.println("p1 " + p1.hashCode());
        System.out.println("p2 " + p2.hashCode());
        System.out.println("p3 " + p3.hashCode());
        System.out.println("p4 " + p4.hashCode());

        System.out.println("equals " + p1.equals(p2));

        System.out.println("compare to de p2 " + p1.compareTo(p2));
        System.out.println("compare to de p3 " + p1.compareTo(p3));

        System.out.println("p1:");
        System.out.println(p1.toString());
        System.out.println("p2:");
        System.out.println(p2.toString());
        System.out.println("p3:");
        System.out.println(p3.toString());

        System.out.println();
        System.out.println("sin ordenar");
        mostrar(array1);

        System.out.println();
        System.out.println("ordenado");
        Arrays.sort(array1);
        mostrar(array1);
    }

    // mostrar
    public static void mostrar(Object array1[]) {
        for (int i = 0; i < array1.length; i++) {
            System.out.println("El prisma " + (i + 1) + ": " + array1[i].toString());
        }

    }
}