package Clinica;

import Clinica.Horario;
import java.util.ArrayList;
import java.util.*;

public class EjercicioOpcional {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 3 especialistas cada uno con 2 especialidades

        // cada especialista atiende 10 y 15 visitas diarias

        // 1 urgencia a la semana

        // Maria no trabaja los viernes y juan no trabaja los lunes

        // cada visita cuesta 40 o 50€(mirar pdf) y en urgencia 20% más

        // especialista cobra 15%

        // simular 2 meses (marzo y abril)
        int x;
        x = Horario.aleatorio();
        System.out.println(x);

        // ahora bien
        String nombres[] = { "Maria", "Juan", "Paco" };
        String especialiadades[] = { "Nutrición", "Fisioterapia" };
        int precio[] = { 40, 50 };
        String formaCo[] = { "Efectivo", "Tarjeta", "Transferencia" };
        // aqui va la matriz que no entiendo una mierda
        ArrayList<Integer> visitasGeneradas = new ArrayList<Integer>();

        //

        boolean salirMenu = false;

        do {
            System.out.println("");
            System.out.println("1. Generar datos de visitas");
            System.out.println("2. Mostrar esos datos");
            System.out.println("3. Mostrar resumen");
            System.out.println("9. Salir");

            x = sc.nextInt();
            switch (x) {
                case 1:
                    // aqui podemos o crear un booleano o si guardamos la informacion en un
                    // arraylist ver si esta llena (mirar ejT3menuarraylist, para aclaraciones)
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 9:
                    salirMenu = true;
                    break;
                default:
                    System.out.println("Se ha equivocado");

            }
        } while (!salirMenu);

    }

    //
}
