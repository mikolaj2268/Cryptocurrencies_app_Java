import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CoinCap_API_present_string {
    public static void main(String[] args) {
        try {
            String apiKey = "ed845cd1-cd07-4a69-8d2a-1eafd6eff344";
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://api.coincap.io/v2/rates/bitcoin")
                    .asString();

            // Print status code and body of the response
            System.out.println("Status code: " + response.getStatus());
            System.out.println("Response body: " + response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}


