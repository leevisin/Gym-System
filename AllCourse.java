/*
 * @Author: your name
 * @Date: 2021-03-28 20:02:49
 * @LastEditTime: 2021-04-15 18:41:38
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \Video-Live\AllCourse.java
 */
import java.io.*;
import java.nio.file.*;


public class AllCourse{

    public static void main(String[] args) throws IOException{

        new AllCourse();

    }

    public AllCourse(){
      // Generate base enviroment
      File videoFile = new File("texts/AllVideo.txt");
      if(!videoFile.exists()){
        addVideo("Functional Training", 30, "videos/FunctionalTraining.MP4", "videos/button_back1.jpg", "HIIT",1);
        addVideo("Yoga Training", 35, "videos/YogaTraining.MP4","videos/button_back2.jpg", "Yoga",1);
        addVideo("Training Muscles", 45, "videos/TrainingMuscles.MP4","videos/button_back3.jpg", "Strength",1);
      }

      File trainerFile = new File("texts/AllTrainer.txt");
      if(!trainerFile.exists()){
        addTrainer("Tom", "Strength", "images/Trainer1.jpg","A long sentence.");
        addTrainer("Tina", "Slim", "images/Trainer2.jpg", "A long sentence.");
        addTrainer("Ann", "Slim", "images/Trainer3.jpg","A long sentence.");
        addTrainer("Vee", "Slim", "images/Trainer4.jpg","A long sentence.");
        addTrainer("Dan", "Slim", "images/Trainer5.jpg","A long sentence.");
        addTrainer("Ken", "Strength", "images/Trainer6.jpg","A long sentence.");
        addTrainer("Andy", "Strength", "images/Trainer7.jpg","A long sentence.");
        addTrainer("Lucia", "Slim", "images/Trainer8.jpg","A long sentence.");
        addTrainer("Bert", "Strength", "images/Trainer9.jpg","A long sentence.");
        addTrainer("Rita", "Slim", "images/Trainer10.jpg","A long sentence.");
        addTrainer("Shelley", "Slim", "images/Trainer11.jpg","I just want to write something");

      }      
      // Need Panel to add video/trainer
    }
   
    public void addVideo(String videoName, int videoTime, String filePath, String figPath, String tag, int vip){
      // Video Name, Video Time, Video URL, Background Button URL
      Video video = new Video(videoName, videoTime, filePath, figPath, tag, vip);
      writeVideoToFile(video);
    }

    public void addTrainer(String trainerName, String trainerType, String figPath, String intro){
      // Trainer Name, Trainer Type, Background Button URL
      Trainer trainer = new Trainer(trainerName, trainerType, figPath, intro);
      writeTrainerToFile(trainer);
    }

    public void writeVideoToFile(Video video){
      String fileDirectory = "texts";
      fileExist(fileDirectory);

      String filename = "texts/AllVideo.txt";
      try {
        FileWriter fileWriter = new FileWriter(filename, true); // It can write at the end of file.
        BufferedWriter writer = new BufferedWriter(fileWriter);
        // Write to file order: Name, Time, Tag, videoPath, videoFig
        writer.write(video.getVideoName() + "," + video.getVideoTime() + "," + video.getVideoTag()+ "," + video.getVideoPath() + "," + video.getVideoFig() +  "," + video.getVideoVip() + "\n");
        writer.close();
        fileWriter.close();
      } catch (Exception e) {
        System.out.println("File Writer error!");
      }
    }
    
    public void writeTrainerToFile(Trainer trainer){
      String fileDirectory = "texts";
      fileExist(fileDirectory);

      String filename = "texts/AllTrainer.txt";
      try {
        FileWriter fileWriter = new FileWriter(filename, true); // It can write at the end of file.
        BufferedWriter writer = new BufferedWriter(fileWriter);  
        writer.write(trainer.getTrainerName() + "," + trainer.getTrainerType() + "," + trainer.getTrainerFig() + "," + trainer.getTrainerIntro() + "\n");
        writer.close();
        fileWriter.close();
      } catch (Exception e) {
        System.out.println("File Writer error!");
      }
    }

    public void fileExist(String pathName){
      File file = new File(pathName);
      if(!file.exists()){
        Path path = Paths.get(pathName);
        try {
          Files.createDirectory(path);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          System.out.println(pathName + "is not exist.");
        }
      }
    }

    
}
