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
 *  Created on 2021/5/18:The JPane contain 1 part of user information
 * 
 * 
 */

public class UserInfoPane {
    public JPanel userInfoPane;

    public String currentaccount = null;
	public String currentpassword = null;
	public String currentemail = null;
    public String currentusertype = null;


    /**
	 * Created a JPanel to contain  user information
	 * @param  JTabbedPane jtb, jtb is the JTabbedPane that will contain this JPanel
	 * @return JPanel, the created JPanel
	 */
    public JPanel makeUserInfoPane(JTabbedPane jtb){
        //initial the JPanel, set layout to be null
        userInfoPane = new JPanel();
        userInfoPane.setLayout(null);
        userInfoPane.setBounds(0, 0, 1200, 800);

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
		    currentpassword = info[1];
		    currentemail = info[2];
            currentusertype = info[3];

		    br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}

        //adding Component to display information
        JLabel aNewLabel = new JLabel("Profile");
        aNewLabel.setBounds(580, 10, 72, 37);
        userInfoPane.add(aNewLabel);

        JLabel aNewLabel1 = new JLabel("Account:");
        aNewLabel1.setBounds(420, 150, 138, 54);
        userInfoPane.add(aNewLabel1);

        JLabel aNewLabel2 = new JLabel("Password:");
        aNewLabel2.setBounds(420, 230, 138, 54);
        userInfoPane.add(aNewLabel2);

        JLabel aNewLabel3 = new JLabel("Email:");
        aNewLabel3.setBounds(420, 310, 138, 54);
        userInfoPane.add(aNewLabel3);

        JLabel aNewLabel7 = new JLabel("User Type:");
        aNewLabel7.setBounds(420, 390, 138, 54);
        userInfoPane.add(aNewLabel7);
        
        

        JLabel aNewLabel4 = new JLabel(currentaccount);
        aNewLabel4.setBounds(490, 150, 138, 54);
        userInfoPane.add(aNewLabel4);

        JLabel aNewLabel5 = new JLabel(currentpassword);
        aNewLabel5.setBounds(490, 230, 138, 54);
        userInfoPane.add(aNewLabel5);

        JLabel aNewLabel6 = new JLabel(currentemail);
        aNewLabel6.setBounds(490, 310, 138, 54);
        userInfoPane.add(aNewLabel6);

        JLabel aNewLabel8 = new JLabel(currentusertype);
        aNewLabel8.setBounds(490, 390, 138, 54);
        userInfoPane.add(aNewLabel8);

    

        JButton editPassword = new JButton("Edit Password");
        editPassword.setBounds(650, 240, 130, 25);
        userInfoPane.add(editPassword);
        editPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditPassword ep = new EditPassword(currentaccount,jtb);
                ep.setLocation(800,300);
                ep.setVisible(true);

            }
        });

        
        JButton editEmail = new JButton("Edit Email");
        editEmail.setBounds(650, 320, 130, 25);
        userInfoPane.add(editEmail);
        editEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditEmail edt = new EditEmail(currentaccount,jtb);
                edt.setLocation(800,300);
                edt.setVisible(true);
                
            }
        });

        JButton editUserType = new JButton("Upgrade to VIP");
        editUserType.setBounds(650, 405, 130, 25);
        userInfoPane.add(editUserType);
        editUserType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(currentusertype.equals("VIP")){
                JOptionPane.showMessageDialog(null, "You are already a VIP user"); 
                }
                else{
                    EditUserType1 etu = new EditUserType1(currentaccount, jtb);
                    etu.setLocation(800,300);
                    etu.setVisible(true);
                }
            }
        });




        return userInfoPane;
    }

    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserInfoPane ui = new UserInfoPane();
        JTabbedPane jt1 = new JTabbedPane();
        frame.getContentPane().add(ui.makeUserInfoPane(jt1));
        frame.setVisible(true);
    }

    
}
