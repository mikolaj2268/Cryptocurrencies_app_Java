import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CryptocurrencySelector extends JFrame {
    private JButton button;
    private JPanel panel;
    private JRadioButton bitcoinButton;
    private JRadioButton etherumButton;
    private JRadioButton tetherButton;
    private JRadioButton solanaButton;
    private ButtonGroup buttonGroup;

    public CryptocurrencySelector() {
        // Set up the button
        button = new JButton("Select");
        button.addActionListener(new ButtonListener());

        // Set up the radio buttons
        bitcoinButton = new JRadioButton("Bitcoin");
        etherumButton = new JRadioButton("Etherum");
        tetherButton = new JRadioButton("Tether");
        solanaButton = new JRadioButton("Solana");

        // Group the radio buttons together
        buttonGroup = new ButtonGroup();
        buttonGroup.add(bitcoinButton);
        buttonGroup.add(etherumButton);
        buttonGroup.add(tetherButton);
        buttonGroup.add(solanaButton);

        // Set up the panel
        panel = new JPanel();
        panel.add(bitcoinButton);
        panel.add(etherumButton);
        panel.add(tetherButton);
        panel.add(solanaButton);
        panel.add(button);

        // Add the panel to the frame
        this.add(panel);

        // Set the size and title of the frame
        this.setSize(200, 200);
        this.setTitle("Cryptocurrency Selector");
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedCryptocurrency = "";

            if (bitcoinButton.isSelected()) {
                selectedCryptocurrency = "Bitcoin";
            } else if (etherumButton.isSelected()) {
                selectedCryptocurrency = "Etherum";
            } else if (tetherButton.isSelected()) {
                selectedCryptocurrency = "Tether";
            } else if (solanaButton.isSelected()) {
                selectedCryptocurrency = "Solana";
            }

            System.out.println("Selected cryptocurrency: " + selectedCryptocurrency);
        }
    }

    public static void main(String[] args) {
        CryptocurrencySelector frame = new CryptocurrencySelector();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
