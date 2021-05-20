import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/** 
 *  Created on 2021/5/18:The JPane contain no.3 part of Recommendation activity
 * 
 * 
 */
public class RecommendationPane {

    public JPanel recommendationPane;
    public String currentaccount;



    public JPanel makeRecomPane(JTabbedPane jtb){
        //initialize
        recommendationPane = new JPanel();
        recommendationPane.setLayout(null);
        recommendationPane.setBounds(0, 0, 1200, 800);
        recommendationPane.setBackground(java.awt.Color.white);

        
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

        JLabel title = new JLabel("Recommendation");
        title.setFont(new Font("Dialog", Font.PLAIN, 30));
        title.setBounds(450, 10, 400, 70);
        recommendationPane.add(title);

        //adding components
        JLabel aNewLabel1 = new JLabel("Height(cm):");
	        aNewLabel1.setBounds(394, 154, 138, 54);
            recommendationPane.add(aNewLabel1);

	        JLabel aNewLabel2 = new JLabel("Weight(kg):");
	        aNewLabel2.setBounds(394, 234, 138, 54);
            recommendationPane.add(aNewLabel2);

	        JLabel aNewLabel3 = new JLabel("Target:");
	        aNewLabel3.setBounds(394, 314, 138, 54);
            recommendationPane.add(aNewLabel3);

            JTextField textField1 = new JTextField();
	        textField1.setBounds(542, 163, 218, 37);
	        recommendationPane.add(textField1);
	        textField1.setColumns(10);

	        JTextField textField2 = new JTextField();
	        textField2.setBounds(542, 243, 218, 37);
	        textField2.setColumns(10);
	        recommendationPane.add(textField2);

            JComboBox<String> comboBox1 = new JComboBox<String>();
	        comboBox1.setBounds(542, 330, 221, 38);
	        recommendationPane.add(comboBox1);
	        comboBox1.addItem("Gain-muscle");
	        comboBox1.addItem("Fat-Loss");

            JButton recommend = new JButton("Recommed");
	        recommend.setBounds(509, 459, 118, 53);
	        recommendationPane.add(recommend);

            //getting trainer information from AllTrainer.txt
            String[][] trainersInfo = Util.readFromFile("texts/AllTrainer.txt");

            recommend.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   //recommend directly based on Target
                    String target = (String) comboBox1.getSelectedItem();
                    if(target.equals("Gain-muscle")){
                        //randomly recommend a Trainer of catagory Gain-muscle
                        int trainer = (int)(Math.random()*4)+1;
                        int i = 0;
                        int j = 0;
                        while(j<trainer){
                            if(trainersInfo[i][1].equals("Strength")){
                                j++;
                            }
                            if(j==trainer){
                                String trainerName = trainersInfo[i][0];
                                String trainerType = trainersInfo[i][1];
                                String imagesPath = trainersInfo[i][2];
                                String intro = trainersInfo[i][3];
                                new BookInfo(trainerName, trainerType, imagesPath,intro);
                            }
                            else{
                                i++;
                            }
                        }
                        
                    }
                    else if(target.equals("Fat-Loss")){
                        //recommend a Trainer of catagory Gain-muscle
                        String target2 = (String) comboBox1.getSelectedItem();
                        int trainer = (int)(Math.random()*4+1);
                        int i = 0;
                        int j = 0;
                        while(j<trainer){
                            if(trainersInfo[i][1].equals("Slim")){
                                    j++;
                                }
                            if(j == trainer){
                                String trainerName = trainersInfo[i][0];
                                String trainerType = trainersInfo[i][1];
                                String imagesPath = trainersInfo[i][2];
                                String intro = trainersInfo[i][3];
                                new BookInfo(trainerName, trainerType, imagesPath,intro);

                            }
                            else{
                                i++;
                            }
                        }
                       

                    }

                }
            });


        return recommendationPane;
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RecommendationPane ui = new RecommendationPane();
        JTabbedPane jt1 = new JTabbedPane();
        frame.getContentPane().add(ui.makeRecomPane(jt1));
        frame.setVisible(true);
    }
}
