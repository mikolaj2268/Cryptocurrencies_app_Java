import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyGUI {
    public static void main(String[] args) {
        String currCrypto = "BTC";
//        ArrayList dates = new ArrayList<Date>();
//        ArrayList prices = new ArrayList<String>();
        HashMap<String, java.util.List<Object>> graphDates = new HashMap<>();
        HashMap<String, List<Object>> graphPrices = new HashMap<>();
        try {
            String apiKey = "4ce7fd33-0262-4c66-92ed-e2100d8eb338";
            Unirest.setTimeouts(0, 0);

            // List of asset names to request data for
            java.util.List<String> assetNames = Arrays.asList("bitcoin", "solana", "ethereum", "tether");
            // List to store JSON responses
            java.util.List<org.json.JSONObject> responses = new ArrayList<>();

            for (String assetName : assetNames) {
                // Make request to API for each asset
                HttpResponse<JsonNode> response = Unirest.get("https://api.coincap.io/v2/assets/" + assetName + "/history?interval=d1")
                        .asJson();

                // Get the JSON object from the response
                org.json.JSONObject obj = response.getBody().getObject();
                // Add a field to the JSON object for the asset name
                obj.put("assetName", assetName);
                // Add JSON object to list of response
                responses.add(obj);

            }

            for (int i = 0; i < responses.size(); i++) {
                JSONArray data = (JSONArray) responses.get(i).get("data");
                //System.out.println(data);
                ArrayList dates = new ArrayList<Date>();
                ArrayList prices = new ArrayList<String>();

                for (Object object:data) {
                    //System.out.println(((JSONObject) object).get("date"));
                    org.json.JSONObject innerObjPar = (JSONObject) object;
                    String date = ((String) innerObjPar.get("date")).substring(0,10);
                    dates.add(date);
                    String price = (String) innerObjPar.get("priceUsd");
                    price = price.substring(0, price.indexOf(".")+2);
                    prices.add(price);
                }
                graphDates.put(assetNames.get(i), dates);
                graphPrices.put(assetNames.get(i), prices);
            }
            System.out.println("Calosc");
            System.out.println(graphDates.get("ethereum"));

        } catch (UnirestException e) {
            e.printStackTrace();
        }



        // Create the frame
        JFrame frame = new JFrame("CryptoCurrency.com");
        frame.setLayout(new FlowLayout());
        frame.setSize(9000, 8000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the left panel with buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new StringButton("Bitcoin"));
        leftPanel.add(new StringButton("Etherum"));
        leftPanel.add(new StringButton("Tether"));
        leftPanel.add(new StringButton("Solana"));
        DateButton date1 = new DateButton("From date:");
        leftPanel.add(date1);
        DateButton date2 = new DateButton("To date:");
        leftPanel.add(date2);
        // Create the right panel with the graph
        JPanel rightPanel = new JPanel();
        // create graph
        //ArrayList<Date> gDates = (ArrayList<Date>) graphDates.get(currCrypto.toString());
        //LineChartExample graph1 = new LineChartExample("2002-01-01", "2023-01-01", currCrypto, (ArrayList<Date>) graphDates.get(currCrypto.toString()), (ArrayList<String>) graphPrices.get(currCrypto.toString()));
        rightPanel.setLayout(new BorderLayout());
        //rightPanel.add(graph1.panel, BorderLayout.CENTER);
        rightPanel.validate();



        // Create the "show" button
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the strings from the StringButton and DateButton objects here
                // You can use the getText() method to get the string from a button
                System.out.println("FROM DATE:");
                System.out.println(date1.getDate());
                System.out.println(("TO DATE"));
                System.out.println(date2.getDate());
                rightPanel.removeAll();
                rightPanel.revalidate();
                //LineChartExample graph2 = new LineChartExample(date1.getDate(), date2.getDate(), "BTC", dates, prices);
                rightPanel.setLayout(new BorderLayout());
                //rightPanel.add(graph2.panel, BorderLayout.CENTER);
                rightPanel.validate();
            }
        });

        // Add the panels and button to the frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(showButton, BorderLayout.SOUTH);

        // Pack and display the frame
        frame.pack();
        frame.setVisible(true);


    }
}