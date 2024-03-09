import Characters.Archers.*;
import Characters.Healers.*;
import Characters.Knights.*;
import Characters.Mages.*;
import Characters.MythicalCreatures.*;
import login_signup.User;
import login_signup.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warlock warlock = new Warlock();
        Soother soother = new Soother();
        Dragon dragon = new Dragon();
        Squire squire = new Squire();
        Shooter shooter = new Shooter();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("!!!Welcome to Mystic Mayhem!!!");
            System.out.println("Please select \n 1 - login \n 2 - sign up \n 3 - inventory");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Selected 1");
                    login();
                    break;
                case 2:
                    System.out.println("Selected 2");
                    signup();
                    break;

                case 3:
                    System.out.println("Selected 3");
                    options();
                    break;
            }
        }


//        User newUser=new User("vinuka","123");
//        newUser.


        // if login is successful

        // go to inventory


        // battles
        // selecting home ground
        // selecting opponent
        // go to battle
        //                [Name of Attacking Player] vs. [Name of Defending Player]
        //        Turn 1: [Name of Attacking Player]
        //[Attacking character] attacks [Defending character]
        //[Defending Character]’s health: [new health of defender after attack]
        //[Attacking Character]’s health: [new health of attacker after attack]
        //        (If the defender died, print [Defending Character] died!)
        //        (Repeat the part in blue for each turn)
        //[Winner] won! OR draw
        //                [Attacking Player] XP: [new XP value] gold coins: [new gold coin value]
        //[Defending Player] XP: [new XP value] gold coins: [new gold coin value]


        // when a new user registers
        // army from all five characters (must)
        // 500gc at the beginning

        // an army must contain all 05 types
    }

    public static void options() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Select 1 to view profile");
            System.out.println("Select 2 to add troops");
            System.out.println("Select 3 to add equipments");
            System.out.println("Select 4 to previous menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Selected 1");
                    User user = UserService.getCurrentUser();
                    System.out.println(user.toString());
                    break;
                case 2:
                    System.out.println("Selected 2");

                    break;

                case 3:
                    System.out.println("Selected 3");
                    break;

                case 4:
                    System.out.println("Selected 4");
                    flag = false;
            }

        }
    }

    public static void signup() {
        UserService.signUp();
    }

    public static void login() {
        UserService.login();
    }

}




