package autos;

public class UsoVehiculo {

    public static void main(String[] args) {
        Moto v1 = new Moto();
        Coche v2 = new Coche();
        System.out.println(funAcelerar(100, v1));

        // El coche ha acelerado y va a 100km/hora
        System.out.println(v1.frenar(25));
        // El coche ha frenado ya y va a 75km/hora
        System.out.println(funAcelerar(130, v2));
        // Exceso
        System.out.println(v2.frenar(25));
        // La moto ha frenado ya y va a 105 km/hora
    }

    static String funAcelerar(int cantidad, Vehiculo vei) {
        return vei.acelerar(cantidad);
    }
}
