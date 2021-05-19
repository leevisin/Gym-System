import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Main Menu");
        jf.setSize(1280, 720);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        final JTabbedPane tabbedPane = new JTabbedPane();


        tabbedPane.addTab("Home", createTextPanel("Home Panel"));

        tabbedPane.addTab("Video", new ImageIcon("bb.jpg"), createTextPanel("Video Panel"));

        tabbedPane.addTab("Trainer", new ImageIcon("bb.jpg"), new TrainerPanel().scrollPanel(), "This is a tab.");

        tabbedPane.addTab("User", new ImageIcon("bb.jpg"), new UserTabbedPane().userTabbedPane(), "This is a tab.");

        tabbedPane.addTab("Administer", new ImageIcon("bb.jpg"), createTextPanel("Administer Panel"), "This is a tab.");


        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Selected Tab: " + tabbedPane.getSelectedIndex());
            }
        });

        tabbedPane.setSelectedIndex(0);

        jf.setContentPane(tabbedPane);
        jf.setVisible(true);
    }

    private static JComponent createTextPanel(String text) {

        JPanel panel = new JPanel(new GridLayout(1, 1));
        
        JLabel label = new JLabel(text);
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label);

        return panel;
    }

}