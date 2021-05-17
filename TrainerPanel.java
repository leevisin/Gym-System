import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TrainerPanel extends Interface {
    public TrainerPanel(){}

    public JPanel trainerPanel(){
        JPanel trainerPanel = new JPanel(new BorderLayout());
        
        trainerPanel.add(searchPanel(), BorderLayout.NORTH);
        trainerPanel.add(trainersPanel(), BorderLayout.CENTER);
        return trainerPanel;
    }
    
    public JPanel searchPanel(){
        JPanel searchPanel = new JPanel();
        JTextField textField = new JTextField(20);
        String userInput = textField.getText();

        URL url = TrainerPanel.class.getResource("images/search.png");
        Icon icon = new ImageIcon(url);
        JButton searchBtn = new JButton(icon);
        searchBtn.setMaximumSize(new Dimension(32,32));
        searchBtn.setIcon(icon);
        searchBtn.setHideActionText(true);
        searchBtn.setToolTipText("Click to Search");
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setFocusPainted(false);

        searchPanel.add(textField);
        searchPanel.add(searchBtn);

        return searchPanel;
    }

    public JPanel trainersPanel(){
        
        int rows = readLine("Source/AllTrainer.txt"); // Trainer Number
        if(rows%3==0){
            rows /= 3;
        }
        else{
            rows = rows/3 + 1;
        }
        JPanel trainersPanel = new JPanel(new GridLayout(rows, 3));

        String[][] trainersInfo = readFromFile("Source/AllTrainer.txt");

        for(int i=0; i<trainersInfo.length; i++){
            String trainerName = trainersInfo[i][0];
            String trainerType = trainersInfo[i][1];
            String imagesPath = trainersInfo[i][2];

            ImageIcon icon = new ImageIcon(trainersInfo[i][2]);
            JButton trainerBtn = new JButton(trainersInfo[i][0], icon);

            trainerBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new BookInfo(trainerName, trainerType, imagesPath);
                }
            });

            trainerBtn.setMaximumSize(new Dimension(600,828));
            trainerBtn.setIcon(icon);
            trainerBtn.setHideActionText(true);
            trainerBtn.setToolTipText("Click to Show Detail Information");
            trainerBtn.setBorderPainted(false);
            trainerBtn.setContentAreaFilled(false);
            trainerBtn.setFocusPainted(false);
            trainerBtn.setVerticalTextPosition(JButton.BOTTOM);
            trainerBtn.setHorizontalTextPosition(JButton.CENTER);
            trainersPanel.add(trainerBtn);
        }

        
        return trainersPanel;
    }

    public JScrollPane scrollPanel(){
        JScrollPane scrollPanel = new JScrollPane(
                trainerPanel(),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        return scrollPanel;
    }


}
