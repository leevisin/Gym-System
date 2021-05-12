import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VideoDemo extends Interface{

    public VideoDemo(){}

    public JPanel videoPanel(){
        JPanel videoPanel = new JPanel();
        
        JPanel searchPanel = new JPanel();
        JTextField textField = new JTextField(20);
        JButton searchBtn = new JButton("Search Video");
        searchPanel.add(textField);
        searchPanel.add(searchBtn);
        searchPanel.setPreferredSize(new Dimension(1280, 50));
        searchPanel.setBackground(Color.black);
        videoPanel.add(searchPanel);
        



        return videoPanel;
    }
    
    public static void main(String[] args) {
        new VideoDemo();
    }
}
