import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VideoPage extends Interface{

    String fileName = "Source/AllVideo.txt";
    JPanel  mainPane,videoPane,leftPane,fatPane,rightPane,totalPane;
    JScrollPane scrollPane;
    Robot rb = null;
    public VideoPage(){
        // Add Search Funtion, Function was finished in supclass

        // Add Course Part, play the video when clicked

        // Add addVideo() Part, Search Result should be shown in Another Page or in this interface panel not CMD

        // Add Back Button

        setBounds(30, 10, 600, 800);
        setResizable(true);           //set the window is resizable
        setVisible(true);             //set the window is  visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the function as close operation
        setLayout(null);
        setLayout(new BorderLayout());
       
        Image image=new ImageIcon("Source/button_back1.jpg").getImage();
        mainPane = new BackgroundPanel(image);
        mainPane.setLayout(new FlowLayout());
        add(mainPane, BorderLayout.NORTH);
      
      /*  mainPane.add(textField,BorderLayout.CENTER);
        mainPane.add(searchBtn,BorderLayout.SOUTH);*/

        mainPane.setPreferredSize(new Dimension(600, 100));

        //define videoPane and make it flow layout
        videoPane = new JPanel();
        videoPane.setLayout(new FlowLayout());
        add(videoPane, BorderLayout.CENTER);//Put the video-pane in the middle of the total page
        videoPane.setPreferredSize(new Dimension(400, 900));
        //videoPane.setBackground(Color.RED);
        videoPane.setOpaque( false );
        videoPane.setPreferredSize( new Dimension(400, 900) );

        scrollPane = new JScrollPane( videoPane );
        getContentPane().add( scrollPane );
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Search Area
        JTextField textField = new JTextField(20);
        JButton searchBtn = new JButton("Search Course");
        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("I am searching!");
                String input = textField.getText();
                String[][] searchResult=searchCourse(fileName,input);
               playVideo(searchResult[0][3]);
            }
        });
        mainPane.add(textField,BorderLayout.CENTER);
        mainPane.add(searchBtn,BorderLayout.SOUTH);

        totalPane = new JPanel();
        totalPane.setLayout(new FlowLayout());
        totalPane.setPreferredSize(new Dimension(400, 1000));
         String[][] allCourse = readFromFile(fileName);
         int rowLength= allCourse.length;
         int columnLength = allCourse[0].length;

        // Generate Total Button for each course
        for(int i=0; i<rowLength; i++){

            JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1]);
            Button_Back(btn,allCourse[i][4]);
                /* JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1] + "mins");//, new ImageIcon(allCourse[i][4])
                btn.setHorizontalTextPosition(SwingConstants.CENTER);
                btn.setOpaque(false);
                btn.setContentAreaFilled(false);
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.setSize(200,100);*/
                String name = allCourse[i][0];
                String path = allCourse[i][3];
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        // System.out.println("This button is clicked.");
                        playVideo(path);
                        System.out.println("This course name is " + name ); // return is still error.
                    }
                });
                totalPane.add(btn);


        }
        videoPane.add(totalPane);

       /* fatPane = new JPanel();
        fatPane.setLayout(new FlowLayout());
        videoPane.add(totalPane);
        fatPane.setPreferredSize(new Dimension(400, 270));
        fatPane.add(fat1);
        fatPane.add(fat2);
        fatPane.add(fat3);*/

        leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension(80, 80));
        add(leftPane, BorderLayout.WEST);
        JButton addVideo = new JButton("ADD VIDEO",new ImageIcon("Source/button_back3.jpg"));
        addVideo.setHorizontalTextPosition(SwingConstants.CENTER);
        addVideo.setOpaque(false);
        addVideo.setContentAreaFilled(false);
        addVideo.setMargin(new Insets(0, 0, 0, 0));
        addVideo.setSize(30,40);
        addVideo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // System.out.println("This button is clicked.");

                System.out.println("I am ADDING VIDEO "); // return is still error.
            }
        });
        leftPane.add(addVideo,BorderLayout.CENTER);


        rightPane = new JPanel();
        rightPane.setPreferredSize(new Dimension(100, 500));
        add(rightPane, BorderLayout.EAST);


    }

    public static void Button_Back(JButton Button,String ImagePath){
        Button.setBounds(0, 0, 300, 200);
        ImageIcon imageIcon = new ImageIcon(ImagePath);
        Image suitablImage = imageIcon.getImage().getScaledInstance(Button.getWidth(), Button.getHeight(), imageIcon.getImage().SCALE_DEFAULT);
        imageIcon = new ImageIcon(suitablImage);
        Button.setIcon(imageIcon);
        Button.setToolTipText("image");
        Button.setBorderPainted(false);
        Button.setFocusPainted(false);
        Button.setVerticalTextPosition(JButton.BOTTOM);
        Button.setHorizontalTextPosition(JButton.CENTER);
    }
    


    //Play the video
    public void playVideo(String filePath){
        Runtime runtime=Runtime.getRuntime();
        try{
            runtime.exec("cmd /c start " + filePath);
        }catch (IOException e)
        {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new VideoPage();
    }
}
