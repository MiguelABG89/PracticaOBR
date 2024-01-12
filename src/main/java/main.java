import static data.FunVarTelefono.funcionTelefono;

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
                case "1" -> funcionTelefono();

                default -> {System.out.println("Opción incorrecta");}
            }
        }while (!salir);

    }
}
