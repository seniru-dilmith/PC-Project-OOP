package login_signup;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {

    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> userList = new ArrayList<>();

    private static User currentUser = null;

    public static void signUp(){
        retrieveUsers();

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        if (!previouslyTaken(username)){
           User newUser = new User(username,password);
           addUser(newUser);
        }

        if (username.isEmpty() || password.isEmpty()){
            System.out.println("Username or Password cannot be empty!!!");
        }
        saveUsers(userList);
    }

    private static void addUser(User user) {
        userList.add(user);
    }

    private static boolean previouslyTaken(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)){
                System.out.println("Username already taken! Returning to previous menu...");
                return true;
            }
        }
        return false;
    }

    public static void login(){
        retrieveUsers();
        //User user = new User();
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your User Name: ");
        String username  = scanner.nextLine();
        System.out.println("Enter Your Password: ");
        String password  = scanner.nextLine();

        authorizeUser(username,password);

    }

    public static void authorizeUser(String username, String password){

        for(User user: userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                currentUser = user;
                System.out.println("Login Successful!");
                return;
            }
        }
        System.out.println("Invalid Login! Try again.");
    }


    public static void saveUsers(ArrayList<User> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("login_signup/users.txt"))) {
            objectOutputStream.writeObject(list);
            System.out.println("Users saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void retrieveUsers() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("login_signup/users.txt"))){
            userList = (ArrayList<User>) objectInputStream.readObject();
            System.out.println("Users retrieved");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}

