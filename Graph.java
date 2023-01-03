//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.xy.XYDataset;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;
//
//public class Graph extends ApplicationFrame {
//    public Graph(String applicationTitle, String chartTitle) throws IOException {
//        super(applicationTitle);
//
//        // Get the top 2 cryptocurrencies from the CoinCap API
//        String apiUrl = "https://api.coincap.io/v2/assets?limit=2";
//        URL url = new URL(apiUrl);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String apiResponse = in.lines().collect(Collectors.joining());
//        in.close();
//        JSONObject json = new JSONObject(apiResponse);
//        JSONArray data = json.getJSONArray("data");
//        List<String> cryptocurrencyIds = new ArrayList<>();
//        for (int i = 0; i < data.length(); i++) {
//            cryptocurrencyIds.add(data.getJSONObject(i).getString("id"));
//        }
//
//        // Create an XY series for each cryptocurrency
//        List<XYSeries> seriesList = new ArrayList<>();
//        for (String id : cryptocurrencyIds) {
//            XYSeries series = new XYSeries(id);
//
//            // Get the past prices for the cryptocurrency from the CoinCap API
//            apiUrl = "https://api.coincap.io/v2/assets/" + id + "/history?interval=d1";
//            url = new URL(apiUrl);
//            con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            apiResponse = in.lines().collect(Collectors.joining());
//            in.close();
//            json = new JSONObject(apiResponse);
//            JSONArray history = json.getJSONArray("data");
//            for (int i = 0; i < history.length(); i++) {
//                long timestamp = history.getJSONObject(i).getLong("timestamp");
//                double price = history.getJSONObject(i).getDouble("priceUsd");
//                series.add(timestamp
//
