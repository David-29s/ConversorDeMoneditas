import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        ApiClient api = new ApiClient();
        FiltroMonedas filtro = new FiltroMonedas();

        while (true) {
            System.out.println("\n📊 Bienvenido/a al Conversor de Moneda 📊");
            System.out.println("1. USD a EUR");
            System.out.println("2. EUR a USD");
            System.out.println("3. USD a MXN");
            System.out.println("4. MXN a USD");
            System.out.println("5. Ingresar monedas manualmente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            String monedaBase = "";
            String monedaDestino = "";

            switch (opcion) {
                case "1" -> {
                    monedaBase = "USD";
                    monedaDestino = "EUR";
                }
                case "2" -> {
                    monedaBase = "EUR";
                    monedaDestino = "USD";
                }
                case "3" -> {
                    monedaBase = "USD";
                    monedaDestino = "MXN";
                }
                case "4" -> {
                    monedaBase = "MXN";
                    monedaDestino = "USD";
                }
                case "5" -> {
                    System.out.print("Ingrese la moneda base (USD, EUR, MXN): ");
                    monedaBase = scanner.nextLine().toUpperCase();
                    System.out.print("Ingrese la moneda destino: ");
                    monedaDestino = scanner.nextLine().toUpperCase();
                }
                case "6" -> {
                    System.out.println("👋 Gracias por usar el conversor. ¡Hasta luego!");
                    return;
                }
                default -> {
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
                    continue;
                }
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad;
            try {
                cantidad = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Use solo números.");
                continue;
            }

            try {
                var conversionRates = api.obtenerConversionRates(monedaBase);
                filtro.mostrarTasas(conversionRates);

                if (!conversionRates.has(monedaDestino)) {
                    System.out.println("❌ La moneda destino no está disponible.");
                    continue;
                }

                double tasa = conversionRates.get(monedaDestino).getAsDouble();
                double resultado = conversor.convertir(cantidad, tasa);

                System.out.printf("✅ %.2f %s equivalen a %.2f %s%n",
                        cantidad, monedaBase, resultado, monedaDestino);

            } catch (Exception e) {
                System.out.println("❌ Ocurrió un error: " + e.getMessage());
            }
        }
    }
}
