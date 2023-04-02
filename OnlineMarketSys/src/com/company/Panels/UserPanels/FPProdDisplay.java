package com.company.Panels.UserPanels;

import com.company.CustomFrame;
import com.company.Products.Product;
import com.company.Users.User;

import javax.swing.*;
import java.awt.*;

public class FPProdDisplay extends JPanel {
    Product product;
    User user;
    CustomFrame cf;
    public FPProdDisplay(Product p, User u, CustomFrame cf){
        this.user = u;
        this.product = p;
        this.cf= cf;


        setLayout(null);
        setSize(new Dimension(850, 170));
        setBackground(Color.WHITE);
        setOpaque(true);
        setVisible(true);
        JLabel prod_image= new JLabel();
        ImageIcon image = new ImageIcon(p.getImage());

        prod_image.setBounds(20, 50, 150,150 );
        prod_image.setVisible(true);
        prod_image.setIcon(image);
        prod_image.setMaximumSize(new Dimension(150, 150));
        add(prod_image);

        JLabel title = new JLabel(p.getName());
        title.setBounds(200, 120, 150,25);
        add(title);

        JLabel price = new JLabel("Rs. "+String.valueOf(p.getCost())+ "Rs/-");
        price.setBounds(title.getX(), title.getY()+ 35, 150,25 );
        add(price);
//        JLabel

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomFrame getCf() {
        return cf;
    }

    public void setCf(CustomFrame cf) {
        this.cf = cf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
