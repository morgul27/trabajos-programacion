import java.text.NumberFormat;
import java.util.Locale;
import java.text.*;

public class formatos {

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println(nf.format(12345678.6544));
		// Resultado: 12.345.678,654

		nf = NumberFormat.getInstance(Locale.ENGLISH);
		System.out.println(nf.format(12345678.6544));
		// Resultado: 12,345,678.654

		nf = NumberFormat.getIntegerInstance();
		System.out.println(nf.format(123456.789));
		// Resultado: 123.456

		nf = NumberFormat.getCurrencyInstance();
		nf = NumberFormat.getCurrencyInstance(new Locale("es","ES"));
		System.out.println(nf.format(12345678.2));
		// Resultado: 12.345.678,20 €

		nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf.format(12345678.2));
		// Resultado: $12,345,678.20 €

		nf.setMaximumFractionDigits(1);
		System.out.println(nf.format(12345678.6544));
		// Resultado: 12.345.678,7


		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println(df.format(123456.789));
		//Muestra en pantalla el valor 123.456,79
	}
}

