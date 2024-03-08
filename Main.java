import Characters.Archers.*;
import Characters.Healers.*;
import Characters.Knights.*;
import Characters.Mages.*;
import Characters.MythicalCreatures.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Warlock warlock = new Warlock();
        Soother soother = new Soother();
        Dragon dragon = new Dragon();
        Squire squire = new Squire();
        Shooter shooter = new Shooter();

        Scanner scanner = new Scanner(System.in);

        System.out.println("!!!Welcome to Mystic Mayhem!!!");
        System.out.println("Please select \n 1 - login \n 2 - sign up");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Selected 01");
                // login
                break;
            case 2:
                System.out.println("Selected 02");
                // signup
                break;
            case 3:
                // exit
                break;
        }

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
}





