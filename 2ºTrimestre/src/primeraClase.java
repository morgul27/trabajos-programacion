package src;

import src.variasClases;

public class primeraClase {
    public String cambiarColor;
    public String iniciarLlamada = "luis";
    public String finalizarLlamada;

    public static void main(String[] args) {
        int memoria = 0;

        variasClases variasclases = new variasClases(); // "variasClases" es el nombre de la clase y "variasclases" es
                                                        // el objeto creado

        variasclases.variasClases();
        variasclases.getcambiarColor();
        variasclases.getiniciarLlamada();
        variasclases.getfinalizarLlamada();

        // System.out.println("El nombre introducido es " + iniciarLlamada);

        memoria = variasclases.settamañoMenoria(memoria);

    }
}
