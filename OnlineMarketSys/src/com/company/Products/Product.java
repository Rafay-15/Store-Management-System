package com.company.Products;

import java.awt.*;
import java.io.*;

public abstract class Product implements Serializable {
    private String name, pID, description;
    private int cost, stock;
//    private Image image;
    private File ImageFile;

    public Product(String name, String pID, String description, int cost, int stock, String Path) {
        this.name = name;
        this.pID = pID;
        this.description = description;
        this.cost = cost;
        this.stock = stock;
        this.ImageFile = new File(Path);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getImage() {
        return ImageFile.getPath();
    }

    public void setImage(String path) {
        this.ImageFile = new File(path);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", pID='" + pID + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", stock=" + stock +
                ", Image Path: "+ this.getImage() +
                '}';
    }
}
