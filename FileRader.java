import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FileRader {
    public static void main(String[] args) {
        try {
            Object obj = new JSONParser().parse(new FileReader("response.json"));
            JSONObject jo = (JSONObject) obj;
            ArrayList<JSONObject> data = (ArrayList) jo.get("data");
            System.out.println(data.get(0));
            HashMap<String, List<Object>> graphDates = new HashMap<>();
            HashMap<String, List<Object>> graphPrices = new HashMap<>();

            String last = "";
            ArrayList dates = new ArrayList<Date>();
            ArrayList prices = new ArrayList<String>();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            for (JSONObject innerObj : data) {
                if(!last.equals((String) innerObj.get("assetName"))){
                    if(!last.equals("")){
                        //System.out.println(last);
                        graphDates.put((String) innerObj.get("assetName"), dates);
                        graphPrices.put((String) innerObj.get("assetName"), prices);
                    }
                    dates = new ArrayList<Date>();
                    prices = new ArrayList<String>();
                }
                last = (String) innerObj.get("assetName");
                //System.out.println(last);

                String date = ((String) innerObj.get("date")).substring(0,10);
                Date dateF = df.parse(date);
                dates.add(dateF);

                System.out.println(dateF.getClass());

                String price = (String) innerObj.get("priceUsd");
                price = price.substring(0, price.indexOf(".")+4);
                prices.add(price);
                //System.out.println(price);
            }
            System.out.println(graphPrices.get("bitcoin"));
            System.out.println(graphDates.get("bitcoin"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}
