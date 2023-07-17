import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class RestfulClient {

    public static void main(String[] args) {
        String asyncUrl = "https://jsonplaceholder.typicode.com/posts/1";

        HttpClient customClient = HttpClient.newBuilder().build();

        try {
            HttpRequest asyncRequest = HttpRequest.newBuilder()
                    .uri(new URI(asyncUrl))
                    .GET()
                    .build();

            CompletableFuture<HttpResponse<String>> futureResponse = customClient.sendAsync(asyncRequest,
                    HttpResponse.BodyHandlers.ofString());

            futureResponse.thenAccept(response -> {
                System.out.println("Async GET Request - Response Body: " + response.body());
            }).join();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
