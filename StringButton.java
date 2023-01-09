import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class StringButton extends JButton {
    private String str;
    static ArrayList<String> cryptoList = new ArrayList<String>();
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
        cryptoList.add(str);
    }

    public String getString() {
        return str;
    }
}