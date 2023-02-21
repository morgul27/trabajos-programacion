package ejercicio;

import packclase.Persona;
import packclase.Rectangulo;

import java.util.Scanner;

public class EjerPersona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangulo listarectangulo[] = new Rectangulo[5];

        Persona p = new Persona();
        System.out.println("Nombre: " + p.getNombre() + " edad= " + p.getedad());
        p.setNombre("Jaimito");
        p.edad = 17;
        System.out.println("Nombre: " + p.getNombre() + " edad= " + p.getedad());

        // siguiente parte
        System.out.println("otro");
        Persona p1, p2;
        p1 = new Persona();
        p1.setNombre("Pedro");
        p1.edad = 18;
        p2 = new Persona();
        p2.setNombre("Maria");
        System.out.println(p1.getNombre() + " " + p1.edad + " y " + p2.getNombre() + " " + p2.edad);

        p1.copiarEn(p2);
        System.out.println(p1.getNombre() + " " + p1.getedad() + " y " + p2.getNombre() + " " + p2.edad);

        p2.setNombre("Juana");
        System.out.println(p1.getNombre() + " " + p1.edad + " y " + p2.getNombre() + " " + p2.edad);

        System.out.println();
        System.out.println();
        System.out.println("Creando personas");
        Persona p3 = new Persona();
        System.out.println(p3.getNombre());

        System.out.println(Persona.ccontador + " y " + p.ocontador);

        System.out.println();
        System.out.println();
        System.out.println("Creando rectangulo");

        // area l+l
        // perimetro l+l+l+l
        // el estatico va al ojeto al no estatico a la clase

        double l;
        double a;

        for (int i = 0; i < listarectangulo.length; i++) {

            System.out.println("Introduce el lado del rectangulo " + i);
            l = sc.nextDouble();
            System.out.println("Introduce el ancho del rectangulo " + i);
            a = sc.nextDouble();

            listarectangulo[i] = new Rectangulo(l, a);

        }

        for (int i = 0; i < listarectangulo.length; i++) {

            listarectangulo[i].mostrar();

        }

    }
}