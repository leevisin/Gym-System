import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

 public class TrainerInterface extends JFrame implements ActionListener{

     String fileName = "Trainer/AllTrainer.txt";
     JFrame frame;
     public TrainerInterface(){
        JPanel coursePanel = new JPanel();
        //JPanel titlePanel = new JPanel();
        JPanel searchPanel=new JPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Search Area
        JTextField textField = new JTextField(20);
        JButton searchBtn = new JButton("Search Trainer");
         searchBtn.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 System.out.println("I am searching!");
                 String input = textField.getText();
                 if(textField.getText().equals("")) {
                  JOptionPane.showMessageDialog(frame, "Search can't be empty!","Warning!",JOptionPane.WARNING_MESSAGE);
              } else if(searchTrainer(input)==null)
              {
                  
                  JOptionPane.showMessageDialog(frame, "Nothing founded!","Warning!",JOptionPane.WARNING_MESSAGE);
              };

             }
         });

         searchPanel.add(textField);
        searchPanel.add(searchBtn);

        // Title Text Area
        //JLabel titileJLabel = new JLabel("Below are Our Trainers",JLabel.CENTER);
        
        //titlePanel.setLayout(new BorderLayout());
        
        
        
        // Get course information from file
        String fileContents = readFromFile(fileName);
        String[] splitFileContents = fileContents.split(",");
        int courseNum = splitFileContents.length/3;
        coursePanel.setLayout(new GridLayout(courseNum,1)); // Set Layout type
        
        // Temp store coure information indepently
        String[] courseName = new String[courseNum];
        String[] courseType = new String[courseNum];
        ImageIcon[] background=new ImageIcon[courseNum];

        for(int i=0,j=0,k=0,l=0; i<splitFileContents.length; i++){
            if(i%3==0){ courseName[j] = splitFileContents[i]; j++; }
            else if(i%3==1){courseType[k] = splitFileContents[i]; k++;}
            else if(i%3==2){background[l]=new ImageIcon(splitFileContents[i]); 
                System.out.println(splitFileContents[i]);
            l++;}
        }

        // Generate JButton for each course
        for(int i=0; i<courseNum; i++){
            JButton btn = new JButton("Traier Name: " + courseName[i] + ", Course Type: "+ courseType[i], background[i]);
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setOpaque(false);
            btn.setContentAreaFilled(false);
            btn.setMargin(new Insets(0, 0, 0, 0));
        
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
            
        getContentPane().add("North",searchPanel);
        getContentPane().add("Center",coursePanel);
     }

     public void actionPerformed(ActionEvent e){
        //  System.out.println("This button is clicked.");
     }

     public String readFromFile(String filename){
        // Read Trainer/ALlTrainer.txt file
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
     
     public String searchTrainer(String keys){
        String searchObject = readFromFile(fileName);
        String[] splitFileContents = searchObject.split(",");
        // int objectNum = splitFileContents.length/3;
        String trainerName = null;
        String trainerType = null;
        for(int i=0; i<splitFileContents.length;i++){
            if(splitFileContents[i].equals(keys)) {
                if(i%3==0){ trainerName=splitFileContents[i]; trainerType=splitFileContents[i+1];}
                else if(i%3==1){trainerName=splitFileContents[i-1]; trainerType=splitFileContents[i];}
            System.out.println("I have booked the trainer called" +" "+ trainerName);}
        }
        if(trainerName==null){ System.out.println("No such trainer!");}
        else {
            BookInfo bi = new BookInfo(trainerName, trainerType);
                    bi.setTitle("Book Infomation");
                    bi.pack();
                    bi.setSize(600, 800);
                    bi.setVisible(true);
        }
               

        return trainerName;
        
    }

     public void addTrainer(){
         
     }


     


     public void runTI() {
        TrainerInterface frame = new TrainerInterface();
        frame.setTitle("TrainerInterface V1.2");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
     }
     
 }
