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


public class EditUserType2 extends JFrame{

    JButton confirm;
    JButton back;
    JLabel carddisplay;     
    JTextField cardnum;               
    
    

    JTabbedPane jt1;


    

    public EditUserType2(String currentaccount,JTabbedPane jtb) throws HeadlessException{
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

        carddisplay = new JLabel("Please enter your bank account: ");
        carddisplay.setBounds(40, 40, 220,120);            
        contentPane.add(carddisplay);

        cardnum = new JTextField();
        cardnum.setBounds(65, 120, 145, 25);           //enter new password here
        cardnum.setColumns(10);
        contentPane.add(cardnum);

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Util.accountFormat(cardnum.getText())){
                    
                    List<Member> members = Util.readFile();
                    for (Member member: Objects.requireNonNull(members)) {
                        if (member.getAccount().equals(currentaccount)){
                            member.setUserType("VIP");                       
                            Util.writeFile(members);  //change the information in member.txt       
                            Util.recordCurrentUser(member);  //change the information in member.txt
                            }
                        }
                    EditUserType2.super.dispose();
                    EditUserType3 eut3 = new EditUserType3(currentaccount,jt1);
                    eut3.setLocation(800,300);
                    eut3.setVisible(true);
                    //update the change to UserInfoPane
                    jt1.remove(0);//remove the first page
                    ImageIcon icon = Util.createImageIcon("images/middle.gif");
                    UserInfoPane uip = new UserInfoPane();
                    jt1.insertTab("User Info", icon, uip.makeUserInfoPane(jt1), "UserInfo",0);
                }
            
                else{
                    JOptionPane.showMessageDialog(EditUserType2.super.rootPane, "This account is invalid"); 
                }
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditUserType2.super.dispose();
            }
        });
    


        

    }

    public static void main(String[] args) {
       
        new EditUserType2("LMX",new JTabbedPane()).setVisible(true);
    } 
    
}