import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class pruebafechas {
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

        // Por ejemplo, si tienes 1,569,600 segundos desde el 1 de enero, el cálculo
        // sería:
        // 1,569,600 segundos / 86,400 segundos por día = 18 días

        float s = aleatorio(1569600);

        int e = (int) s / 86400;
        System.out.println("Ha salido el numero de segundos " + s + " y es dia " + e + " ");

        // probando mes y dias
        b = aleatorio(8760, 1);
        mes = (b / 8760) * 12; // el mes no pasa de 12, por lo que creo que esta bien
        dias = (b / 8760) * 365;
        dias = dias / 12;
        System.out.println("diaaa " + dias);

        System.out.println(b + " " + (mes + 1) + " " + (e + 1) + " ");

        //
        // probando cosas
        LocalDate fecha3 = LocalDate.of(2022, (int) (mes + 1), (int) (dias + 1));
        System.out.println(fecha3);

    }

    // funciones aleatorio
    public static int aleatorio(int a, int b) {
        int min;
        int max;
        int ran;

        min = Math.min(a, b);
        max = Math.max(a, b);
        ran = (int) (Math.floor((max) * Math.random()) + min);
        return ran;
    }

    public static int aleatorio(int a) {
        int ran;

        ran = (int) (Math.floor((a) * Math.random()));
        return ran;
    }

}