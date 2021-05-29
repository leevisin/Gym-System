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

/**
 * Generate base environment of video and trainer
 */
public class AllCourse{

    public static void main(String[] args) throws IOException{

        new AllCourse();

    }

    public AllCourse(){
      // Generate base enviroment
      File videoFile = new File("texts/AllVideo.txt");
      if(!videoFile.exists()){
        addVideo("Functional Training", 30, "videos/FunctionalTraining.MP4", "images/button_back1.jpg", "HIIT",0);
        addVideo("Yoga Training", 35, "videos/YogaTraining.MP4","images/button_back2.jpg", "Yoga",0);
        addVideo("Training Muscles", 45, "videos/TrainingMuscles.MP4","images/button_back3.jpg", "Strength",0);
        addVideo("Functional Training", 38, "videos/FunctionalTraining.MP4", "images/button_back8.jpg", "HIIT",1);
        addVideo("Yoga Training", 33, "videos/YogaTraining.MP4","images/button_back4.jpg", "Yoga",1);
        addVideo("Training Muscles", 50, "videos/TrainingMuscles.MP4","images/button_back7.jpg", "Strength",1);
        addVideo("Functional Training", 67, "videos/FunctionalTraining.MP4", "images/button_back9.jpg", "HIIT",2);
        addVideo("Yoga Training", 45, "videos/YogaTraining.MP4","images/button_back5.jpg", "Yoga",2);
        addVideo("Training Muscles", 40, "videos/TrainingMuscles.MP4","images/button_back6.jpg", "Strength",2);
      }

      File trainerFile = new File("texts/AllTrainer.txt");
      if(!trainerFile.exists()){
        addTrainer("Tom", "Strength", "images/Trainer1.jpg","More than 20 years of experience in martial arts training. Disciplinary sports club fitness instructor Boundlss online coach. Watahhh fitness personal trainer IPTA Certified Senior Fitness Trainer. Certificate in Advanced Sports Anatomy. Sports nutrition and physiology certification");
        addTrainer("Tina", "Slim", "images/Trainer2.jpg", "Students can strengthen their core muscles and improve poor posture and pain. And make their body shape more beautiful. I teach in small classes and hoping that students can get professional guidance and provide teaching according to different levels of people.");
        addTrainer("Ann", "Slim", "images/Trainer3.jpg","Students can strengthen their core muscles and improve poor posture and pain. And make their body shape more beautiful. I teach in small classes and hoping that students can get professional guidance and provide teaching according to different levels of people.");
        addTrainer("Vee", "Slim", "images/Trainer4.jpg","Students can strengthen their core muscles and improve poor posture and pain. And make their body shape more beautiful. I teach in small classes and hoping that students can get professional guidance and provide teaching according to different levels of people.");
        addTrainer("Dan", "Slim", "images/Trainer5.jpg","Students can strengthen their core muscles and improve poor posture and pain. And make their body shape more beautiful. I teach in small classes and hoping that students can get professional guidance and provide teaching according to different levels of people.");
        addTrainer("Ken", "Strength", "images/Trainer6.jpg","More than 20 years of experience in martial arts training. Disciplinary sports club fitness instructor Boundlss online coach. Watahhh fitness personal trainer IPTA Certified Senior Fitness Trainer. Certificate in Advanced Sports Anatomy. Sports nutrition and physiology certification");
        addTrainer("Andy", "Strength", "images/Trainer7.jpg","More than 20 years of experience in martial arts training. Disciplinary sports club fitness instructor Boundlss online coach. Watahhh fitness personal trainer IPTA Certified Senior Fitness Trainer. Certificate in Advanced Sports Anatomy. Sports nutrition and physiology certification");
        addTrainer("Lucia", "Slim", "images/Trainer8.jpg","Students can strengthen their core muscles and improve poor posture and pain. And make their body shape more beautiful. I teach in small classes and hoping that students can get professional guidance and provide teaching according to different levels of people.");
        addTrainer("Bert", "Strength", "images/Trainer9.jpg","More than 20 years of experience in martial arts training. Disciplinary sports club fitness instructor Boundlss online coach. Watahhh fitness personal trainer IPTA Certified Senior Fitness Trainer. Certificate in Advanced Sports Anatomy. Sports nutrition and physiology certification");
        addTrainer("Rita", "Slim", "images/Trainer10.jpg","Students can strengthen their core muscles and improve poor posture and pain. And make their body shape more beautiful. I teach in small classes and hoping that students can get professional guidance and provide teaching according to different levels of people.");
        addTrainer("Shelley", "Slim", "images/Trainer11.jpg","Students can strengthen their core muscles and improve poor posture and pain. And make their body shape more beautiful. I teach in small classes and hoping that students can get professional guidance and provide teaching according to different levels of people.");
      }
    }
   
    /**
     * Add Video
     * @param videoName
     * @param videoTime
     * @param filePath
     * @param figPath
     * @param tag
     * @param vip
     */
    public void addVideo(String videoName, int videoTime, String filePath, String figPath, String tag, int vip){
      // Video Name, Video Time, Video URL, Background Button URL
      Video video = new Video(videoName, videoTime, filePath, figPath, tag, vip);
      writeVideoToFile(video);
    }

    /**
     * Add Trainer
     * @param trainerName
     * @param trainerType
     * @param figPath
     * @param intro
     */
    public void addTrainer(String trainerName, String trainerType, String figPath, String intro){
      // Trainer Name, Trainer Type, Background Button URL
      Trainer trainer = new Trainer(trainerName, trainerType, figPath, intro);
      writeTrainerToFile(trainer);
    }

    /**
     * Write Video Information to file
     * @param video
     */
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
    
    /**
     * Write Trainer information to file
     * @param trainer
     */
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

    /**
     * Check directory exist or generate it
     * @param pathName
     */
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
