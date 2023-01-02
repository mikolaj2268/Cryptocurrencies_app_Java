import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        // Create the date picker buttons
        JButton startDateButton = new JButton("Choose Start Date");
        JButton endDateButton = new JButton("Choose End Date");

        // Set up the event handlers for the buttons
        startDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar startDate = Calendar.getInstance();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl startDatePanel = new JDatePanelImpl(startDate, p);
                JDatePickerImpl startDatePicker = new JDatePickerImpl(startDatePanel, new DateLabelFormatter());
                startDate = (Calendar) startDatePicker.getModel().getValue();
                System.out.println("Selected start date: " + startDate.getTime());
            }
        });

        endDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar endDate = Calendar.getInstance();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl endDatePanel = new JDatePanelImpl(endDate, p);
                JDatePickerImpl endDatePicker = new JDatePickerImpl(endDatePanel, new DateLabelFormatter());
                endDate = (Calendar) endDatePicker.getModel().getValue();
                System.out.println("Selected end date: " + endDate.getTime());
            }
        });

        // Set up the layout
        JPanel panel = new JPanel();
        panel.add(startDateButton);
        panel.add(endDateButton);

        // Set up the frame and show it
        JFrame frame = new JFrame("Date Chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
