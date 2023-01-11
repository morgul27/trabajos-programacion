public class abecedariopiramide 
{
	public static void main (String[] arg) 
	{
		System.out.println ("Piramide Caracteres de la a la z");
		char i = 'A';
		String texto="";
		do
		{
			texto=texto+i;
			System.out.println(texto);
			i++;
		} while (i<='Z');
	}
}