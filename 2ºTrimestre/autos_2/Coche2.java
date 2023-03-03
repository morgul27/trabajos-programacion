package autos_2;

public class Coche2 implements Vehiculo2 {
    int velocidad = 0;

    public String frenado1(int v) {
        this.velocidad -= v;
        return "velocidad del coche es " + this.velocidad;
    }

    public String acelerar1(int v) {
        this.velocidad += v;
        return "velocidad del coche ahora es " + this.velocidad;
    }

    public int plazas1() {
        return 4;
    }

}