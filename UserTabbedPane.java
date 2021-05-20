import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/** 
 *  Created on 2021/5/18:The Tabbed Pane contain 3 parts of user information and activity
 * 
 * 
 */

public class UserTabbedPane extends Interface{
    public JTabbedPane userTabbedPane;


  /**
	 * Created a JTabedPane to contain 3 parts of user information
	 * @param 
	 * @return JTabbedPane, the created JTabbedPane
	 */
    public JTabbedPane userTabbedPane(){
        //initialize the JTabbedpanel
        userTabbedPane = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);
        
        //Adding 3 Pane

        //No.1 User information
        ImageIcon icon = createImageIcon("images/middle.gif");
        UserInfoPane uip = new UserInfoPane();
        userTabbedPane.addTab("User Info", icon,uip.makeUserInfoPane(userTabbedPane));

        //No.2 Booked Trainer Information
        BookedTrainerPane btp = new BookedTrainerPane();
        userTabbedPane.addTab("BookedTrainer", icon,btp.makeBookedTrainerPane(userTabbedPane));

        //No.3 Recommendation Page
        RecommendationPane rdp = new RecommendationPane();
        userTabbedPane.addTab("Recommendation", icon,rdp.makeRecomPane(userTabbedPane));





        return userTabbedPane;
        
    }
    
protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {
        System.err.println("Couldn't find file: " + path);
        return null;
    }
}

public static void main(String[] args){
    JFrame frame = new JFrame("TabbedPaneDemo");
        
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setLocation(1100, 600);
    // frame.setLocationRelativeTo(null);
    //Add content to the window.
    frame.add(new UserTabbedPane().userTabbedPane(), BorderLayout.CENTER);
    
    //Display the window.   
    frame.pack();
    frame.setVisible(true);
}


}