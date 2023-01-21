import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyGUI {
    public static void main(String[] args) {
        try {UIManager.setLookAndFeel( new FlatLightLaf() );}
        catch( Exception e ) { e.printStackTrace();}
        String currCrypto = "bitcoin";
        FileReaderJ readerJ = new FileReaderJ();
        readerJ.readFile("response.json");
        HashMap<String, ArrayList<Date>> graphDates = readerJ.getGraphDates();
        HashMap<String, ArrayList<String>> graphPrices = readerJ.getGraphPrices();
        System.out.println(graphPrices.get(currCrypto));
        System.out.println(graphDates.get(currCrypto));

        // Create the frame
        JFrame frame = new JFrame("CryptoCurrency.com");
        frame.setLayout(new FlowLayout());
        frame.setSize(9000, 8000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the left panel with buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        StringButton s1 = new StringButton("Bitcoin");
        leftPanel.add(s1);
        StringButton s2 = new StringButton("Ethereum");
        leftPanel.add(s2);
        StringButton s3 = new StringButton("Tether");
        leftPanel.add(s3);
        StringButton s4 = new StringButton("Solana");
        leftPanel.add(s4);
        DateButton date1 = new DateButton("From date:");
        leftPanel.add(date1);
        DateButton date2 = new DateButton("To date:");
        leftPanel.add(date2);
        // Create the right panel with the graph
        JPanel rightPanel = new JPanel();
        // create graph


        LineChart graph1 = new LineChart("2002-01-01", "2023-01-01", currCrypto, graphDates.get(currCrypto),graphPrices.get(currCrypto));
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
                int size = s1.cryptoList.size();
                String currCrypto = (s1.cryptoList.get(size - 1)).toLowerCase();
                rightPanel.removeAll();
                rightPanel.revalidate();
                LineChart graph2 = new LineChart(date1.getDate(), date2.getDate(), currCrypto, graphDates.get(currCrypto),graphPrices.get(currCrypto));
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