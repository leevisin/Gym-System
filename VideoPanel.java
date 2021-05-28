import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VideoPanel extends Interface{
    String fileName = "texts/AllVideo.txt";
    Robot robot = null;
    JPanel videoPanel = new JPanel(new BorderLayout());

    public VideoPanel(){}

    public JPanel videoPanel(){
        
        


        videoPanel.add(searchPanel(), BorderLayout.NORTH);
        videoPanel.add(coursePanel(), BorderLayout.CENTER);
        
        return videoPanel;    
    }

    public JPanel searchPanel(){
        JPanel searchPanel = new JPanel();
        JTextField textField = new JTextField(20);

        ImageIcon icon = new ImageIcon("images/search.png");
        JButton searchBtn = new JButton(icon);

        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("I am searching!");
                String input = textField.getText();
                String[][] searchResult=searchCourse("texts/AllVideo.txt",input);
                /*for(int i=0;i<=searchResult.length;i++){
                    System.out.println(searchResult[i][0]);
                }*/
                if(input.equals("")) {
                    JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "Search can't be empty!","Warning!",JOptionPane.WARNING_MESSAGE);}
                else{
                    videoPanel.removeAll();
                    videoPanel.add(searchPanel(), BorderLayout.NORTH);
                    videoPanel.add(refreshVideoPanel(searchResult), BorderLayout.CENTER);
                    videoPanel.revalidate();
                }   
            }
        });
        searchBtn.setMaximumSize(new Dimension(32,32));
        searchBtn.setIcon(icon);
        searchBtn.setHideActionText(true);
        searchBtn.setToolTipText("Click to Search");
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setFocusPainted(false);

        String[][] tagVideo = classifyByTag("texts/AllVideo.txt");

        JButton AllBtn =new JButton("All courses");
        String[][] allvideo = readFromFile("texts/AllVideo.txt");
        AllBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    videoPanel.removeAll();
                    videoPanel.add(searchPanel(), BorderLayout.NORTH);
                    videoPanel.add(refreshVideoPanel(allvideo), BorderLayout.CENTER);
                    videoPanel.revalidate();
            }
        });

        JButton tagBtn =new JButton("Classsified");
        tagBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    videoPanel.removeAll();
                    videoPanel.add(searchPanel(), BorderLayout.NORTH);
                    videoPanel.add(refreshVideoPanel(tagVideo), BorderLayout.CENTER);
                    videoPanel.revalidate();
            }
        });

        String[][] vipVideo = classifyByVip();
        JButton vipBtn =new JButton("Vip");
        vipBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String[][] userInfor=new String[1][4];
                userInfor=readFromFile("texts/currentuser.txt");
                if(userInfor[0][3].equals("normal")){
                    JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You are not a VIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
                }else{
                    videoPanel.removeAll();
                    videoPanel.add(searchPanel(), BorderLayout.NORTH);
                    videoPanel.add(refreshVideoPanel(vipVideo), BorderLayout.CENTER);
                    videoPanel.revalidate();}
            }
        });
       
        searchPanel.add(textField);
        searchPanel.add(searchBtn);
        searchPanel.add(AllBtn);
        searchPanel.add(tagBtn);
        searchPanel.add(vipBtn);
        return searchPanel;
    }
    

    public JPanel coursePanel(){

        int rows = readLine("texts/AllVideo.txt"); // Trainer Number
        if(rows%3==0){
            rows /= 3;
        }
        else{
            rows = rows/3 + 1;
        }
        
        JPanel coursePanel=new JPanel();
        coursePanel.setLayout(new FlowLayout());
        
        
        coursePanel.setPreferredSize(new Dimension(1000, rows*250));
          String[][] allCourse = readFromFile("texts/AllVideo.txt");
         int rowLength= allCourse.length;
         

        // Generate Total Button for each course
        for(int i=0; i<rowLength; i++){

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
//video is "2"
if(videoVip.equals("2")){
    if(userInfor[0][3].equals("normal")||userInfor[0][3].equals("VIP")){
        JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You are not a SVIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
    }else
       {playVideo(videoPath);}
}

//video is "1"
if(videoVip.equals("1")){
if(userInfor[0][3].equals("normal")){
    JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You are not a VIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
}
if(userInfor[0][3].equals("VIP")){
    // left num --
    if(leftNum>-0)
            {   System.out.println(leftNum+"\n");
                playVideo(videoPath);
                System.out.println("This course name is " + videoName ); 
                leftNum--;
                System.out.println(leftNum+"\n");
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
if(userInfor[0][3].equals("SVIP")){
    playVideo(videoPath);
}
}

//video is "0"
if(videoVip.equals("0")){
    
    playVideo(videoPath);
    System.out.println("This course name is " + videoName );
}
                }
                });
            coursePanel.add(btn);
        }


        

        
       

        return coursePanel;
    }
    public JPanel refreshVideoPanel(String[][] searchResult){

        int rows = readLine("texts/AllVideo.txt"); // Trainer Number
        if(rows%3==0){
            rows /= 3;
        }
        else{
            rows = rows/3 + 1;
        }
        
        
        JPanel coursePanel=new JPanel();
        coursePanel.setLayout(new FlowLayout());
        
        
        coursePanel.setPreferredSize(new Dimension(1000, rows*250));

        for(int i=0; i<searchResult.length; i++){
            String videoName = searchResult[i][0];
            String videoTime = searchResult[i][1];
            String videoType = searchResult[i][2];
            String videoPath = searchResult[i][3];
            String videoPicture = searchResult[i][4];
            String videoVip = searchResult[i][5];

            JButton btn = new JButton(videoName+ "  "+ videoTime);
            Button_Back(btn,videoPicture,videoVip);
            
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    // System.out.println("This button is clicked.");
                    String[][] userInfor=new String[1][5];
                    userInfor=readFromFile("texts/currentuser.txt");
                    int leftNum = Integer.parseInt(userInfor[0][4]);

                    //video is "2"
                    if(videoVip.equals("2")){
                        if(userInfor[0][3].equals("normal")||userInfor[0][3].equals("VIP")){
                            JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You are not a SVIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
                        }else
                           {playVideo(videoPath);}
                    }

                    //video is "1"
                    if(videoVip.equals("1")){
                    if(userInfor[0][3].equals("normal")){
                        JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "You are not a VIP customer!","Warning!",JOptionPane.WARNING_MESSAGE);
                    }
                    if(userInfor[0][3].equals("VIP")){
                        // left num --
                        if(leftNum>-0)
                                {   System.out.println(leftNum+"\n");
                                    playVideo(videoPath);
                                    System.out.println("This course name is " + videoName ); 
                                    leftNum--;
                                    System.out.println(leftNum+"\n");
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
                    if(userInfor[0][3].equals("SVIP")){
                        playVideo(videoPath);
                    }
                    }

                    //video is "0"
                    if(videoVip.equals("0")){
                        
                        playVideo(videoPath);
                        System.out.println("This course name is " + videoName );
                    }
                    }
            });

            coursePanel.add(btn);
            }
            
            return coursePanel;
        }

        
    

    public static void Button_Back(JButton Button,String ImagePath,String videoVip){
        Button.setBounds(0, 0, 300, 200);
        ImageIcon imageIcon = new ImageIcon(ImagePath);
        Image suitablImage = imageIcon.getImage().getScaledInstance(Button.getWidth(), Button.getHeight(), imageIcon.getImage().SCALE_DEFAULT);
        imageIcon = new ImageIcon(suitablImage);
        Button.setIcon(imageIcon);
        if(videoVip.equals("2")){
            Button.setToolTipText("SVIP");
        }
        if(videoVip.equals("1")){
           Button.setToolTipText("VIP");
        }
        if(videoVip.equals("0")){Button.setToolTipText("Normal");}
        Button.setBackground(Color.white);
        Button.setBorderPainted(false);
        Button.setFocusPainted(false);
        Button.setVerticalTextPosition(JButton.BOTTOM);
        Button.setHorizontalTextPosition(JButton.CENTER);
    }

    public JScrollPane scrollPanel(){
        JScrollPane scrollPanel = new JScrollPane(
                videoPanel(),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        return scrollPanel;
    }
    
}
