import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.nio.file.*;

public class BookInfo extends Interface {

    
    public BookInfo(String trainerName, String trainerType, String imagePath){
        // Show BookInfo Page to User
        // Record the book information into BookInfo.txt
        // Add Back Button

        JFrame frame = new JFrame();
        frame.setTitle("Trainer Detail Infomation");
        frame.pack();
        frame.setSize(1280, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setContentPane(trainerDetailInfo(trainerName, trainerType, imagePath));
    }

    public void recordBookInfo(String trainerName, String trainerType){
        String filename = "Source/BookInfo.txt";
        try {
        FileWriter fileWriter = new FileWriter(filename, true); // It can write at the end of file.
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String userInfo = readCurrentUser();
        writer.write(userInfo.split(",")[0] + "," + trainerName + "," + trainerType +"\n");
        writer.close();
        fileWriter.close();
        } catch (Exception e) {
        System.out.println("File Writer error!");
        }

    }

    public String readCurrentUser(){
        String userInfo = "";
        try{
            FileReader fileReader = new FileReader("Source/currentuser.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneLine = bufferedReader.readLine();
                userInfo += oneLine;
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e) {
            System.out.println("Errors occured: IOException!");
            System.exit(1);
        }     
        return userInfo;
    }

    public static void Button_Back(JButton Button,String ImagePath){

        Button.setBounds(0, 0, 300, 200);
        ImageIcon imageBack = new ImageIcon(ImagePath);
        Image suitable = imageBack.getImage().getScaledInstance(Button.getWidth(), Button.getHeight(), imageBack.getImage().SCALE_DEFAULT);
        imageBack = new ImageIcon(suitable);
        Button.setIcon(imageBack);
        Button.setToolTipText("image");
        Button.setBorderPainted(false);
        Button.setFocusPainted(false);
        Button.setVerticalTextPosition(JButton.BOTTOM);
        Button.setHorizontalTextPosition(JButton.CENTER);
    }

    public JPanel trainerDetailInfo(String trainerName, String trainerType, String imagePath){
        JPanel infoPanel = new JPanel(new BorderLayout());
        JPanel imagesPanel = new JPanel();
        JPanel textPanel = new JPanel(new BorderLayout());
        JButton bookBtn = new JButton("Click to Book Trainer");
        JButton returnBtn = new JButton("Return");

        JPanel namePanel = trainerName(trainerName);
        JPanel typePanel = trainerType(trainerType);
        namePanel.add(typePanel);
        typePanel.add(new JLabel("Trainer Introduction"));
        textPanel.add(namePanel, BorderLayout.NORTH);


        bookBtn.setSize(50,50);
        bookBtn.setBackground(Color.YELLOW);
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.add(bookBtn, BorderLayout.CENTER);

        btnPanel.add(returnBtn, BorderLayout.EAST);

        JPanel blankPanel = new JPanel();
        blankPanel.setPreferredSize(new Dimension(10, 20));
        btnPanel.add(blankPanel, BorderLayout.SOUTH);
        
        textPanel.add(btnPanel, BorderLayout.SOUTH);





        imagesPanel.add(trainerPicture(imagePath));
        

        infoPanel.add(imagesPanel, BorderLayout.WEST);
        infoPanel.add(textPanel, BorderLayout.CENTER);
        return infoPanel;
    }

    public JButton trainerPicture(String imagePath){
        ImageIcon icon = new ImageIcon(imagePath);
        JButton trainerBtn = new JButton(icon);
        trainerBtn.setMaximumSize(new Dimension(600,828));
        trainerBtn.setIcon(icon);
        trainerBtn.setHideActionText(true);
        trainerBtn.setToolTipText("Click to Show Detail Information");
        trainerBtn.setBorderPainted(false);
        trainerBtn.setContentAreaFilled(false);
        trainerBtn.setFocusPainted(false);
        trainerBtn.setVerticalTextPosition(JButton.BOTTOM);
        trainerBtn.setHorizontalTextPosition(JButton.CENTER);
        return trainerBtn;
    }

    public JPanel trainerName(String trainerName){
        JPanel trainerNamePanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(trainerName);
        label.setFont(new Font(null, Font.BOLD, 150));
        label.setHorizontalAlignment(SwingConstants.LEFT);

        trainerNamePanel.add(label, BorderLayout.NORTH);
        return trainerNamePanel;
    }

    public JPanel trainerType(String trainerType){
        JPanel trainerTypePanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(trainerType + "   ");
        label.setFont(new Font(null, Font.ITALIC, 50));
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        trainerTypePanel.add(label, BorderLayout.NORTH);
        return trainerTypePanel;
    }
}

