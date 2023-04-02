package com.company.UtilityTools;

import com.company.Products.Product;

import java.io.Serializable;

public abstract class UtilityTools extends Product implements Serializable {


    public UtilityTools(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
