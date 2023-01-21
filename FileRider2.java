public class FileRider2 {
    public static void main(String[] args) {
//        try {
//            String apiKey = "4ce7fd33-0262-4c66-92ed-e2100d8eb338";
//            Unirest.setTimeouts(0, 0);

            // List of asset names to request data for
//            List<String> assetNames = Arrays.asList("bitcoin", "solana", "ethereum", "tether");
//            // List to store JSON responses
//            List<org.json.JSONObject> responses = new ArrayList<>();
//
//            for (String assetName : assetNames) {
//                // Make request to API for each asset
//                HttpResponse<JsonNode> response = Unirest.get("https://api.coincap.io/v2/assets/" + assetName + "/history?interval=d1")
//                        .asJson();
//
//                // Get the JSON object from the response
//                org.json.JSONObject obj = response.getBody().getObject();
//                // Add a field to the JSON object for the asset name
//                obj.put("assetName", assetName);
//                // Add JSON object to list of response
//                responses.add(obj);
//
//            }
//            HashMap<String, List<Object>> graphDates = new HashMap<>();
//            HashMap<String, List<Object>> graphPrices = new HashMap<>();
//
//            for (int i = 0; i < responses.size(); i++) {
//                JSONArray data = (JSONArray) responses.get(i).get("data");
//                //System.out.println(data);
//                ArrayList dates = new ArrayList<>();
//                ArrayList prices = new ArrayList<>();
//
//                for (Object object:data) {
//                    //System.out.println(((JSONObject) object).get("date"));
//                    JSONObject innerObjPar = (JSONObject) object;
//                    String date = ((String) innerObjPar.get("date")).substring(0,10);
//                    dates.add(date);
//                    String price = (String) innerObjPar.get("priceUsd");
//                    price = price.substring(0, price.indexOf(".")+2);
//                    prices.add(price);
//                }
//                graphDates.put(assetNames.get(i), dates);
//                graphPrices.put(assetNames.get(i), prices);
////                System.out.println(assetNames.get(i));
////                System.out.println(graphDates);
//
//            }
//            System.out.println("Calosc");
//            System.out.println(graphDates.get("ethereum"));





//            System.out.println("CALA LISTA");
//            System.out.println(bitcoin);
//            System.out.println(responses);


//        try {
//            Object obj = new JSONParser().parse(new FileReader("response.json"));
//            JSONObject jo = (JSONObject) obj;
//            ArrayList data = (ArrayList) jo.get("data");
//            System.out.println(data);
//            ArrayList dates = new ArrayList<>();
//            ArrayList prices = new ArrayList<>();
//
//            for (Object innerObj : data) {
//                JSONObject innerObjPar = (JSONObject) innerObj;
//                String date = ((String) innerObjPar.get("date")).substring(0,10);
//                dates.add(date);
//
//                String price = (String) innerObjPar.get("priceUsd");
//                price = price.substring(0, price.indexOf(".")+2);
//                prices.add(price);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }
    }
}

