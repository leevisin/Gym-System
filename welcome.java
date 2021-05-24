import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.Math;


public class welcome extends Interface{
    public JPanel adImage;
    public JPanel trainerRC;
    public JPanel videoRC;
    
    
    
    public JPanel adimageJPanel(){
        
        
        
        return adImage;
        
    }
    public JPanel trainerRecommend(){
        //写一个label

        //数组存三个随机数
        int end = readLine("texts/AllTrainer.txt");
        System.out.println("一共有x行"+end);
        int[] randomInt = new int[3];
        randomInt[0]=getRandom(0, end-1);
        do{
            randomInt[1]= getRandom(0, end-1);
        }while(!(randomInt[1]==randomInt[0]));

        do{
            randomInt[2]= getRandom(0, end-1);
        }while(!(randomInt[2]==randomInt[1]||randomInt[2]==randomInt[0]));
        
        System.out.println(randomInt[0]+","+randomInt[1]+","+randomInt[2]);
        //先从文件中把图片读出来for循环把加入
        String[][] trainersInfo = readFromFile("texts/AllTrainer.txt");
        
        for(int i=0; i<trainersInfo.length; i++){

            String trainerName = trainersInfo[i][0];
            String trainerType = trainersInfo[i][1];
            String imagesPath = trainersInfo[i][2];
            String intro = trainersInfo[i][3];
            // Problem intro String can't be too long
            if(i==randomInt[0]||i==randomInt[1]||i==randomInt[2]){
            ImageIcon icon = new ImageIcon(trainersInfo[i][2]);
            
            JButton trainerBtn = new JButton(trainerName + ": " + trainerType, icon);

            trainerBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new BookInfo(trainerName, trainerType, imagesPath, intro);
                }
            });

            trainerBtn.setMaximumSize(new Dimension(600,828));
            trainerBtn.setIcon(icon);
            trainerBtn.setBackground(Color.WHITE);
            trainerBtn.setHideActionText(true);
            trainerBtn.setToolTipText("Click to Show Detail Information");
            trainerBtn.setBorderPainted(false);
            trainerBtn.setFocusPainted(false);
            trainerBtn.setVerticalTextPosition(JButton.BOTTOM);
            trainerBtn.setHorizontalTextPosition(JButton.CENTER);
            trainerRC.add(trainerBtn);
            }
        }




        return trainerRC; 
    }

    
    
    public JPanel videoRecommend(){
        return videoRC;


    }

    public static int getRandom(int start, int end){
        return (int)(Math.random() * (end-start+1) + start);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome ui = new welcome();
        frame.getContentPane().add(ui.trainerRecommend());
        frame.setVisible(true);
    }
}