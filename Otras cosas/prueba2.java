import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class prueba2 {
    public static void main(String[] args) {
        // random
        // Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
        int menor = 3;
        int mayor = 8;
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        System.out.println(n);
    }
}
