package packclase;

public class Persona {
    private String nombre;
    public int edad;
    public static int ccontador;
    public int ocontador;

    public Persona() {
        String nombre = "Sin nombre";
        int edad = -1;
        ccontador++;
        ocontador++;
    }
    // get devuelve el valor
    // set establecer el valor

    public void setNombre(String n) {
        this.nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public int getedad() {
        return edad;
    }

    public void copiarEn(Persona p) {
        p.edad = this.edad;
        p.nombre = this.nombre;
    }

}
