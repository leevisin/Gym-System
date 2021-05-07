	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

	

	/**
	 * ProfilePage.java Description This class contains a profile of users success.
	 * Copyright (c) 2020 Copyright Holder All Rights Reserved.
	 * 
	 * @author Ruizhuo Chen & Tongxin Ma
	 * @date March 29th, 2021
	 * @version 1.0
	 * 
	 * @author Tongxin Ma 
	 * @date May 6th , 2021
	 * @version 1.1
	 */
	public class Information {
		String filename = "form.txt";
		File file = new File(filename); 
		

	    JFrame frame;

	    private JTextField textField1;

	    private JTextField textField2;

	    /**
	     * Launch the application.
	     */
	    public void runinfor() {
	        Information window = new Information();
	        window.frame.setVisible(true);
	    }

	    /**
	     * Create the application.
	     */
	    public Information() {
	        initialize();
	    }

	    /**
	     * Initialize the contents of the frame.
	     */
	    private void initialize() {
	        frame = new JFrame("Information");
	        frame.setBounds(0, 0, 600, 800);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);

	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 590, 790);
	        frame.getContentPane().add(panel);
	        panel.setLayout(null);

	        JLabel aNewLabel1 = new JLabel("Height(cm):");
	        aNewLabel1.setBounds(94, 54, 138, 54);
	        panel.add(aNewLabel1);

	        JLabel aNewLabel2 = new JLabel("Weight(kg):");
	        aNewLabel2.setBounds(94, 134, 138, 54);
	        panel.add(aNewLabel2);

	        JLabel aNewLabel3 = new JLabel("Target:");
	        aNewLabel3.setBounds(94, 214, 138, 54);
	        panel.add(aNewLabel3);

	        JLabel aNewLabel4 = new JLabel("Expected exercise time:");
	        aNewLabel4.setBounds(65, 308, 138, 54);
	        panel.add(aNewLabel4);

	        JLabel aNewLabel5 = new JLabel("Expected exercise frequency:");
	        aNewLabel5.setBounds(41, 386, 203, 54);
	        panel.add(aNewLabel5);

	        textField1 = new JTextField();
	        textField1.setBounds(242, 63, 218, 37);
	        panel.add(textField1);
	        textField1.setColumns(10);

	        textField2 = new JTextField();
	        textField2.setBounds(242, 143, 218, 37);
	        textField2.setColumns(10);
	        panel.add(textField2);

	        JComboBox<String> comboBox1 = new JComboBox<String>();
	        comboBox1.setBounds(242, 230, 221, 38);
	        panel.add(comboBox1);
	        comboBox1.addItem("Gain muscle");
	        comboBox1.addItem("Power-enhanced");
	        comboBox1.addItem("Fat Loss");
	        comboBox1.addItem("Shaping");
	        comboBox1.addItem("Rehabilitation training");
	        comboBox1.addItem("Special");
	        comboBox1.addItem("Relax");

	        JComboBox<String> comboBox2 = new JComboBox<String>();
	        comboBox2.setBounds(242, 316, 221, 38);
	        panel.add(comboBox2);
	        comboBox2.addItem("1 hour per training");
	        comboBox2.addItem("2 hours per training");
	        comboBox2.addItem("3 hours per training");
	        comboBox2.addItem("more training time ");

	        JComboBox<String> comboBox3 = new JComboBox<String>();
	        comboBox3.setBounds(242, 394, 221, 38);
	        panel.add(comboBox3);
	        comboBox3.addItem("1 day per week");
	        comboBox3.addItem("2 days per weekg");
	        comboBox3.addItem("3 days per week");
	        comboBox3.addItem("more training time ");

	        JButton aNewButton1 = new JButton("Trainers");
	        aNewButton1.setBounds(100, 509, 118, 53);
	        panel.add(aNewButton1);

	        JButton aNewButton2 = new JButton("Recommed");
	        aNewButton2.setBounds(359, 509, 118, 53);
	        panel.add(aNewButton2);

	        Icon icon = new ImageIcon("background.jpg");
	        JLabel backGroundLabel = new JLabel(icon);
	        backGroundLabel.setBounds(0, 0, 600, 800);
	        panel.add(backGroundLabel);
	        
	        //click ”trainer“  textfield  dialog
	        aNewButton1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
	        		if(textField1.getText().equals("")||textField2.getText().equals("")) {
	        			JOptionPane.showMessageDialog(frame, "Hight and Weight can't be empty!","Warning!",JOptionPane.WARNING_MESSAGE);
	        		} 
	        		else if(!pattern.matcher(textField1.getText()).matches()||!pattern.matcher(textField2.getText()).matches()) {
	                	JOptionPane.showMessageDialog(frame, "Hight and Weight must be numbers!","Warning!",JOptionPane.WARNING_MESSAGE);
	        		}
	        		
					//next operation
	        		else {
	        			int result = JOptionPane.showConfirmDialog(
	                            frame,
	                            "submit",
	                            "Notice!",
	                            JOptionPane.YES_NO_CANCEL_OPTION
	                    );
	                    System.out.println("choose result: " + result);
	                    if (result==0) {
							// write current user's informations in the form.txt , realize the function of changing the user's plan,
	                    	try{
								if(!file.exists())
	                    		file.createNewFile();
								BufferedReader bre = new BufferedReader(new FileReader(file));				
								BufferedWriter put = new BufferedWriter(new FileWriter(file,true));
								InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(Util.currentuser)), StandardCharsets.UTF_8);
								//obtain all information of current user
								BufferedReader br = new BufferedReader(reader);
								String curinfo; 
								String[] strinfo;
								String currentaccount = null;
								curinfo = br.readLine(); 
								strinfo = curinfo.split(",");
								currentaccount = strinfo[0];
				   				br.close();
								//将文件内容读取到数组里面
								//Interface in = new Interface();
								//String[][] userplan = in.readFromFile(filename);
								String contents = "";
								String oneline = bre.readLine();
								int lines = 0; 
								while(oneline!=null){
									lines ++;
									contents += oneline + ",";
									oneline = bre.readLine();
								}
								int rows = lines;
								if(lines!=0){
									BufferedWriter out = new BufferedWriter(new FileWriter(file,false));
									String[] userplancontents = contents.split(",");
									int columns = userplancontents.length/rows;
									String[][] userplanArray = new  String[rows][columns];
									int k = 0;
									for(int i1=0 ; i1<rows ;i1++){
										for(int j1=0;j1<columns;j1++){
											userplanArray[i1][j1] = userplancontents[k];
											k++;
										}	
									}	


									//save the new user's plan (delect first)
									for(int i=0; i<userplanArray.length;i++){
										if(userplanArray[i][0].equals(currentaccount)){
											continue;
										}
										for(int j=0;j<userplanArray[0].length;j++){
											if(j!=userplanArray[0].length-1){
												out.write(userplanArray[i][j]+",");
											}
											else{
												out.write(userplanArray[i][j]+"\n");
											}
										}
									}
									out.close();
								}						
								// after delect previous user's plan, write new plan at the end of the file.
	                    		put.write(currentaccount+",");
	                    		put.write("shengao "+textField1.getText()+",");
	                    		put.write("tizhong "+textField2.getText()+",");
	                    		put.write("target: "+(String)comboBox1.getSelectedItem()+",");
	                    		put.write("Expected exercise time:"+(String)comboBox2.getSelectedItem()+",");
	                    		put.write("expected exercise frequency:"+(String)comboBox3.getSelectedItem()+"\n");

								put.close();
								bre.close();		
	                    }catch(IOException e1){
	                    	e1.printStackTrace();
	                    }
	                    }
	        		}
	        	}
	                });
	        
	        //click  ”recommend“  textfield  dialog
	        aNewButton2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
	        		if(textField1.getText().equals("")||textField2.getText().equals("")) {
	        			JOptionPane.showMessageDialog(frame, "Hight and Weight can't be empty!","Warning!",JOptionPane.WARNING_MESSAGE);
	        		} 
	        		else if(!pattern.matcher(textField1.getText()).matches()||!pattern.matcher(textField2.getText()).matches()) {
	                	JOptionPane.showMessageDialog(frame, "Hight and Weight must be numbers!","Warning!",JOptionPane.WARNING_MESSAGE);
	        		}
	        		//next operation
	        		else {
	        			int result = JOptionPane.showConfirmDialog(
	                            frame,
	                            "submit",
	                            "Notice!",
	                            JOptionPane.YES_NO_CANCEL_OPTION
	                    );
	                    System.out.println("choose result: " + result);
	                    if (result==0) {
	                    	try{if(!file.exists())
	                    		file.createNewFile();
	                    		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
	                    		out.write("shengao "+textField1.getText()+",");
	                    		out.write("tizhong "+textField2.getText()+",");
	                    		out.write("target: "+(String)comboBox1.getSelectedItem()+",");
	                    		out.write("Expected exercise time:"+(String)comboBox2.getSelectedItem()+",");
	                    		out.write("expected exercise frequency:"+(String)comboBox3.getSelectedItem()+"\0");
	                    		out.newLine();
	                    		out.close();		
	                    }catch(IOException e1){
	                    	e1.printStackTrace();
	                    }
	                    }
	        		}
	        	}
	                });

	    }
	}
