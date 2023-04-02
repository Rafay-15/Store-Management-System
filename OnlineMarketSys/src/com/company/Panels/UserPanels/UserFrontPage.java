package com.company.Panels.UserPanels;

import com.company.FileHandling.ProductHandling;
import com.company.CustomFrame;
import com.company.Panels.LoginPanel;
import com.company.Products.Product;
import com.company.Users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class UserFrontPage extends JPanel implements MouseListener {
    User user;
    public CustomFrame customFrame;
    public UserFrontPage(User u, CustomFrame customFrame ){
        //Carry the user
        this.user =u;
        this.customFrame = customFrame;
        setSize(new Dimension(900, 550));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        JButton back = new JButton("Logout!");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pressed!");

                JButton b = (JButton) e.getSource();
                JPanel p = (JPanel) b.getParent();
                Container f =  p.getParent();
                if (f != null) {
                    for (Component c : f.getComponents()) {
                        if (c instanceof JButton || c instanceof JPanel || c instanceof JFrame) {
                            f.remove(c);
                        }
                    }
                }
                customFrame.dispose();
                try {
                    new CustomFrame();
                } catch (IOException ex) {
                    System.out.println("Erroe USERFP LINE46");
                }
                revalidate();
            }
        });

        add(back);


        for(Product p : ProductHandling.readFromFile()){
            FPProdDisplay pp = new FPProdDisplay(p, user, customFrame);
            pp.addMouseListener(this);
            add(pp);
            add(Box.createVerticalStrut(5));

        }

        setOpaque(true);
        revalidate();
    }

    public CustomFrame getCustomFrame() {
        return customFrame;
    }

    public void setCustomFrame(CustomFrame customFrame) {
        this.customFrame = customFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        FPProdDisplay p= (FPProdDisplay) e.getSource();
        JPanel Jp= (JPanel) p.getParent();
        Container f = p.getParent();
        for (Component c : f.getComponents()) {
            if (c instanceof JButton || c instanceof JPanel) {
                f.remove(c);
            }
        }

       f.add(new ProdPage(p.getProduct(), p.getUser(), p.getCf()));
        f.revalidate();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}