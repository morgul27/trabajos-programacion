import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class prueba1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double b;
        double mes;
        double dias;
        int horas;

        LocalDate fecha1 = LocalDate.of(2023, 2, 5);
        LocalDate fecha2 = LocalDate.of(2023, 3, 1);

        long diasDeDiferencia = ChronoUnit.DAYS.between(fecha1, fecha2);

        System.out.println("La diferencia en días entre " + fecha1 + " y " + fecha2 + " es: " + diasDeDiferencia);

        b = aleatorio(8760);

        float s = aleatorio(1569600);

        dias = s / 86400;
        System.out.println(s + " " + dias + " ");

        mes = (b / 8760) * 12;
        dias = (b / 8760) * 365;

        mes = Math.floor(mes);
        dias = (int) Math.floor(dias);
        System.out.println(b + " " + mes + " " + dias + " ");
    }

    // funcion aleatorio
    public static int aleatorio(int a, int b) {
        int min;
        int max;
        int ran;

        min = Math.min(a, b);
        max = Math.max(a, b);
        ran = (int) (Math.floor((max - min + 1) * Math.random()) + min);
        return ran;
    }

    public static int aleatorio(int a) {
        int ran;

        ran = (int) (Math.floor((a) * Math.random()));
        return ran;
    }

}