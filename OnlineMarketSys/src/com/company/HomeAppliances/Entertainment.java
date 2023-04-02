package com.company.HomeAppliances;

import java.io.Serializable;


public class Entertainment extends HomeAppliances implements Serializable {

    public Entertainment(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
