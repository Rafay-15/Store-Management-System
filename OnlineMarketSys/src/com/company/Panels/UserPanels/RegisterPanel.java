package com.company.Panels.UserPanels;

import com.company.CustomFrame;
import com.company.FileHandling.UserRecords;
import com.company.Panels.LoginPanel;
import com.company.Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.jar.Attributes;

public class RegisterPanel extends JPanel {
    JTextField name, adress, email, userName, password;
    JButton register, back;
    public RegisterPanel(CustomFrame customFrame) throws IOException {
        setBounds(0,0, 900,600);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(4,4,4,4);
        c.gridx = 450; c.gridy=300; c.weightx=1; c.weighty =0;
        setOpaque(true);
//        setBackground(Color.GREEN);

        name = new JTextField(24);
        name.setText("Name");
        name.setForeground(Color.GRAY);
        name.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (name.getText().equals("Name")) {
                    name.setText("");
                    name.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (name.getText().isEmpty()) {
                    name.setText("Name");
                    name.setForeground(Color.GRAY);
                }
            }
        });
        add(name, c);

        adress = new JTextField(24);
        adress.setText("Address");
        adress.setForeground(Color.GRAY);
        adress.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (adress.getText().equals("Address")) {
                    adress.setText("");
                    adress.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (adress.getText().isEmpty()) {
                    adress.setText("Address");
                    adress.setForeground(Color.GRAY);
                }
            }
        });
        c.gridy=310;
        add(adress, c);

        email = new JTextField(24);
        email.setText("Email!");
        email.setForeground(Color.GRAY);
        email.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (email.getText().equals("Email!")) {
                    email.setText("");
                    email.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (email.getText().isEmpty()) {
                    email.setText("Email!");
                    email.setForeground(Color.GRAY);
                }
            }
        });
        c.gridy=320;
        add(email,c);

        userName = new JTextField(24);
        userName.setText("UserName (Can't be changed later!)");
        userName.setForeground(Color.GRAY);
        userName.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (userName.getText().equals("UserName (Can't be changed later!)")) {
                    userName.setText("");
                    userName.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (userName.getText().isEmpty()) {
                    userName.setText("UserName (Can't be changed later!)");
                    userName.setForeground(Color.GRAY);
                }
            }
        });
        c.gridy=330;
        add(userName,c);

        password = new JTextField(24);
        password.setText("Password");
        password.setForeground(Color.GRAY);
        password.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (password.getText().equals("Password")) {
                    password.setText("");
                    password.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (password.getText().isEmpty()) {
                    password.setText("Password");
                    password.setForeground(Color.GRAY);
                }
            }
        });
        c.gridy=340;
        add(password,c);

        //Registering a new user
        register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (name.getText().equals("Name")|| email.getText().equals("Email") || adress.getText().equals("Address")
                        ||userName.getText().equals("UserName (Can't be changed later!)") || password.getText().equals("Password")){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields!");
                }
                else if(!userCheck()){
                    JOptionPane.showMessageDialog(null, "User Name taken 😥\n    Try again!");
                }
                else{
                    UserRecords.createNewUserRecord(new User(name.getText(), adress.getText(), email.getText(),
                            userName.getText(), password.getText()));

                    JButton b = (JButton) e.getSource();
                    JPanel p = (JPanel) b.getParent();
                    Container f =  p.getParent();



                    //Taking User Back to log in screen!
                    if (f != null) {
                        for (Component c : f.getComponents()) {
                            if (c instanceof JButton || c instanceof JPanel) {
                                f.remove(c);
                            }
                        }
                    }
                    LoginPanel px = new LoginPanel((customFrame));

                    f.add(px);
                    f.validate();
                }
            }
        });
        c.gridx=450; c.gridy=350;
        add(register,c);

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
                LoginPanel px = new LoginPanel(customFrame);

                f.add(px);
                f.validate();
            }
        });

        add(back);

        setOpaque(false);
        revalidate();
        setVisible(true);
    }
    public boolean userCheck(){
        for(User u : UserRecords.readUserList()){
            if (u.getUserName().equals(userName.getText())){
                return false;
            }
        }
        return true;
    }
}
