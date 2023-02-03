
class String2Numeric{
public static void main (String[] args){

//De String a int:
        String cadena1 = "123";
        int entero = Integer.parseInt(cadena1);

//De String a float:
	String cadena2 = "1.23";
        float flotante = Float.parseFloat(cadena2);

 //De String a double:
        String cadena3 = "12.3";
        double decimal = Double.parseDouble(cadena3);
        
        System.out.println(entero+ " "+flotante+" "+decimal);
}
}