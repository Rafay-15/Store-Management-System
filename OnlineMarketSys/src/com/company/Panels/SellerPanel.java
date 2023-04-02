package com.company.Panels;

import com.company.CustomFrame;
import com.company.Panels.SellerPanels.AddProdPanel;
import com.company.Panels.SellerPanels.DeleteProdPanel;
import com.company.Panels.SellerPanels.SearchProdPanel;
import com.company.Panels.SellerPanels.UpdateProdPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerPanel extends JPanel {
    JButton search, add, update, delete, logOut;

    public SellerPanel(CustomFrame customFrame){
        setBounds(0,0,900,600);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(4,4,4,4);
        c.gridx = 450; c.gridy=300; c.weightx=1; c.weighty =0;

        setOpaque(false);
//        setBackground(Color.GRAY);
        Dimension d = new Dimension(150, 20);

        logOut = new JButton("LogOut!");
        logOut.addActionListener(new ActionListener() {
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
        });
        add(logOut);

        search = new JButton("Search Product");
        search.setPreferredSize(d);
        search.addActionListener(new ActionListener() {
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

                f.add(new SearchProdPanel(customFrame));
                f.revalidate();
            }
        });


        add = new JButton("Add New Product");
        add.setPreferredSize(d);
        add.addActionListener(new ActionListener() {
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
                AddProdPanel app = new AddProdPanel(customFrame);
                f.add(app);
                f.revalidate();
            }
        });


        update = new JButton("Update Product");
        update.setPreferredSize(d);
        update.addActionListener(new ActionListener() {
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

                f.add(new UpdateProdPanel(customFrame));
                f.revalidate();
            }
        });


        delete = new JButton("Delete Product");
        delete.setPreferredSize(d);
        add(delete, c);
        delete.addActionListener(new ActionListener() {
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

                f.add(new DeleteProdPanel(customFrame));
                f.revalidate();
            }
        });

        add(add, c);
        c.gridy= 320;
        add(search, c);
        c.gridy= 340;
        add(update, c);
        c.gridy= 360;
        add(delete, c);
        revalidate();
    }
}
