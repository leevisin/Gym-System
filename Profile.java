	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	/**
	 * Title name.java Description This class contains a game which never will
	 * success. Copyright (c) 2020 Copyright Holder All Rights Reserved.
	 * 
	 * @author Ruizhuo Chen
	 * @date May 18th, 2020
	 * @version 1.0
	 */
	public class Profile {

	    private JFrame frame;

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
	    private void initialize() {
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
	        
	        

	        JLabel aNewLabel4 = new JLabel("get Account");
	        aNewLabel4.setBounds(264, 57, 138, 54);
	        panel.add(aNewLabel4);

	        JLabel aNewLabel5 = new JLabel("get password");
	        aNewLabel5.setBounds(264, 134, 138, 54);
	        panel.add(aNewLabel5);

	        JLabel aNewLabel6 = new JLabel("get Email");
	        aNewLabel6.setBounds(264, 214, 138, 54);
	        panel.add(aNewLabel6);

	        JButton aNewButton1 = new JButton("Edit");
	        aNewButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            }
	        });
	        aNewButton1.setBounds(46, 578, 200, 40);
	        panel.add(aNewButton1);

	        JButton aNewButton2 = new JButton("Ruturn");
	        aNewButton2.setBounds(310, 578, 200, 40);
	        panel.add(aNewButton2);

	        Icon icon = new ImageIcon("background.jpg");
	        JLabel backGroundLabel = new JLabel(icon);
	        backGroundLabel.setBounds(0, 0, 600, 800);
	        panel.add(backGroundLabel);

	    }
	}

