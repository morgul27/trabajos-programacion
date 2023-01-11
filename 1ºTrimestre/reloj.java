import java.util.Scanner;

public class reloj {
	
	public static void main (String[] args) {
		
		
		while (true) {
			for(int horas=0; horas<24; horas++){
				for(int minutos=0; minutos<60;minutos++){
					for(int segundos=0; segundos<60;segundos++){
						if (segundos == 60) {
							//reinicio los segundos
							segundos = 0;
							//aumento los minutos
							minutos++;
							if (minutos == 60) {
								//Reinicio los minutos
								minutos = 0;
								//Aumento las horas
								horas++;
								if (horas == 24) {
									//Reinicio las horas
									horas = 0;
								}
							}
						}
						System.out.println(horas+":"+minutos+":"+segundos);
					}
				}
			}
		}
	}
}