package clinicabd;

import java.sql.Connection;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class claseMenus {

    // primer menu que sale en el programa
    public static void primerMenu(Connection connection_) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        boolean salirMenu = false;

        try {
            do {
                // menu
                System.out.println();
                System.out.println("Menu Principal");
                System.out.println("1. Menu para inserta");
                System.out.println("2. Menu de impresion");
                System.out.println("3. Menu administrador");
                System.out.println("4. Salir");
                System.out.println();

                // Ingresar numero
                System.out.println("Ingresa un numero entre el 1 y el 4");

                x = Integer.parseInt(sc.nextLine()); // lo paso a int, aunque sea un caracter

                switch (x) {
                    case 1:
                        // insertar un servicio
                        MenuInsertar(connection_);
                        System.out.println();

                        break;
                    case 2:
                        // modificar un tratamiento, todavia no lo modifica
                        Menuimpresion(connection_);
                        System.out.println();
                        break;
                    case 3:
                        MenuAdministrador(connection_);
                        break;
                    // hacer menu con contraseña para crear la base de datos
                    case 4:
                        salirMenu = true;
                        break;
                    default:
                        System.out.println();
                        System.out.println("Debe introducir un numero entre 1 y 4");
                        System.out.println();
                }
            } while (!salirMenu);

            sc.close();
            tablabdClinica.main(null);

        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar un numero entero valido");

        }

    }

    // funcion 8 del menu de administrador
    public static void MenuAdministrador(Connection connection_) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        boolean salirMenu = false;

        System.out.println("Ingrese la contrasegna para continuar");
        try {
            x = Integer.parseInt(sc.nextLine()); // lo paso a int, aunque sea un caracter
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar la contrasegna segura");
        }
        if (x == 666) {
            do {
                // menu
                System.out.println();
                System.out.println("Menu Administrador");
                System.out.println("1. Crear la base de datos");
                System.out.println("2. Menu para insertar");
                System.out.println("3. Crear 3000 paciente"); // de momento, tengo que cambiarlo
                System.out.println("4. Insertar Familias");
                System.out.println("5. Insertar Tratamientos");
                System.out.println("6. Salir");
                System.out.println();

                // Ingresar numero
                System.out.println("Ingresa un numero entre el 1 y el 6");
                try {
                    x = Integer.parseInt(sc.nextLine()); // lo paso a int, aunque sea un caracter
                } catch (NumberFormatException e) {
                    System.out.println("Debes ingresar un numero");
                }
                switch (x) {
                    case 1:
                        // crear la base de datos
                        insercionFunciones.crearbasedatos(connection_);
                        break;
                    case 2:
                        MenuInsertar(connection_);
                        break;
                    case 3:
                        // Crear 3000 paciente
                        insercionFunciones.crearPacsv();
                        insercionFunciones.insert3000Paciente(connection_);
                        break;
                    case 4:
                        insercionFunciones.insertFamiliacsv(connection_);
                        break;
                    case 5:
                        insercionFunciones.tratamientomano(connection_);
                        break;
                    case 6:
                        primerMenu(connection_);
                        break;
                    default:
                        System.out.println();
                        System.out.println("Debe introducir un numero entre 1 y 6");
                        System.out.println();
                }
            } while (!salirMenu);
        } else {
            System.out.println("Contraseña incorrecta");
            System.out.println();
            primerMenu(connection_);
        }
        sc.close();

    }

    // Menu para ver que quieres insertar
    public static void MenuInsertar(Connection connection_) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        boolean salirMenu = false;

        do {
            System.out.println();
            System.out.println("Menu Insercion");
            System.out.println("1. Insertar un paciente");
            System.out.println("2. Insertar un cobros");
            System.out.println("3. Insertar un profesional");
            System.out.println("4. Insertar un servicios");
            System.out.println("5. Insertar una liquidacion");
            System.out.println("9. Salir");
            System.out.println();

            // Ingresar numero
            System.out.println("Ingresa un numero entre el 1 y el 9");
            try {
                x = Integer.parseInt(sc.nextLine()); // lo paso a int, aunque sea un caracter

            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero valido");
            }

            switch (x) {
                case 1:
                    insercionFunciones.insertarPac(connection_);
                    System.out.println();
                    break;
                case 2:
                    insercionFunciones.insertCobros(connection_);
                    System.out.println();

                    break;
                case 3:
                    insercionFunciones.insetarProfesional(connection_);
                    System.out.println();
                    break;
                case 4:
                    insercionFunciones.insertarservicios(connection_);
                    System.out.println();
                    break;
                case 5:
                    insercionFunciones.insertarliquidacion(connection_);
                    System.out.println();
                    break;
                case 9:
                    primerMenu(connection_);
                    break;
                default:
                    System.out.println();
                    System.out.println("Debe introducir un numero entre 1 y 9");
                    System.out.println();
            }
        } while (!salirMenu);

        sc.close();
    }

    // Menu de impresion
    public static void Menuimpresion(Connection connection_) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        boolean salirMenu = false;

        do {
            System.out.println();
            System.out.println("Menu para impresion");
            System.out.println("1. Mostar todos los pacientes");
            System.out.println("2. Menu de resumen de importes entre fechas");
            System.out.println("3. Mostrar liquidaciones");
            System.out.println("4. Ver Historial Pacientes");
            System.out.println("5. Ver Liquidacion");
            System.out.println("6. Salir");
            System.out.println();

            // Ingresar numero
            System.out.println("Ingresa un numero entre el 1 y el 6");
            try {
                x = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero valido");
            }

            switch (x) {
                case 1:
                    impresionFunciones.mostrarPac(connection_);
                    System.out.println();
                    break;
                case 2:
                    impresionFunciones.mostrarliquid(connection_);
                    System.out.println();
                    break;
                case 3:
                    impresionFunciones.HistorialPacientes(connection_);
                    System.out.println();
                    break;
                case 4:
                    impresionFunciones.sacarliquidacion(connection_);
                    System.out.println();
                    break;
                case 5:
                    MenuAdministrador(connection_);
                    break;
                case 6:
                    salirMenu = true;
                    primerMenu(connection_);
                    break;
                default:
                    System.out.println();
                    System.out.println("Debe introducir un numero entre 1 y 6");
                    System.out.println();
            }
        } while (!salirMenu);

        sc.close();
    }

    // Menu de resumen de tratamientos realizados
    public static void resumenMenu(Connection connection_) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        boolean salirMenu = false;

        do {
            System.out.println();
            System.out.println("Menu de resumen de importes entre fechas");
            System.out.println("1. Odontologia");
            System.out.println("2. Familia y tipo de tratamiento");
            System.out.println("3. Combinados");
            System.out.println("4. Salir");
            System.out.println();

            // Ingresar numero
            System.out.println("Ingresa un numero entre el 1 y el 4");
            try {
                x = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero entero valido");
            }

            switch (x) {
                case 1:
                    impresionFunciones.consultaOdonto(connection_);
                    System.out.println();
                    break;
                case 2:
                    impresionFunciones.consultaFamilia(connection_);
                    System.out.println();
                    break;
                case 3:
                    impresionFunciones.consultaOdonto(connection_);
                    impresionFunciones.consultaFamilia(connection_);
                    System.out.println();
                    break;
                case 4:
                    Menuimpresion(connection_);
                    salirMenu = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("Debe introducir un numero entre 1 y 4");
                    System.out.println();
            }
        } while (!salirMenu);

        sc.close();
    }

}