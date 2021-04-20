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

    public Menu() throws HeadlessException {
        /*initalization of the menu page*/
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        videoSection = new JButton("Videos");
        videoSection.setBounds(220, 150, 200, 60);        // place the "Videos" button
        contentPane.add(videoSection);

        liveSection = new JButton("Live Training");
        liveSection.setBounds(220, 300, 200, 60);        // place the "Live Training" button
        contentPane.add(liveSection);

        profileSection = new JButton("User Profile");
        profileSection.setBounds(220, 450, 200, 60);    // place the "User Profile" button
        contentPane.add(profileSection);

        infoSection = new JButton("Information");
        infoSection.setBounds(220, 600, 200, 60);    // place the "Information" button
        contentPane.add(infoSection);
        
        JLabel backgroundLabel = new JLabel("");
        //URL url = getClass().getResource("background.jpg");
        backgroundLabel.setIcon(new ImageIcon(Menu.class.getResource("background.jpg")));
        backgroundLabel.setBounds(0, 0, 600, 800);      // set the background image
        contentPane.add(backgroundLabel);
        
        videoSection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
                VideoInterface vi = new VideoInterface();
                vi.runVI();
            }
        });

        liveSection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu.super.dispose();
                TrainerInterface ti = new TrainerInterface();
                ti.runTI();
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
        

    }

    public static void main(String[] args) {
        new Menu().setVisible(true);
    } 
}