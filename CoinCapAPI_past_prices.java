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
        String apiUrl = "https://api.coincap.io/v2/assets?limit=2"; // link do API

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String apiResponse = in.lines().collect(Collectors.joining());
        in.close();

        // Sciaganie danych API
        JSONObject json = new JSONObject(apiResponse);
        JSONArray data = json.getJSONArray("data");
        List<String> cryptocurrencyIds = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            cryptocurrencyIds.add(data.getJSONObject(i).getString("id"));
        }

        // Ceny dla poszczegolnych kryptowalut
        for (String id : cryptocurrencyIds) {
            apiUrl = "https://api.coincap.io/v2/assets/" + id + "/history?interval=d1"; // Interwal 1 dzien

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

