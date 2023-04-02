package com.company.UtilityTools;

import java.io.Serializable;

public class GardeningTools extends UtilityTools implements Serializable {

    public GardeningTools(String name, String pID, String description, int cost, int stock, String Path) {
        super(name, pID, description, cost, stock, Path);
    }
}
