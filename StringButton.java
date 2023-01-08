import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StringButton extends JButton {
    private String str;

    public StringButton(String str) {
        super(str);
        this.str = str;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }

    public void onClick() {
        System.out.println(str);
    }

    public String getString() {
        return str;
    }
}