package com.company.Panels;

import com.company.FileHandling.AdminRecords;
import com.company.FileHandling.UserRecords;
import com.company.CustomFrame;
import com.company.Panels.UserPanels.RegisterPanel;
import com.company.Panels.UserPanels.UserFrontPage;
import com.company.Users.Seller;
import com.company.Users.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginPanel extends JPanel {
    JTextField t1,t2;
    JButton login, back, register;
    public LoginPanel(CustomFrame customFrame)  {
        System.out.println("HERE!");
        setBounds(0,0, 900,600);

        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("C:\\\\Users\\\\mrafa\\\\IdeaProjects\\\\OnlineMarketSys\\\\Images\\\\BackgroundPicR.jpg"));
        }catch(IOException e){
            System.out.println("IO EXCENPTION LOGINPANEL LINE32");
        }
//        this.setBackground(new ImageIcon(img));


        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(4,4,4,4);
        c.gridx = 450; c.gridy=300; c.weightx=1; c.weighty =0;
        setOpaque(true);

        //  UserName Text Feild
        t1 =new JTextField(20);
        t1.setText("UserName");
        t1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (t1.getText().equals("UserName")) {
                    t1.setText("");
                    t1.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (t1.getText().isEmpty()) {
                    t1.setText("UserName");
                    t1.setForeground(Color.GRAY);
                }
            }
        });
        add(t1, c);


        //Password TextFeild
        t2 = new JPasswordField(20);
        t2.setText("Password");
        c.gridx=450; c.gridy=310;
        t2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(t2.getText().equals("Password")){
                    t2.setText("");
                    t2.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (t2.getText().isEmpty()){
                    t2.setText("Password");
                    t2.setForeground(Color.GRAY);
                }
            }
        });
        add(t2,c);


        //LoginButton
        login = new JButton("Login!");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JPanel p= (JPanel) b.getParent();
                Container f = p.getParent();
                if (b.getText().equals("Login!")){
                    for(User s: UserRecords.readUserList()){
                        if(t1.getText().equals(s.getUserName())&&t2.getText().equals(s.getPassword())){
                            for (Component c : f.getComponents()) {
                                if (c instanceof JButton || c instanceof JPanel) {
                                    f.remove(c);
                                }
                            }

                            UserFrontPage up = new UserFrontPage(s, customFrame);
                            JScrollPane upj = new JScrollPane(up);
                            up.setOpaque(false);
                            upj.setOpaque(false);
                            upj.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                            f.add(upj);
                            f.revalidate();

                        }
                    }

                }
            }
        });
        c.gridx=450; c.gridy=320;
        add(login, c);
        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JPanel p = (JPanel) b.getParent();
                Container f =  p.getParent();
                if (f != null) {
                    for (Component c : f.getComponents()) {
                        if (c instanceof JButton || c instanceof JPanel) {
                            f.remove(c);
                        }
                    }
                }

                f.repaint();
                LoginTypePanel l = new LoginTypePanel(customFrame);
                f.add(l);
                f.validate();
            }
        });
        add(back);


        //RegisterButton!
        Dimension x = new Dimension(190,21);
        register = new JButton("Not a User? Register Now!");
        register.setPreferredSize(x);
        register.setFocusable(false);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JPanel p = (JPanel) b.getParent();
                Container f =  p.getParent();
                if (f != null) {
                    for (Component c : f.getComponents()) {
                        if (c instanceof JButton || c instanceof JPanel) {
                            f.remove(c);
                        }
                    }
                }

                f.repaint();
                RegisterPanel r = null;
                try {
                    r = new RegisterPanel(customFrame);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                f.add(r);
                f.validate();
            }
        });
        c.gridy=330;
        add(register, c);

        //Setting requisites for the panel
        setOpaque(false);
        validate();
        revalidate();
        setVisible(true);
        repaint();
    }
}
