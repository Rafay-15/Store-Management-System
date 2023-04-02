package com.company.Panels;

import com.company.Products.Product;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel {
    private Product product;

    public ProductPanel(LayoutManager layout, boolean isDoubleBuffered, Product product) {
        super(layout, isDoubleBuffered);
        this.product = product;
    }

    public ProductPanel(LayoutManager layout, Product product) {
        super(layout);
        this.product = product;
    }

    public ProductPanel(boolean isDoubleBuffered, Product product) {
        super(isDoubleBuffered);
        this.product = product;
    }

    public ProductPanel(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
