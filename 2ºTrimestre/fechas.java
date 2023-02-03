import java.util.Scanner;
import java.util.Locale;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.format.DateTimeFormatter;

public class fechas {
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();
        LocalDateTime ahora = LocalDateTime.now();

        System.out.println("la fecha actual es " + LocalDate.now());
        System.out.println("la hora actual es " + LocalTime.now());
        System.out.println("la fecha y hora actual es " + LocalDateTime.now());
        System.out.println("El instante actual es " + Instant.now());
        System.out.println("la fecha y hora actuales con zona horaria son: " + ZonedDateTime.now());
        System.out.println("El primer dia del año es " + LocalDate.of(LocalDate.now(), Month.JANUARY, 1));

        System.out.println("Hace 20 dias fue " + LocalDateTime.of(2023, Month.JANUARY, 24, 12, 21, 01, 0000));

        System.out.println(
                "El cumpleaños fue " + LocalDate.parse("27/08/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}