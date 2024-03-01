package data;

import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarDatos {

    // Método para eliminar los datos de una persona de la agenda
    public static void eliminar() {
        // Pedir el nombre de la persona que se desea eliminar
        String NombrePersona = Leer.pedirCadena("Introduce el nombre de la persona que quieres eliminar: ");

        try (Connection miCon = Conexion.conectar()) {
            System.out.println("Conexión establecida con éxito.");

            // Preparar la sentencia SQL para eliminar la persona de la tabla AGENDA
            PreparedStatement ps = miCon.prepareStatement("DELETE FROM AGENDA WHERE NOMBRE = ?");

            // Establecer el valor del parámetro en la sentencia SQL
            ps.setString(1, NombrePersona);

            // Ejecutar la sentencia SQL para eliminar la persona de la base de datos
            ps.executeUpdate();
            System.out.println("Contacto eliminado exitosamente.");

        } catch (SQLException e) {
            // Capturar excepciones SQL y lanzar una RuntimeException
            throw new RuntimeException(e);
        }
    }
}
