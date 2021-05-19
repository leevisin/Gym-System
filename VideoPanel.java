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

    public VideoPanel(){}

    public JPanel videoPanel(){
        JPanel videoPanel = new JPanel(new BorderLayout());

        


        videoPanel.add(searchPanel(), BorderLayout.NORTH);
        videoPanel.add(scrollPane(), BorderLayout.CENTER);
        
        return videoPanel;    
    }

    public JPanel searchPanel(){
        JPanel searchPanel = new JPanel();
        JTextField textField = new JTextField(20);

        URL url = VideoPanel.class.getResource("images/search.png");
        Icon icon = new ImageIcon(url);
        JButton searchBtn = new JButton(icon);
        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("I am searching!");
                String input = textField.getText();
                String[][] searchResult=searchCourse("Source/AllVideo.txt",input);
                for(int i=0;i<=searchResult.length;i++){
                    System.out.println(searchResult[i][0]);
                }
                if(input.equals("")) {
                    JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "Search can't be empty!","Warning!",JOptionPane.WARNING_MESSAGE);}
                else if(input!=null){
                    if(searchResult[0][0]==null){
                        JOptionPane.showMessageDialog(VideoPanel.super.rootPane, "There is no searched resault!","Warning!",JOptionPane.WARNING_MESSAGE);}
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

        searchPanel.add(textField);
        searchPanel.add(searchBtn);

        return searchPanel;
    }
    

    public JScrollPane scrollPane(){
        JPanel coursePanel=new JPanel();
        coursePanel.setLayout(new FlowLayout());
        coursePanel.setPreferredSize(new Dimension(1000, 2000));
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

        
        //define videoPane and make it flow layout
       JPanel totalPane = new JPanel();
        totalPane.setLayout(new FlowLayout());
        add(totalPane, BorderLayout.CENTER);//Put the video-pane in the middle of the total page
        totalPane.setPreferredSize(new Dimension(1000, 2000));
        //videoPane.setBackground(Color.RED);
        totalPane.setOpaque( false );
        totalPane.setPreferredSize( new Dimension(1000, 2000) );
        totalPane.add(coursePanel);

        JScrollPane scrollPanel = new JScrollPane( totalPane );
        
        try {
            
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        return scrollPanel;
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

    
}
