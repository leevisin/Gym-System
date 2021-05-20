import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BookConfirm extends Interface{
    public BookConfirm(){
        JFrame jf = new JFrame("Main Menu");
        jf.setSize(300, 200);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        JLabel successLabel = new JLabel("You have booked the trainer successfully!");
        // successLabel.setFont(new Font(null, Font.PLAIN, 50));
        successLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel jp = new JPanel();
        jp.add(successLabel);

        jf.setContentPane(jp);
    }

    
}
