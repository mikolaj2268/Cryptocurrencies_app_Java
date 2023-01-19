import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class StringButton extends JButton {
    private String str;
    public static String crypto;
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
        crypto = str;

    }

//    public String getString() {
//        return crypto;
//    }
}