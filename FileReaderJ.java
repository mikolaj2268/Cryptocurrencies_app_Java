import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FileReaderJ {
    private HashMap<String, ArrayList<Date>> graphDates;
    private HashMap<String, ArrayList<String>> graphPrices;

    public FileReaderJ() {
        graphDates = new HashMap<>();
        graphPrices = new HashMap<>();
    }

    public void readFile(String fileName){
        try {
            Object obj = new JSONParser().parse(new java.io.FileReader(fileName));
            JSONObject jo = (JSONObject) obj;
            ArrayList<JSONObject> data = (ArrayList) jo.get("data");

            String last = "";
            ArrayList dates = new ArrayList<Date>();
            ArrayList prices = new ArrayList<String>();

            for (JSONObject innerObj : data) {
                if(!last.equals((String) innerObj.get("assetName"))){
                    if(!last.equals("")){
                        System.out.println(last);
                        this.graphDates.put((String) innerObj.get("assetName"), dates);
                        this.graphPrices.put((String) innerObj.get("assetName"), prices);
                    }
                    dates = new ArrayList<Date>();
                    prices = new ArrayList<String>();
                }
                last = (String) innerObj.get("assetName");

                String date = ((String) innerObj.get("date")).substring(0,10);
                dates.add(date);

                String price = (String) innerObj.get("priceUsd");
                price = price.substring(0, price.indexOf(".")+4);
                prices.add(price);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, ArrayList<Date>> getGraphDates() {
        return graphDates;
    }

    public HashMap<String, ArrayList<String>> getGraphPrices() {
        return graphPrices;
    }
}
