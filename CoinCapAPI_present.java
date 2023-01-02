import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class CoinCapAPI_present {
    public static void main(String[] args) throws IOException {
        String apiUrl = "https://api.coincap.io/v2/assets?limit=2"; // API endpoint for top 2 cryptocurrencies

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String apiResponse = in.lines().collect(Collectors.joining());
        in.close();

        System.out.println(apiResponse);
    }
}

