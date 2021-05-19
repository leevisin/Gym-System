import javax.swing.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/** 
 *  Created on 2021/5/18:The JPane contain no.2 part of booked Trainer
 * 
 * 
 */
public class BookedTrainerPane {

    
    public JPanel bookedTrainerPane;
    public String currentaccount = null;
    public String[][] trainerInfo;

      /**
	 * Created a JPanel to contain  user information
	 * @param  JTabbedPane jtb, jtb is the JTabbedPane that will contain this JPanel
	 * @return JPanel, the created JPanel
	 */
    public JPanel makeBookedTrainerPane(JTabbedPane jtb){
        //initialize the JPanel
        bookedTrainerPane = new JPanel();
        bookedTrainerPane.setLayout(null);
        bookedTrainerPane.setBounds(0, 0, 1200, 800);

        //accquire information of current user
		String allinfo; 
		String[] info;
		BufferedReader br = null;
		InputStreamReader reader = null;
		try{
		    reader = new InputStreamReader(new FileInputStream(new File(Util.currentuser)), StandardCharsets.UTF_8);
            br = new BufferedReader(reader);
		    allinfo = br.readLine(); //obtain all information of current user
		    info = allinfo.split(",");
	        currentaccount = info[0];
		    //currentpassword = info[1];
		    //currentemail = info[2];
            //currentusertype = info[3];
		    br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}

        //gettring trainer information
        trainerInfo = readFromFile("Source/BookInfo.txt");
        System.out.println(trainerInfo);

        //adding component to the JPanel












       return bookedTrainerPane;

    }






     // Get the user information from file.txt
     public String[][] readFromFile(String filename){
        // Exit when file not exist
        try {
            File file = new File(filename);
            if(!file.exists()){
                System.out.println("No such file, then we will exit..");
                System.exit(0);
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
        String[][] infoArray = new String[rows][columns];
        int k=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                infoArray[i][j] = courseContents[k];
                k++;
            }
        }

        // Read information to an array and storage it, so that it needn't read twice.
        return infoArray;
     }

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


    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BookedTrainerPane ui = new BookedTrainerPane();
        JTabbedPane jt1 = new JTabbedPane();
        frame.getContentPane().add(ui.makeBookedTrainerPane(jt1));
        frame.setVisible(true);
    }
}
