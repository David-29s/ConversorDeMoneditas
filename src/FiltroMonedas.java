import com.google.gson.JsonObject;

public class FiltroMonedas {
    public void mostrarTasas(JsonObject conversionRates) {
        String[] monedasFiltrar = {"ARS", "BRL", "COP"};
        System.out.println("----- Tasas filtradas -----");

        for (String codigo : monedasFiltrar) {
            if (conversionRates.has(codigo)) {
                double tasa = conversionRates.get(codigo).getAsDouble();
                System.out.println("Tasa de " + codigo + ": " + tasa);
            } else {
                System.out.println("La moneda " + codigo + " no está disponible.");
            }
        }

        System.out.println("---------------------------");
    }
}
