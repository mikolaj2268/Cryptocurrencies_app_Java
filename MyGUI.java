import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyGUI {
    public static void main(String[] args) {
        String currCrypto = "BTC";
        ArrayList dates = new ArrayList<Date>();
        ArrayList prices = new ArrayList<String>();
        try {
            Object obj = new JSONParser().parse(new FileReader("response.json"));
            JSONObject jo = (JSONObject) obj;
            ArrayList data = (ArrayList) jo.get("data");
            System.out.println(data);
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

            for (Object innerObj : data) {
                JSONObject innerObjPar = (JSONObject) innerObj;
                String date = ((String) innerObjPar.get("date")).substring(0,10);
                Date dateParsed = sdformat.parse(date);
                dates.add(dateParsed);

                String price = (String) innerObjPar.get("priceUsd");
                price = price.substring(0, price.indexOf(".")+2);
                prices.add(price);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }


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
        StringButton s2 = new StringButton("Etherum");
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

        LineChartExample graph1 = new LineChartExample("2002-01-01", "2023-01-01", currCrypto, dates, prices);
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
                LineChartExample graph2 = new LineChartExample(date1.getDate(), date2.getDate(), "BTC", dates, prices);
                rightPanel.setLayout(new BorderLayout());
                rightPanel.add(graph2.panel, BorderLayout.CENTER);
                rightPanel.validate();
                int size = s1.cryptoList.size();
                String CryptoForGraph = s1.cryptoList.get(size - 1);
                System.out.println(CryptoForGraph); //to jest ostatnia kliknieta kryptowaluta
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