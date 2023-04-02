package com.company.FileHandling;

import com.company.Products.Product;
import com.company.Users.Seller;

import java.io.*;
import java.util.ArrayList;

public class AdminRecords implements Serializable {


    public static void createAdmin(Seller s)  {
        File f= new File("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\Admin\\AdminRecord.txt");
        ObjectOutputStream oos;
        try{
            if (!f.exists()){
                oos = new ObjectOutputStream(new FileOutputStream(f));

                oos.writeObject(s);

            }
            else{
                System.out.println("Inventory already listed!");
            }
        }
        catch (IOException e){
            System.out.println();
        }
    }



    public static void writeToFile(Seller s){
        try{

            File f= new File("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\Admin\\AdminRecord.txt");
            ObjectOutputStream oos;
            if (f.exists()){
                oos = new MyOOS(new FileOutputStream(f,true));
            }
            else{
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }

            oos.writeObject(s);
            oos.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Create Inventory First!");
//            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("IOE occurred!");
//            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("EXCEPTION!");
//            e.printStackTrace();
        }
    }
    public static ArrayList<Seller> readFromFile(){
        ArrayList<Seller> arr = new ArrayList<>();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\Admin\\AdminRecord.txt"));
            while (true){
                Seller s = (Seller) is.readObject();
                arr.add(s);
            }
        }
        catch (ClassNotFoundException | FileNotFoundException c) {
            System.out.println("Exception Found: Class not found || File not found! ");
            c.printStackTrace();
        }
        catch (EOFException e) {
            System.out.println("EOF!");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOEXCEPTION");
        }
        return arr;
    }
}
