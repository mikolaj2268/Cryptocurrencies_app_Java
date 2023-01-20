package API;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.FileWriter;
import java.io.IOException;

public class CoinCap_API_present_JSON {
    public static void main(String[] args) {
        try {
            String apiKey = "4ce7fd33-0262-4c66-92ed-e2100d8eb338";
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response = Unirest.get("https://api.coincap.io/v2/rates/bitcoin")
                    .asJson();

            // Print status code and body of the response
            System.out.println("Status code: " + response.getStatus());
            System.out.println("Response body: " + response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }


    }
}


