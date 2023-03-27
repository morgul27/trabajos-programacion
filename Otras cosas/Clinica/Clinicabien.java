package Clinica;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.math.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.text.*;

public class Clinicabien {

    public static void main(String[] args) {
        int opcionMenu;
        Scanner sc = new Scanner(System.in);
        String especialistas[] = { "Maria", "Juan", "Paco" };
        String ramas[] = { "Nutricion", "Fisioterapia" };
        String fcobro[] = { "Efectivo", "Tarjeta", "Transferencia" };
        int ramasEspec[][] = { { 0, 1 }, { 1 }, { 0 } };

        // cada elemento del arraylist es una visita
        // cada visita tiene información almacendada en 7 enteros que corresponden a los
        // distintos datos
        // fecha: nº dias posteriores al primero
        // codigo cleinte
        // indice del array especialista
        // indice del array rama
        // precio
        // urgencia (=1)
        // indice del array de la forma de cobro
        ArrayList<int[]> visitas = new ArrayList();

        do {
            System.out.println("Menu");
            System.out.println("1. Simulacion datos de visitas");
            System.out.println("2. Muestra los datos visitas");
            System.out.println("3. Resumen Formas de cobro");
            System.out.println("4. Salir");
            opcionMenu = leerEntero("Elije opcion:", 1, 4);

            switch (opcionMenu) {
                case 1:
                    genVisitas(visitas, especialistas, ramasEspec, fcobro);
                    break;
                case 2:
                    listarVisitas(visitas, especialistas, ramas, fcobro);
                    break;
                case 3:
                    resumenFCobro(visitas, especialistas, ramas, fcobro);
                    break;
            }
        } while (opcionMenu != 4);
        System.out.println("Fin ejercicio");
    }

    // *****************************************************************************
    // Método para generar las visitas de todos los dias de todos los especialistas
    public static void genVisitas(ArrayList<int[]> v, String especialistas[], int ramasE[][], String fCobro[]) {
        LocalDate dia;
        LocalDate dia1 = LocalDate.of(2022, Month.MARCH, 1);
        LocalDate dia2 = LocalDate.of(2022, Month.APRIL, 30);
        // Period intervalo = dia1.until(dia2);
        long intervalo = ChronoUnit.DAYS.between(dia1, dia2);
        boolean diaValido;
        ArrayList<LocalDate> festivos = new ArrayList();

        // arraylist con dias festivos
        festivos.add(LocalDate.of(2022, Month.MARCH, 1));
        festivos.add(LocalDate.of(2022, Month.APRIL, 1));
        festivos.add(LocalDate.of(2022, Month.APRIL, 2));

        System.out.println("****** Generando visitas " + intervalo + "  dias   *****");

        for (int i = 0; i <= intervalo; i++) {
            // * se puede incluir un incremento de 3 si es viernes, previo posicionamiento
            // inicial en 1 dia laborable
            dia = dia1.plusDays(i);
            diaValido = true;

            if (dia.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    dia.getDayOfWeek() == DayOfWeek.SUNDAY)
                diaValido = false;
            if (festivos.contains(dia))
                diaValido = false;

            if (diaValido) {
                System.out.println("** dia " + (i + 1) + "  " + dia.getDayOfWeek() + "  **");
                genVisitasDia(v, especialistas, ramasE, i, fCobro, dia1);
            }
        }
    }

    // Método para generar las visitas diarias
    public static void genVisitasDia(ArrayList<int[]> v, String especialistas[], int[][] ramasE, int nDia,
            String fCobro[], LocalDate dia1) {
        // LocalDate dia1 = LocalDate.of(2022, Month.MARCH, 1);
        LocalDate dia = dia1.plusDays(nDia);

        int vAleatorias;
        int especialidad;

        for (int i = 0; i < especialistas.length; i++) {
            // exclusion de dias de las semana libres. Se podria/deberia mejorar con un un
            // arrylist
            if (!((especialistas[i].equalsIgnoreCase("juan") && dia.getDayOfWeek() == DayOfWeek.MONDAY) ||
                    (especialistas[i].equalsIgnoreCase("maria") && dia.getDayOfWeek() == DayOfWeek.FRIDAY))) {

                // se toma la especialidad que corresponde al especialista o -1 para indicar que
                // puede ser cualquiera de las especialidades
                // es una opción "rapida".Mejorable tratando como aleatoria la posicion de
                // ramasE[i] cuando fuera de longitud >1
                if (ramasE[i].length == 1)
                    especialidad = ramasE[i][0];
                else
                    especialidad = -1;
                vAleatorias = genVisitasDiaEspecialista(v, nDia, i, especialidad, fCobro);
                System.out.println("**     especialista " + (i + 1) + " con " + vAleatorias + " visitas  **");
            }
        }
    }

