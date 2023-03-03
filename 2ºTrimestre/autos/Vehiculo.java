package autos;

public interface Vehiculo {
    int VELOCIDAD_MAXIMA = 120;

    String frenar(int cuanto); // mostrar mensaje de frenado y mostrar velocidad

    String acelerar(int cuanto); // controlar limite (mensaje) y mostrar a cuanto va

    int plazas();
}