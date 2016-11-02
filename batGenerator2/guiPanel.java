package main;

//Imports
        import javax.swing.*;
        import java.awt.*;
        import java.io.*;
        import java.awt.event.*;

// guiPanel Class
class guiPanel extends JPanel implements ActionListener
{
    private JTextField pathTyped, copyPathTyped;
    private JLabel statusLabel;

    //Constructor
    guiPanel()
    {
        /// Declaring what each of the labels/ buttons/ text entry are

        JLabel pathInputLabel = new JLabel("Read the README to know what to put in each input field.");
        pathTyped = new JTextField(40);
        pathTyped.addActionListener(new pathListener());
        copyPathTyped = new JTextField(40);
        copyPathTyped.addActionListener(new pathListener());
        JButton goButton = new JButton("Go");
        goButton.addActionListener(this);
        statusLabel = new JLabel("Bat Not Created");

        /// adding them to the frame
        add(pathInputLabel);
        add(pathTyped);
        add(copyPathTyped);
        add(goButton);
        add(statusLabel);

        /// window settings
        setPreferredSize(new Dimension(450, 105));
        setBackground(Color.white);
    }

    /// adding action listener to the button
    private class pathListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String pathTypedInput;
            String copyPathTypedInput;
            do
            {
                /// for pathTyped
                String filler = pathTyped.getText();
                pathTyped.setText(filler);
                pathTypedInput = pathTyped.getText();

                /// for copyPathTyped
                String filler2 = copyPathTyped.getText();
                copyPathTyped.setText(filler2);
                copyPathTypedInput = copyPathTyped.getText();

            }
            while (pathTypedInput.equalsIgnoreCase(copyPathTypedInput));
        }
    }

    private class batCreation extends pathListener
    {
        PrintWriter writer;
        String pathOne = "this will be the directory input";
        String pathTwo = "this will be the directory input for the copying";


        /// Constructor
        batCreation() {
            pathOne = pathTyped.getText();
            pathTwo = copyPathTyped.getText();

            try
            {
                writer = new PrintWriter("HM1 NG Bat.bat", "UTF-8");
                writer.println("@ECHO OFF");
                writer.println("TITLE Buffet Time's HM NG Bat File (Auto-Generated)");
                writer.println("del '" + pathOne + "SaveData.sav'");
                writer.println("copy '" + pathTwo + "SaveData.sav' '" + pathOne + "'");
                writer.close();
                System.out.println("Done writing to file.");
            }

            catch (FileNotFoundException | UnsupportedEncodingException e) {e.printStackTrace();}
        }
    }

    /// sets the button to execute the batCreation
    @Override
    public void actionPerformed(ActionEvent e)
    {
        new batCreation();
        statusLabel.setText("Bat File was successfully created");
    }
}
