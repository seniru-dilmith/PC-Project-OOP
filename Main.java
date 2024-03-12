import Characters.Archers.Archer;
import Characters.Character;
import Equipment.Armour;
import login_signup.User;
import login_signup.UserService;

import java.util.ArrayList;
import java.util.Scanner;

//main class
public class Main {

    public static User currentUser;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // scanner object to read inputs from user
            firstScreen();
            gameFlow();

        User user = new User("user", "user", "123");
        user.setID(5);
        user.getArchers().add(user.getShooter());
    }

    public static void firstScreen(){
        Scanner scanner = new Scanner(System.in);  // scanner object to read inputs from user
        // welocme message
        System.out.println("!!!Welcome to Mystic Mayhem!!!");
        System.out.println("Please select \n\t 1 - login \n\t 2 - sign up \n\t 3 - inventory");

        // read user choice
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentUser = UserService.login();
                break;
            case 2:
                if (UserService.signUp()){
                    firstScreen();
                }
                break;

            case 3:
                System.exit(0);
                break;
        }

    }
    public static void gameFlow() {
        Scanner scanner = new Scanner(System.in); // scanner object to read inputs from user

            System.out.println("Enter 1: Battle Options");
            System.out.println("Enter 2: Battle");
            System.out.println("Enter 3: Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    battleOptions();
                    break;

                case 2:


                case 3:
                    System.exit(0);
                    break;


            }


    }

    public static void battleOptions() {
        Scanner scanner = new Scanner(System.in); // scanner object to read inputs from user

            System.out.println("Enter 1: View Inventory");
            System.out.println("Enter 2: Customize Troops");
            System.out.println("Enter 3: Customize Equipments");
            System.out.println("Enter 4: Back");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    User user = UserService.getCurrentUser();
                    System.out.println(user.toString());
                    break;

                case 2:
                    customizeTroops();
                    break;

                case 3:
                    break;

                case 4:
                    break;
            }


    }

    public static void customizeTroops(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Customize Archer ");
        System.out.println("Enter 2: Customize Knight");
        System.out.println("Enter 3: Customize Mage");
        System.out.println("Enter 4: Customize Healer");
        System.out.println("Enter 5: Customize Mythical Creature");
        System.out.println("Enter 6: Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                customizeArcher();
                break;

            case 2:

                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            case 6:
                break;
        }

    }

    public static void customizeArcher(){
        ArrayList<Archer> allArchers = currentUser.getAllArchers();
        for (Archer archer : allArchers){
            System.out.print(archer.getName() + " ");
        }
    }
}




