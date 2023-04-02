package com.company.FileHandling;

import com.company.Users.User;

import java.io.*;
import java.util.ArrayList;

public class UserRecords implements Serializable {

    public static void createNewUserRecord(User user){
        try{
            File f = new File("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\UserData\\UserData.txt");
            ObjectOutputStream oos;
            if (f.exists()){
                oos = new MyOOS(new FileOutputStream(f, true));
            }
            else{oos = new ObjectOutputStream(new FileOutputStream(f));}
            oos.writeObject(user);
        }catch(Exception e){
            System.out.println("System Error!");
        }
    }

    public static void updateuserRecord(ArrayList<User>users){
        try{
            File f= new File("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\UserData\\UserData.txt");
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream(f));

            oos.writeObject(users);

            oos.close();
        }
        catch (Exception e) {
            System.out.println("Error: ");
//            e.printStackTrace();
        }
    }

    public static ArrayList<User> readUserList(){
        ArrayList<User> arr =new ArrayList<>();
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\mrafa\\IdeaProjects\\OnlineMarketSys\\UserData\\UserData.txt"));
            while (true){
                arr.add((User) is.readObject());
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
//            e.printStackTrace();
            System.out.println("IOEXCEPTION line 57");
        }
        if (arr==null){
            System.out.println("Inventory Might Not Have Been Created! line 60 inven array null!");
        }
        return arr;

    }

}
