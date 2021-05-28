import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookInfo extends Interface {

    JFrame frame = new JFrame();

    public BookInfo(String trainerName, String trainerType, String imagePath, String intro){
        // Show BookInfo Page to User
        // Record the book information into BookInfo.txt
        // Add Back Button
        
        frame.setTitle("Trainer Detail Infomation");
        frame.pack();
        frame.setSize(1280, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setContentPane(trainerDetailInfo(trainerName, trainerType, imagePath, intro));
    }




    public static void Button_Back(JButton Button,String ImagePath){

        Button.setBounds(0, 0, 300, 200);
        ImageIcon imageBack = new ImageIcon(ImagePath);
        Image suitable = imageBack.getImage().getScaledInstance(Button.getWidth(), Button.getHeight(), imageBack.getImage().SCALE_DEFAULT);
        imageBack = new ImageIcon(suitable);
        Button.setIcon(imageBack);
        Button.setToolTipText("image");
        Button.setBorderPainted(false);
        Button.setFocusPainted(false);
        Button.setVerticalTextPosition(JButton.BOTTOM);
        Button.setHorizontalTextPosition(JButton.CENTER);
    }

    public JPanel trainerDetailInfo(String trainerName, String trainerType, String imagePath, String intro){
        JPanel infoPanel = new JPanel(new BorderLayout());
        JPanel imagesPanel = new JPanel();
        JPanel textPanel = new JPanel(new BorderLayout());
        JPanel blankPanel = new JPanel();

        JButton bookBtn = new JButton("Click to Book Trainer");
        JButton returnBtn = new JButton("Return");

        JPanel namePanel = trainerName(trainerName);
        JPanel typePanel = trainerType(trainerType);
        namePanel.add(typePanel);
        
        blankPanel.setPreferredSize(new Dimension(10, 20));
        blankPanel.setBackground(Color.WHITE);

        // Need to change line may be not JLabel
        JTextArea textArea = new JTextArea("    " + intro);
        textArea.setLineWrap(true);
        textArea.setFont(new Font("Microsoft Serif Pro", Font.PLAIN, 30));
        textArea.setBackground(Color.WHITE);

        typePanel.add(textArea);
        textPanel.setBackground(Color.WHITE);
        textPanel.add(namePanel, BorderLayout.NORTH);


        bookBtn.setSize(50,50);
        bookBtn.setBackground(Color.YELLOW);
        bookBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new BookConfirm(trainerName, trainerType);
            }
        });

        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.add(bookBtn, BorderLayout.CENTER);

        returnBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Close current window
                frame.setVisible(false);
            }
        });
        returnBtn.setContentAreaFilled(false);
        btnPanel.add(returnBtn, BorderLayout.EAST);



        btnPanel.add(blankPanel, BorderLayout.SOUTH);
        
        textPanel.add(btnPanel, BorderLayout.SOUTH);





        imagesPanel.add(trainerPicture(imagePath));
        imagesPanel.setBackground(Color.WHITE);

        infoPanel.add(imagesPanel, BorderLayout.WEST);
        infoPanel.add(textPanel, BorderLayout.CENTER);
        return infoPanel;
    }

    public JButton trainerPicture(String imagePath){
        ImageIcon icon = new ImageIcon(imagePath);
        JButton trainerBtn = new JButton(icon);
        trainerBtn.setMaximumSize(new Dimension(600,828));
        trainerBtn.setIcon(icon);
        trainerBtn.setHideActionText(true);
        trainerBtn.setToolTipText("Click to Show Detail Information");
        trainerBtn.setBorderPainted(false);
        trainerBtn.setContentAreaFilled(false);
        trainerBtn.setFocusPainted(false);
        trainerBtn.setVerticalTextPosition(JButton.BOTTOM);
        trainerBtn.setHorizontalTextPosition(JButton.CENTER);
        return trainerBtn;
    }

    public JPanel trainerName(String trainerName){
        JPanel trainerNamePanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(trainerName);
        label.setForeground(Color.WHITE);
        label.setFont(new Font(null, Font.BOLD, 150));
        label.setHorizontalAlignment(SwingConstants.LEFT);

        trainerNamePanel.add(label, BorderLayout.NORTH);
        trainerNamePanel.setBackground(Color.DARK_GRAY);
        return trainerNamePanel;
    }

    public JPanel trainerType(String trainerType){
        JPanel trainerTypePanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(trainerType + "   ");
        label.setForeground(Color.BLACK);
        label.setFont(new Font(null, Font.PLAIN, 50));
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        trainerTypePanel.add(label, BorderLayout.NORTH);
        trainerTypePanel.setBackground(Color.LIGHT_GRAY);
        return trainerTypePanel;
    }
}

