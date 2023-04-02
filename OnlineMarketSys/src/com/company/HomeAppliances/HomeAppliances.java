package com.company.HomeAppliances;

import com.company.Products.Product;

import java.io.Serializable;

public abstract class HomeAppliances extends Product implements Serializable {

    public HomeAppliances(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
