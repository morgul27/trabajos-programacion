package autos_2;

public interface Vehiculo2 {
    int VELOCIDAD_MAXIMA = 120;

    String frenado1(int cuanto); // mostrar mensaje de frenado y mostrar velocidad

    String acelerar1(int cuanto); // controlar limite (mensaje) y mostrar a cuanto va

    int plazas1();
}
