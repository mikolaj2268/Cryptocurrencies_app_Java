import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = 0; i < data.size(); i++) {
                JSONObject innerObj = data.get(i);
                if(!last.equals((String) innerObj.get("assetName")) || i == (data.size()-1)){
                    if(!last.equals("")){
                        this.graphDates.put(last, dates);
                        this.graphPrices.put(last, prices);
                    }
                    dates = new ArrayList<Date>();
                    prices = new ArrayList<String>();
                }
                last = (String) innerObj.get("assetName");

                String date = ((String) innerObj.get("date")).substring(0,10);
                Date dateF = df.parse(date);
                dates.add(dateF);


                String price = (String) innerObj.get("priceUsd");
                price = price.substring(0, price.indexOf(".")+4);
                prices.add(price);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
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
