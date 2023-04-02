package com.company.Panels;

import com.company.CustomFrame;
import com.company.FileHandling.AdminRecords;
import com.company.Users.Seller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;



public class AdminLoginPanel extends JPanel {
    JTextField t1,t2;
    JButton login, back;
    public AdminLoginPanel (CustomFrame customFrame){
        System.out.println("HERE!");
        setBounds(0,0, 900,600);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(4,4,4,4);
        c.gridx = 450; c.gridy=300; c.weightx=1; c.weighty =0;
        setOpaque(true);
        setBackground(Color.GREEN);



        t1 =new JTextField(20);
        t1.setPreferredSize(new Dimension((int) t1.getPreferredSize().getWidth(), 30));
        t1.setText("Admin Name");
        t1.setForeground(Color.GRAY);


        t1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (t1.getText().equals("Admin Name")) {
                    t1.setText("");
                    t1.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (t1.getText().isEmpty()) {
                    t1.setText("Admin Name");
                    t1.setForeground(Color.GRAY);
                }
            }
        });
        add(t1, c);



        t2 = new JPasswordField(20);
        t2.setText("Password");
        t2.setPreferredSize(new Dimension((int) t2.getPreferredSize().getWidth(), 30));
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

        login = new JButton("Login!");
        login.setFocusable(false);
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

                LoginTypePanel l = new LoginTypePanel(customFrame);
                f.add(l);
                f.validate();
            }
        });        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JPanel p= (JPanel) b.getParent();
                Container f = p.getParent();
                for(Seller s: AdminRecords.readFromFile()){
                    if(t1.getText().equals(s.getUserName())&&t2.getText().equals(s.getPassword())){
                        for (Component c : f.getComponents()) {
                            if (c instanceof JButton || c instanceof JPanel) {
                                f.remove(c);
                            }
                        }
                        SellerPanel sp = new SellerPanel(customFrame);
                        f.add(sp);
                        f.revalidate();
                        // TODO: 29/12/2022  create new panel!
                    }
                }

            }
        });
        c.gridx=450; c.gridy=320;


        add(login,c);



        add(back);

        setOpaque(false);
        revalidate();
        setVisible(true);
    }
}
