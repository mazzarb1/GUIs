/**
 * Created by brandonmazzarella on 6/5/17.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.URL;
import java.util.Random;


public class JukeBoxControls extends JPanel {

    private JComboBox<String> soundsCombo;
    private JButton playButton;
    private AudioClip[] sounds;
    private AudioClip current;


    //Set up the GUI

    public JukeBoxControls()
    {
        URL url1, url2, url3;
        url1 = url2 = url3 = null;

        //Obtain audio Sources

        try
        {
            url1 = new URL("file","localhost","Eee.wav");
            url2 = new URL("file","localhost","Erin's A Pony.wav");
            url3 = new URL("file","localhost","Chew.wav");
        }
        catch (Exception exception){
            System.out.println("Couldn't find files");
        }

        sounds = new AudioClip[4];
        sounds[0] = null; //Selection Box
        sounds[1] = JApplet.newAudioClip(url1);
        sounds[2] = JApplet.newAudioClip(url2);
        sounds[3] = JApplet.newAudioClip(url3);

        //String list of combo box options
        String[] soundNames = {"Make a selection...", "Eee","Erin's A Pony","Chew"};

        soundsCombo = new JComboBox<String>(soundNames);
        soundsCombo.setBackground(Color.cyan);

        //Setting up the buttons
        playButton = new JButton ("Play");
        JButton stopButton = new JButton("Stop");
        JButton random = new JButton("Random");

        setPreferredSize(new Dimension(240,100));

        add(soundsCombo);
        add(playButton);
        add(stopButton);
        add(random);


        soundsCombo.addActionListener(new ComboListener());
        stopButton.addActionListener(new ButtonListener());
        playButton.addActionListener(new ButtonListener());
        random.addActionListener(new RandomButtonListener());

        current = null;



    }


    private class ComboListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (current != null)
                current.stop();
            current = sounds[soundsCombo.getSelectedIndex()];
        }
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if (current != null)
                current.stop();

            if(event.getSource() == playButton)
                if(current != null)
                    current.play();

        }

    }

    private class RandomButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            Random rand = new Random();
            int n = rand.nextInt(3) + 1;
            current = sounds[n];
            current.play();

        }
    }

}
