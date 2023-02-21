package ejercicio;

import java.util.Scanner;

public class ejDNI {

    public double getnumero() {
        return numero;
    }

    public void setnumero(int numero) {
        this.numero = numero;
    }

    public String getletra() {
        return letra;
    }

    public void setletra(String letra) {
        this.letra = letra;
    }

    // empieza
    public int numero;
    public String letra;

    public ejDNI(int n, String letra) {
        this.numero = n;
        this.letra = letra;
    }

    public ejDNI() {

    }

    public int numeroDNI() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("introduce el numero de tu DNI");
        n = sc.nextInt();
        return n;
    }

    private int calculo(int n) {
        String l;
        n = n / 23;
        return n;
    }

    public void recuperar() {

    }

}
