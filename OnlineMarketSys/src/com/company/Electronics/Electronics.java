package com.company.Electronics;

import com.company.Products.Product;

import java.io.Serializable;

public abstract class Electronics extends Product implements Serializable {


    public Electronics(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
