package API;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeResponses {
    public static void main(String[] args) {
        // Create a list to store all the responses
        List<JSONObject> responses = new ArrayList<>();

        // Define the file names
        List<String> fileNames = Arrays.asList("solana.json", "ethereum.json", "bitcoin.json", "tether.json");

        for (String fileName : fileNames) {
            try {
                // Read the JSON file
                File file = new File(fileName);
                String content = new String(Files.readAllBytes(file.toPath()));
                // Parse the JSON file to a JSONArray
                JSONArray data = new JSONArray(content);
                for (int i = 0; i < data.length(); i++) {
                    JSONObject row = data.getJSONObject(i);
                    responses.add(row);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Create a new JSONArray to store all the responses
        JSONArray finalData = new JSONArray(responses);

        JSONObject finalResponse = new JSONObject();
        finalResponse.put("data", finalData);

        // Write the object to a file
        try (FileWriter file = new FileWriter("final_response.json")) {
            file.write(finalResponse.toString());
            System.out.println("Successfully saved final JSON object to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}