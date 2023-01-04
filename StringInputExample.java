import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class StringInputExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("String Input Example");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the "Enter String" button
        JButton enterStringButton = new JButton("Enter String");

        // Create the text field where the user can enter a string
        final JTextField stringInputField = new JTextField(20);

        // Add an action listener to the "Enter String" button
        enterStringButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, get the string from the text field
                String inputString = stringInputField.getText();
                // Print the string to the console
                System.out.println("Entered string: " + inputString);
            }
        });

        // Add the button and text field to the frame
        frame.add(enterStringButton);
        frame.add(stringInputField);

        frame.setVisible(true);
    }
}
