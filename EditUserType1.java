import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.util.Objects;
  /**
	 * Created on 2021/05/18
	 * 
	 */


public class EditUserType1 extends JFrame{

    JButton confirm;
    JButton back;
    JLabel newusertype;                    
    
    

    JTabbedPane jt1;


    

    public EditUserType1(String currentaccount,JTabbedPane jtb) throws HeadlessException{
        jt1 = jtb;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        confirm = new JButton("Confirm");
        confirm.setBounds(160, 200, 100, 30);               // adding the Confirm Button
        contentPane.add(confirm);

        back = new JButton("Back");
        back.setBounds(40, 200, 100, 30);                   // adding the Back Button
        contentPane.add(back);

        newusertype = new JLabel("upgrade account: "+ currentaccount+" to VIP?");
          
        newusertype.setBounds(40, 40, 220,120);            
        contentPane.add(newusertype);

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditUserType1.super.dispose();
                EditUserType2 eut2 = new EditUserType2(currentaccount,jt1);
                eut2.setLocation(800,300);
                eut2.setVisible(true);

            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditUserType1.super.dispose();
            }
        });
    


        

    }

    public static void main(String[] args) {
       
        new EditUserType1("LMX",new JTabbedPane()).setVisible(true);
    } 
    
}

