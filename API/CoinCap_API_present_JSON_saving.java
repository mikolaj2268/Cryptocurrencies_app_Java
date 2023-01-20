package API;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CoinCap_API_present_JSON_saving {
    public static void main(String[] args) {
        try {
            String apiKey = "4ce7fd33-0262-4c66-92ed-e2100d8eb338";
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response = Unirest.get("https://api.coincap.io/v2/assets/bitcoin/history?interval=d1")
                    .asJson();

            System.out.println("Status code: " + response.getStatus());
            System.out.println("Response body: " + response.getBody());
            // Get the JSON object from the response
            JSONObject obj = response.getBody().getObject();

            // Write the object to a file
            try (FileWriter file = new FileWriter("API/response.json")) {
                file.write(obj.toString());
                System.out.println("Successfully saved JSON object to file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}



