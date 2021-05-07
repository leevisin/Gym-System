import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TrainerPage extends Interface{

    String fileName = "Source/AllTrainer.txt";
    JPanel  mainPane,coursePane,leftPane,fatPane,rightPane,totalPane;
    JScrollPane scrollPane;
    Robot rb = null;
    public TrainerPage(){
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
        //顶层
        Image image=new ImageIcon("Source/button_back1.jpg").getImage();
        mainPane = new BackgroundPanel(image);
        mainPane.setLayout(new FlowLayout());
        add(mainPane, BorderLayout.NORTH);
        //搜索框
      /*  mainPane.add(textField,BorderLayout.CENTER);
        mainPane.add(searchBtn,BorderLayout.SOUTH);*/

        mainPane.setPreferredSize(new Dimension(600, 100));

        //define videoPane and make it flow layout
        coursePane = new JPanel();
        coursePane.setLayout(new FlowLayout());
        add(coursePane, BorderLayout.CENTER);//Put the video-pane in the middle of the total page
        coursePane.setPreferredSize(new Dimension(400, 900));
        //videoPane.setBackground(Color.RED);
        coursePane.setOpaque( false );
        coursePane.setPreferredSize( new Dimension(400, 900) );

        scrollPane = new JScrollPane( coursePane );
        getContentPane().add( scrollPane );
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Search Area
        JTextField textField = new JTextField(20);
        JButton searchBtn = new JButton("Search Trainer");
        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("I am searching!");
                String input = textField.getText();
                String[][] searchResult=searchCourse(fileName,input);
            }
        });

        totalPane = new JPanel();
        totalPane.setLayout(new FlowLayout());
        totalPane.setPreferredSize(new Dimension(400, 1000));
        String[][] allTrainer = readFromFile(fileName);
        int rowLength= allTrainer.length;
        int columnLength = allTrainer[0].length;

        // Generate Total Button for each course
        for(int i=0; i<columnLength; i++){

            JButton btn = new JButton(allTrainer[i][0]  + "  "+ allTrainer[i][1]);
            Button_Back(btn,allTrainer[i][2]);
                /*JButton btn = new JButton(allCourse[i][0]  + "  "+ allCourse[i][1] + "mins", new ImageIcon(allCourse[i][3]));
                btn.setHorizontalTextPosition(SwingConstants.CENTER);
                btn.setOpaque(false);
                btn.setContentAreaFilled(false);
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.setSize(300,400);*/
            String name = allTrainer[i][0];
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    // System.out.println("This button is clicked.");
                    System.out.println("This course name is " + name ); // return is still error.
                }
            });
            totalPane.add(btn);


        }
        coursePane.add(totalPane);

       /* fatPane = new JPanel();
        fatPane.setLayout(new FlowLayout());
        videoPane.add(totalPane);
        fatPane.setPreferredSize(new Dimension(400, 270));
        fatPane.add(fat1);
        fatPane.add(fat2);
        fatPane.add(fat3);*/

        leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension(100, 500));
        add(leftPane, BorderLayout.WEST);
        JButton addTrainer = new JButton("ADD TRAINER",new ImageIcon("source/button_back2.jpg"));
        addTrainer.setHorizontalTextPosition(SwingConstants.CENTER);
        addTrainer.setOpaque(false);
        addTrainer.setContentAreaFilled(false);
        addTrainer.setMargin(new Insets(0, 0, 0, 0));
        addTrainer.setSize(300,400);
        addTrainer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // System.out.println("This button is clicked.");

                System.out.println("I am ADDING VIDEO "); // return is still error.
            }
        });
        leftPane.add(addTrainer,BorderLayout.CENTER);


        rightPane = new JPanel();
        rightPane.setPreferredSize(new Dimension(100, 500));
        add(rightPane, BorderLayout.EAST);


    }
    public static void Button_Back(JButton Button,String ImagePath){

        Button.setBounds(0, 0, 300, 200);
        ImageIcon imageBack = new ImageIcon(ImagePath);
        Image suitable = imageBack.getImage().getScaledInstance(Button.getWidth(), Button.getHeight(), imageBack.getImage().SCALE_DEFAULT);
        imageBack = new ImageIcon(suitable);
        Button.setIcon(imageBack);
        Button.setToolTipText("image");
        Button.setBorderPainted(false);
        Button.setFocusPainted(false);
        Button.setVerticalTextPosition(JButton.BOTTOM);
        Button.setHorizontalTextPosition(JButton.CENTER);
    }


    public static void main(String[] args) {
        new VideoPage();
    }
}
