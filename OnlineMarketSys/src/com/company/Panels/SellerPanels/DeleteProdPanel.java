package com.company.Panels.SellerPanels;

import com.company.CustomFrame;
import com.company.FileHandling.ProductHandling;
import com.company.Panels.ProductPanel;
import com.company.Panels.SellerPanel;
import com.company.Products.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class DeleteProdPanel extends JPanel {
    JTextField pID;
    JButton back, Delete;
    public DeleteProdPanel(CustomFrame cf){
        setBounds(0,0,900,600);
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(4,4,4,4);
        c.gridx = 450; c.gridy=200; c.weightx=1; c.weighty =0;

        back = new JButton("Back");
        back.setFocusable(false);
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

                f.add(new SellerPanel(cf));
                f.validate();
            }
        });
        add(back);

        pID = new JTextField(24);
        pID.setText("Product ID");
        c.gridx=450; c.gridy=310;
        pID.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(pID.getText().equals("Product ID")){
                    pID.setText("");
                    pID.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (pID.getText().isEmpty()){
                    pID.setText("Product ID");
                    pID.setForeground(Color.GRAY);
                }
            }
        });
        add(pID,c);

        Delete= new JButton("Delete");
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Product> NewArray = new ArrayList<>();
                for(Product p: ProductHandling.readFromFile()){
                    if (!p.getpID().equals(pID.getText())){
                        NewArray.add(p);
                    }
                }
                ProductHandling.writeToFile(NewArray);

                for (Product p : ProductHandling.readFromFile()){
                    if (p.getpID().equals(pID.getText())){
                        JOptionPane.showMessageDialog(null, "Product Not Deleted, Try Again!");
                        JButton b = (JButton) e.getSource();
                        JPanel pa = (JPanel) b.getParent();
                        Container f =  pa.getParent();
                        if (f != null) {
                            for (Component c : f.getComponents()) {
                                if (c instanceof JButton || c instanceof JPanel) {
                                    f.remove(c);
                                }
                            }
                        }

                        f.add(new DeleteProdPanel(cf));
                        f.validate();
                    }
                }
                JOptionPane.showMessageDialog(null, "Product Delete!");

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
                f.add(new SellerPanel(cf));
                f.validate();
            }
        });
        c.gridy= 220;
        add(Delete, c);

    }
}
