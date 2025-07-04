package com.marver.conversor.modulos;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class conexionAPI {
    public static void convertirMoneda(String monedaInicial, String monedaFinal, double cantidad) {
        try {
            String ApiKey = "77a829568b9c080a9e7efd56";
            String direccion = "https://v6.exchangerate-api.com/v6/" + ApiKey + "/latest/" + monedaInicial;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(jsonResponse, JsonObject.class);
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            double tasaMonedaInicial = rates.get(monedaInicial).getAsDouble();
            double tasaMonedaFinal = rates.get(monedaFinal).getAsDouble();

            double resultado = cantidad / tasaMonedaInicial * tasaMonedaFinal;

            System.out.println("=>>> " + cantidad + " " + monedaInicial + " equivale a " + resultado + " " + monedaFinal + " <<<=");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }


    }
}
