import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoinCapAPI_past_prices {
    public static void main(String[] args) throws IOException {
        String apiUrl = "https://api.coincap.io/v2/assets?limit=2"; // API endpoint for top 2 cryptocurrencies

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String apiResponse = in.lines().collect(Collectors.joining());
        in.close();

        // Parse the API response to get the cryptocurrency IDs
        // Note: This assumes that the API response is in JSON format and uses a JSON library to parse the response
        JSONObject json = new JSONObject(apiResponse);
        JSONArray data = json.getJSONArray("data");
        List<String> cryptocurrencyIds = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            cryptocurrencyIds.add(data.getJSONObject(i).getString("id"));
        }

        // Get the past prices for each cryptocurrency
        for (String id : cryptocurrencyIds) {
            apiUrl = "https://api.coincap.io/v2/assets/" + id + "/history?interval=d1"; // API endpoint for past prices with a 1 day interval

            url = new URL(apiUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            apiResponse = in.lines().collect(Collectors.joining());
            in.close();

            System.out.println(apiResponse);
        }
    }
}

