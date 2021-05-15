import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class TestPanel extends JFrame{
    public TestPanel(){
        JPanel jp = new JPanel();
        JScrollPane jsp = new JScrollPane(jp, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        URL url = TestPanel.class.getResource("images/search.png");
        Icon icon = new ImageIcon(url);


        JButton jBtn = new JButton(icon);

        jBtn.setMaximumSize(new Dimension(32,32));//设置按钮和图片的大小相同
        jBtn.setIcon(icon);//为按钮设置图标
        jBtn.setHideActionText(true);
        jBtn.setToolTipText("图片按钮");//设置按钮提示为文字
        jBtn.setBorderPainted(false);//设置按钮边界不显示
        jBtn.setContentAreaFilled(false);
        jBtn.setFocusPainted(false);

        // jBtn.setSize(50,50);
        jp.add(jBtn);
        // jsp.add(jp);
        JLabel TestLabel = new JLabel("This is a Test Label");
        // jsp.add(TestLabel);
        getContentPane().add(jsp);

        setTitle("Test");
        setVisible(true);
        setSize(1280,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // String[][] test = new String[2][3];
        // System.out.println(test.length);
        // System.out.println(test[0].length);
        new TestPanel();
    }
}
