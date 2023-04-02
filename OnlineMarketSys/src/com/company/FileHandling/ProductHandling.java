package com.company.FileHandling;

import com.company.Products.Product;

import java.io.*;
import java.util.ArrayList;

public class ProductHandling {
    public static void createInventory(ArrayList<Product> arr)  {
        File f= new File("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\MarketData\\Products\\Products.txt");
        ObjectOutputStream oos;
        try{
            if (!f.exists()){
                oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(arr);
            }
            else{
                System.out.println("Inventory already listed!");
            }
        }
        catch (IOException e){
            System.out.println("Exception Line 22");
            System.out.println(e);
        }
    }
    public static void writeToFile(ArrayList<Product> arr){
        try{
            File f= new File("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\MarketData\\Products\\Products.txt");
            ObjectOutputStream oos;

            oos = new ObjectOutputStream(new FileOutputStream(f));

            oos.writeObject(arr);
            oos.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Create Inventory First! lin e36");
//            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("IOE occurred line 40!");
//            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("EXCEPTION LIne 44!");
//            e.printStackTrace();
        }
    }
    public static ArrayList<Product> readFromFile(){
        ArrayList<Product> arr = null;
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\MarketData\\Products\\Products.txt"));
            while (true){
                 arr = (ArrayList<Product>)is.readObject();
            }
        }
        catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found!  line 57");
//            c.printStackTrace();
        }
        catch (EOFException e) {
            System.out.println("EOF! line 61");
        }
        catch (IOException e) {
//            e.printStackTrace();
            System.out.println("IOEXCEPTION line 65");
        }
        if (arr==null){
            System.out.println("Inventory Might Not Have Been Created! line 68");
        }
        return arr;
    }

}
