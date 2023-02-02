
import java.util.Scanner;

public class telefonoalmacenados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String telefonos[][] = {
                { "Antonio", "123456" },
                { "Pedro", "145478" },
                { "Lola", "789457" },
                { "Alvaro", "666999" }
        };
        int i;
        if (args.length != 1)
            System.out.println("ejecute bla bla");
        else {
            for (i = 0; i < telefonos.length; i++) {
                if (args[0].equals(telefonos[i][0])) {
                    System.out.println(telefonos[i][0] + " " + telefonos[i][1]);
                    break;
                }
            }
            if (i == telefonos.length)
                System.out.println("nombre no encontrado.");
        }

    }

}
