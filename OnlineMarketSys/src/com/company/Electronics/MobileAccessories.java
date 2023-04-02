package com.company.Electronics;

import java.io.Serializable;

public class MobileAccessories extends Electronics implements Serializable {

    public MobileAccessories(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
