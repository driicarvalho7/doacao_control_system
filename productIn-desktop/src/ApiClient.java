import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    private static final String BASE_URL = "http://localhost:3000/api";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    // Método para realizar login e obter o token JWT
    public static String login(String username, String password) throws Exception {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);

        String requestBody = gson.toJson(credentials);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/auth/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Map<String, String> jsonResponse = gson.fromJson(response.body(), HashMap.class);
            return jsonResponse.get("token");
        } else {
            throw new Exception("Erro ao fazer login: " + response.body());
        }
    }

    // Método para acessar rota protegida com o token JWT
    public static String accessProtectedRoute(String token) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/auth/protected"))
                .header("Authorization", token)  // Passa o token JWT
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Erro ao acessar rota protegida: " + response.body());
        }
    }

    public static void main(String[] args) {
        try {
            // 1. Realiza o login para obter o JWT
            String token = login("user1", "password1");
            System.out.println("Token JWT: " + token);

            // 2. Acessa a rota protegida com o token JWT
            String protectedData = accessProtectedRoute(token);
            System.out.println("Resposta da Rota Protegida: " + protectedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
