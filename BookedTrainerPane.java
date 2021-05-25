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
    public String[][] lessonInfo;

      /**
	 * Created a JPanel to contain  user information
	 * @param  JTabbedPane jtb, jtb is the JTabbedPane that will contain this JPanel
	 * @return JPanel, the created JPanel
	 */
    public JPanel makeBookedTrainerPane(JTabbedPane jtb){
        //initialize the JPanel
        int rows = readLine("texts/BookInfo.txt");
    
        bookedTrainerPane = new JPanel(new GridLayout(rows+1, 5));
        bookedTrainerPane.setBounds(0, 0, 1200, 800);

        JLabel title1 = new JLabel("User");
        title1.setFont(new Font(null, Font.PLAIN, 19));
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setBorder(BorderFactory.createLineBorder(Color.black));
        bookedTrainerPane.add(title1);

        JLabel title2 = new JLabel("Trainer");
        title2.setFont(new Font(null, Font.PLAIN, 19));
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBorder(BorderFactory.createLineBorder(Color.black));
        bookedTrainerPane.add(title2);
    
        JLabel title3 = new JLabel("Lesson Type");
        title3.setFont(new Font(null, Font.PLAIN, 19));
        title3.setHorizontalAlignment(SwingConstants.CENTER);
        title3.setBorder(BorderFactory.createLineBorder(Color.black));
        bookedTrainerPane.add(title3);

        JLabel title4 = new JLabel("Booked Date");
        title4.setFont(new Font(null, Font.PLAIN, 19));
        title4.setHorizontalAlignment(SwingConstants.CENTER);
        title4.setBorder(BorderFactory.createLineBorder(Color.black));
        bookedTrainerPane.add(title4);

        JLabel title5 = new JLabel("Booked Hours");
        title5.setFont(new Font(null, Font.PLAIN, 19));
        title5.setHorizontalAlignment(SwingConstants.CENTER);
        title5.setBorder(BorderFactory.createLineBorder(Color.black));
        bookedTrainerPane.add(title5);



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
		    br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}

        //gettring booked trainer information for all users
        lessonInfo = readFromFile("texts/BookInfo.txt");
        //display the lesson booked by current user
        for(int i=0; i<lessonInfo.length; i++){
            String userAccount = lessonInfo[i][0];
 
            //display the lesson booked by current user
            if(userAccount.equals(currentaccount)){
                //user account
                JLabel account1 = new JLabel(lessonInfo[i][0]);
                account1.setFont(new Font(null, Font.PLAIN, 15));
                account1.setHorizontalAlignment(SwingConstants.CENTER);
                bookedTrainerPane.add(account1);
                //triner Name
                JLabel trainer1 = new JLabel(lessonInfo[i][1]);
                trainer1.setFont(new Font(null, Font.PLAIN, 15));
                trainer1.setHorizontalAlignment(SwingConstants.CENTER);
                bookedTrainerPane.add(trainer1);
                //trainer Type
                JLabel type1 = new JLabel(lessonInfo[i][2]);
                type1.setFont(new Font(null, Font.PLAIN, 15));
                type1.setHorizontalAlignment(SwingConstants.CENTER);
                bookedTrainerPane.add(type1);
                //booked day
                JLabel day1 = new JLabel(lessonInfo[i][3]);
                day1.setFont(new Font(null, Font.PLAIN, 15));
                day1.setHorizontalAlignment(SwingConstants.CENTER);
                bookedTrainerPane.add(day1);
                //booked hours
                JLabel hours1 = new JLabel(lessonInfo[i][4]);
                hours1.setFont(new Font(null, Font.PLAIN, 15));
                hours1.setHorizontalAlignment(SwingConstants.CENTER);
                bookedTrainerPane.add(hours1);


            }
        }
        



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

    public JScrollPane scrollPanel(JTabbedPane jtb){
        BookedTrainerPane btp = new BookedTrainerPane();

        JScrollPane scrollPanel = new JScrollPane(
                btp.makeBookedTrainerPane(jtb),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        return scrollPanel;
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
