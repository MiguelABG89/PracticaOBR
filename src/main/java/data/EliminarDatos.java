package data;

import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarDatos {
    public static void eliminar(){
        String NombrePersona = Leer.pedirCadena("Introduce el nombre de la persona que quieres eliminar: ");

        try(Connection miCon = Conexion.conectar()){
            System.out.println("ok");
            //creamos la sentencia donde solo puede meter hasta 3 telefonos
            PreparedStatement ps = miCon.prepareStatement( "DELETE AGENDA A WHERE A.NOMBRE = ?");
            ps.setString(1,NombrePersona);
            ps.executeUpdate();
            System.out.println("contacto Eliminado");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
