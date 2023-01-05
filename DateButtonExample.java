import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateButtonExample {
    private JFrame frame;
    private DateButton dateButton;
    private JTextField dateField;

    public DateButtonExample() {
        // Initialize the frame
        frame = new JFrame("My GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Initialize the DateButton and add it to the frame
        dateButton = new DateButton("Choose Date");
        frame.add(dateButton, BorderLayout.NORTH);

        // Initialize the text field and add it to the frame
        dateField = new JTextField();
        frame.add(dateField, BorderLayout.SOUTH);

        // Add an action listener to the DateButton
        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the text of the text field to the selected date
                dateField.setText(dateButton.getDate());
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DateButtonExample();
    }
}
