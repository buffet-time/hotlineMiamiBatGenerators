package main;

import javax.swing.*;

///
/// Created by Buffet Time
/// Started on April 27th, 2016
///


public class driver
{
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
