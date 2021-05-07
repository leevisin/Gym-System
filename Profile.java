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
	import java.util.Objects;


	/**
	 * Title name.java Description This class contains a game which never will
	 * success. Copyright (c) 2020 Copyright Holder All Rights Reserved.
	 * 
	 * @author Ruizhuo Chen
	 * @date May 18th, 2020
	 * @version 1.0
	 * @author Wenxuan Liang
	 * @date April 21th, 2021
	 * @version 1.1   (able to obtain information of current user)
	 * @author Wenxuan Liang
	 * @date May 6th,2020
	 * @version 2.0	(able to edit user information)
	 */
	public class Profile {
		public String currentaccount = null;
		public String currentpassword = null;
		public String currentemail = null;

	    public JFrame frame;

	    /**
	     * Launch the application.
	     */
	   public void runpf() {
	                try {
	                    Profile window = new Profile();
	                    window.frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	     }

	    /**
	     * Create the application.
	     */
	    public Profile() {
	        initialize();
	    }

	    /**
	     * Initialize the contents of the frame.
	     */
	    public void initialize() {
			/*accquire information of current user*/
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
			 currentpassword = info[1];
			 currentemail = info[2];

			br.close();

			}catch (IOException e) {
				e.printStackTrace();
			}

			


			/*establish the GUI*/
	        frame = new JFrame();
	        frame.setBounds(0, 0, 600, 800);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);

	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 590, 790);
	        frame.getContentPane().add(panel);
	        panel.setLayout(null);

	        JLabel aNewLabel = new JLabel("Profile");
	        aNewLabel.setBounds(231, 10, 72, 37);
	        panel.add(aNewLabel);

	        JLabel aNewLabel1 = new JLabel("Account:");
	        aNewLabel1.setBounds(94, 57, 138, 54);
	        panel.add(aNewLabel1);

	        JLabel aNewLabel2 = new JLabel("Password:");
	        aNewLabel2.setBounds(94, 134, 138, 54);
	        panel.add(aNewLabel2);

	        JLabel aNewLabel3 = new JLabel("Email:");
	        aNewLabel3.setBounds(94, 214, 138, 54);
	        panel.add(aNewLabel3);
	        
	        

	        JLabel aNewLabel4 = new JLabel(currentaccount);
	        aNewLabel4.setBounds(264, 57, 138, 54);
	        panel.add(aNewLabel4);

	        JLabel aNewLabel5 = new JLabel(currentpassword);
	        aNewLabel5.setBounds(264, 134, 138, 54);
	        panel.add(aNewLabel5);

	        JLabel aNewLabel6 = new JLabel(currentemail);
	        aNewLabel6.setBounds(264, 214, 138, 54);
	        panel.add(aNewLabel6);

		

			JButton editPassword = new JButton("Edit Password");
			editPassword.setBounds(410, 144, 130, 25);
	        panel.add(editPassword);
			editPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditPassword(currentaccount).setVisible(true);
				}
			});

			
			JButton editEmail = new JButton("Edit Email");
			editEmail.setBounds(410, 224, 130, 25);
	        panel.add(editEmail);
			editEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new EditEmail(currentaccount).setVisible(true);
					
				}
			});



	        JButton aNewButton2 = new JButton("Return");
	        aNewButton2.setBounds(310, 578, 200, 40);
	        panel.add(aNewButton2);

	        Icon icon = new ImageIcon("Source/background.jpg");
	        JLabel backGroundLabel = new JLabel(icon);
	        backGroundLabel.setBounds(0, 0, 600, 800);
	        panel.add(backGroundLabel);

			aNewButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					Menu menu = new Menu();                         //when return is clicked, go back to the Menu
					menu.setVisible(true);
				}
			});

	    }

		public static void main(String[] args){
			Profile pf = new Profile();
			pf.runpf();
		}

	}


   /**
	 * updated on 2021/4/21: able to accquire information from current user
	 * updated on 2021/5/06: able to edit user information
	 * 
	 */

