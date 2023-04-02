package com.company.Panels.SellerPanels;

import com.company.CustomFrame;
import com.company.FileHandling.ProductHandling;
import com.company.HomeAppliances.Entertainment;
import com.company.Panels.SellerPanel;
import com.company.Products.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UPanel extends JPanel {

    JTextField name,description, cost,stock, imagePath;
    JButton back, update;

    public UPanel(Product p, CustomFrame customFrame){
        setBounds(0,0,900,600);
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets= new Insets(4,4,4,4);
        c.gridx = 450; c.gridy=100; c.weightx=1; c.weighty =0;
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
                f.add(new UpdateProdPanel(customFrame));
                f.validate();
            }
        });
        add(back);

        name =new JTextField(24);
        name.setText(p.getName());
        add(name, c);

        description = new JTextField(24);
        description.setText(p.getDescription());
        c.gridy= 120;
        add(description,c);

        cost = new JTextField(24);
        cost.setText(String.valueOf(p.getCost()));
        c.gridy= 140;
        add(cost,c);

        stock = new JTextField(24);
        stock.setText(String.valueOf(p.getStock()));
        c.gridy = 160;
        add(stock, c);

        imagePath = new JTextField(24);
        imagePath.setText(p.getImage());
        c.gridy = 180;
        add(imagePath, c);

        update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Product> NewList = ProductHandling.readFromFile();
                for (Product pa: NewList){
                    if (pa.getpID().equals(p.getpID())){
                        System.out.println("UPANEL LINE77!");
                        pa.setName(name.getText());
                        pa.setDescription(description.getText());
                        pa.setImage(imagePath.getText());
                        pa.setCost(Integer.parseInt(cost.getText()));
                        pa.setStock(Integer.parseInt(stock.getText()));
                    }
                }

                ProductHandling.writeToFile(NewList);

                for(Product i : ProductHandling.readFromFile()){
                    if(i.getName().equals(name.getText()) && i.getImage().equals(imagePath.getText()) &&
                       i.getCost()==Integer.parseInt(cost.getText()) && i.getStock()==Integer.parseInt(stock.getText())&&
                        i.getDescription().equals(description.getText())){
                        JOptionPane.showMessageDialog(null, "Updated!");
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
                        f.validate();
                    }
                }
            }
        });
        c.gridy = 200;
        add(update,c);
    }
}
