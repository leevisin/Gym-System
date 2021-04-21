import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

 public class Interface extends JFrame implements ActionListener{

     // Base on fileName generate different interface page
     public String fileName;

     // Whole information of course read from file
     public String courseInfo;


     // There are n row and one line
     public Interface(){

     }

     // When the button is clicked, play the course
     // The method could be implement in public Interface(){}
     public void actionPerformed(ActionEvent e){
        
     }

     // Get the course information from file.txt
     public String readFromFile(String filename){
        // Create base enviroment when file not exist
        // You can use new AllCourse(); to generate base environment
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
        // Read information to an array and storage it, so that it needn't read twice.
        return null;
     }
     
     // It should be extended in subclass
     public void addCourse(){}

     // Search all course name, when course name contains part or all courseName
     public void searchCourse(String courseName){}

     // Remove course, first search then remove
     public void removeCourse(String courseName){}
     


     
     
 }
