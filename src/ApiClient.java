import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    public JsonObject obtenerConversionRates(String monedaBase) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/d308a2f5a9701d9ec4b6d2d2/latest/" + monedaBase.toUpperCase()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error: Código de estado HTTP " + response.statusCode());
        }

        if (!response.headers().firstValue("Content-Type").orElse("").contains("application/json")) {
            throw new IOException("Error: La respuesta no es JSON.");
        }

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

        if (!json.get("result").getAsString().equals("success")) {
            throw new IOException("Error en la API: " + json.get("error-type").getAsString());
        }

        return json.getAsJsonObject("conversion_rates");
    }
}

