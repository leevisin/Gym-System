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


public class HomePanel extends Interface{
    public JPanel adImage = new JPanel();
    public JPanel recommend1 = new JPanel(new BorderLayout());
    public JPanel recommend2 = new JPanel();
    public JPanel trainerRC = new JPanel(new BorderLayout());
    
    
    public JPanel recommend3 = new JPanel(new BorderLayout());
    public JPanel recommend4 = new JPanel();
    public JPanel videoRC = new JPanel();
    
    
    
    public JPanel adimageJPanel(){
        
        
        
        return adImage;
        
    }
    public JPanel trainerRecommend(){
        //写一个label
        JLabel RC = new JLabel("Trainer recommendation!");
        RC.setForeground(Color.WHITE);
        recommend1.add(RC,BorderLayout.WEST);
        trainerRC.add(recommend1, BorderLayout.NORTH);
        //数组存三个随机数
        int end = readLine("texts/AllTrainer.txt");
        System.out.println("一共有x行"+end);
        int[] randomInt = new int[3];
        randomInt[0]=getRandom(0, end-1);
        do{
            randomInt[1]= getRandom(0, end-1);
        }while(randomInt[1]==randomInt[0]);

        do{
            randomInt[2]= getRandom(0, end-1);
        }while(randomInt[2]==randomInt[1]||randomInt[2]==randomInt[0]);
        
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
            recommend2.add(trainerBtn);
            }
            
            
            trainerRC.add(recommend2,BorderLayout.CENTER);
        }
        return trainerRC; 
    }

    
    
    public JPanel videoRecommend(){
        public JPanel recommend3 = new JPanel(new BorderLayout());
        JLabel RC1 = new JLabel("Trainer recommendation!");
        RC1.setForeground(Color.WHITE);
        recommend3.add(RC1,BorderLayout.WEST);
        videoRC.add(recommend1, BorderLayout.NORTH);
        //数组存三个随机数
        int end = readLine("texts/AllTrainer.txt");
        System.out.println("一共有x行"+end);
        int[] randomInt = new int[3];
        randomInt[0]=getRandom(0, end-1);
        do{
            randomInt[1]= getRandom(0, end-1);
        }while(randomInt[1]==randomInt[0]);

        do{
            randomInt[2]= getRandom(0, end-1);
        }while(randomInt[2]==randomInt[1]||randomInt[2]==randomInt[0]);
        
        System.out.println(randomInt[0]+","+randomInt[1]+","+randomInt[2]);

        ///
        String[][] allCourse = readFromFile("texts/AllVideo.txt");
         int rowLength= allCourse.length;
         

        // Generate Total Button for each course
        for(int i=0; i<rowLength; i++){
            if(i==randomInt[0]||i==randomInt[1]||i==randomInt[2]){
            JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1]);
            Button_Back(btn,allCourse[i][4],allCourse[i][5]);
            String videoName = allCourse[i][0];
                String videoPath = allCourse[i][3];
                String videoVip=allCourse[i][5];
                
                
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        // System.out.println("This button is clicked.");
                        String[][] userInfor=new String[1][5];
                        userInfor=readFromFile("texts/currentuser.txt");
                        int leftNum = Integer.parseInt(userInfor[0][4]);
                        if(videoVip.equals("1")){

                        
                        if(userInfor[0][3].equals("normal")){
                            JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You are not a VIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
                        }else if(userInfor[0][3].equals("VIP"))
                           {
                               if(leftNum>-0)
                                {   playVideo(videoPath);
                                    System.out.println("This course name is " + videoName ); 
                                    leftNum--;
                                    //Recored the change in currentuser.txt and member.txt
                                    List<Member> members = Util.readFile();
                                    for (Member member: Objects.requireNonNull(members)) {
                                        if (member.getAccount().equals(userInfor[0][0])){
                                            member.setVedioTimes(leftNum); 
                                            Util.writeFile(members);         
                                            Util.recordCurrentUser(member);
                                         }
                                    } 
                                }else{
                                    JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You have no try left !","Warning!",JOptionPane.WARNING_MESSAGE);
                            }}
                        else{
                            //when user is SVIP, then there is no need to change the times of video viewing
                            playVideo(videoPath);
                        }


                        }else{
                            if(leftNum>-0||userInfor[0][3].equals("SVIP")){
                            playVideo(videoPath);
                            System.out.println("This course name is " + videoName );
                                if(!userInfor[0][3].equals("SVIP")){ // only reduce video viewing times when user are not an SVIP
                                    leftNum--;
                                    List<Member> members = Util.readFile();
                                    for (Member member: Objects.requireNonNull(members)) {
                                        if (member.getAccount().equals(userInfor[0][0])){
                                            member.setVedioTimes(leftNum); 
                                            Util.writeFile(members);         
                                            Util.recordCurrentUser(member);
                                        }
                                    }
                                }
                            }else{
                                JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You have no try left !","Warning!",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                }
                });

            recommend4.add(btn);
            }
        }

        return videoRC;


    }

    public static int getRandom(int start, int end){
        return (int)(Math.random() * (end-start+1) + start);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomePanel ui = new HomePanel();
        frame.getContentPane().add(ui.trainerRecommend());
        frame.setVisible(true);
    }
}