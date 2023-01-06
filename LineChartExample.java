import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;

public class LineChartExample {
    public ChartPanel panel;
    private JFreeChart chart;

    public LineChartExample(String startDate, String endDate, String name) {
        // Create dataset
        DefaultCategoryDataset dataset = createDataset(name);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                name, // Chart title
                "Date", // X-Axis Label
                "USD$", // Y-Axis Label
                dataset
        );

        this.panel = new ChartPanel(chart);
    }

    private DefaultCategoryDataset createDataset(String name) {

        String series1 = "BTC";
        String series2 = "ETHERUM";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        if(name == "BTC") {
            dataset.addValue(200, series1, "2016-12-19");
            dataset.addValue(150, series1, "2016-12-20");
            dataset.addValue(100, series1, "2016-12-21");
            dataset.addValue(210, series1, "2016-12-22");
            dataset.addValue(240, series1, "2016-12-23");
            dataset.addValue(195, series1, "2016-12-24");
            dataset.addValue(245, series1, "2016-12-25");
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