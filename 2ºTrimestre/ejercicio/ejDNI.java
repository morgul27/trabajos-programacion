package ejercicio;

public class ejDNI {

    public int getnumero() {
        return numero;
    }

    public void setnumero(int numero) {
        this.numero = numero;
    }

    // empieza
    private int numero;

    public ejDNI(int n) {
        this.numero = n;

    }

    public ejDNI() {

    }

    public char letra(int numero) {
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero % 23;

        return caracteres.charAt(resto);
    }

    public void mostrar() {
        System.out.println("el numero es " + numero + " y letra " + letra(numero));
    }

}