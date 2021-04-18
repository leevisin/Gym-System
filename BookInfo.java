import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

public class BookInfo extends JFrame{
    public BookInfo(String trainerName, String trainerType){
        JLabel info = new JLabel("You have booked " + trainerName + "'s " + trainerType + " course successfully!",JLabel.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add("Center",info);
        getContentPane().add(panel);
    }
}
