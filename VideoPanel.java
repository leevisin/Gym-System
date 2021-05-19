import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VideoPanel extends Interface{
    String fileName = "Source/AllVideo.txt";
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

        // URL url = VideoPanel.class.getResource("images/search.png");
        // Icon icon = new ImageIcon(url);
        ImageIcon icon = new ImageIcon("images/search.png");
        JButton searchBtn = new JButton(icon);

        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("I am searching!");
                String input = textField.getText();
                String[][] searchResult=searchCourse("Source/AllVideo.txt",input);
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

        String[][] tagVideo = classifyByTag("Source/AllVideo.txt");

        JButton AllBtn =new JButton("All courses");
        String[][] allvideo = readFromFile("Source/AllVideo.txt");
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
       
        searchPanel.add(textField);
        searchPanel.add(searchBtn);
        searchPanel.add(AllBtn);
        searchPanel.add(tagBtn);
        return searchPanel;
    }
    

    public JPanel coursePanel(){

        int rows = readLine("Source/AllVideo.txt"); // Trainer Number
        if(rows%3==0){
            rows /= 3;
        }
        else{
            rows = rows/3 + 1;
        }
        
        JPanel coursePanel=new JPanel();
        coursePanel.setLayout(new FlowLayout());
        
        
        coursePanel.setPreferredSize(new Dimension(1000, rows*250));
          String[][] allCourse = readFromFile("Source/AllVideo.txt");
         int rowLength= allCourse.length;
         

        // Generate Total Button for each course
        for(int i=0; i<rowLength; i++){

            JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1]);
            Button_Back(btn,allCourse[i][4]);
            String name = allCourse[i][0];
                String path = allCourse[i][3];
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        // System.out.println("This button is clicked.");
                        playVideo(path);
                        System.out.println("This course name is " + name ); // return is still error.
                    }
                });
            coursePanel.add(btn);
        }


        

        
       

        return coursePanel;
    }
    public JPanel refreshVideoPanel(String[][] searchResult){

        int rows = readLine("Source/AllVideo.txt"); // Trainer Number
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

            JButton btn = new JButton(videoName+ "  "+ videoTime);
            Button_Back(btn,videoPicture);
            
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        // System.out.println("This button is clicked.");
                        playVideo(videoPath);
                        System.out.println("This course name is " + videoName ); // return is still error.
                    }
                });
            coursePanel.add(btn);
            
        }

        return coursePanel;
    }

    public static void Button_Back(JButton Button,String ImagePath){
        Button.setBounds(0, 0, 300, 200);
        ImageIcon imageIcon = new ImageIcon(ImagePath);
        Image suitablImage = imageIcon.getImage().getScaledInstance(Button.getWidth(), Button.getHeight(), imageIcon.getImage().SCALE_DEFAULT);
        imageIcon = new ImageIcon(suitablImage);
        Button.setIcon(imageIcon);
        Button.setToolTipText("COURSE");
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
