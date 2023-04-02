package com.company.Users;

import com.company.Products.Product;
import com.company.FileHandling.ProductHandling;

import java.io.Serializable;
import java.util.ArrayList;

public class Seller implements Serializable {
    private String userName, password;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Seller(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
