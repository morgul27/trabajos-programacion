package clinicabd.clases;

public class PACIENTES {
    protected int Historia;
    protected String Apellidos;
    protected String Nombre;
    protected String DNI;
    protected String FechaNacimiento; // mirar si poner date o String
    protected String Genero;
    protected String Direccion;
    protected int CP;
    protected int CodProvincia;
    protected String email;
    protected int Telefono1;
    protected int Telefono2;

    public PACIENTES() {
    }

    public PACIENTES(int historia, String apellidos, String nombre, String dNI, String fechaNacimiento, String genero,
            String direccion, int cP, int codProvincia, String email, int telefono1, int telefono2) {
        Historia = historia;
        Apellidos = apellidos;
        Nombre = nombre;
        DNI = dNI;
        FechaNacimiento = fechaNacimiento;
        Genero = genero;
        Direccion = direccion;
        CP = cP;
        CodProvincia = codProvincia;
        this.email = email;
        Telefono1 = telefono1;
        Telefono2 = telefono2;
    }

    public int getHistoria() {
        return Historia;
    }

    public void setHistoria(int historia) {
        Historia = historia;
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

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
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

}
