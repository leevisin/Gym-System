import java.io.*;
import java.nio.file.*;

public class writeTest {
    public static void main(String[] args) {

        File file = new File("Test/Test.txt");
        if(!file.exists()){
            new AllCourse();
        }


        try{
            String filename = "Test/Test.txt";
            File name = new File("Test");
            System.out.println(name.exists());
            
            Path path = Paths.get("Test");
            Path pathCreate = Files.createDirectory(path);
            
            System.out.println(name.exists());
            FileWriter fileWriter = new FileWriter(filename, true); // It can write at the end of file.
            BufferedWriter writer = new BufferedWriter(fileWriter);
            // if(isVideo==true){
              writer.write("You are succeed!");
            // }
            // else{
            //   writer.write(trainer.getTrainerName() + "," + trainer.getTrainerType() + "\n");
            // }
            writer.close();
            fileWriter.close();
        }
        catch(Exception e){ System.out.println("Error!"); }
    }
}