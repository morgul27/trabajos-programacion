public class OpUnarios {
	public static void main (String [] args)
	{
		int resultado = 1;
		
		resultado--; //resultado vale 0
		System.out.println(resultado);
		//Imprime 0
		
		resultado++; //resultado vale 1
		System.out.println(resultado);
		//Imprime 1
		
		resultado = -resultado; //resultado vale -1
		System.out.println(resultado);
		//Imprime -1
		
		boolean falso = false;
		System.out.println(falso); //Imprime false
		System.out.println(!falso); //Imprime true
	}
}