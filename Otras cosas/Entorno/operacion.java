package Entorno;

public class operacion {
    protected int num1;
    protected int num2;

   

    public operacion() {
    }

    public operacion(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public static int sumar( int num1, int num2){
        int suma= num1 +num2;
        return suma;
    }
    
    public static int restar( int num1, int num2){
        int resta= num1 - num2;
        return resta;
    }

    public static int mult( int num1, int num2){
        int mult= num1 * num2;
        return mult;
    }


    public static int dividir( int num1, int num2){
        int dividir= num1 / num2;
        return dividir;
    }
}
