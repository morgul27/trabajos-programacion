
import java.time.*;

class fechas1{
public static void main (String[] args){

System.out.println("La fecha actual es: " + LocalDate.now());
System.out.println( "La hora actual es: " + LocalTime.now() );
System.out.println( "La fecha y hora actuales son: "
										+	LocalDateTime.now() );
System.out.println( "El instante actual es: " + Instant.now() );
System.out.println( "La fecha y hora actuales con zona horaria son: "
										+ ZonedDateTime.now() );
}
}

