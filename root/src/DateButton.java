import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class DateButton extends JButton implements ActionListener {

    // JDatePicker used to display the current date
    private JDatePicker datePicker;

    // Date selected by the user
    private Calendar selectedDate;

    public DateButton(String text) {
        super(text);

        // Initialize the JDatePicker and add it to the button
        datePicker = new JDatePicker();
        this.addActionListener(this);
        this.add(datePicker);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected date from the JDatePicker


        selectedDate = (Calendar) datePicker.getModel().getValue();

    }

    public String getDate() {
        int year = selectedDate.get(Calendar.YEAR);
        int month = selectedDate.get(Calendar.MONTH) + 1; // Month is 0-based
        int day = selectedDate.get(Calendar.DAY_OF_MONTH);
        return String.format("%d-%02d-%02d", year, month, day);
    }
}