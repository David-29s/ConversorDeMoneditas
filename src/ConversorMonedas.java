import com.google.gson.JsonObject;
import java.io.IOException;

public class ConversorMonedas {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
        try {
            EntradaUsuario entrada = new EntradaUsuario();
            ApiClient api = new ApiClient();
            Conversor conversor = new Conversor();
            FiltroMonedas filtro = new FiltroMonedas();

            System.out.println("********* Conversor de Monedas *********");

            String monedaBase = entrada.leerMoneda("Ingrese la moneda base (USD, EUR, MXN): ");
            String monedaDestino = entrada.leerMoneda("Ingrese la moneda destino (USD, EUR, MXN): ");
            double cantidad = entrada.leerCantidad("Ingrese la cantidad a convertir: ");

            JsonObject conversionRates = api.obtenerConversionRates(monedaBase);

            filtro.mostrarTasas(conversionRates);

            if (!conversionRates.has(monedaDestino)) {
                System.out.println("La moneda destino no está disponible.");
                return;
            }

            double tasa = conversionRates.get(monedaDestino).getAsDouble();
            double resultado = conversor.convertir(cantidad, tasa);

            System.out.printf("%.2f %s equivalen a %.2f %s%n",
                    cantidad, monedaBase, resultado, monedaDestino);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
