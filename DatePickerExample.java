import java.util.Date;
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

public class DatePickerExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CryptoCurrency.com");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the "Choose Date" button
        JButton chooseDateButton = new JButton("Choose Date");

        // Create the date picker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        // Add an action listener to the "Choose Date" button
        chooseDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, show the date picker
                datePicker.setVisible(true);

            }
        });

        // Add the button and date picker to the frame
        frame.add(chooseDateButton);
        frame.add(datePicker);

        frame.setVisible(true);

    }
}
