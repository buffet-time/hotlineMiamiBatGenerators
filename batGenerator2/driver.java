package main;

import javax.swing.*;

public class driver
{
    // just creating the gui all programming is contained in guiPanel.java
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("NG Any% Batch Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiPanel panel = new guiPanel();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.pack();
    }
}
