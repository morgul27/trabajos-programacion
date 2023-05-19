package clinicabd.clases;

public class PROFESIONALES {
    protected String NIF;
    protected String Apellidos;
    protected String Nombre;
    protected String DNI;
    protected String Direccion;
    protected int CP;
    protected int CodProvincia;
    protected String email;
    protected int Telefono1;
    protected int Telefono2;
    protected double Comision;

    public PROFESIONALES() {
    }

    public PROFESIONALES(String nIF, String apellidos, String nombre, String dNI, String direccion, int cP,
            int codProvincia, String email, int telefono1, int telefono2, double comision) {
        NIF = nIF;
        Apellidos = apellidos;
        Nombre = nombre;
        DNI = dNI;
        Direccion = direccion;
        CP = cP;
        CodProvincia = codProvincia;
        this.email = email;
        Telefono1 = telefono1;
        Telefono2 = telefono2;
        Comision = comision;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String nIF) {
        NIF = nIF;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int cP) {
        CP = cP;
    }

    public int getCodProvincia() {
        return CodProvincia;
    }

    public void setCodProvincia(int codProvincia) {
        CodProvincia = codProvincia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono1() {
        return Telefono1;
    }

    public void setTelefono1(int telefono1) {
        Telefono1 = telefono1;
    }

    public int getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(int telefono2) {
        Telefono2 = telefono2;
    }

    public double getComision() {
        return Comision;
    }

    public void setComision(double comision) {
        Comision = comision;
    }

}
