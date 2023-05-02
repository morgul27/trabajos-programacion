import java.util.ArrayList;
import java.util.Random;

public class sorteo {
    // d)
    public static String obtenerEquipo(ArrayList<String> listaEquipos) {
        Random rnd = new Random();
        int index = rnd.nextInt(listaEquipos.size());

        String equipo = listaEquipos.remove(index);
        return equipo;
    }

    public static void main(String[] args) {
        // a)
        String[][] MSel = {
                { "España", "Alemania", "Francia", "Inglaterra" },
                { "Italia", "Portugal", "Holanda", "Croacia" },
                { "Grecia", "Noruega", "Bélgica", "Suecia" }
        };
        // b)
        ArrayList<String>[] VSel = new ArrayList[3];

        for (int i = 0; i < VSel.length; i++) {
            VSel[i] = new ArrayList<String>();
            for (int j = 0; j < MSel[i].length; j++) {
                VSel[i].add(MSel[i][j]);
            }
        }
        // c)
        String[][] G = new String[4][3];
        // e)
        // Crear un ArrayList con todos los equipos
        ArrayList<String> equipos = new ArrayList<String>();
        for (int i = 0; i < VSel.length; i++) {
            for (int j = 0; j < VSel[i].size(); j++) {
                equipos.add(VSel[i].get(j));
            }
        }

        // Asignar equipos aleatoriamente a cada grupo
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[i].length; j++) {
                G[i][j] = obtenerEquipo(equipos);
            }
        }

        // Mostrar los grupos resultantes
        for (int i = 0; i < G.length; i++) {
            System.out.println("Grupo " + (i + 1) + ":");
            for (int j = 0; j < G[i].length; j++) {
                System.out.println(G[i][j]);
            }
            System.out.println();
        }

    }

}
