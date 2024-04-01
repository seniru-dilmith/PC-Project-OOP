package login_signup;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private static ArrayList<User> userList = new ArrayList<>();

    private static User currentUser = null;

    public static boolean signUp(){
        retrieveUsers();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        if (!previouslyTaken(username)){
           User newUser = new User(username, name, password);
           addUser(newUser);
           newUser.setID(userList.size());
        }

        if (username.isEmpty() || password.isEmpty()){
            System.out.println("Username or Password cannot be empty!!!");
        }

        saveUsers(userList);
        return true;
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

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static User login(){

        retrieveUsers();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your username: ");
        String username  = scanner.nextLine();
        System.out.println("Enter Your Password: ");
        String password  = scanner.nextLine();

        currentUser = authorizeUser(username,password);
        return currentUser;
    }

    public static User authorizeUser(String username, String password){

        for(User user: userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                currentUser = user;
                System.out.println("Login Successful!");
                return currentUser;
            }
        }
        System.out.println("Invalid Login! Try again.");
        return null;
    }


    public static void saveUsers(ArrayList<User> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("login_signup/users.txt"))) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            System.out.println("If this is your first signup, please don't consider this as an error.");
        }
    }

    public static void updateFile() {
        saveUsers(userList);
    }

    private static void retrieveUsers() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("login_signup/users.txt"))){
            userList = (ArrayList<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("If this is your first signup, please don't consider this as an error.");
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}