    // Método para generar las visitas diaria de cada especialista
    // en el parametro rama se indica el indice de la especialidad o si es -1 para
    // aleatorio
    public static int genVisitasDiaEspecialista(ArrayList<int[]> v, int dia, int iEsp, int iRama, String fCobro[]) {
        int tarifas[] = { 40, 50 };
        int numVis = aleatorio(10, 15);
        int cPac, fCob, ramaV, esUrg = 0;

        for (int i = 1; i <= numVis; i++) {
            cPac = aleatorio(1, 3000);
            fCob = aleatorio(0, fCobro.length - 1);
            // para sustituir el 2 por la longitud-1 del array de fcobros, habria que
            // arrastrarlo en el envio de parametros o declar el array de forma de cobro
            // como "global"
            if (iRama == -1)
                ramaV = aleatorio(0, 1);
            else
                ramaV = iRama;
            // visita = new int[7];
            // se declara, crea e iniciaiza de una sola vez, el array con los datos de cada
            // visita
            int visita[] = { dia, iEsp, ramaV, cPac, esUrg, tarifas[ramaV], fCob };

            v.add(visita);
        }
        // *faltaria inddcar/añadir si es o no urgencia en base a una probabilidad
        return numVis;
    }

    // *****************************************************************************
    // Método para generar las visitas de todos los dias de todos los especialistas
    public static void listarVisitas(ArrayList<int[]> v, String Especialistas[], String Ramas[], String fCobro[]) {
        LocalDate dia, dia1 = LocalDate.of(2021, Month.MARCH, 1);
        int visita[] = new int[7];
        String nEspec, nRama, urgencia, nfCobro;
        int pac, precio;

        for (int i = 0; i < v.size(); i++) {
            visita = v.get(i);
            dia = dia1.plusDays(visita[0]);
            nEspec = Especialistas[visita[1]];
            nRama = Ramas[visita[2]];
            pac = visita[3];
            if (visita[4] == 1)
                urgencia = "** URGENCIA **";
            else
                urgencia = " ";
            precio = visita[5];
            nfCobro = fCobro[visita[6]];

            System.out.printf("Visita:%1$04d Dia:%2$10s "
                    + "Especialista:%3$-15s Rama:%4$-15s "
                    + "Cliente:%5$04d Precio:%6$04d "
                    + "FCobro:%7$-15s Urgencia:%8$-15s\n", i,
                    dia.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    nEspec, nRama, pac, precio, nfCobro, urgencia);
        }
    }

    // *****************************************************************************
    // Método para generar las visitas de todos los dias de todos los especialistas
    public static void resumenFCobro(ArrayList<int[]> v, String Especialistas[], String Ramas[], String fCobro[]) {
        int visita[] = new int[7];
        int resumen[] = new int[fCobro.length];
        int total = 0;
        DecimalFormat ef = new DecimalFormat("#,###.00 €");

        for (int i = 0; i < v.size(); i++) {
            visita = v.get(i);
            resumen[visita[6]] += visita[5];
        }
        for (int i = 0; i < fCobro.length; i++) {
            System.out.printf("%1$-15s %2$20s\n", fCobro[i] + ":", ef.format(resumen[i]));
            total += resumen[i];
        }
        System.out.printf("%1$30s\n", "------------------------------------");
        System.out.printf("TOTAL:%1$30s\n", ef.format(total));

    }

    // *****************************************************************************
    // Método para leer un número de tipo int y controlar la excepción
    public static int leerEntero(String texto, int menor, int mayor) {
        Scanner sc = new Scanner(System.in);
        boolean repetir;
        int n = 0;
        do {
            repetir = false;
            try {
                System.out.print(texto + ". (Valor valido de " + menor + " a " + mayor + " ambos inclusive): ");
                n = sc.nextInt();
                if (n < menor || n > mayor) {
                    System.out.println("Valor fuera de rango");
                    repetir = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido");
                repetir = true;
            } finally {
                sc.nextLine();
            }
        } while (repetir);
        return n;
    }

    // Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
    public static int aleatorio(int menor, int mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

}
