import java.util.Scanner;

public class EntradaUsuario {
    private final Scanner scanner = new Scanner(System.in);

    public String leerMoneda(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().toUpperCase();
    }

    public double leerCantidad(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }
}
