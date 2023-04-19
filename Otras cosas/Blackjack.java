import java.util.ArrayList;

public class Blackjack {
    public static void main(String[] args) {
        ArrayList<String> repartidor = new ArrayList<String>();
        ArrayList<String> jugador = new ArrayList<String>();

        Integer baraja[][] = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 }
        };

        // cuando muestre a partir del 11, lo que puedo hacer es meter un switch que
        // diga que 11 sea J, etc
        System.out.println();

    }

    // Método para GENERAR UN ENTERO ALEAORIO DENTRO DE UN RANGO
    public static int aleatorio(int menor, int mayor) {
        int n = (int) Math.floor((mayor - menor + 1) * Math.random()) + menor;
        return n;
    }

}