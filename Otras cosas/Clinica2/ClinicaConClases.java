package Clinica2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.math.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.*;
import java.text.*;

public class ClinicaConClases {
    public static void main(String[] args) {
        System.out.println(aleatorio(100));

        Personas p1 = new Personas();
        sabergenero(p1);

        LocalDate dia1 = LocalDate.of(2002, 2, 5);
        Period dia2 = Period.between(dia1, LocalDate.now());

        System.out.println("prueba " + dia2);

    }

    // funcion aleatorio
    public static int aleatorio(int b) {
        int ran = (int) (Math.floor((b + 1) * Math.random()));
        return ran;
    }

    public static int aleatorio(int menor, int mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

    public static void sabergenero(Personas p) {
        int ran = aleatorio(100);

        if (ran < 45) {
            p.setGenero(false);
        } else {
            p.setGenero(true);
        }
    }

    // mirar edad el dia que nacio y el dia actual
    public static void laedad() {
        LocalDate dia1 = LocalDate.of(2002, 2, 5);
        Period.between(dia1, LocalDate.now());
        System.out.println(Period.between(dia1, LocalDate.now()));
    }
}