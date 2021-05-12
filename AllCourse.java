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
      File videoFile = new File("Source/AllVideo.txt");
      if(!videoFile.exists()){
        addVideo("Functional Training", 30, "Source/FunctionalTraining.MP4", "Source/button_back1.jpg", "HIIT");
        addVideo("Yoga Training", 35, "Source/YogaTraining.MP4","Source/button_back2.jpg", "Yoga");
        addVideo("Training Muscles", 45, "Source/TrainingMuscles.MP4","Source/button_back3.jpg", "Strength");
      }

      File trainerFile = new File("Source/AllTrainer.txt");
      if(!trainerFile.exists()){
        addTrainer("Tom", "Strength", "images/Trainer1.png");
        addTrainer("Jack", "Explosive Power", "images/Trainer2.png");
        addTrainer("Ann", "Slim", "images/Trainer3.png");
      }      
      // Need Panel to add video/trainer
    }
   
    public void addVideo(String videoName, int videoTime, String filePath, String figPath, String tag){
      // Video Name, Video Time, Video URL, Background Button URL
      Video video = new Video(videoName, videoTime, filePath, figPath, tag);
      writeVideoToFile(video);
    }

    public void addTrainer(String trainerName, String trainerType, String figPath){
      // Trainer Name, Trainer Type, Background Button URL
      Trainer trainer = new Trainer(trainerName, trainerType, figPath);
      writeTrainerToFile(trainer);
    }

    public void writeVideoToFile(Video video){
      String fileDirectory = "Source";
      fileExist(fileDirectory);

      String filename = "Source/AllVideo.txt";
      try {
        FileWriter fileWriter = new FileWriter(filename, true); // It can write at the end of file.
        BufferedWriter writer = new BufferedWriter(fileWriter);
        // Write to file order: Name, Time, Tag, videoPath, videoFig
        writer.write(video.getVideoName() + "," + video.getVideoTime() + "," + video.getVideoTag()+ "," + video.getVideoPath() + "," + video.getVideoFig() + "\n");
        writer.close();
        fileWriter.close();
      } catch (Exception e) {
        System.out.println("File Writer error!");
      }
    }
    
    public void writeTrainerToFile(Trainer trainer){
      String fileDirectory = "Source";
      fileExist(fileDirectory);

      String filename = "Source/AllTrainer.txt";
      try {
        FileWriter fileWriter = new FileWriter(filename, true); // It can write at the end of file.
        BufferedWriter writer = new BufferedWriter(fileWriter);  
        writer.write(trainer.getTrainerName() + "," + trainer.getTrainerType() + "," + trainer.getTrainerFig() +"\n");
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
