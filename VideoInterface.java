import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

 public class VideoInterface extends JFrame implements ActionListener{

     String fileName = "Source/AllVideo.txt";
     JFrame frame;

     public VideoInterface(){
        //ImageIcon background1 = new ImageIcon("button_back1.jpg");
        //ImageIcon background2 = new ImageIcon("button_back2.jpg");
        //ImageIcon background3 = new ImageIcon("button_back3.jpg");
        //ImageIcon background[]={background1,background2,background3};
        
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
                   if(textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Search can't be empty!","Warning!",JOptionPane.WARNING_MESSAGE);
                } else if(searchVideo(input)==null)
                {
                    
                    JOptionPane.showMessageDialog(frame, "Nothing founded!","Warning!",JOptionPane.WARNING_MESSAGE);
                };
  
               }
           });
           
           searchPanel.add(textField);
        searchPanel.add(searchBtn);

        // Get course information from file
        String fileContents = readFromFile(fileName);
        String[] splitFileContents = fileContents.split(",");
        int courseNum = splitFileContents.length/4;
        coursePanel.setLayout(new GridLayout(courseNum/2,2)); // Set Layout type
        
        // Temp store coure information indepently
        String[] courseName = new String[courseNum];
        int[] courseTime = new int[courseNum];
        String[] filePath = new String[courseNum];
        ImageIcon[] background=new ImageIcon[courseNum];

        for(int i=0,j=0,k=0,l=0,m=0; i<splitFileContents.length; i++){
            if(i%4==0){ courseName[j] = splitFileContents[i]; j++; }
            else if(i%4==1) {courseTime[k] = Integer.parseInt(splitFileContents[i]); k++; }
            else if(i%4==2) {filePath[l] = splitFileContents[i]; l++;}
            else if(i%4==3){background[m]=new ImageIcon(splitFileContents[i]); 
                System.out.println(splitFileContents[i]);
                m++;}
        }

        // Generate JButton for each course
        for(int i=0; i<courseNum; i++){
            JButton btn = new JButton(courseName[i] + "  "+ courseTime[i] + "mins", background[i]);
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
        // Read Video/AllVideo.txt file
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
    public String searchVideo(String keys){
        String searchObject = readFromFile(fileName);
        String[] splitFileContents = searchObject.split(",");
        // int objectNum = splitFileContents.length/3;
        String name = null;
        String path = null;
        for(int i=0; i<splitFileContents.length;i++){
            if(splitFileContents[i].equals(keys)) {
                if(i%4==0){ name=splitFileContents[i]; path=splitFileContents[i+2];}
                else if(i%4==1){name=splitFileContents[i-1]; path=splitFileContents[i+1];}
            System.out.println("I have searched classes called" +" "+ name);}
        }
        if(path==null){ System.out.println("Nothing found!");}
               else playVideo(path);

        return path;
    }

    // Add video through interface
    public void addVideo(String videoName, int videoTime, String filePath, String figPath, String tag){
        Video video = new Video(videoName, videoTime, filePath, figPath, tag);
        new AllCourse().writeVideoToFile(video);
    }

     public void removeVideo(){

     }

     public void runVI() {
        VideoInterface frame = new VideoInterface();
        frame.setTitle("VideoInterface V1.2");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
     }
     
 }
