/*
 * @Author: your name
 * @Date: 2021-03-31 21:40:58
 * @LastEditTime: 2021-04-10 15:42:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Video-Live\BookInfo.java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.nio.file.*;

public class BookInfo extends JFrame {

    public BookInfo(String trainerName, String trainerType){
        recordBookInfo(trainerName, trainerType);
        JLabel info = new JLabel("You have booked " + trainerName + "'s " + trainerType + " course successfully!",JLabel.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add("Center",info);
        getContentPane().add(panel);
    }

    public void recordBookInfo(String trainerName, String trainerType){
        String filename = "BookInfo.txt";
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
            FileReader fileReader = new FileReader("currentuser.txt");
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

}

