import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.nio.file.*;

public class BookInfo extends JFrame {

    
    public BookInfo(String trainerName, String trainerType, String imagePath){
        // Show BookInfo Page to User
        // Record the book information into BookInfo.txt
        // Add Back Button
        JPanel totalPane = new JPanel();
        totalPane.setLayout(new FlowLayout());
        totalPane.setPreferredSize(new Dimension(400, 1000));
        JButton btn = new JButton("You have booked " + trainerName + "'s " + trainerType + " course successfully!");
        Button_Back(btn,imagePath);
        recordBookInfo(trainerName, trainerType);
        //JLabel info = new JLabel("You have booked " + trainerName + "'s " + trainerType + " course successfully!",JLabel.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add("Center",btn);
        //panel.add("Center",info);
        totalPane.add("Center",panel);
        getContentPane().add(panel);
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
}

