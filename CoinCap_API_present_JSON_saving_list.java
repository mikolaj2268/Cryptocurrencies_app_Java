import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CoinCap_API_present_JSON_saving_list {
    public static void main(String[] args) {
        try {
            String apiKey = "4ce7fd33-0262-4c66-92ed-e2100d8eb338";
            Unirest.setTimeouts(0, 0);

            // List of asset names to request data for
            List<String> assetNames = Arrays.asList("bitcoin", "solana", "ethereum", "tether");
            // List to store JSON responses
            List<JSONObject> responses = new ArrayList<>();

            for (String assetName : assetNames) {
                // Make request to API for each asset
                HttpResponse<JsonNode> response = Unirest.get("https://api.coincap.io/v2/assets/" + assetName + "/history?interval=d1")
                        .asJson();

                // Get the JSON object from the response
                JSONObject obj = response.getBody().getObject();
                // Add a field to the JSON object for the asset name
                obj.put("assetName", assetName);
                // Add JSON object to list of responses
                responses.add(obj);
            }

            // Write the object to a file
            try (FileWriter file = new FileWriter("response.json")) {
                // Write all of the responses to the file
                for (JSONObject response : responses) {
                    file.write(response.toString());
                }
                System.out.println("Successfully saved JSON objects to file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}





