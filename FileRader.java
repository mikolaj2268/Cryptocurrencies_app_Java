import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.IOException;

public class FileRader {
    public static void main(String[] args) {
        try {
            Object obj = new JSONParser().parse(new FileReader("response.json"));
            JSONObject jo = (JSONObject) obj;
            ArrayList data = (ArrayList) jo.get("data");
            System.out.println(data);
            ArrayList dates = new ArrayList<>();
            ArrayList prices = new ArrayList<>();

            for (Object innerObj : data) {
                JSONObject innerObjPar = (JSONObject) innerObj;
                String date = ((String) innerObjPar.get("date")).substring(0,10);
                dates.add(date);

                String price = (String) innerObjPar.get("priceUsd");
                price = price.substring(0, price.indexOf(".")+2);
                prices.add(price);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
