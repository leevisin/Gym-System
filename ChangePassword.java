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
public class ChangePassword {
	JFrame frame;

    private JTextField textField1;

    private JTextField textField2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        ChangePassword window = new ChangePassword();
        window.frame.setVisible(true);
    }

    /**
     * Create the application.
     */
    public ChangePassword() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Change the password!");
        frame.setBounds(0, 0, 600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(10, 0, 566, 680);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        
        
        JLabel aNewLabel1 = new JLabel("new password:");
        aNewLabel1.setBounds(94, 54, 138, 54);
        panel.add(aNewLabel1);

        JLabel aNewLabel2 = new JLabel("password confirm:");
        aNewLabel2.setBounds(94, 134, 138, 54);
        panel.add(aNewLabel2);
        
        textField1 = new JTextField();
        textField1.setBounds(242, 63, 218, 37);
        panel.add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setBounds(242, 143, 218, 37);
        textField2.setColumns(10);
        panel.add(textField2);
        
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
        
        
        
        
        aNewButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        		if(textField1.getText().equals("")||textField2.getText().equals("")) {
        			JOptionPane.showMessageDialog(frame, "Password can't be empty!","Warning!",JOptionPane.WARNING_MESSAGE);
        		} 
        		else if(!pattern.matcher(textField1.getText()).matches()||!pattern.matcher(textField2.getText()).matches()) {
                	JOptionPane.showMessageDialog(frame, "Hight and Weight must be numbers!","Warning!",JOptionPane.WARNING_MESSAGE);
        		}
        		else if(!textField1.getText().equals(textField2.getText())) {
                	JOptionPane.showMessageDialog(frame, "password and password confirm must be same!","Warning!",JOptionPane.WARNING_MESSAGE);
        		}
        		//next operation
        		else {
        			int result = JOptionPane.showConfirmDialog(
                            frame,
                            "submit£¿",
                            "Notice!",
                            JOptionPane.YES_NO_CANCEL_OPTION
                    );
                    System.out.println("choose result: " + result);
                    if (result==0) {
               
                    }
        		}
        	}
                });
    }
}
