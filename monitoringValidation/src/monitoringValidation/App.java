package monitoringValidation;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {

    public static void main(String[] args) throws Exception {
        // --- Paraméterek (a curl-ből) ---
        String evaluationId = "12345"; // Ez helyettesíti a $1 változót
        String token = System.getenv("TOKEN"); // Jenkinsben/OS-ben beállított környezeti változó (mint $token)
        
        if (token == null || token.isEmpty()) {
            throw new IllegalStateException("TOKEN environment variable is not set!");
        }

        // --- URL felépítése ---
        String url = "https://avs-backend.cfapps.eu10.hana.ondemand.com/api/v2/evaluationmetadata/"
                     + evaluationId + "/children";

        // --- HttpClient ---
        HttpClient client = HttpClient.newHttpClient();

        // --- HttpRequest beállítása ---
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("accept", "application/json")
                .GET()
                .build();

        // --- Kérés elküldése és válasz feldolgozása ---
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // --- Kiíratás ---
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body:\n" + response.body());
    }
}