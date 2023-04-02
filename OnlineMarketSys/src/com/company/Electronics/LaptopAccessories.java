package com.company.Electronics;

import java.io.Serializable;

public class LaptopAccessories extends Electronics implements Serializable {

    public LaptopAccessories(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
