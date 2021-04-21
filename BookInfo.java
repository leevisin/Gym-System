/*
 * @Author: your name
 * @Date: 2021-03-31 21:40:58
 * @LastEditTime: 2021-04-10 15:42:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Video-Live\BookInfo.java
 *  
 * updated on 2021/4/21 21:12
 * able to recording booking information in text file
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.nio.charset.StandardCharsets;

public class BookInfo extends JFrame {

    public BookInfo(String trainerName, String trainerType){
        /*showing responds to user*/
        JLabel info = new JLabel("You have booked " + trainerName + "'s " + trainerType + " course successfully!",JLabel.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add("Center",info);
        getContentPane().add(panel);

        /*recording booking information in text file*/
        /*getting current user*/
        BufferedReader br = null;
		InputStreamReader reader = null;
        String allinfo = null;
        String[] userinfo = null;
        String currentaccount = null;


        try{
			reader = new InputStreamReader(new FileInputStream(new File(Util.currentuser)), StandardCharsets.UTF_8);
            br = new BufferedReader(reader);
			allinfo = br.readLine(); //obtain all information of current user
			userinfo = allinfo.split(",");
			currentaccount = userinfo[0];
            br.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        /*appending booking information into text file*/
        OutputStreamWriter writer = null;
        try{
            writer = new OutputStreamWriter(new FileOutputStream(new File("bookinginfo.txt"),true), StandardCharsets.UTF_8);
            String bookinfo = currentaccount+',' + trainerName+',' + trainerType+"\n";            
            writer.append(bookinfo);                                                        //need to check for multiple registration later
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        
        


    }
}

