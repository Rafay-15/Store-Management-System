package com.company;

import com.company.FileHandling.AdminRecords;
import com.company.FileHandling.UserRecords;
import com.company.Products.Product;
import com.company.Electronics.Mobiles;
import com.company.FileHandling.ProductHandling;
import com.company.Users.Seller;
import com.company.Users.User;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
//        Product p = new Mobiles("Iphone", "ExamplePhone", "The lastest phone", 20000, 5,"C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\Images\\iphonepic.jfif");
//        Product q = new Mobiles("REDMI", "01213C", "The older phone", 15000, 10, "C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\Images\\redmi.jpg");
//
//        ArrayList<Product> a = new ArrayList<>();
//        a.add(p);
//        a.add(q);
//
//        ProductHandling.createInventory(a);
//        System.out.println(ProductHandling.readFromFile());

//        for (Product r: ProductHandling.readFromFile()){
//            System.out.println(r.toString());
//        }

//        Seller s= new Seller("admin", "admin");
//        Seller r = new Seller("Rafay", "RAFAY");

//        AdminRecords.createAdmin(s);
//        AdminRecords.writeToFile(r);
//        System.out.println(AdminRecords.readFromFile());
//        System.out.println(ProductHandling.readFromFile());
//        User u = new User("User", "User Adress", "userEmail", "User1", "password");
//        UserRecords.createNewUserRecord(u);


            CustomFrame f = new CustomFrame();
        System.out.println(UserRecords.readUserList());
//        System.out.println(ProductHandling.readFromFile());
    }
}
