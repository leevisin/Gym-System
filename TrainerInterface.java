package profilePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

 public class TrainerInterface extends JFrame implements ActionListener{

     String fileName = "AllTrainer.txt";

     public TrainerInterface(){
        JPanel coursePanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Title Text Area
        JLabel titileJLabel = new JLabel("Below are Our Trainers",JLabel.CENTER);
        JLabel hintJLabel = new JLabel("Please Click to Book Trainers",JLabel.CENTER);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add("North",titileJLabel);
        titlePanel.add("Center",hintJLabel);
        
        // Get course information from file
        String fileContents = readFromFile(fileName);
        String[] splitFileContents = fileContents.split(",");
        int courseNum = splitFileContents.length/2;
        coursePanel.setLayout(new GridLayout(courseNum,1)); // Set Layout type
        
        // Temp store coure information indepently
        String[] courseName = new String[courseNum];
        String[] courseType = new String[courseNum];

        for(int i=0,j=0,k=0; i<splitFileContents.length; i++){
            if(i%2==0){ courseName[j] = splitFileContents[i]; j++; }
            else {courseType[k] = splitFileContents[i]; k++; }
        }

        // Generate JButton for each course
        for(int i=0; i<courseNum; i++){
            JButton btn = new JButton("Traier Name: " + courseName[i] + ", Course Type: "+ courseType[i]);
            String trainerName = courseName[i];
            String trainerType = courseType[i];
            btn.setSize(300,400);
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    // System.out.println("This button is clicked.");
                    BookInfo bi = new BookInfo(trainerName, trainerType);
                    bi.setTitle("Book Infomation");
                    bi.pack();
                    bi.setSize(600, 800);
                    bi.setVisible(true);
                }
            });
            coursePanel.add(btn);
        }
            
        getContentPane().add("North",titlePanel);
        getContentPane().add("Center",coursePanel);
     }

     public void actionPerformed(ActionEvent e){
        //  System.out.println("This button is clicked.");
     }

     public String readFromFile(String filename){
        // Read AllCourse.txt file
        try{
            String contents = "";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneLine = bufferedReader.readLine();
            while(oneLine != null){
                contents += oneLine + ",";
                oneLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            return contents;
        }
        catch (IOException e) {
            System.out.println("Errors occured: IOException");
            System.exit(1);
          }
        return null; // When error occurs.
     }
     
     public void searchTrainer(){}

     public void addTrainer(){}

     public void removeTrainer(){}

     


     public void runTi(){
        TrainerInterface frame = new TrainerInterface();
        frame.setTitle("TrainerInterface V1.2");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
     }
     
 }