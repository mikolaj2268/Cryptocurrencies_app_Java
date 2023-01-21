package API;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CoinCap_API_present_JSON_saving_list_correct {
    public static void main(String[] args) {
        try {
            String apiKey = "4ce7fd33-0262-4c66-92ed-e2100d8eb338";
            Unirest.setTimeouts(0, 0);

            List<String> assetNames = Arrays.asList("bitcoin", "solana", "ethereum", "tether");

            for (String assetName : assetNames) {
                // Make request to API for each asset
                HttpResponse<JsonNode> response = Unirest.get("https://api.coincap.io/v2/assets/" + assetName + "/history?interval=d1")
                        .asJson();

                // Get the JSON object from the response
                JSONObject obj = response.getBody().getObject();
                JSONArray data = obj.getJSONArray("data");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject row = data.getJSONObject(i);
                    // Add a field to the JSON object for the asset name
                    row.put("assetName", assetName);
                }

                // Write the object to a file
                try (FileWriter file = new FileWriter("API/" + assetName + ".json")) {
                    file.write(data.toString());
                    System.out.println("Successfully saved " + assetName + " JSON objects to file");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }}





