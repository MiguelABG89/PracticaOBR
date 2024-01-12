package data;

import libs.Leer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {
    public static void insertar(){
        //Pedimos los datos del contacto
        String NombrePersona = Leer.pedirCadena("Introduce el nombre de la persona: ");
        String Telefeono1 = Leer.pedirCadena("Introduce el primer telefono de la persona: ");
        String Telefeono2 = Leer.pedirCadena("Introduce el segundo telefono de la persona: ");
        String Telefeono3 = Leer.pedirCadena("Introduce el Tercer telefono de la persona: ");

        try(Connection miCon = Conexion.conectar()){
            System.out.println("ok");
            //creamos la sentencia donde solo puede meter hasta 3 telefonos
            PreparedStatement ps = miCon.prepareStatement( "INSERT INTO AGENDA VALUES (?,TELEFONO(?,?,?))");
            ps.setString(1,NombrePersona);
            //comporbamos que si ha dejado vacio el campo se vuelva null
            if (Telefeono1.equals("")){
                Telefeono1=null;
            }
            if (Telefeono2.equals("")){
                Telefeono2=null;
            }
            if (Telefeono3.equals("")){
                Telefeono3=null;
            }
            //insertamos los datos y ejecutamos el execute
            ps.setString(2,Telefeono1);
            ps.setString(3,Telefeono2);
            ps.setString(4,Telefeono3);

            ps.executeUpdate();
            System.out.println("Nuevo contacto insetado");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
