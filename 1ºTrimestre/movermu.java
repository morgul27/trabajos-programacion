import java.util.Scanner;

public class movermu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int aux;
        String a;
        String matriz[][];
        matriz = new String[5][5];

        rellenar(matriz);

        matriz[0][0] = "( Inicio )";
        matriz[4][4] = "( Fin )";
        matriz[2][1] = "(|)";
        matriz[2][2] = "(|)";
        matriz[0][2] = "(|)";
        matriz[1][4] = "(|)";
        matriz[1][0] = "(|)";

        do {
            System.out.println("    MATRIZ");
            verm(matriz);
            System.out.println();
            System.out.println("Introduce abajo, arriba, izquierda o derecha");

            a = sc.nextLine();

            if ((a.equals("abajo") && !matriz[x + 1][y].equals("(|)"))
                    || (a.equals("arriba") && !matriz[x - 1][y].equals("(|)"))) {

                aux = x;
                x = moverx(matriz, a, x);
                matriz[x][y] = "(x)";
                if (x != aux)
                    matriz[aux][y] = "( )";

            } else if ((a.equals("derecha") && !matriz[x][y + 1].equals("(|)"))
                    || (a.equals("izquierda") && !matriz[x][y - 1].equals("(|)"))) {
                aux = y;
                y = movery(matriz, a, y);
                matriz[x][y] = "(x)";
                if (y != aux)
                    matriz[x][aux] = "( )";
            }

        } while (x != 4 || y != 4);
        System.out.println();
        System.out.println("Has ganado!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    // funcion para rellenar matriz y ver matriz
    public static void rellenar(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "( )";

            }
        }
    }

    // funcion para ver matriz
    public static void verm(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }

    // funcion para moverse x
    public static int moverx(String matriz[][], String a, int x) {

        if (a.equals("abajo") && (x < 4)) {
            x = x + 1;

        } else if (a.equals("arriba") && (x > 0)) {
            x = x - 1;
        }
        return x;
    }

    // funcion para moverse y
    public static int movery(String matriz[][], String a, int y) {

        if (a.equals("derecha") && (y < 4)) {
            y = y + 1;

        } else if (a.equals("izquierda") && (y > 0)) {
            y = y - 1;
        }
        return y;

    }

}