/**
 * Created by brandonmazzarella on 6/5/17.
 */

import javax.swing.*;
public class JukeBox {

    public static void main(String[] args){
        JFrame frame = new JFrame("Mazz Sound Generator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JukeBoxControls());

        frame.pack();
        frame.setVisible(true);
    }
}
