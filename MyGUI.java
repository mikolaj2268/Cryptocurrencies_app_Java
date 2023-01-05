import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.sourceforge.jdatepicker.AbstractDateModel;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDateComponent;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.graphics.JNextIcon;
import net.sourceforge.jdatepicker.graphics.JPreviousIcon;
import net.sourceforge.jdatepicker.impl.DateComponentFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import net.sourceforge.jdatepicker.util.JDatePickerUtil;
public class MyGUI {
    public static void main(String[] args) {
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
        JPanel rightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the graph here using g.drawLine(), etc.
            }
        };


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