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


public class EditUserType3 extends JFrame{

    JButton confirm;
    JLabel display;     
              
    
    

    JTabbedPane jt1;


    public EditUserType3(String currentaccount,JTabbedPane jtb) throws HeadlessException{
        jt1 = jtb;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 300, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        confirm = new JButton("OK");
        confirm.setBounds(80, 160, 100, 30);               // adding the Confirm Button
        contentPane.add(confirm);


        display = new JLabel("You are a VIP member now!");
        display.setBounds(50, 40, 220,120);            
        contentPane.add(display);


        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditUserType3.super.dispose();

            }
        });

   
    


        

    }

    public static void main(String[] args) {
       
        new EditUserType3("LMX",new JTabbedPane()).setVisible(true);
    } 
    
}
