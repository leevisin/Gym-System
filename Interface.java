import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

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
     public String[][] readFromFile(String filename){
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

        String contents = "";
        try{
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneLine = bufferedReader.readLine();
            while(oneLine != null){
                contents += oneLine + ",";
                oneLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (IOException e) {
            System.out.println("Errors occured: IOException!");
            System.exit(1);
        }     

        // Store file contents into array
        int rows = readLine(filename);
        String[] courseContents = contents.split(",");
        int columns = courseContents.length/rows;
        String[][] courseArray = new String[rows][columns];
        int k=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                courseArray[i][j] = courseContents[k];
                k++;
            }
        }

        // Read information to an array and storage it, so that it needn't read twice.
        return courseArray;
     }
     
     

     // Read Line, i.e number of course
     public int readLine(String filename){
         int lines = 0;
         try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String oneLine = bufferedReader.readLine();
            while(oneLine != null){
                lines++;
                oneLine = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
         } catch (Exception e) {
            System.out.println("readLine function error!");
         }
        return lines;
     }

     // Search all course name, when course name contains part or all courseName
     public String[][] searchCourse(String filename, String courseName){
        
        int searchNum = 0;
        String[][] courseArray = readFromFile(filename);
        for(int i=0; i<courseArray.length; i++){
            if(courseArray[i][0].contains(courseName)){
                searchNum++;
            }
        }

        String[][] searchResult = new String[searchNum][courseArray[0].length];
        int k=0;
        for(int i=0; i<courseArray.length; i++){
            if(courseArray[i][0].contains(courseName)){
                for(int j=0; j<courseArray[0].length; j++){
                    searchResult[k][j] = courseArray[i][j];
                }
                k++;
            }
        }

        return searchResult;

     }

     // It should be extended in subclass
     public void addCourse(){}

     public void addVideo(String videoName, int videoTime, String filePath, String tag, int vip){
        Video video = new Video(videoName, videoTime, filePath, filePath, tag, vip);
        new AllCourse().writeVideoToFile(video);
        System.out.println("You have added video: " + videoName);
      }
  
      public void addTrainer(String trainerName, String trainerType, String figPath, String intro){
        Trainer trainer = new Trainer(trainerName, trainerType, figPath, intro);
        new AllCourse().writeTrainerToFile(trainer);
        System.out.println("You have added Trainer: " + trainerName);
      }


      public void playVideo(String filePath){
        Runtime runtime=Runtime.getRuntime();
        try{
            runtime.exec("cmd /c start " + filePath);
        }catch (IOException e)
        {
            System.out.println(e);
        }

    }

     // Remove course, first search then remove
     public void removeCourse(String filename, String courseName){
        // courseName must be exact that can be removed
        try {
            String[][] orignalData = readFromFile(filename);
            FileWriter fileWriter = new FileWriter(filename, false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(int i=0; i<orignalData.length; i++){
                if(orignalData[i][0].equals(courseName)){
                    continue;
                }
                for(int j=0; j<orignalData[0].length; j++){
                    if(j!=orignalData[0].length-1){
                        writer.write(orignalData[i][j] + ",");
                    }
                    else{
                        writer.write(orignalData[i][j] + "\n");
                    }   
                }
                
            }
            writer.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("removeCourse() File Writer error!");
        }
        System.out.println("You have remove the course successfully!");
     }
     
     // Classify by Tag
     public String[][] classifyByTag(String filename){
        String[][] courseArray = readFromFile(filename);
        for(int i=0; i<courseArray.length; i++){
            for(int j=i+1; j<courseArray.length; j++){
                // Copy the value of String[] not pointer
                // courseArray[][2] is tag value
                if(courseArray[i][2].compareTo(courseArray[j][2])>0){
                String[] tmp = Arrays.copyOf(courseArray[i],courseArray[0].length);
                    for(int k=0; k<courseArray[0].length; k++){
                        courseArray[i][k] = courseArray[j][k];
                        courseArray[j][k] = tmp[k];
                    }
                }
            }
        }
        return courseArray;
     }

     //Classify by Vip
     public String[][] classifyByVip(){
         String[][] courses =readFromFile("texts/allVideo.txt");
         int lines =readLine("texts/allVideo.txt");
         
         int num=0;
         for(int i=0;i<=lines-1;i++){
            if(courses[i][5].equals("0"))
            num++;
        }
        int vipLines=lines-num;
        String[][] coursesVip =new String[vipLines][6];

        int j=0;
         for(int i=0;i<=lines-1;i++){
             if(courses[i][5].equals("1"))
               {        
                   
                   
                     for(int l=0;l<=5;l++)
                       {coursesVip[j][l]=courses[i][l];}
                       j++;
                    

                }
        }

       


               return coursesVip;
         }

         
         
     


     public static void main(String[] args) {
         Interface inter = new Interface();
         // Test for removeCourse() function
         // inter.removeCourse("Video/AllVideo.txt", "Yoga");

         // Test for classifyByTag
        //  String[][] tagArray = inter.classifyByTag("Source/AllVideo.txt");
        //  for(int i=0; i<tagArray.length; i++){
        //      for(int j=0; j<tagArray[0].length; j++){
        //          System.out.print(tagArray[i][j] + " ");
        //      }
        //      System.out.println();
        //  }
        //  Test for searchCourse() function
         String[][] array = inter.searchCourse("texts/AllVideo.txt","c");
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // String[][] formArray = inter.readFromFile("form.txt");
        // for(int i=0; i<formArray.length; i++){
        //     for(int j=0; j<formArray[0].length; j++){
        //         System.out.print(formArray[i][j] + " ");
        //     }
        //     System.out.println();
        // }

     }


     
     
 }
