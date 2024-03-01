package data;

import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {
    public static void insertar() {
        // Pedimos los datos del contacto
        String NombrePersona = Leer.pedirCadena("Introduce el nombre de la persona: ");
        String Telefono1 = Leer.pedirCadena("Introduce el primer telefono de la persona: ");
        String Telefono2 = Leer.pedirCadena("Introduce el segundo telefono de la persona: ");
        String Telefono3 = Leer.pedirCadena("Introduce el Tercer telefono de la persona: ");

        try (Connection miCon = Conexion.conectar()) {
            // Mensaje de confirmación de conexión
            System.out.println("ok");

            // Creamos la sentencia donde solo puede meter hasta 3 telefonos
            PreparedStatement ps = miCon.prepareStatement("INSERT INTO AGENDA VALUES (?,TELEFONO(?,?,?))");

            // Seteamos el nombre de la persona en la consulta
            ps.setString(1, NombrePersona);

            // Comprobamos que si ha dejado vacío el campo se vuelva null
            if (Telefono1.equals("")) {
                Telefono1 = null;
            }
            if (Telefono2.equals("")) {
                Telefono2 = null;
            }
            if (Telefono3.equals("")) {
                Telefono3 = null;
            }

            // Insertamos los datos y ejecutamos el execute
            ps.setString(2, Telefono1);
            ps.setString(3, Telefono2);
            ps.setString(4, Telefono3);

            // Ejecutamos la inserción
            ps.executeUpdate();

            // Mensaje de confirmación de inserción exitosa
            System.out.println("Nuevo contacto insertado");

        } catch (SQLException e) {
            // Manejo de excepción, lanzando una RuntimeException
            throw new RuntimeException(e);
        }
    }
}

