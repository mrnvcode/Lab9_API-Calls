import java.net.http.HttpClient;
import java.time.Duration;


public class HttpClientSetup {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        System.out.println("Basic HttpClient instance created");

        HttpClient customizedHttpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        System.out.println("Customized HttpClient instance created");
    }
}
