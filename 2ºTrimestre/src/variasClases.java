package src;

import java.util.Scanner;

public class variasClases {
    private String cambiarColor;
    private String iniciarLlamada;
    private String finalizarLlamada;

    public void variasClases(String cambiarColo, String iniciarLlamad, String finalizarLlamad) {
        cambiarColo = getcambiarColor();
        iniciarLlamad = getiniciarLlamada();
        finalizarLlamad = getfinalizarLlamada();
    }

    public String getcambiarColor() {
        Scanner sc = new Scanner(System.in);
        String x;

        System.out.println("indica el color que quieras poner");
        x = sc.next();
        cambiarColor = x;
        return cambiarColor;
    }

    public String getiniciarLlamada() {
        Scanner sc = new Scanner(System.in);
        String x;

        System.out.println("Introduce el nombre de una persona");
        x = sc.next();
        System.out.println("El nombre introducido es " + x);
        return iniciarLlamada;
    }

    public String getfinalizarLlamada() {
        System.out.println("Has finalizado la llamada");
        return finalizarLlamada;
    }

}