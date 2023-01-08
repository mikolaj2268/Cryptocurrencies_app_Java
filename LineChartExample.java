import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LineChartExample {
    public ChartPanel panel;
    private JFreeChart chart;
    private ArrayList<Date> dates;
    private ArrayList<String> prices;

    public LineChartExample(String startDate, String endDate, String name, ArrayList<Date> dates,  ArrayList<String> prices) {
        // Create dataset
        this.dates = dates;
        this.prices = prices;
        DefaultCategoryDataset dataset = createDataset(name, startDate, endDate);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                name, // Chart title
                "Date", // X-Axis Label
                "USD$", // Y-Axis Label
                dataset
        );
        chart.setBackgroundPaint(Color.white);
        chart.getPlot().setBackgroundPaint(Color.black);
        this.panel = new ChartPanel(chart);
    }

    private DefaultCategoryDataset createDataset(String name, String startDate, String endDate) {
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate1 = null;
        Date endDate1 = null;
        try {
            startDate1 = sdformat.parse(startDate);
            endDate1 = sdformat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String series1 = "BTC";
        String series2 = "ETHERUM";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if(name == "BTC") {
            Boolean range = false;
            for (int i = 0; i < dates.size(); i++) {
                if(dates.get(i).compareTo(startDate1)>0 & endDate1.compareTo(dates.get(i))>0) {
                    dataset.addValue(Float.valueOf(prices.get(i)), series1, dates.get(i));
                }
            }
        } else {
            dataset.addValue(150, series2, "2016-12-19");
            dataset.addValue(130, series2, "2016-12-20");
            dataset.addValue(95, series2, "2016-12-21");
            dataset.addValue(195, series2, "2016-12-22");
            dataset.addValue(200, series2, "2016-12-23");
            dataset.addValue(180, series2, "2016-12-24");
            dataset.addValue(230, series2, "2016-12-25");
        }
        return dataset;
    }

}  