import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Scrollpicture extends JFrame{
MyJPanel ep;
int index;
public ImageIcon[] imgs={
  new ImageIcon("images/Logo.jpg");
  new ImageIcon("images/Discount.jpg");
   };

public Scrollpicture(){
    ep = new MyJPanel();
    this.add(ep);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setTitle("窗口");
    this. setVisible (true);
    Timer timer = new Timer(5000, addActionListener(){
            public void actionPerformed(ActionEvent e) {
                ep.repaint();
            }
    
    timer.start();
}
public static void main(String[] args){ 
  new Scrollpicture();
}
class MyJPanel extends JPanel{
    public void paint(Graphics g){
    super.paint(g);
    g.drawImage(imgs[index%imgs.length].getImage(), 0, 0, this);
    index++;
}
}
}
