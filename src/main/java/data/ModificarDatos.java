package data;

import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarDatos {

    // Método para modificar los datos de una persona en la agenda
    public static void modificar() {
        // Pedir el nombre de la persona y los nuevos números de teléfono
        String NombrePersona = Leer.pedirCadena("Introduce el nombre de la persona que quieres modificar: ");
        String NuevoTlf1 = Leer.pedirCadena("Introduce el nuevo Teléfono 1: ");
        String NuevoTlf2 = Leer.pedirCadena("Introduce el nuevo Teléfono 2: ");
        String NuevoTlf3 = Leer.pedirCadena("Introduce el nuevo Teléfono 3: ");

        try (Connection miCon = Conexion.conectar()) {
            System.out.println("Conexión establecida con éxito.");

            // Preparar la sentencia SQL para actualizar los datos en la tabla AGENDA
            // Usamos TELEFONO(?,?,?) para permitir hasta 3 números de teléfono
            PreparedStatement ps = miCon.prepareStatement("UPDATE AGENDA SET TELEF = TELEFONO(?,?,?) WHERE ? = NOMBRE");

            // Comprobamos si algún campo de teléfono está vacío y lo convertimos a null
            if (NuevoTlf1.equals("")) {
                NuevoTlf1 = null;
            }
            if (NuevoTlf2.equals("")) {
                NuevoTlf2 = null;
            }
            if (NuevoTlf3.equals("")) {
                NuevoTlf3 = null;
            }

            // Establecer los valores de los parámetros en la sentencia SQL
            ps.setString(1, NuevoTlf1);
            ps.setString(2, NuevoTlf2);
            ps.setString(3, NuevoTlf3);
            ps.setString(4, NombrePersona);

            // Ejecutar la sentencia SQL para actualizar los datos en la base de datos
            ps.executeUpdate();
            System.out.println("Contacto modificado exitosamente.");

        } catch (SQLException e) {
            // Capturar excepciones SQL y lanzar una RuntimeException
            throw new RuntimeException(e);
        }
    }
}
