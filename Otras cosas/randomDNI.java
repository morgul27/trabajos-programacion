import java.util.Random;
import java.util.ArrayList;
import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class randomDNI {

    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "DNI.csv"));
            int[] randomNumbers = generateRandomNumbers(4200);
            char[] randomLetters = generateRandomLetters(4200);

            System.out.println("Números aleatorios y letras aleatorias:");
            for (int i = 0; i < 4500; i++) {
                bw.write("'" + randomNumbers[i] + "" + randomLetters[i] + "'\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] generateRandomNumbers(int count) {
        int[] numbers = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(99999999) + 1;
        }

        return numbers;
    }

    public static char[] generateRandomLetters(int count) {
        char[] letters = new char[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(26); // Generar un índice aleatorio entre 0 y 25
            char randomLetter = (char) ('A' + randomIndex); // Convertir el índice a un carácter del abecedario
            letters[i] = randomLetter;
        }

        return letters;
    }

}