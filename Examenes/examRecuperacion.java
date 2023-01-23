import java.util.Scanner;

public class examRecuperacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m[][] = { { 9, 5, 10, 25, 50 }, { 100, 25, 666, 785, 400 }, { 114, 696, 433, 800, 3 },
                { 799, 2, 1, 0, 2 } };
        int suma = 0;
        int c = 0;

        for (int i = 0; i < m.length; i += 2) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] % 3 == 0) {
                    suma += m[i][j];
                    c++;
                }
            }
        }
        if (c > 0)
            System.out.println("La suma es " + suma + "la media es " + suma / c);
    }
}