package autos_2;

public class UsoVehiculo2 {

    public void main(String[] args) {
        Coche2 ve1 = new Coche2();
        Moto2 ve2 = new Moto2();

        ve1.acelerar1(120);
        ve2.acelerar1(120);

        System.out.println("La velocidad del coche es " + ve1);
        System.out.println("La velocidad del coche es " + ve2);

    }

}
