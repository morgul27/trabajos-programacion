package prisma;

import java.util.ArrayList;

public class prismaPrueba {

    public static void main(String[] args) {

        prisma p1 = new prisma();
        prisma p2 = new prisma();
        prisma p3 = new prisma();

        Object array1[] = { p1, p2, p3 };

        p1.setalto(5);
        p1.setancho(7);
        p1.setlargo(5);

        p2.setalto(25);
        p2.setancho(1);
        p2.setlargo(7);

        p3.setalto(20);
        p3.setancho(10);
        p3.setlargo(17);

        System.out.println("p1 volumen " + p1.volumen());
        System.out.println("p2 volumen " + p2.volumen());

        System.out.println("p1 " + p1.hashCode());
        System.out.println("p2 " + p2.hashCode());

        System.out.println("equals " + p1.equals(p2));

        System.out.println("compare to de p2 " + p1.compareTo(p2));
        System.out.println("compare to de p3 " + p1.compareTo(p3));

        System.out.println("p1:");
        System.out.println(p1.toString());
        System.out.println("p2:");
        System.out.println(p2.toString());
        System.out.println("p3:");
        System.out.println(p3.toString());

        System.out.println("sin ordenar");
        System.out.println(array1);

        System.out.println("ordenar");

        p1.ordenao(p2, array1);
    }
}