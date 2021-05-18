import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
//this class is use to test the JTabbedPane in JTabbedPane

public class PaneInPaneTest{
    public static void main(String[] args){
        JTabbedPane jtout = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
        JTabbedPane jtin = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);

        jtout.addTab("try1", jtin);
        JComponent panel1 = makeTextPanel("Panel #1");
        JComponent panel2 = makeTextPanel("Panel #2");
        JComponent panel3 = makeTextPanel("Panel #3");
        jtin.addTab("1",panel1);
        jtin.addTab("2",panel2);
        jtin.addTab("3",panel3);


        JFrame frame = new JFrame("TabbedPaneDemo");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLocation(30, 20);
        // frame.setLocationRelativeTo(null);
        //Add content to the window.
        frame.add(jtout, BorderLayout.CENTER);
        
        //Display the window.   
        frame.pack();
        frame.setVisible(true);

        

    }

    
public static JComponent makeTextPanel(String text) {
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel(text);
    filler.setHorizontalAlignment(JLabel.CENTER);
     panel.setLayout(new GridLayout(1, 1));
    panel.add(filler);
    return panel;
    }
}