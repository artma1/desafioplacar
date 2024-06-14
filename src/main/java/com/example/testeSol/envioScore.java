package com.example.testeSol;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class envioScore {

    public static void main(String[] args) {
        // Verifique se o argumento do corpo foi fornecido
        if (args.length < 1) {
            System.out.println("Por favor, forneça o corpo da solicitação como um argumento de linha de comando.");
            return;
        }

        String requestBody = args[0];

        try {
            // Crie um objeto URI e depois converta para URL
            URI uri = new URI("http://localhost:8080/verify");
            URL url = uri.toURL();

            // Abra a conexão com o recurso
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defina o método para POST
            connection.setRequestMethod("POST");

            // Defina o tipo de conteúdo para JSON
            connection.setRequestProperty("Content-Type", "application/json");

            // Ative o envio do corpo da solicitação
            connection.setDoOutput(true);

            // Obtenha o OutputStream para escrever o corpo da solicitação
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtenha a resposta do servidor
            int responseCode = connection.getResponseCode();
            System.out.println("Código de Resposta HTTP: " + responseCode);

            // Feche a conexão
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
