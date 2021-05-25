import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminPanel extends Interface{

    JPanel adminPanel = new JPanel(new BorderLayout());

    public AdminPanel(){

    }

    public JPanel AdminsterPanel(){
        
        JButton addVideoBtn = new JButton("Add Video");
        JButton addTrainerBtn = new JButton("Add Trainer");
        JButton removeVideoBtn = new JButton("Remove Video");
        JButton removeTrainerBtn = new JButton("Remove Trainer");

        addVideoBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                adminPanel.removeAll();
                adminPanel.add(addVideoPanel());
            }
        });


        JPanel btnPanel = new JPanel(new GridLayout(2,2,50,50));
        btnPanel.setPreferredSize(new Dimension(300,300));
        btnPanel.add(addVideoBtn);
        btnPanel.add(addTrainerBtn);
        btnPanel.add(removeVideoBtn);
        btnPanel.add(removeTrainerBtn);

        adminPanel.add(btnPanel, BorderLayout.CENTER);
        return adminPanel;
    }

    public JPanel addVideoPanel(){
        JPanel addVideoPanel = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new GridLayout(6,1));
        JPanel rightPanel = new JPanel(new GridLayout(6,1));
        JTextField videoNameArea = new JTextField(20);
        JTextField videoTimeArea = new JTextField(20);
        JTextField filePathArea = new JTextField(20);
        JTextField tagArea = new JTextField(20);
        JTextField vipArea = new JTextField(20);

        JButton confirmBtn = new JButton("Confirm");
        JButton cancelBtn = new JButton("Cancel");

        cancelBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                adminPanel.removeAll();
                adminPanel.add(new AdminPanel().AdminsterPanel());
            }
        });

        leftPanel.add(new JLabel("Video Name: "));
        leftPanel.add(new JLabel("Video Time: "));
        leftPanel.add(new JLabel("Video File Path: "));
        leftPanel.add(new JLabel("Video Tag: "));
        leftPanel.add(new JLabel("Video VIP(0-free, 1-VIP, 2-SVIP): "));
        leftPanel.add(confirmBtn);


        rightPanel.add(videoNameArea);
        rightPanel.add(videoTimeArea);
        rightPanel.add(filePathArea);
        rightPanel.add(tagArea);
        rightPanel.add(vipArea);
        rightPanel.add(cancelBtn);

        confirmBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println(videoNameArea.getText());
                System.out.println(Integer.parseInt(videoTimeArea.getText()));
                System.out.println(filePathArea.getText());
                System.out.println(tagArea.getText());
                System.out.println(Integer.parseInt(vipArea.getText()));
                addVideo(videoNameArea.getText(), Integer.parseInt(videoTimeArea.getText()), filePathArea.getText(), tagArea.getText(), Integer.parseInt(vipArea.getText()));
            }
        });

        addVideoPanel.add(leftPanel, BorderLayout.WEST);
        addVideoPanel.add(rightPanel, BorderLayout.CENTER);
        return addVideoPanel;
    }
}
