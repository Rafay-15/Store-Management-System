package com.company;

import com.company.Panels.LoginTypePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomFrame extends JFrame {
    public CustomFrame() throws IOException {
        setLayout(null);
        setResizable(false);
        Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2 )- (450);
        int y = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2) - 300;
        setLocation(x, y);
        setTitle("Generic Online Store");
        Image logo = ImageIO.read(new File("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\Images\\icon.jpg"));
        setIconImage(logo);
        setSize(900,600);




        final Image backgroundImage = javax.imageio.ImageIO.read(new File("C:\\\\Users\\\\mrafa\\\\IdeaProjects\\\\OnlineMarketSys\\\\Images\\\\BackgroundPicR.jpg"));
        backgroundImage.getScaledInstance(900,600, Image.SCALE_DEFAULT);
        setContentPane(new JPanel(new BorderLayout()) {
            @Override public void paintComponent(Graphics g) {
                g.drawImage(backgroundImage, 0, 0, null);
            }
        });

        LoginTypePanel l = new LoginTypePanel(this);
        add(l);

        setVisible(true);
    }

    public void updateFrame() throws IOException {
        this.dispose();
        revalidate();
        new Frame();
        revalidate();
    }
}