//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.time.Millisecond;
//import org.jfree.data.time.TimeSeries;
//import org.jfree.data.time.TimeSeriesCollection;
//import yahoofinance.Stock;
//import yahoofinance.YahooFinance;
//import yahoofinance.histquotes.HistoricalQuote;
//import yahoofinance.histquotes.Interval;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.*;
//
//import javax.swing.*;
//
//public class YahooFetcher {
//
//    public static void main(String[] args) throws IOException {
//
//        //creating a list of symbols (Wikipedia - DJIA)
//        List<String> indecies_companies = new ArrayList<>();
//        indecies_companies.add("DJIA");
////        indecies_companies.add("NKE");
////        indecies_companies.add("IBM");
////        indecies_companies.add("GS");
////        itd
//
//        //for each symbol_name we display a graph
//        for (String ind: indecies_companies){
//            DisplayGraph(ind);
//        }
//    }
//
//
//    public static JFreeChart GenerateChart(String name_of_index, Calendar from_date, Calendar to_date){
//        //function generates an object JFreeChart based on index and date
//
//        try {
//            TimeSeriesCollection dataset = new TimeSeriesCollection();
//            Stock stock = YahooFinance.get(name_of_index, from_date, to_date, Interval.DAILY);
//            List<HistoricalQuote> historystock = stock.getHistory();
//            TimeSeries series = new TimeSeries("Stock Prices");
//            for (HistoricalQuote quote : historystock) {
//                Date x = quote.getDate().getTime();
//                double y = quote.getClose().doubleValue();
//                series.add(new Millisecond(x), y);
//            }
//
//            dataset.addSeries(series);
//
//            JFreeChart chart = ChartFactory.createTimeSeriesChart(
//                    name_of_index + " Index", // chart title
//                    "Date", // x-axis label
//                    "Value", // y-axis label
//                    dataset, // data set
//                    true, // include legend
//                    true, // tooltips
//                    false // urls
//            );
//
//            return chart;
//        } catch (Exception e) {
//            System.out.println("Blad" + e.getMessage());
//        }
//        return null;
//    }
//
//    public static void DisplayGraph(String index_name) throws IOException {
//        //function displays a graph based on index_name. The date range is 3 years.
//
//        Calendar from = Calendar.getInstance();
//        Calendar to = Calendar.getInstance();
//        from.add(Calendar.YEAR, -3);
//        JFreeChart chart = GenerateChart(index_name, from, to);
//
//        ChartPanel panel = new ChartPanel(chart);
//
//        JFrame frame = new JFrame("Chart");
//        frame.setContentPane(panel);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void Yahoo_data_test() throws IOException {
//        //function to get to know better this Yahoo api
//
//        Calendar from = Calendar.getInstance();
//        Calendar to = Calendar.getInstance();
//        from.add(Calendar.YEAR, -5);
//        Stock stock = YahooFinance.get("NKE", from, to, Interval.DAILY);
//        List<HistoricalQuote> historyGoogle = stock.getHistory();
//
//
//        System.out.println(historyGoogle.get(1));
//        System.out.println(historyGoogle.get(2));
//        System.out.println(historyGoogle.get(historyGoogle.size()-1));
//        System.out.println(historyGoogle.get(1).getClass());
//
//        HistoricalQuote dzien1 = historyGoogle.get(historyGoogle.size()-1);
//        System.out.println("OPEN:" +dzien1.getDate().getTime());
//
//
//        BigDecimal price2 = stock.getQuote(true).getPrice();
//        System.out.println(price2);
//
//    }
//
//}
