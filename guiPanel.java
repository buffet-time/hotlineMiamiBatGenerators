package main;

//Imports
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

// guiPanel Class
public class guiPanel extends JPanel implements ActionListener {
    private JTextField pathTyped;
    public JLabel statusLabel;

    //Constructor
    public guiPanel() {
        /// Declaring what each of the labels/ buttons/ text entry are

        JLabel pathInputLabel = new JLabel("Path to SaveData.sav: ");
        pathTyped = new JTextField(40);
        pathTyped.addActionListener(new pathListener());
        JButton goButton = new JButton("Go");
        goButton.addActionListener(this);
        statusLabel = new JLabel("Bat Not Created");

        /// adding them to the frame
        add(pathInputLabel);
        add(pathTyped);
        add(goButton);
        add(statusLabel);

        /// window settings
        setPreferredSize(new Dimension(450, 120));
        setBackground(Color.white);
    }


    /// adding action listener to the button
    private class pathListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String blah;
            do {
                String filler = pathTyped.getText();
                pathTyped.setText(filler);
                blah = pathTyped.getText();
            }
            while (blah.equalsIgnoreCase(""));
        }
    }


    public class batCreation extends pathListener {
        PrintWriter writer;
        String placeHolder = "this will be the directory input";


        /// Constructor
        public batCreation() {
            placeHolder = pathTyped.getText();
            try {
                writer = new PrintWriter("HM1 NG Bat.bat", "UTF-8");
                writer.println("@ECHO OFF");
                writer.println("TITLE Buffet Time's HM1 NG Bat File (Auto-Generated)");
                writer.println("del '" + placeHolder + "SaveData.sav'");
                writer.close();
                System.out.println("Done writing to file.");
                }
            catch (FileNotFoundException e) {e.printStackTrace();}
            catch (UnsupportedEncodingException e) {e.printStackTrace();
            }
        }
    }


    /// sets the button to execute the batCreation
    @Override
    public void actionPerformed(ActionEvent e) {
        new batCreation();
        statusLabel.setText("Bat File was successfully created");
    }
}
