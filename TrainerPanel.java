import javax.swing.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TrainerPanel extends Interface {
    JPanel trainerPanel = new JPanel(new BorderLayout());
    
    public TrainerPanel(){}

    public JPanel trainerPanel(){
        try {
            File file = new File("texts/AllTrainer.txt");
            if(!file.exists()){
                new AllCourse();
            }
        } catch (Exception e) {
            System.out.println("Create Base Enviroment Error!");
        }
        
        trainerPanel.add(searchPanel(), BorderLayout.NORTH);
        trainerPanel.add(trainersPanel(), BorderLayout.CENTER);
        return trainerPanel;
    }
    
    public JPanel searchPanel(){
        JPanel searchPanel = new JPanel();
        JTextField textField = new JTextField(20);

        ImageIcon icon = new ImageIcon("images/search.png");
        JButton searchBtn = new JButton(icon);

        searchBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               String[][] searchTrainers = searchCourse("texts/AllTrainer.txt", textField.getText());
               trainerPanel.removeAll();
               trainerPanel.add(searchPanel(), BorderLayout.NORTH);
               trainerPanel.add(refreshTrainerPanel(searchTrainers), BorderLayout.CENTER);
               trainerPanel.revalidate();
            }
        });

        searchBtn.setMaximumSize(new Dimension(32,32));
        searchBtn.setIcon(icon);
        searchBtn.setHideActionText(true);
        searchBtn.setToolTipText("Click to Search");
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setFocusPainted(false);

        JLabel searchLabel = new JLabel("Search: ");
        searchLabel.setForeground(Color.WHITE);
        searchPanel.add(searchLabel);
        searchPanel.add(textField);
        searchPanel.add(searchBtn);
        searchPanel.setBackground(Color.DARK_GRAY);
        return searchPanel;
    }

    public JPanel trainersPanel(){
        
        int rows = readLine("texts/AllTrainer.txt"); // Trainer Number
        if(rows%3==0){
            rows /= 3;
        }
        else{
            rows = rows/3 + 1;
        }
        JPanel trainersPanel = new JPanel(new GridLayout(rows, 3, 5, 5));

        String[][] trainersInfo = readFromFile("texts/AllTrainer.txt");

        for(int i=0; i<trainersInfo.length; i++){
            String trainerName = trainersInfo[i][0];
            String trainerType = trainersInfo[i][1];
            String imagesPath = trainersInfo[i][2];
            String intro = trainersInfo[i][3];
            // Problem intro String can't be too long


            ImageIcon icon = new ImageIcon(trainersInfo[i][2]);
            JButton trainerBtn = new JButton(trainerName + ": " + trainerType, icon);

            trainerBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new BookInfo(trainerName, trainerType, imagesPath, intro);
                }
            });

            trainerBtn.setMaximumSize(new Dimension(600,828));
            trainerBtn.setIcon(icon);
            trainerBtn.setBackground(Color.WHITE);
            trainerBtn.setHideActionText(true);
            trainerBtn.setToolTipText("Click to Show Detail Information");
            trainerBtn.setBorderPainted(false);
            trainerBtn.setFocusPainted(false);
            trainerBtn.setVerticalTextPosition(JButton.BOTTOM);
            trainerBtn.setHorizontalTextPosition(JButton.CENTER);
            trainersPanel.add(trainerBtn);
        }

        return trainersPanel;
    }

    public JPanel refreshTrainerPanel(String[][] searchTrainers){
        
        int rows = searchTrainers.length; // Trainer Number
        if(rows%3==0){
            rows /= 3;
        }
        else{
            rows = rows/3 + 1;
        }
        JPanel trainersPanel = new JPanel(new GridLayout(rows, 3, 5, 5));

        for(int i=0; i<searchTrainers.length; i++){
            String trainerName = searchTrainers[i][0];
            String trainerType = searchTrainers[i][1];
            String imagesPath = searchTrainers[i][2];
            String intro = searchTrainers[i][3];

            ImageIcon icon = new ImageIcon(searchTrainers[i][2]);
            JButton trainerBtn = new JButton(searchTrainers[i][0], icon);

            trainerBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new BookInfo(trainerName, trainerType, imagesPath, intro);
                }
            });

            trainerBtn.setMaximumSize(new Dimension(600,828));
            trainerBtn.setIcon(icon);
            trainerBtn.setHideActionText(true);
            trainerBtn.setToolTipText("Click to Show Detail Information");
            trainerBtn.setBorderPainted(false);
            // trainerBtn.setContentAreaFilled(false);
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
