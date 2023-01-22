import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {

    public static void main(String args[]) {
        new Test();
    }

    public Test() {

        super("Test GridBagLayout");

        JPanel contentPanel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        JButton button1 = new JButton("Short");
        JButton button2 = new JButton("Medium");
        JButton button3 = new JButton("Looooong");

        JComboBox comboBox = new JComboBox(new String[] {"These", "Are", "Different", "Selections"});

        // the weights the component should have in concern to them being added to a container that is larger
        // than its preferred size
        c.weightx = 0.5;
        c.weighty = 0.5;

        // the coordinates of the component
        c.gridx = 0;
        c.gridy = 0;

        // the way the component should be "glued" to the container
        c.anchor = GridBagConstraints.LINE_START;

        // the way the component should expand in size if it is placed in a container that is larger
        // than its preferred size
        c.fill = GridBagConstraints.HORIZONTAL;

        contentPanel.add(button1, c);

        // reuse the GridBagContraint, no need to instantiate one for each component
        c.gridy = 1;
        contentPanel.add(button2, c);

        c.gridy = 2;
        contentPanel.add(button3, c);

        c.gridy = 0;
        c.gridx = 1;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(0, 50, 0, 10);
        contentPanel.add(comboBox, c);

        this.getContentPane().add(contentPanel, BorderLayout.CENTER);

        this.pack();

        this.setVisible(true);
    }
}
