package profilePage;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Title name.java Description This class contains a game which never will
 * success. Copyright (c) 2020 Copyright Holder All Rights Reserved.
 * 
 * @author Ruizhuo Chen
 * @date May 18th, 2020
 * @version 1.0
 */
public class ProfilePage {
	private JFrame frame;

    private JTextField textField1;

    private JTextField textField2;

    private JTextField textField3;

    private JTextField textField4;

    private JTextField textField5;

    /**
     * Launch the application.
     */ 
    public void run() {
                try {
                    ProfilePage window = new ProfilePage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    /**
     * Create the application.
     */
    public ProfilePage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("porfile change");
        frame.setBounds(100, 100, 600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 0, 566, 680);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel aNewLabel = new JLabel("Profile");
        aNewLabel.setBounds(224, 10, 72, 37);
        panel.add(aNewLabel);
        // aNewLabel.setHorizontalTextPosition(JLabel.CENTER);

        JLabel aNewLabel1 = new JLabel("Account:");
        aNewLabel1.setBounds(94, 54, 138, 54);
        panel.add(aNewLabel1);

        JLabel aNewLabel2 = new JLabel("password:");
        aNewLabel2.setBounds(94, 134, 138, 54);
        panel.add(aNewLabel2);

        JLabel aNewLabel3 = new JLabel("password confirm:");
        aNewLabel3.setBounds(94, 214, 138, 54);
        panel.add(aNewLabel3);

        JLabel aNewLabel4 = new JLabel("gender");
        aNewLabel4.setBounds(94, 294, 138, 54);
        panel.add(aNewLabel4);

        JLabel aNewLabel5 = new JLabel("Level:");
        aNewLabel5.setBounds(94, 374, 138, 54);
        panel.add(aNewLabel5);


        textField1 = new JTextField();
        textField1.setBounds(242, 63, 218, 37);
        panel.add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setColumns(10);
        textField2.setBounds(242, 143, 218, 37);
        panel.add(textField2);

        textField3 = new JTextField();
        textField3.setColumns(10);
        textField3.setBounds(242, 223, 218, 37);
        panel.add(textField3);

        textField4 = new JTextField();
        textField4.setColumns(10);
        textField4.setBounds(242, 303, 218, 37);
        panel.add(textField4);

        textField5 = new JTextField();
        textField5.setColumns(10);
        textField5.setBounds(242, 383, 218, 37);
        panel.add(textField5);

        JButton changePassword = new JButton("please enter your new password and confirm!");
        changePassword.setBounds(239, 462, 221, 38);
        panel.add(changePassword);

        JButton aNewButton3 = new JButton("back");
        aNewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        aNewButton3.setBounds(70, 614, 200, 40);
        panel.add(aNewButton3);

        JButton aNewButton4 = new JButton("Save");
        aNewButton4.setBounds(314, 614, 200, 40);
        panel.add(aNewButton4);
        
        Icon icon = new ImageIcon("background.jpg");
        JLabel backGroundLabel = new JLabel(icon);
        backGroundLabel.setBounds(0, 0, 600, 800);
        panel.add(backGroundLabel);
        //ÐÞ¸ÄÃÜÂë°´¼ü
        	
        	changePassword.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String inputContent  = JOptionPane.showInputDialog(
							frame,
							"new password£º"
							);
					String inputContent1  = JOptionPane.showInputDialog(
							frame,
							"confirm password£º"
							);
					if(inputContent1.equals(inputContent1)) {
					System.out.println("content£º"+inputContent+inputContent1);
					System.out.println("modified successfully");
					}
					else {
						System.out.println("modified fail");
					}
				}
        		
        	});
    }
}
