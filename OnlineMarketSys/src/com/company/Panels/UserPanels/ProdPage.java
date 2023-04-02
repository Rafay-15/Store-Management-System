package com.company.Panels.UserPanels;

import com.company.CustomFrame;
import com.company.FileHandling.UserRecords;
import com.company.Panels.LoginPanel;
import com.company.Products.Product;
import com.company.Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ProdPage extends JPanel {
    User user;
    Product product;
    public ProdPage(Product p , User user, CustomFrame customFrame) {
        this.product = p;
        this.user = user;

        setSize(new Dimension(900,600));
        setBackground(Color.white);
        setOpaque(true);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton back = new JButton("Back!");
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
                UserFrontPage px = new UserFrontPage(user,customFrame);

                f.add(px);
                f.validate();
            }
        });

        add(back);


        JLabel jl = new JLabel();
        ImageIcon ii = new ImageIcon(p.getImage());
        jl.setIcon(ii);
        this.add(jl);
        this.add(Box.createVerticalStrut(10));

        JLabel pName = new JLabel(p.getName());
        this.add(pName);
        add(Box.createVerticalStrut(12));

        JLabel price = new JLabel("Rs. "+ p.getCost());
        this.add(price);

        JTextArea description = new JTextArea(p.getDescription(), 5,10);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        add(description);
        add(Box.createHorizontalGlue());

        JButton buy = new JButton("Buy Now!");
        JButton wishlist = new JButton(" Add to WishList ");

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<User> users = UserRecords.readUserList();
                for (User u : users){
                    if (Objects.equals(u.getUserName(), user.getUserName())){
                        u.getOrders().add(product);
                        break;
                    }
                }
                UserRecords.updateuserRecord(users);
            }
        });

        wishlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<User> users = UserRecords.readUserList();
                for (User u : users){
                    if (Objects.equals(u.getUserName(), user.getUserName())){
                        u.getWishList().add(product);
                        break;
                    }
                }
                UserRecords.updateuserRecord(users);
            }
        });

        buy.add(Box.createVerticalStrut(5));
        wishlist.add(Box.createVerticalStrut(5));

        add(buy);
        add(wishlist);


        setOpaque(false);
        revalidate();
        setVisible(true);

    }


}