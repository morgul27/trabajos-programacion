/*
 * import java.io.BufferedReader;
 * import java.io.BufferedWriter;
 * import java.io.FileReader;
 * import java.io.FileWriter;
 * import java.io.IOException;
 * 
 * public class LeerEscribirArchivo {
 * public static void main(String[] args) {
 * // Leer un archivo
 * // Ruta del archivo a leer
 * String archivoALeer = "ruta_del_archivo/archivo_lectura.txt";
 * 
 * try (BufferedReader reader = new BufferedReader(new
 * FileReader(archivoALeer))) {
 * String linea;
 * while ((linea = reader.readLine()) != null) {
 * // Procesar cada línea del archivo
 * System.out.println(linea);
 * }
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * 
 * //Escribir en un archivo
 * // Ruta del archivo a escribir
 * String archivoAEscribir = "ruta_del_archivo/archivo_escritura.txt";
 * 
 * try (BufferedWriter writer = new BufferedWriter(new
 * FileWriter(archivoAEscribir))) {
 * // Contenido a escribir en el archivo
 * String contenido = "Hola, esto es un ejemplo de escritura en archivo.";
 * 
 * // Escribir en el archivo
 * writer.write(contenido);
 * 
 * System.out.println("Escritura exitosa");
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * }
 * }
 */

/*
 * //Fichero de config.
 * import java.io.FileInputStream;
 * import java.io.IOException;
 * import java.util.Properties;
 * 
 * public class Configuracion {
 * public static void main(String[] args) {
 * // Ruta del archivo de configuración
 * String archivoConfiguracion = "ruta_del_archivo/config.properties";
 * 
 * // Crear objeto Properties
 * Properties properties = new Properties();
 * 
 * try {
 * // Cargar el archivo de configuración
 * FileInputStream fis = new FileInputStream(archivoConfiguracion);
 * properties.load(fis);
 * 
 * // Obtener los valores de configuración
 * String valor1 = properties.getProperty("clave1");
 * String valor2 = properties.getProperty("clave2");
 * 
 * // Utilizar los valores de configuración
 * System.out.println("Valor 1: " + valor1);
 * System.out.println("Valor 2: " + valor2);
 * 
 * // Cerrar el flujo de entrada
 * fis.close();
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * }
 * }
 */

/*
 * //Conexion a base de datos
 * import java.sql.Connection;
 * import java.sql.DriverManager;
 * import java.sql.SQLException;
 * 
 * public class ConexionBD {
 * public static void main(String[] args) {
 * // Datos de conexión a la base de datos
 * String url = "jdbc:mysql://localhost:3306/nombre_base_datos";
 * String username = "usuario";
 * String password = "contraseña";
 * 
 * try {
 * // Establecer la conexión
 * Connection connection = DriverManager.getConnection(url, username, password);
 * System.out.println("Conexión exitosa");
 * 
 * // Realizar operaciones en la base de datos
 * 
 * // Cerrar la conexión
 * connection.close();
 * } catch (SQLException e) {
 * e.printStackTrace();
 * }
 * }
 * }
 */

/*
 * // Actualización (UPDATE) con PreparedStatement
 * String sql =
 * "UPDATE nombre_tabla SET columna1=?, columna2=? WHERE condicion";
 * try (Connection connection = DriverManager.getConnection(url, username,
 * password);
 * PreparedStatement statement = connection.prepareStatement(sql)) {
 * // Establecer los valores de los parámetros
 * statement.setString(1, valor1);
 * statement.setString(2, valor2);
 * // Ejecutar la actualización
 * statement.executeUpdate();
 * // Imprimir mensaje de éxito
 * System.out.println("Actualización exitosa");
 * } catch (SQLException e) {
 * e.printStackTrace();
 * }
 */

/*
 * // Eliminación (DELETE) con Statement
 * String sql = "DELETE FROM nombre_tabla WHERE condicion";
 * try (Connection connection = DriverManager.getConnection(url, username,
 * password);
 * Statement statement = connection.createStatement()) {
 * // Ejecutar la eliminación
 * statement.executeUpdate(sql);
 * // Imprimir mensaje de éxito
 * System.out.println("Eliminación exitosa");
 * } catch (SQLException e) {
 * e.printStackTrace();
 * }
 */

/*
 * // Inserción (INSERT) con PreparedStatement
 * String sql = "INSERT INTO nombre_tabla (columna1, columna2) VALUES (?, ?)";
 * try (Connection connection = DriverManager.getConnection(url, username,
 * password);
 * PreparedStatement statement = connection.prepareStatement(sql)) {
 * // Establecer los valores de los parámetros
 * statement.setString(1, valor1);
 * statement.setString(2, valor2);
 * // Ejecutar la inserción
 * statement.executeUpdate();
 * // Imprimir mensaje de éxito
 * System.out.println("Inserción exitosa");
 * } catch (SQLException e) {
 * e.printStackTrace();
 * }
 */