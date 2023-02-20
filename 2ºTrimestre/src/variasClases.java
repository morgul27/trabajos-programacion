package src;

import java.util.Scanner;

public class variasClases {
    public String cambiarColor;
    public String iniciarLlamada;
    public String finalizarLlamada;

    public void variasClases() {
        int memoria = 0;
        int calidad = 0;

        cambiarColor = getcambiarColor();
        iniciarLlamada = getiniciarLlamada();
        finalizarLlamada = getfinalizarLlamada();
        memoria = settamañoMenoria(memoria);
        setCalidad(calidad);
        System.out.println("El tamaño de memoria es " + memoria + "GB");

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

    int settamañoMenoria(int memoria) {
        memoria = 8;
        return memoria;
    }

    private void setCalidad(int calidad) {
        calidad = 5;
        System.out.println("La calidad de fotografia en megapixeles es " + calidad);
    }

}