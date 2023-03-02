package autos;

public class Moto implements Vehiculo {
    int velocidad = 0;

    @Override
    public String frenar(int cuanto) {
        velocidad -= cuanto;
        return "La moto ha frenado ya y va a " + velocidad + " km/hora";
    }

    @Override
    public String acelerar(int cuanto) {
        String cadena = "";
        velocidad += cuanto;
        if (velocidad > VELOCIDAD_MAXIMA)
            cadena = "Exceso de velocidad";
        cadena += "La moto ha acelerado y va a " + velocidad + " km/hora";
        return cadena;
    }

    public int plazas() {
        return 2;
    }
}