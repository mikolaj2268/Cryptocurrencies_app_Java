import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;
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
        TimeSeriesCollection dataset = createDataset(name, startDate, endDate);
        // Create chart
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                name.toUpperCase(), // Chart title
                "Date", // X-Axis Label
                "USD$", // Y-Axis Label
                dataset,
                false,
                true,
                true
        );
        chart.setBackgroundPaint(Color.black);
        chart.getPlot().setBackgroundPaint(Color.black);
        chart.getTitle().setPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        setAxisFontColor(axis, Color.white);
        Axis axis1 = plot.getRangeAxis();
        setAxisFontColor(axis1, Color.white);

        this.panel = new ChartPanel(chart);
    }

    private void setAxisFontColor(Axis axis, Color fontColour) {
            axis.setLabelPaint(fontColour);
            axis.setTickLabelPaint(fontColour);

    }

    private TimeSeriesCollection createDataset(String name, String startDate, String endDate){
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

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries series = new TimeSeries(name);
        for (int i = 0; i < dates.size(); i++) {
            if(dates.get(i).compareTo(startDateP)>0 & endDateP.compareTo(dates.get(i))>0) {
                series.add(new Day(dates.get(i)),Float.valueOf(prices.get(i)));
            }
        }
        dataset.addSeries(series);
        return dataset;
    }

}  