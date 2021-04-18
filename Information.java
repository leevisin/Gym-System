package profilePage;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

	

	/**
	 * ProfilePage.java Description This class contains a profile of users success.
	 * Copyright (c) 2020 Copyright Holder All Rights Reserved.
	 * 
	 * @author Ruizhuo Chen & Tongxin Ma
	 * @date March 29th, 2021
	 * @version 1.0
	 */
	public class Information {
		File file = new File("D:\\miniproject\\SoftwareEngineering\\form.txt"); // 创建文件对象
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
	        
	        //click trainer or recommend textfield dialog
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
	                            "submit？",
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
	                            "submit？",
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
