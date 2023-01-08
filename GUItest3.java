import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GUItest3 {

    float tempCtr;

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyGraphPanel myGraphPanel = new MyGraphPanel();
        f.add(myGraphPanel, BorderLayout.CENTER);
        f.add(new JButton(new AbstractAction("+1") {
            @Override
            public void actionPerformed(ActionEvent e) {
                XYSeries mySeries = myGraphPanel.myDataset.getSeries(0);
                mySeries.addOrUpdate(tempCtr, Math.pow(2, tempCtr));
                tempCtr++;
            }
        }), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    class MyGraphPanel extends JPanel {

        JFreeChart myChart;
        ChartPanel chartPanel;
        XYSeriesCollection myDataset;

        private MyGraphPanel() {
            setLayout(new GridLayout());
            XYSeries myData = new XYSeries("My data");
            myData.add(tempCtr, tempCtr++);
            myData.add(tempCtr, tempCtr++);
            myDataset = new XYSeriesCollection();
            myDataset.addSeries(myData);
            myChart = ChartFactory.createXYLineChart("My chart", "X axis", "Y axis",
                    myDataset, PlotOrientation.VERTICAL, true, true, false);
            chartPanel = new ChartPanel(myChart);
            this.add(chartPanel);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(512, 256);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new GUItest3()::display);
    }
}