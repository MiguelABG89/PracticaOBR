import static data.EliminarDatos.eliminar;
import static data.FunVarTelefono.funcionTelefono;
import static data.InsertarDatos.insertar;
import static data.ModificarDatos.modificar;

public class main {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion = "";
        do {
            System.out.println("0. Salir");
            System.out.println("1. Listar los clientes y el número de artículos que ha comprado");

            opcion = libs.Leer.pedirCadena("Introduce una opción");
            switch (opcion) {
                case "0" -> {salir = true;}
                case "1" ->insertar();
                case "2" ->modificar();
                case "3" -> eliminar();
                case "4" -> funcionTelefono();

                default -> {System.out.println("Opción incorrecta");}
            }
        }while (!salir);

    }
}
