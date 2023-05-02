import java.io.*;

public class ej8File {

    public static void main(String[] args) {
        // debe contener el nombre de una carpeta
        File dir = new File(
                "C:/Users/JoséMiguelNavarroDeA/Desktop/ejercicios en clase/programas/GitHub/trabajos-programacion");
        String[] listaArchivos = dir.list();
        for (int i = 0; i < listaArchivos.length; i++) {
            System.out.println(listaArchivos[i]);
        }
    }
}
