import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LineChart {
    public ChartPanel panel;
    private JFreeChart chart;
    private ArrayList<Date> dates;
    private ArrayList<String> prices;

    public LineChart(String startDate, String endDate, String name, ArrayList<Date> dates, ArrayList<String> prices) {
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

    private DefaultCategoryDataset createDataset(String name, String startDate, String endDate){
        DateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

        Date startDateP = null;
        Date endDateP = null;
        try {
            startDateP = sdformat.parse(startDate);
            endDateP = sdformat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String series1 = name;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < dates.size(); i++) {

            if(dates.get(i).compareTo(startDateP)>0 & endDateP.compareTo(dates.get(i))>0) {
                dataset.addValue(Float.valueOf(prices.get(i)), series1, dates.get(i));
            }
        }
        return dataset;
    }

}  