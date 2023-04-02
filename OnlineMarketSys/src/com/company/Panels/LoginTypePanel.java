package com.company.Panels;
import com.company.CustomFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginTypePanel extends JPanel {
    JButton user, admin;
    public LoginTypePanel(CustomFrame customFrame){
        setLayout(new GridBagLayout());
        setBackground(Color.green);

        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(4,4,4,4);
        c.gridx = 0; c.gridy=0; c.weightx=1; c.weighty =0;
        setOpaque(true);

        user = new JButton("Customer");
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JPanel p = (JPanel) b.getParent();
                Container f =  p.getParent();
                for (Component c : f.getComponents()) {
                    if (c instanceof JButton || c instanceof JPanel) {
                        f.remove(c);
                    }
                }

                LoginPanel lp = new LoginPanel(customFrame);
                f.add(lp);
                f.validate();
            }
        });
        user.setFocusable(false);
        add(user, c);

        admin = new JButton("Seller");
        admin.setFocusable(false);
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JPanel p = (JPanel) b.getParent();
                Container f =  p.getParent();
                for (Component c : f.getComponents()) {
                    if (c instanceof JButton || c instanceof JPanel) {
                        f.remove(c);
                    }
                }

                AdminLoginPanel al = new AdminLoginPanel(customFrame);
                f.add(al);
                f.validate();
            }
        });
        c.gridx = 0;
        c.gridy=1;
        add(admin,c);

        repaint();
        setOpaque(false);
        setVisible(true);
    }
}
