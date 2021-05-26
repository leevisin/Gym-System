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
import java.util.Objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// import jdk.internal.org.jline.terminal.MouseEvent.Button;

// import jdk.internal.org.objectweb.asm.Label;

import java.lang.Math;


public class HomePanel extends Interface{
    public JPanel adImage = new JPanel(null);
    public JPanel recommend1 = new JPanel(null);
    public JPanel recommend2 = new JPanel(null);
    public JPanel trainerRC = new JPanel(null);
    
    
    public JPanel recommend3 = new JPanel(null);
    public JPanel recommend4 = new JPanel(null);
    public JPanel videoRC = new JPanel(null);
    
    public JPanel homePanel1 = new JPanel(null);
    
    public JPanel homePanel(){
        //logo
        // JLabel label = new JLabel();
        // label.setIcon(new ImageIcon("images/LOGO.gif"));//文件路径
        // Label.setBounds(0,0,1280,240);
        // homePanel1.add(label);
        JButton  LOGO = new JButton();
        ImageIcon icon1 = new ImageIcon("images/LOGO.gif");
        LOGO.setBounds(0, 0, 1280, 240);
        Image temp1 = icon1.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), icon1.getImage().SCALE_DEFAULT);  
        icon1 = new ImageIcon(temp1); 
        LOGO.setIcon(icon1);
        homePanel1.add(LOGO);
        //按钮1 加 trainer
        //写一个label
        JButton TR = new JButton("Trainer recommendation!");
        TR.setForeground(Color.BLACK);
        //看一下哪个合适
        //TR.setBounds(new Rectangle(0, 0, 1280, 20));
        TR.setBounds(0, 460, 1280, 20);
        homePanel1.add(TR);
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
        // trainerRC.setPreferredSize(new Dimension(1080, 240));
        int BoxX = 135 ; 
        for(int i=0; i<trainersInfo.length; i++){       
            String trainerName = trainersInfo[i][0];
            String trainerType = trainersInfo[i][1];
            String imagesPath = trainersInfo[i][2];
            String intro = trainersInfo[i][3];
            // Problem intro String can't be too long
            if(i==randomInt[0]||i==randomInt[1]||i==randomInt[2]){
            ImageIcon icon = new ImageIcon(trainersInfo[i][2]);
            JButton trainerBtn = new JButton(trainerName + ": " + trainerType, icon); 
            // trainerBtn.setMaximumSize(new Dimension(30,20)); 
            trainerBtn.setSize(150, 180);
            Image temp = icon.getImage().getScaledInstance(trainerBtn.getWidth(), trainerBtn.getHeight(), icon.getImage().SCALE_DEFAULT);  
            icon = new ImageIcon(temp); 
            trainerBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new BookInfo(trainerName, trainerType, imagesPath, intro);
                }
            });
            
            trainerBtn.setIcon(icon);
            trainerBtn.setBackground(Color.WHITE);
            // trainerBtn.setHideActionText(true);
            trainerBtn.setToolTipText("Click to Show Detail Information");
            trainerBtn.setBorderPainted(false);
            trainerBtn.setFocusPainted(false);
            trainerBtn.setVerticalTextPosition(JButton.BOTTOM);
            trainerBtn.setHorizontalTextPosition(JButton.CENTER);
            trainerBtn.setBounds(BoxX,480,150,200);
            BoxX+=420;
            homePanel1.add(trainerBtn);
            }  
        }

        //按钮2 加 视频
        JButton VR = new JButton("Videos recommendation!");
        VR.setForeground(Color.BLACK);
        VR.setBounds(0, 240, 1280, 20);
        homePanel1.add(VR);
        
        // public JPanel recommend3 = new JPanel(new BorderLayout());
        // JLabel RC1 = new JLabel("Trainer recommendation!");
        // RC1.setForeground(Color.WHITE);
        // recommend3.add(RC1,BorderLayout.WEST);
        // videoRC.add(recommend1, BorderLayout.NORTH);
        //数组存三个随机数
        int end1 = readLine("texts/AllVideo.txt");
        System.out.println("一共有x行"+end1);
        int[] randomInt1 = new int[3];
        randomInt1[0]=getRandom(0, end1-1);
        do{
            randomInt1[1]= getRandom(0, end1-1);
        }while(randomInt1[1]==randomInt1[0]);

        do{
            randomInt1[2]= getRandom(0, end1-1);
        }while(randomInt1[2]==randomInt1[1]||randomInt1[2]==randomInt1[0]);
        
        System.out.println(randomInt1[0]+","+randomInt1[1]+","+randomInt1[2]);
        //推荐三个视频
        String[][] allCourse = readFromFile("texts/AllVideo.txt");
        // trainerRC.setPreferredSize(new Dimension(1080, 240));
        int rowLength= allCourse.length;
        // Generate Total Button for each course
        int BoxX1 = 75;
        for(int i=0; i<rowLength; i++){
            JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1]);
            Button_Back(btn,allCourse[i][4],allCourse[i][5]);
            String videoName = allCourse[i][0];
            String videoPath = allCourse[i][3];
            String videoVip = allCourse[i][5];
                
            if(i==randomInt1[0]||i==randomInt1[1]||i==randomInt1[2]){ 
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        // System.out.println("This button is clicked.");
                        String[][] userInfor=new String[1][5];
                        userInfor=readFromFile("texts/currentuser.txt");
                        int leftNum = Integer.parseInt(userInfor[0][4]);
                        if(videoVip.equals("1")){

                        
                        if(userInfor[0][3].equals("normal")){
                            JOptionPane.showMessageDialog(HomePanel.super.rootPane, "You are not a VIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
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
                                    JOptionPane.showMessageDialog(HomePanel.super.rootPane, "You have no try left !","Warning!",JOptionPane.WARNING_MESSAGE);
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
                                JOptionPane.showMessageDialog(HomePanel.super.rootPane, "You have no try left !","Warning!",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                }
                });
                btn.setBounds(BoxX1, 260, 270, 200);
                homePanel1.add(btn);
                BoxX1+= 420;
            }   
        }
        return homePanel1; 
    }
    










    public JPanel adimageJPanel(){
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("images/LOGO.gif"));//文件路径
        adImage.add(label);
        return adImage;
        
    }
    public JPanel trainerRecommend(){
        //写一个label
        JButton TR = new JButton("Trainer recommendation!");
        TR.setForeground(Color.BLACK);
        //看一下哪个合适
        TR.setBounds(new Rectangle(0, 0, 1280, 40));
        // TR.setBounds(0, 0, 1280, 40);
        recommend2.add(TR);
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
        // trainerRC.setPreferredSize(new Dimension(1080, 240));
        for(int i=0; i<trainersInfo.length; i++){
            int BoxX = 135 ;        
            String trainerName = trainersInfo[i][0];
            String trainerType = trainersInfo[i][1];
            String imagesPath = trainersInfo[i][2];
            String intro = trainersInfo[i][3];
            // Problem intro String can't be too long
            if(i==randomInt[0]||i==randomInt[1]||i==randomInt[2]){
            ImageIcon icon = new ImageIcon(trainersInfo[i][2]);
            JButton trainerBtn = new JButton(trainerName + ": " + trainerType, icon); 
            // trainerBtn.setMaximumSize(new Dimension(30,20)); 
            trainerBtn.setBounds(BoxX,40,150,200);
            BoxX+=420;
            Image temp = icon.getImage().getScaledInstance(trainerBtn.getWidth(), trainerBtn.getHeight(), icon.getImage().SCALE_DEFAULT);  
            icon = new ImageIcon(temp);  
            


            trainerBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new BookInfo(trainerName, trainerType, imagesPath, intro);
                }
            });

            
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
        }
        
        // recommend1.add(recommend2,BorderLayout.CENTER);
        // trainerRC.add(recommend1);
        return trainerRC; 
    }

    
    
    public JPanel videoRecommend(){
        
        JButton VR = new JButton("Videos recommendation!");
        VR.setForeground(Color.BLACK);
        VR.setBounds(0, 240, 1280, 40);
        recommend3.add(VR);
        
        // public JPanel recommend3 = new JPanel(new BorderLayout());
        // JLabel RC1 = new JLabel("Trainer recommendation!");
        // RC1.setForeground(Color.WHITE);
        // recommend3.add(RC1,BorderLayout.WEST);
        // videoRC.add(recommend1, BorderLayout.NORTH);
        //数组存三个随机数
        int end = readLine("texts/AllVideo.txt");
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
        //推荐三个视频
        String[][] allCourse = readFromFile("texts/AllVideo.txt");
        // trainerRC.setPreferredSize(new Dimension(1080, 240));
        int rowLength= allCourse.length;
        // Generate Total Button for each course
        
        for(int i=0; i<rowLength; i++){
            JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1]);
            Button_Back(btn,allCourse[i][4],allCourse[i][5]);
            String videoName = allCourse[i][0];
            String videoPath = allCourse[i][3];
            String videoVip = allCourse[i][5];
                
            if(i==randomInt[0]||i==randomInt[1]||i==randomInt[2]){ 
                int BoxX1 = 75;
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        // System.out.println("This button is clicked.");
                        String[][] userInfor=new String[1][5];
                        userInfor=readFromFile("texts/currentuser.txt");
                        int leftNum = Integer.parseInt(userInfor[0][4]);
                        if(videoVip.equals("1")){

                        
                        if(userInfor[0][3].equals("normal")){
                            JOptionPane.showMessageDialog(HomePanel.super.rootPane, "You are not a VIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
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
                                    JOptionPane.showMessageDialog(HomePanel.super.rootPane, "You have no try left !","Warning!",JOptionPane.WARNING_MESSAGE);
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
                                JOptionPane.showMessageDialog(HomePanel.super.rootPane, "You have no try left !","Warning!",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                }
                });
                btn.setBounds(BoxX1, 280, 270, 180);
                recommend2.add(btn);
                BoxX1+= 420;
            }   
        }
        // recommend3.add(recommend4,BorderLayout.CENTER);
        // videoRC.add(recommend3);
        return videoRC;
    }

    public static int getRandom(int start, int end){
        return (int)(Math.random() * (end-start+1) + start);
    }
    
    public static void Button_Back(JButton Button,String ImagePath,String videoVip){
        Button.setBounds(0, 0, 270, 180);
        ImageIcon imageIcon = new ImageIcon(ImagePath);
        Image suitablImage = imageIcon.getImage().getScaledInstance(Button.getWidth(), Button.getHeight(), imageIcon.getImage().SCALE_DEFAULT);
        imageIcon = new ImageIcon(suitablImage);
        Button.setIcon(imageIcon);
        if(videoVip.equals("1")){
           Button.setToolTipText("VIP");
        }else{Button.setToolTipText("Normal");}
        Button.setBackground(Color.white);
        Button.setBorderPainted(false);
        Button.setFocusPainted(false);
        Button.setVerticalTextPosition(JButton.BOTTOM);
        Button.setHorizontalTextPosition(JButton.CENTER);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomePanel ui = new HomePanel();
        frame.add(ui.homePanel());
        // frame.add(ui.adimageJPanel(),BorderLayout.NORTH);
        // frame.add(ui.videoRecommend(),BorderLayout.CENTER);
        // frame.add(ui.trainerRecommend(),BorderLayout.SOUTH);
 
        frame.setVisible(true);
    }
}