import java.util.Scanner;
public class examenT1y2{ 
    public static void main (String args[]){ 
		Scanner sc = new Scanner(System.in);
		String[][] Preguntas = {
				{"Cuantos mundiales ha ganado la selección española de futbol","Ninguno","Dos","Uno","c"},
				{"En que año gano España su último mundial","No ha ganado ningún mundial","2010","1982","b"},
				{"En que año se celebró el mundial de futbol en España","Nunca se ha celebrado un mundial en España","2010","1982","c"},
				{"En que país se está celebrando el mundial de 2022","Catar","Arabia Saudi","Francia","a"},
				{"Cual es la selección actualmente campeona del mundo","Brasil","Argentina","Francia","c"},
				{"Cual es el único jugador que ha marcado al menos un gol e cinco mundiales consecutivos","Messi","Cristiano Ronaldo","Borja Iglesias","b"},
				{"Contra que selección ha sido la mayor goleada a favor de España en un mundial","6-1 a Bulgaria en Francia 1998","7-0 a Costa Rica en Catar 2022","12-1 a Malta en España 1982","b"}
                                   };
		
		int aciertos = 0;
		int fallos = 0;
		String respuesta="v";
		
		for (int i = 0; i < Preguntas.length; i++) {
			System.out.println("PREGUNTA NUMERO "+(i+1) +":");
			System.out.println(Preguntas[i][0]);
			char op='a';
		
			for (int j=1 ; j < Preguntas[i].length-1; j++ ){
                System.out.println(" "+(op++)+". "+Preguntas[i][j]);
			}
			
			System.out.println(" d. Continuar sin responder\n");
            do {
				System.out.print("Introduce una opción válida: ");
				respuesta = sc.nextLine();
			}while(!respuesta.equals("a") && !respuesta.equals("b") && !respuesta.equals("c") && !respuesta.equals("d"));
			
			if(respuesta.equals(Preguntas[i][4]))
				aciertos++;
			else if(!respuesta.equals("d"))
				fallos++;
			System.out.println();
		}
		System.out.println();
		System.out.println("RESULTADOS OBTENDIOS:");
		System.out.println("aciertos "+aciertos);
		System.out.println("fallos "+fallos);
		System.out.println("sin responder "+(Preguntas.length-aciertos-fallos));
	}
}