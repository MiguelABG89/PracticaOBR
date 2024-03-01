package data;

import libs.Leer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FunVarTelefono {
    public static void funcionTelefono() {
        // Pedimos el nombre del alumno
        String nombreAlum = Leer.pedirCadena("Introduce el nombre: ");

        // Variable para almacenar el teléfono
        String telefono;

        try (Connection miCon = Conexion.conectar()) {
            // Creamos una llamada al procedimiento almacenado
            CallableStatement cs = miCon.prepareCall("{? = call FUN_VAR_TELEF(?)}");

            // Configuramos el parámetro de salida
            cs.registerOutParameter(1, Types.VARCHAR);

            // Seteamos el nombre del alumno como parámetro de entrada
            cs.setString(2, nombreAlum);

            // Ejecutamos la llamada al procedimiento almacenado
            cs.execute();

            // Obtenemos el valor del teléfono desde el parámetro de salida
            telefono = cs.getString(1);

            // Imprimimos el teléfono
            System.out.println("Teléfono: " + telefono);

        } catch (SQLException e) {
            // Manejo de excepción, lanzando una RuntimeException
            throw new RuntimeException(e);
        }
    }
}
