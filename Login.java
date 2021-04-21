
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Objects;

public class Login extends JFrame {
    JTextField accountField;
    JPasswordField passwordField;

    public Login() throws HeadlessException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 600, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Dialog", Font.PLAIN, 35));
        titleLabel.setBounds(245, 50, 100, 80);
        contentPane.add(titleLabel);

        JLabel accountLabel = new JLabel("Account:");
        accountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        accountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        accountLabel.setBounds(50, 150, 100, 30);
        contentPane.add(accountLabel);

        accountField = new JTextField();
        accountField.setBounds(170, 150, 145, 25);
        contentPane.add(accountField);
        accountField.setColumns(10);

        JLabel  passwordLabel= new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setBounds(65, 225, 100, 30);
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(170, 225, 145, 25);
        contentPane.add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 350, 100, 30);
        contentPane.add(registerButton);

        JButton loginButton = new JButton("Login in");
        loginButton.setBounds(300, 350, 100, 30);
        contentPane.add(loginButton);

        JLabel backgroundLabel = new JLabel("");
        backgroundLabel.setIcon(new ImageIcon(Login.class.getResource("background.jpg")));
        backgroundLabel.setBounds(0, 0, 600, 800);
        contentPane.add(backgroundLabel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText();
                String password = String.valueOf(passwordField.getPassword());
                boolean login = false;
                List<Member> members = Util.readFile();
                for (Member member : Objects.requireNonNull(members)) {
                    if (member.getAccount().equals(account) && member.getPassword().equals(password)) { 
                        Util.recordCurrentUser(member);//record current user
                        login = true;
                        break;
                    }
                }
                if (login) {
                    JOptionPane.showMessageDialog(Login.super.rootPane, "Login Success!");
                    Login.super.dispose();
                    new Menu().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(Login.super.rootPane, "Login Error!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login.super.dispose();
                new Register().setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}

   /**
	 * updated on 2021/4/21: able to record current user when log in
	 * 
	 */