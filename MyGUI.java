
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyGUI {
    public static void main(String[] args) {
        String currCrypto = "BTC";
        // Create the frame
        JFrame frame = new JFrame("CryptoCurrency.com");
        frame.setLayout(new FlowLayout());
        frame.setSize(9000, 8000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the left panel with buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new StringButton("Bitcoin"));
        leftPanel.add(new StringButton("Etherum"));
        leftPanel.add(new StringButton("Tether"));
        leftPanel.add(new StringButton("Solana"));
        DateButton date1 = new DateButton("From date:");
        leftPanel.add(date1);
        DateButton date2 = new DateButton("To date:");
        leftPanel.add(date2);
        // Create the right panel with the graph
        JPanel rightPanel = new JPanel();
        // create graph

        LineChartExample graph1 = new LineChartExample("01.01.2002", "01.01.2020", currCrypto);
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(graph1.panel, BorderLayout.CENTER);
        rightPanel.validate();



        // Create the "show" button
        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the strings from the StringButton and DateButton objects here
                // You can use the getText() method to get the string from a button
                System.out.println("FROM DATE:");
                System.out.println(date1.getDate());
                System.out.println(("TO DATE"));
                System.out.println(date2.getDate());
                rightPanel.removeAll();
                rightPanel.revalidate();
                LineChartExample graph2 = new LineChartExample(date1.getDate(), date2.getDate(), "ETHERUM");
                rightPanel.setLayout(new BorderLayout());
                rightPanel.add(graph2.panel, BorderLayout.CENTER);
                rightPanel.validate();
            }
        });

        // Add the panels and button to the frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(showButton, BorderLayout.SOUTH);

        // Pack and display the frame
        frame.pack();
        frame.setVisible(true);


    }
}