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

public class BookConfirm extends Interface{
    public BookConfirm(String trainerName, String trainerType){
        JFrame jf = new JFrame("Confirm Book");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        JPanel labelPanel = new JPanel(new GridLayout(2,1,20,20));
        JPanel comboxPanel = new JPanel(new GridLayout(2,1,20,20));

        JLabel weekLabel = new JLabel("Week:");
        JLabel timeLabel = new JLabel("Time:");
        labelPanel.add(weekLabel, BorderLayout.WEST);
        labelPanel.add(timeLabel, BorderLayout.CENTER);


        weekLabel.setFont(new Font("Microsoft Serif Pro", Font.PLAIN, 20));
        String[] listWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        JComboBox<String> comboBox1 = new JComboBox<String>(listWeek);
        timeLabel.setFont(new Font("Microsoft Serif Pro", Font.PLAIN, 20));
        String[] listTime = {"8:00-10:00","10:00-12:00","13:00-15:00","15:00-17:00","19:00-21:00"};
        JComboBox<String> comboBox2 = new JComboBox<String>(listTime);

        comboxPanel.add(comboBox1, BorderLayout.WEST);
        comboxPanel.add(comboBox2, BorderLayout.CENTER);
        
        JButton confirmBtn = new JButton("Confirm");
        JButton cancelBtn = new JButton("Cancel");
        JPanel btnPanel = new JPanel();
        confirmBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int week = comboBox1.getSelectedIndex() + 1;
                int time = comboBox2.getSelectedIndex() + 1;
                recordBookInfo(trainerName, trainerType, week, time);
                jf.setVisible(false);
                JOptionPane.showMessageDialog(null, "You Have Booked " + trainerName + " Successfully!", "Book Success",JOptionPane.PLAIN_MESSAGE);
            }
        });

        cancelBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jf.setVisible(false);
            }
        });

        btnPanel.add(confirmBtn);
        btnPanel.add(cancelBtn);


        JPanel jp = new JPanel();
        jp.add(labelPanel);
        jp.add(comboxPanel);
        jp.add(btnPanel);
        jf.setContentPane(jp);
    }

    public void recordBookInfo(String trainerName, String trainerType, int week, int time){
        String filename = "texts/BookInfo.txt";
        try {
        FileWriter fileWriter = new FileWriter(filename, true); // It can write at the end of file.
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String userInfo = readCurrentUser();
        writer.write(userInfo.split(",")[0] + "," + trainerName + "," + trainerType + "," + week + "," + time + "\n");
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
}
