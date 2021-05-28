import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
        //logo on the top
        JButton  LOGO = new JButton();
        ImageIcon icon1 = new ImageIcon("images/LOGO.gif");
        LOGO.setBounds(0, 0, 1280, 240);
        Image temp1 = icon1.getImage().getScaledInstance(LOGO.getWidth(), LOGO.getHeight(), icon1.getImage().SCALE_DEFAULT);  
        icon1 = new ImageIcon(temp1); 
        LOGO.setIcon(icon1);
        homePanel1.add(LOGO);
        //Trainer recoomendation navigation
        JButton TR = new JButton("Trainer recommendation!");
        TR.setForeground(Color.BLACK);
        TR.setBounds(0, 460, 1280, 20);
        homePanel1.add(TR);
        //Randomly recommend three trainers
        //Generate three different random numbers,use the method of getRandom()
        int end = readLine("texts/AllTrainer.txt");
        int[] randomInt = new int[3];
        randomInt[0]=getRandom(0, end-1);
        do{
            randomInt[1]= getRandom(0, end-1);
        }while(randomInt[1]==randomInt[0]);

        do{
            randomInt[2]= getRandom(0, end-1);
        }while(randomInt[2]==randomInt[1]||randomInt[2]==randomInt[0]);       
        //Extract the information from the file, use the loop to make a button
        String[][] trainersInfo = readFromFile("texts/AllTrainer.txt");
        //GUILayout , BoxX is the The abscissa of the button
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
            trainerBtn.setToolTipText("Click to Show Detail Information");
            trainerBtn.setBorderPainted(false);
            trainerBtn.setFocusPainted(false);
            trainerBtn.setVerticalTextPosition(JButton.BOTTOM);
            trainerBtn.setHorizontalTextPosition(JButton.CENTER);
            trainerBtn.setBounds(BoxX,480,150,200);
            //the gap between the two buttons is 420
            BoxX+=420;
            homePanel1.add(trainerBtn);
            }  
        }
        //Videos recommendation naviagtion
        JButton VR = new JButton("Videos recommendation!");
        VR.setForeground(Color.BLACK);
        VR.setBounds(0, 240, 1280, 20);
        homePanel1.add(VR);
        //Randomly recommend three Videos
        //Generate three different random numbers,use the method of getRandom()
        int end1 = readLine("texts/AllVideo.txt");
        int[] randomInt1 = new int[3];
        randomInt1[0]=getRandom(0, end1-1);
        do{
            randomInt1[1]= getRandom(0, end1-1);
        }while(randomInt1[1]==randomInt1[0]);

        do{
            randomInt1[2]= getRandom(0, end1-1);
        }while(randomInt1[2]==randomInt1[1]||randomInt1[2]==randomInt1[0]);
        //Extract the information from the file
        String[][] allCourse = readFromFile("texts/AllVideo.txt");
        int rowLength= allCourse.length;
        //BoxX1 is is the abscissa of the buttons
        int BoxX1 = 75;
        //use loop to make videos button
        for(int i=0; i<rowLength; i++){
            JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1]);
            Button_Back(btn,allCourse[i][4],allCourse[i][5]);
            String videoName = allCourse[i][0];
            String videoPath = allCourse[i][3];
            String videoVip = allCourse[i][5];
                
            if(i==randomInt1[0]||i==randomInt1[1]||i==randomInt1[2]){ 
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
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
    //getRandom is a method to generate random number , return an integer.
    public static int getRandom(int start, int end){
        return (int)(Math.random() * (end-start+1) + start);
    }
    //Button_back is a method to defines the properties of the button
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
    //main method is use to test the homePanel()
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomePanel ui = new HomePanel();
        frame.add(ui.homePanel());
        frame.setVisible(true);
    }
}