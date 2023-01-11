import java.util.Scanner;
public class t3_ordenburbuja_mejorado{
public static void main(String args[]){

	int miarray[] = {9,3,31,25,17};
 	int aux;

//	recorrido externo correspondiente a las pasadas
//	para localizar el mayor y ponerlo al final
	for (int i=0; i < miarray.length; i++) {

// 	se comparan por parejas vecinas, de modo que al mismo
//  tiempo que el mayor sube hacia su sitio, se va aprovechando
//  para ir dando cierto orden al resto

// 	Cada pasada que avanza trata un elemento menos ya que
//  se han colocodado ya "i" mayores

		int cambios=0;
  		for (int j = 0; j < miarray.length-i-1; j++) {	//

 			if(miarray[j] > miarray[j+1]){
				cambios++;

 				aux = miarray[j+1];
                miarray[j+1] = miarray[j];
                miarray[j] = aux;
            }

            String cadenaelementos="";
            for(int x: miarray) cadenaelementos+=" "+x;
            System.out.println("i="+i+" j="+j+" j+1="+(j+1)+
            "    "+cadenaelementos);
        }

//si en una pasada hay menos de dos intercambio
//no queda nada por ordenar
        if (cambios<=1) {
			System.out.println("No hay mas cambios");
			break;
		}
	}
}
}
