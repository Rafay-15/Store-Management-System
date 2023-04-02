package com.company.Electronics;

import java.io.Serializable;

public class Laptop extends Electronics implements Serializable {

    public Laptop(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
