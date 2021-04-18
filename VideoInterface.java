import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

 public class VideoInterface extends JFrame implements ActionListener{

     String fileName = "Video/AllVideo.txt";

     public VideoInterface(){
        ImageIcon background = new ImageIcon("button_back.png");
        JPanel coursePanel = new JPanel();
        JPanel searchPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

          // Search Area
          JTextField textField = new JTextField(20);
          JButton searchBtn = new JButton("Search Course");
           searchBtn.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                   System.out.println("I am searching!");
                   String input = textField.getText();
                   searchVideo(input);
  
               }
           });
           searchPanel.add(textField);
        searchPanel.add(searchBtn);

        // Get course information from file
        String fileContents = readFromFile(fileName);
        String[] splitFileContents = fileContents.split(",");
        int courseNum = splitFileContents.length/3;
        coursePanel.setLayout(new GridLayout(courseNum/2,2)); // Set Layout type
        
        // Temp store coure information indepently
        String[] courseName = new String[courseNum];
        int[] courseTime = new int[courseNum];
        String[] filePath = new String[courseNum];

        for(int i=0,j=0,k=0,l=0; i<splitFileContents.length; i++){
            if(i%3==0){ courseName[j] = splitFileContents[i]; j++; }
            else if(i%3==1) {courseTime[k] = Integer.parseInt(splitFileContents[i]); k++; }
            else {filePath[l] = splitFileContents[i]; l++;}
        }

        // Generate JButton for each course
        for(int i=0; i<courseNum; i++){
            JButton btn = new JButton(courseName[i] + "  "+ courseTime[i] + "mins", background);
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setOpaque(false);
            btn.setContentAreaFilled(false);
            btn.setMargin(new Insets(0, 0, 0, 0));
            btn.setSize(300,400);
            String name = courseName[i];
            String path = filePath[i];
            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    // System.out.println("This button is clicked.");
                    playVideo(path);
                    System.out.println("This course name is " + name ); // return is still error.
                }
            });
            coursePanel.add(btn);
        }
            
        getContentPane().add("North",searchPanel);
        getContentPane().add("Center",coursePanel);
     }

     public void actionPerformed(ActionEvent e){
        //  System.out.println("This button is clicked.");
     }

     public String readFromFile(String filename){
        // Read AllCourse.txt file
        // Create base enviroment when file not exist
        try {
            File file = new File(filename);
            if(!file.exists()){
                new AllCourse();
            }
        } catch (Exception e) {
            System.out.println("Create Base Enviroment Error!");
        }
        
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
     
     public static void playVideo(String filePath){
        Runtime runtime=Runtime.getRuntime();
        try{
            runtime.exec("cmd /c start " + filePath);
        }catch (IOException e)
        {
            System.out.println(e);
        }

    }
    public void searchVideo(String keys){
        String searchObject = readFromFile(fileName);
        String[] splitFileContents = searchObject.split(",");
        // int objectNum = splitFileContents.length/3;
        String name = null;
        String path = null;
        for(int i=0; i<splitFileContents.length;i++){
            if(splitFileContents[i].equals(keys)) {
                if(i%3==0){ name=splitFileContents[i]; path=splitFileContents[i+2];}
                else if(i%3==1){name=splitFileContents[i-1]; path=splitFileContents[i+1];}
            System.out.println("I have searched classes called" +" "+ name);}
        }
        if(path==null){ System.out.println("Nothing found!");}
               else playVideo(path);
    }

     public void addVideo(){}

     public void removeVideo(){}
     
     public void clickVideo(){}

     public static void main(String[] args) {
        VideoInterface frame = new VideoInterface();
        frame.setTitle("VideoInterface V1.2");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
     }
     
 }
