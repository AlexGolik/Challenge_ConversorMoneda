package com.alura.api;

import com.alura.dto.ConvertDTO;
import com.google.gson.Gson;
import com.alura.dto.ConvertUnit;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class pointAPI {
    private final String apiKey = System.getenv("API_KEY");
    private final String apiUrl = System.getenv("API_URL");

    public ConvertDTO getCurrencyConverter(ConvertUnit unit, ConvertUnit target, Double amount) {
        URI url = URI.create(apiUrl + apiKey + "/pair/" + unit.name() + "/" + target.name() + "/" + amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la respuesta de la API: " + response.statusCode());
            }
            return new Gson().fromJson(response.body(), ConvertDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer la conversion revise la request: " + e.getMessage(), e);
        }
    }
}