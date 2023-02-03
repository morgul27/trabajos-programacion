
class ConValueOf{
public static void main (String[] args){

	//Convertir número en cadena con método valueOf()
	int numero1 = 728;
	String cadena1 = String.valueOf(numero1);
	System.out.println(cadena1 + 1);

	//Convertir cadena a numero con método valueOf()
	String cadena2 = "3";
	int numero2 = Integer.valueOf(cadena2);
	System.out.println(numero2 + 1);
}
}

