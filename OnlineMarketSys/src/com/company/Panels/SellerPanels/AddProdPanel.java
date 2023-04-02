package com.company.Panels.SellerPanels;

import com.company.CustomFrame;
import com.company.Electronics.Laptop;
import com.company.Electronics.LaptopAccessories;
import com.company.Electronics.MobileAccessories;
import com.company.Electronics.Mobiles;
import com.company.FileHandling.ProductHandling;
import com.company.HomeAppliances.Entertainment;
import com.company.HomeAppliances.KitchenAppliences;
import com.company.Panels.LoginTypePanel;
import com.company.Panels.SellerPanel;
import com.company.Products.Product;
import com.company.UtilityTools.GardeningTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.BitSet;

public class AddProdPanel extends JPanel {
    JButton back, add;
    JTextField name,pID,description, cost,stock, imagePath;
    JRadioButton Laptop, LaptopAccessories, MobileAccessories,
            Mobile, Entertainment, KitchenAppliance, GardenTool;
    ButtonGroup bg =new ButtonGroup();
    public AddProdPanel(CustomFrame cf){
        setSize(900,600);
        setOpaque(false);
        setBackground(Color.GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Dimension dimension = new Dimension(100, 15);

        add(Box.createHorizontalGlue());

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

                f.add(new SellerPanel(cf));
                f.validate();
            }
        });
        add(back);

        Laptop = new JRadioButton("Laptop");
        Laptop.setPreferredSize(dimension);
        bg.add(Laptop);
        add(Laptop);

        LaptopAccessories = new JRadioButton("Laptop Accessories");
        bg.add(LaptopAccessories);
        LaptopAccessories.setPreferredSize(dimension);
        add(LaptopAccessories);

        Mobile = new JRadioButton("Mobile");
        bg.add(Mobile);
        Mobile.setPreferredSize(dimension);
        add(Mobile);


        MobileAccessories = new JRadioButton("Mobile Accessories");
        bg.add(MobileAccessories);
        MobileAccessories.setPreferredSize(dimension);
        add(MobileAccessories);

        Entertainment= new JRadioButton("Entertainment");
        bg.add(Entertainment);
        Entertainment.setPreferredSize(dimension);
        add(Entertainment);

        GardenTool= new JRadioButton("GardenTool");
        bg.add(GardenTool);
        GardenTool.setPreferredSize(dimension);
        add(GardenTool);

        KitchenAppliance= new JRadioButton("HomeAppliance");
        bg.add(KitchenAppliance);
        KitchenAppliance.setPreferredSize(dimension);
        add(KitchenAppliance);


        add(Box.createHorizontalGlue());



        name = new JTextField(24);
        name.setText("Product Name");
        name.setForeground(Color.GRAY);
        name.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (name.getText().equals("Product Name")) {
                    name.setText("");
                    name.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (name.getText().isEmpty()) {
                    name.setText("Product Name");
                    name.setForeground(Color.GRAY);
                }
            }
        });
        add(name);

        pID = new JTextField(24);
        pID.setText("Product ID");
        pID.setForeground(Color.GRAY);
        pID.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (pID.getText().equals("Product ID")) {
                    pID.setText("");
                    pID.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (pID.getText().isEmpty()) {
                    pID.setText("Product ID");
                    pID.setForeground(Color.GRAY);
                }
            }
        });
        add(pID);

        description = new JTextField(24);
        description.setText("Product Description");
        description.setForeground(Color.GRAY);
        description.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (description.getText().equals("Product Description")) {
                    description.setText("");
                    description.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (description.getText().isEmpty()) {
                    description.setText("Product Description");
                    description.setForeground(Color.GRAY);
                }
            }
        });
        add(description);

        cost = new JTextField(24);
        cost.setText("Product Price");
        cost.setForeground(Color.GRAY);
        cost.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (cost.getText().equals("Product Price")) {
                    cost.setText("");
                    cost.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (cost.getText().isEmpty()) {
                    cost.setText("Product Price");
                    cost.setForeground(Color.GRAY);
                }
            }
        });
        add(cost);

        stock = new JTextField(24);
        stock.setText("Product Stock");
        stock.setForeground(Color.GRAY);
        stock.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (stock.getText().equals("Product Stock")) {
                    stock.setText("");
                    stock.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (stock.getText().isEmpty()) {
                    stock.setText("Product Stock");
                    stock.setForeground(Color.GRAY);
                }
            }
        });
        add(stock);

        imagePath = new JTextField(24);
        imagePath.setText("Image Path");
        imagePath.setForeground(Color.GRAY);
        imagePath.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (imagePath.getText().equals("Image Path")) {
                    imagePath.setText("");
                    imagePath.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (imagePath.getText().isEmpty()) {
                    imagePath.setText("Image Path");
                    imagePath.setForeground(Color.GRAY);
                }
            }
        });
        add(imagePath);


        add= new JButton("ADD");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!stock.getText().equals("Product Stock") && !imagePath.getText().equals("Image Path")&&
                        !cost.getText().equals("Product Price")&& !description.getText().equals("Product Description")&&
                        !pID.getText().equals("Product ID")&& !name.getText().equals("Product Name")){

                    if (Laptop.isSelected()){
                        Product p = new Laptop(name.getText(), pID.getText(), description.getText(),
                                Integer.parseInt(cost.getText()), Integer.parseInt(stock.getText()), imagePath.getText());
                        ArrayList<Product> pa =ProductHandling.readFromFile();
                        pa.add(p);
                        ProductHandling.writeToFile(pa);
                    }
                    else if (LaptopAccessories.isSelected()){
                        Product p = new LaptopAccessories(name.getText(), pID.getText(), description.getText(),
                                Integer.parseInt(cost.getText()), Integer.parseInt(stock.getText()), imagePath.getText());
                        ArrayList<Product> pa =ProductHandling.readFromFile();
                        pa.add(p);
                        ProductHandling.writeToFile(pa);
                    }
                    else if (Mobile.isSelected()){
                        Product p = new Mobiles(name.getText(), pID.getText(), description.getText(),
                                Integer.parseInt(cost.getText()), Integer.parseInt(stock.getText()), imagePath.getText());
                        ArrayList<Product> pa =ProductHandling.readFromFile();
                        pa.add(p);
                        ProductHandling.writeToFile(pa);
                    }
                    else if (MobileAccessories.isSelected()){
                        Product p = new MobileAccessories(name.getText(), pID.getText(), description.getText(),
                                Integer.parseInt(cost.getText()), Integer.parseInt(stock.getText()), imagePath.getText());
                        ArrayList<Product> pa =ProductHandling.readFromFile();
                        pa.add(p);
                        ProductHandling.writeToFile(pa);
                    }
                    else if (KitchenAppliance.isSelected()){
                        Product p = new KitchenAppliences(name.getText(), pID.getText(), description.getText(),
                                Integer.parseInt(cost.getText()), Integer.parseInt(stock.getText()), imagePath.getText());
                        ArrayList<Product> pa =ProductHandling.readFromFile();
                        pa.add(p);
                        ProductHandling.writeToFile(pa);
                    }
                    else if (Entertainment.isSelected()){
                        Product p = new Entertainment(name.getText(), pID.getText(), description.getText(),
                                Integer.parseInt(cost.getText()), Integer.parseInt(stock.getText()), imagePath.getText());
                        ArrayList<Product> pa =ProductHandling.readFromFile();
                        pa.add(p);
                        ProductHandling.writeToFile(pa);
                    }
                    else if (GardenTool.isSelected()){
                        Product p = new GardeningTools(name.getText(), pID.getText(), description.getText(),
                                Integer.parseInt(cost.getText()), Integer.parseInt(stock.getText()), imagePath.getText());
                        ArrayList<Product> pa =ProductHandling.readFromFile();
                        pa.add(p);
                        ProductHandling.writeToFile(pa);
                    }

                    for(Product p : ProductHandling.readFromFile()){
                        if(p.getpID().equals(pID.getText())){
                            JOptionPane.showMessageDialog(null, "Product Added!");
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

                            f.add(new AddProdPanel(cf));
                            f.validate();
                            break;

                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Fill All Fields!");
                }
            }
        });
        add.setFocusable(false);

        add(add);

        add(Box.createHorizontalGlue());
        revalidate();
        setVisible(true);




    }
}
