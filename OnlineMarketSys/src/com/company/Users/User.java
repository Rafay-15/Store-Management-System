package com.company.Users;

import com.company.Products.Product;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name, address, email;
    private String userName,password;
    private ArrayList<Product> Orders = new ArrayList<Product>();
    private ArrayList<Product> WishList = new ArrayList<Product>();

    public User(String name, String address, String email, String userName, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User(String name, String address, String email, String userName, String password, ArrayList<Product> orders, ArrayList<Product> wishList) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.password = password;
        Orders = orders;
        WishList = wishList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public ArrayList<Product> getOrders() {
        return Orders;
    }

    public void setOrders(ArrayList<Product> orders) {
        Orders = orders;
    }

    public ArrayList<Product> getWishList() {
        return WishList;
    }

    public void setWishList(ArrayList<Product> wishList) {
        WishList = wishList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
