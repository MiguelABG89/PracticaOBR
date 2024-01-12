package data;

import libs.Leer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class FunVarTelefono {
    public static void funcionTelefono(){
        String nombreAlum = Leer.pedirCadena("Introduce el nombre: ");
        String telefono;
        try (Connection miCon = Conexion.conectar()){
            CallableStatement cs = miCon.prepareCall("{? = call FUN_VAR_TELEF(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2,nombreAlum);
            cs.execute();
            telefono=cs.getString(1);
            System.out.println(telefono);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
