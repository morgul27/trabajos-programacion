import java.util.Scanner;
import java.util.ArrayList;

public class ejT3ciudades_y_Temperatura {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ciudad = new ArrayList<String>();
        ArrayList<Double> temp = new ArrayList<Double>();
        String F;
        Double T;
        Double mayor = 0.0;
        Double menor = 10000.0;
        Double suma = 0.0;
        int c = 0;
        int posicion;
        double media;

        do {
            System.out.println("Pon el nombre de la ciudad o FIN para terminar");
            F = sc.next();
            if (F.equals("FIN") || F.equals("fin"))
                break;
            ciudad.add(F);
            do {
                System.out.println("Di la temperatura de esa ciudad");
                T = sc.nextDouble();
            } while (T < 0 || T > 50);
            temp.add(T);

            mayor = (T > mayor) ? T : mayor;
            menor = (T < menor) ? T : menor;
            suma += T;
            c++;

        } while (!F.equals("FIN") || !F.equals("fin"));

        System.out.println();
        media = suma / c;
        System.out.println("La temperatura mayor es " + mayor + "ºC la temperatura menor es " + menor
                + "ºC y la media es " + media + "ºC");

        posicion = temp.indexOf(mayor);
        System.out.println("La ciudad con mayor temperatura es " + ciudad.get(posicion));
        posicion = temp.indexOf(menor);
        System.out.println("La ciudad con menor temperatura es " + ciudad.get(posicion));

        System.out.println();
        System.out.println("la ciudades más grande que la media son:");
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) > media)
                System.out.println(ciudad.get(i));
        }
    }
}