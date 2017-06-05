import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 * Created by brandonmazzarella on 6/5/17.
 */
public class PushCounterPanel extends JPanel {

    private int count;
    private JButton push;
    private JLabel label;

    //Constructor: Sets up the GUI; initial values.
    public PushCounterPanel()
    {
        count = 0;
        push = new JButton("Push Me!");
        push.addActionListener(new ButtonListener());

        label = new JLabel("Pushes: " + count);
        add(push);
        add(label);

        setBackground(Color.cyan);
        setPreferredSize(new Dimension(300,40));

    }

    //Creating our own ButtonListener Object
    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent event)
        {
            count++;
            label.setText("Pushes: " + count);
        }

    }

}
