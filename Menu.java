import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Objects;

public class Menu extends JFrame{
    /**
     *
     */
    JButton videoSection;
    JButton liveSection;
    JButton profileSection;
    JButton infoSection;
    JButton back;

    public Menu() throws HeadlessException {
        /*initalization of the menu page*/
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Menu");
        titleLabel.setFont(new Font("Dialog", Font.PLAIN, 35));
        titleLabel.setBounds(250, 50, 200, 80); 
        contentPane.add(titleLabel);                      //add the title "Menu"  

        back = new JButton("Back to Login");
        back.setBounds(20, 20, 150, 40);                // place the "back to login" button
        contentPane.add(back);

        videoSection = new JButton("Videos");
        videoSection.setBounds(200, 150, 200, 60);        // place the "Videos" button
        contentPane.add(videoSection);

        liveSection = new JButton("Live Training");
        liveSection.setBounds(200, 300, 200, 60);        // place the "Live Training" button
        contentPane.add(liveSection);

        profileSection = new JButton("User Profile");
        profileSection.setBounds(200, 450, 200, 60);    // place the "User Profile" button
        contentPane.add(profileSection);

        infoSection = new JButton("Information");
        infoSection.setBounds(200, 600, 200, 60);    // place the "Information" button
        contentPane.add(infoSection);
        
        JLabel backgroundLabel = new JLabel("");
        //URL url = getClass().getResource("Source/background.jpg");
        backgroundLabel.setIcon(new ImageIcon(Menu.class.getResource("Source/background.jpg")));
        backgroundLabel.setBounds(0, 0, 600, 800);      // set the background image
        contentPane.add(backgroundLabel);

        
        videoSection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
                VideoPage vp = new VideoPage();
               
            }
        });

        liveSection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
                
                VideoPage vp = new VideoPage();
            }
        });
        profileSection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
                Profile pf = new Profile();
                pf.runpf();
            }
        });
        infoSection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
                Information info = new Information();
                info.runinfor();
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
                new Login().setVisible(true);
            }
        });
        
        

    }

    public static void main(String[] args) {
        new Menu().setVisible(true);
    } 
}


   /**
	 * updated on 2021/5/6: adding the Menu title, adding the back button
     * 
	 * 
	 */