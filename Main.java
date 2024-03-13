import Characters.Character;
import Characters.Archers.*;
import Characters.Healers.*;
import Characters.Knights.*;
import Characters.Mages.*;
import Characters.MythicalCreatures.*;
import Equipment.Armour;
import Equipment.Artefact;
import login_signup.User;
import login_signup.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

//main class
public class Main {

    public static User currentUser;
    private static ArrayList<Character> armyToBattle = new ArrayList<>();
    private static ArrayList<Archer> archers = new ArrayList<>();
    private static ArrayList<Knight> knights = new ArrayList<>();
    private static ArrayList<Mage> mages = new ArrayList<>();
    private static ArrayList<Healer> healers = new ArrayList<>();
    private static ArrayList<MythicalCreature> mythicalCreatures = new ArrayList<>();
    
    public static boolean isArmyReady() {
        boolean ready = false;

        archers = currentUser.getArchers();
        knights = currentUser.getKnights();
        mages = currentUser.getMages();
        healers = currentUser.getHealers();
        mythicalCreatures = currentUser.getMythicalCreatures();

        try {
            armyToBattle.add(archers.get(archers.size() - 1));
            armyToBattle.add(knights.get(knights.size() - 1));
            armyToBattle.add(mages.get(mages.size() - 1));
            armyToBattle.add(healers.get(healers.size() - 1));
            armyToBattle.add(mythicalCreatures.get(mythicalCreatures.size() - 1));
            ready = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You need to have at least one of each character type to battle!");
            customizeTroops();
        }
        return ready;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // scanner object to read inputs from user
            firstScreen();
            gameFlow();

    }

    public static void firstScreen(){
        Scanner scanner = new Scanner(System.in);  // scanner object to read inputs from user
        // welocme message
        System.out.println("!!!Welcome to Mystic Mayhem!!!");
        System.out.println("Enter 1: Login");
        System.out.println("Enter 2: Signup");
        System.out.println("Enter 3: Exit");

        // read user choice
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                currentUser = UserService.login();
                if (currentUser==null){
                    firstScreen();
                }
                break;
            case "2":
                if (UserService.signUp()){
                    firstScreen();
                }
                break;

            case "3":
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                firstScreen();
                break;

        }

    }


    public static void gameFlow() {
        Scanner scanner = new Scanner(System.in); // scanner object to read inputs from user

            System.out.println("Enter 1: Battle Options");
            System.out.println("Enter 2: Battle");
            System.out.println("Enter 3: Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    battleOptions();
                    break;

                case "2":
                    if (isArmyReady()) {
                        System.out.println("Battle Begins!");
                        selectHomeGround();
                    } else {
                        customizeTroops();
                    }
                    break;

                case "3":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input. Please Try Again!");
                    gameFlow();
                    break;

            }


    }

    public static void selectHomeGround(){
        Scanner scanner = new Scanner(System.in); // scanner object to read inputs from user
        System.out.println("Select Your Home Ground");
        System.out.println("Enter 1: Hilcrest");
        System.out.println("Enter 2: Marshland");
        System.out.println("Enter 3: Desert");
        System.out.println("Enter 4: Arcane");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                currentUser.setHomeGround(HomeGround.Hilcrest);
                break;

            case "2":
                currentUser.setHomeGround(HomeGround.Marshland);
                break;

            case "3":
                currentUser.setHomeGround(HomeGround.Desert);
                break;

            case "4":
                currentUser.setHomeGround(HomeGround.Arcane);
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                selectHomeGround();
                break;
        }
        UserService.updateFile();
        System.out.println("Home Ground Selected Successfully!");
        customizeTroops();
    }

    public static void battleOptions() {
        Scanner scanner = new Scanner(System.in); // scanner object to read inputs from user

            System.out.println("Enter 1: View Inventory");
            System.out.println("Enter 2: Customize Troops");
            System.out.println("Enter 3: Customize Equipments");
            System.out.println("Enter 4: Back");



            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    User user = UserService.getCurrentUser();
                    System.out.println(user.toString());
                    System.out.println();
                    user.printCurrentArmy();
                    System.out.println();
                    System.out.println("Enter Any Key: Back");
                    String choice1 = scanner.nextLine();
                    battleOptions();
                    break;

                case "2":
                    customizeTroops();
                    break;

                case "3":
                    customizeEquipments();
                    break;

                case "4":
                    gameFlow();
                    break;

                default:
                    System.out.println("Invalid Input. Please Try Again!");
                    battleOptions();
                    break;
            }


    }

    public static void customizeEquipments(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Armour");
        System.out.println("Enter 2: Purchase Artefacts");
        System.out.println("Enter 3: Back");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                purchaseArmour();
                break;

            case "2":
                purchaseArtefacts();
                break;

            case "3":
                battleOptions();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                customizeEquipments();
                break;
        }

    }

    public static void purchaseArmour(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Chainmail");
        System.out.println("Enter 2: Purchase Regalia");
        System.out.println("Enter 3: Purchase Fleece");
        System.out.println("Enter 4: Back");
        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                Character character = selectCharacter();
                assert character != null;
                if (character.getArmour() != null) {
                    System.out.println("You already have an armour equipped!");
                    purchaseArmour();
                }
                character.setArmour(Armour.chainmail);
                UserService.updateFile();
                customizeEquipments();
                break;

            case "2":
                character = selectCharacter();
                assert character != null;
                if (character.getArmour() != null) {
                    System.out.println("You already have an armour equipped!");
                    purchaseArmour();
                }
                character.setArmour(Armour.regalia);
                UserService.updateFile();
                customizeEquipments();
                break;

            case "3":
                character = selectCharacter();
                assert character != null;
                if (character.getArmour() != null) {
                    System.out.println("You already have an armour equipped!");
                    purchaseArmour();
                }
                character.setArmour(Armour.fleece);
                UserService.updateFile();
                customizeEquipments();
                break;
            
            case "4":
                customizeEquipments();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseArmour();
                break;
        }
        
    }

    public static void purchaseArtefacts(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Excalibur");
        System.out.println("Enter 2: Purchase Amulet");
        System.out.println("Enter 3: Purchase Crystal");
        System.out.println("Enter 4: Back");
        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                Character character = selectCharacter();
                assert character != null;
                if (character.getArtefact() != null) {
                    System.out.println("You already have an artefact equipped!");
                    purchaseArtefacts();
                }
                character.setArtefact(Artefact.Excalibur);
                UserService.updateFile();
                customizeEquipments();
                break;

            case "2":
                character = selectCharacter();
                assert character != null;
                if (character.getArtefact() == null) {
                    System.out.println("You already have an artefact equipped!");
                    purchaseArtefacts();
                }
                character.setArtefact(Artefact.Amulet);
                UserService.updateFile();
                customizeEquipments();
                break;

            case "3":
                character = selectCharacter();
                assert character != null;
                if (character.getArtefact() == null) {
                    System.out.println("You already have an artefact equipped!");
                    purchaseArtefacts();
                }
                character.setArtefact(Artefact.Crystal);
                UserService.updateFile();
                customizeEquipments();
                break;

            case "4":
                customizeEquipments();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseArtefacts();
                break;


        }


    }
    
    public static Character selectCharacter(){
        System.out.println("Archers: Enter, ");
        System.out.print("1: Add to Shooter\t");
        System.out.print("2: Add to Ranger\t");
        System.out.print("3: Add to Sunfire\t");
        System.out.print("4: Add to Zing\t");
        System.out.print("5: Add to Saggitarius");
        System.out.println();
        System.out.println("Knights: Enter, ");
        System.out.print("6: Add to Squire\t");
        System.out.print("7: Add to Cavalier\t");
        System.out.print("8: Add to Templar\t");
        System.out.print("9: Add to Zoro\t");
        System.out.print("10: Add to Swiftblade");
        System.out.println();
        System.out.println("Mages: Enter, ");
        System.out.print("11: Add to Warlock\t");
        System.out.print("12: Add to Illusionist\t");
        System.out.print("13: Add to Enchanter\t");
        System.out.print("14: Add to Conjurer\t");
        System.out.print("15: Add to Eldritch");
        System.out.println();
        System.out.println("Healers: Enter, ");
        System.out.print("16: Add to Soother\t");
        System.out.print("17: Add to Medic\t");
        System.out.print("18: Add to Alchemist\t");
        System.out.print("19: Add to Saint\t");
        System.out.print("20: Add to Lightbringer");
        System.out.println();
        System.out.println("Mythical Creatures: Enter, ");
        System.out.print("21: Add to Dragon\t");
        System.out.print("22: Add to Basilisk\t");
        System.out.print("23: Add to Hydra\t");
        System.out.print("24: Add to Pheonix\t");
        System.out.print("25: Add to Pegasus\n");

        Scanner scanner = new Scanner(System.in);

        String Choice = scanner.nextLine();

        ArrayList<Archer> allArchers = currentUser.getArchers();
        ArrayList<Knight> allKnights = currentUser.getKnights();
        ArrayList<Mage> allMages = currentUser.getMages();
        ArrayList<Healer> allHealers = currentUser.getHealers();
        ArrayList<MythicalCreature> allMythicalCreatures = currentUser.getMythicalCreatures();
        switch (Choice) {
            case "1":
                for (Archer archer : allArchers) {
                    if (archer.getName().equals("Shooter")) {
                        return archer;
                    }
                }
                break;

            case "2":
                for (Archer archer : allArchers) {
                    if (archer.getName().equals("Ranger")) {
                        return archer;
                    }
                }
                break;

            case "3":
                for (Archer archer : allArchers) {
                    if (archer.getName().equals("Sunfire")) {
                        return archer;
                    }
                }
                break;

            case "4":
                for (Archer archer : allArchers) {
                    if (archer.getName().equals("Zing")) {
                        return archer;
                    }
                }
                break;

            case "5":
                for (Archer archer : allArchers) {
                    if (archer.getName().equals("Saggitarius")) {
                        return archer;
                    }
                }
                break;

            case "6":
                for (Knight knight : allKnights) {
                    if (knight.getName().equals("Squire")) {
                        return knight;
                    }
                }
                break;

            case "7":
                for (Knight knight : allKnights) {
                    if (knight.getName().equals("Cavalier")) {
                        return knight;
                    }
                }
                break;

            case "8":
                for (Knight knight : allKnights) {
                    if (knight.getName().equals("Templar")) {
                        return knight;
                    }
                }
                break;

            case "9":
                for (Knight knight : allKnights) {
                    if (knight.getName().equals("Zoro")) {
                        return knight;
                    }
                }
                break;

            case "10":
                for (Knight knight : allKnights) {
                    if (knight.getName().equals("Swiftblade")) {
                        return knight;
                    }
                }
                break;

            case "11":
                for (Mage mage : allMages) {
                    if (mage.getName().equals("Warlock")) {
                        return mage;
                    }
                }
                break;

            case "12":
                for (Mage mage : allMages) {
                    if (mage.getName().equals("Illusionist")) {
                        return mage;
                    }
                }
                break;

            case "13":
                for (Mage mage : allMages) {
                    if (mage.getName().equals("Enchanter")) {
                        return mage;
                    }
                }
                break;

            case "14":
                for (Mage mage : allMages) {
                    if (mage.getName().equals("Conjurer")) {
                        return mage;
                    }
                }
                break;
            case "15":
                for (Mage mage : allMages) {
                    if (mage.getName().equals("Eldritch")) {
                        return mage;
                    }
                }
                break;

            case "16":
                for (Healer healer : allHealers) {
                    if (healer.getName().equals("Soother")) {
                        return healer;
                    }
                }
                break;

            case "17":
                for (Healer healer : allHealers) {
                    if (healer.getName().equals("Medic")) {
                        return healer;
                    }
                }
                break;

            case "18":
                for (Healer healer : allHealers) {
                    if (healer.getName().equals("Alchemist")) {
                        return healer;
                    }
                }
                break;

            case "19":
                for (Healer healer : allHealers) {
                    if (healer.getName().equals("Saint")) {
                        return healer;
                    }
                }
                break;

            case "20":
                for (Healer healer : allHealers) {
                    if (healer.getName().equals("Lightbringer")) {
                        return healer;
                    }
                }
                break;

            case "21":
                for (MythicalCreature mythicalCreature : allMythicalCreatures) {
                    if (mythicalCreature.getName().equals("Dragon")) {
                        return mythicalCreature;
                    }
                }
                break;

            case "22":
                for (MythicalCreature mythicalCreature : allMythicalCreatures) {
                    if (mythicalCreature.getName().equals("Basilisk")) {
                        return mythicalCreature;
                    }
                }
                break;

            case "23":
                for (MythicalCreature mythicalCreature : allMythicalCreatures) {
                    if (mythicalCreature.getName().equals("Hydra")) {
                        return mythicalCreature;
                    }
                }
                break;

            case "24":
                for (MythicalCreature mythicalCreature : allMythicalCreatures) {
                    if (mythicalCreature.getName().equals("Pheonix")) {
                        return mythicalCreature;
                    }
                }
                break;

            case "25":
                for (MythicalCreature mythicalCreature : allMythicalCreatures) {
                    if (mythicalCreature.getName().equals("Pegasus")) {
                        return mythicalCreature;
                    }
                }
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                selectCharacter();
                break;
        }
        return null;
    }





    public static void customizeTroops(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Troops");
        System.out.println("Enter 2: Sell Troops");
        System.out.println("Enter 3: Back");


        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                purchaseTroops();
                break;

            case 2:
                sellTroops();
                break;

            case 3:
                battleOptions();
                break;


        }

    }

    public static void purchaseTroops(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Archer ");
        System.out.println("Enter 2: Purchase Knight");
        System.out.println("Enter 3: Purchase Mage");
        System.out.println("Enter 4: Purchase Healer");
        System.out.println("Enter 5: Purchase Mythical Creature");
        System.out.println("Enter 6: Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                purchaseArcher();
                break;

            case 2:
                purchaseKnight();
                break;

            case 3:
                purchaseMage();
                break;

            case 4:
                purchaseHealer();
                break;

            case 5:
                purchaseMythicalCreature();
                break;

            case 6:
                if (isArmyReady()) {
                    selectHomeGround();
                } else {
                    customizeTroops();
                }
                break;
        }

    }


    public static void purchaseArcher(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Archer> allArchers = User.getAllArchers();
        for (Archer archer : allArchers) {
            System.out.print(archer.toString() + " \n");
        }
            System.out.println("");
            System.out.println("Enter 1: Purchase Shooter ");
            System.out.println("Enter 2: Purchase Ranger");
            System.out.println("Enter 3: Purchase Sunfire");
            System.out.println("Enter 4: Purchase Zing");
            System.out.println("Enter 5: Purchase Saggitarius");
            System.out.println("Enter 6: Back");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    currentUser.getArchers().add(User.getShooter());
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getShooter().getPrice());
                    UserService.updateFile();
                    System.out.println("Shooter Added Successfully!");
                    purchaseTroops();
                    break;

                case 2:
                    currentUser.getArchers().add(User.getRanger());
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getRanger().getPrice());
                    UserService.updateFile();
                    System.out.println("Ranger Added Successfully!");
                    purchaseTroops();
                    break;

                case 3:
                    currentUser.getArchers().add(User.getSunfire());
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSunfire().getPrice());
                    UserService.updateFile();
                    System.out.println("Sunfire Added Successfully!");
                    purchaseTroops();
                    break;

                case 4:
                    currentUser.getArchers().add(User.getZing());
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getZing().getPrice());
                    UserService.updateFile();
                    System.out.println("Zing Added Successfully!");
                    purchaseTroops();
                    break;

                case 5:
                    currentUser.getArchers().add(User.getSaggitarus());
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSaggitarus().getPrice());
                    UserService.updateFile();
                    System.out.println("Saggitarius Added Successfully!");
                    purchaseTroops();
                    break;

                case 6:
                    purchaseTroops();
                    break;
            }

    }


    public static void purchaseKnight(){

        Scanner scanner = new Scanner(System.in);
        ArrayList<Knight> allKnights = User.getAllKnights();
        for (Knight knight : allKnights) {
            System.out.print(knight.toString() + " \n");
        }
        System.out.println("");
        System.out.println("Enter 1: Purchase Squire ");
        System.out.println("Enter 2: Purchase Cavalier");
        System.out.println("Enter 3: Purchase Templar");
        System.out.println("Enter 4: Purchase Zoro");
        System.out.println("Enter 5: Purchase SwiftBlade");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentUser.getKnights().add(User.getSquire());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSquire().getPrice());
                UserService.updateFile();
                System.out.println("Squire Added Successfully!");
                purchaseTroops();
                break;

            case 2:
                currentUser.getKnights().add(User.getCavalier());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getCavalier().getPrice());
                UserService.updateFile();
                System.out.println("Cavalier Added Successfully!");
                purchaseTroops();
                break;

            case 3:
                currentUser.getKnights().add(User.getTemplar());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getTemplar().getPrice());
                UserService.updateFile();
                System.out.println("Templar Added Successfully!");
                purchaseTroops();
                break;

            case 4:
                currentUser.getKnights().add(User.getZoro());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getZoro().getPrice());
                UserService.updateFile();
                System.out.println("Zoro Added Successfully!");
                purchaseTroops();
                break;

            case 5:
                currentUser.getKnights().add(User.getSwiftblade());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSwiftblade().getPrice());
                UserService.updateFile();
                System.out.println("Swiftblade Added Successfully!");
                purchaseTroops();
                break;

            case 6:
                purchaseTroops();
                break;
        }

    }

    public static void purchaseMage(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mage> allMages = User.getAllMages();
        for (Mage mage : allMages) {
            System.out.print(mage.toString() + " \n");
        }
        System.out.println("");
        System.out.println("Enter 1: Purchase Warlock");
        System.out.println("Enter 2: Purchase Illusionist");
        System.out.println("Enter 3: Purchase Enchanter");
        System.out.println("Enter 4: Purchase Conjurer");
        System.out.println("Enter 5: Purchase Eldritch");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentUser.getMages().add(User.getWarlock());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getWarlock().getPrice());
                UserService.updateFile();
                System.out.println("Warlock Added Successfully!");
                purchaseTroops();
                break;

            case 2:
                currentUser.getMages().add(User.getIllusionist());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getIllusionist().getPrice());
                UserService.updateFile();
                System.out.println("Illusionist Added Successfully!");
                purchaseTroops();
                break;

            case 3:
                currentUser.getMages().add(User.getEnchanter());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getEnchanter().getPrice());
                UserService.updateFile();
                System.out.println("Enchanter Added Successfully!");
                purchaseTroops();
                break;

            case 4:
                currentUser.getMages().add(User.getConjurer());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getConjurer().getPrice());
                UserService.updateFile();
                System.out.println("Conjurer Added Successfully!");
                purchaseTroops();
                break;

            case 5:
                currentUser.getMages().add(User.getEldritch());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getEldritch().getPrice());
                UserService.updateFile();
                System.out.println("Eldritch Added Successfully!");
                purchaseTroops();
                break;

            case 6:
                purchaseTroops();
                break;
        }

    }
    public static void purchaseHealer(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Healer> allHealer = User.getAllHealers();
        for (Healer healer : allHealer) {
            System.out.print(healer.toString() + " \n");
        }
        System.out.println("");
        System.out.println("Enter 1: Purchase Soother ");
        System.out.println("Enter 2: Purchase Medic");
        System.out.println("Enter 3: Purchase Alchemist");
        System.out.println("Enter 4: Purchase Saint");
        System.out.println("Enter 5: Purchase Lightbringer");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentUser.getHealers().add(User.getSoother());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSoother().getPrice());
                UserService.updateFile();
                System.out.println("Soother Added Successfully!");
                purchaseTroops();
                break;

            case 2:
                currentUser.getHealers().add(User.getMedic());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getMedic().getPrice());
                UserService.updateFile();
                System.out.println("Medic Added Successfully!");
                purchaseTroops();
                break;

            case 3:
                currentUser.getHealers().add(User.getAlchemist());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getAlchemist().getPrice());
                UserService.updateFile();
                System.out.println("Alchemist Added Successfully!");
                purchaseTroops();
                break;

            case 4:
                currentUser.getHealers().add(User.getSaint());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSaint().getPrice());
                UserService.updateFile();
                System.out.println("Saint Added Successfully!");
                purchaseTroops();
                break;

            case 5:
                currentUser.getHealers().add(User.getLightBringer());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getLightBringer().getPrice());
                UserService.updateFile();
                System.out.println("Lightbringer Added Successfully!");
                purchaseTroops();
                break;

            case 6:
                purchaseTroops();
                break;
        }

    }
    public static void purchaseMythicalCreature(){

        Scanner scanner = new Scanner(System.in);
        ArrayList<MythicalCreature> allMythicalCreatures = User.getAllMythicalCreatures();
        for (MythicalCreature mythicalCreature : allMythicalCreatures) {
            System.out.print(mythicalCreature.toString() + " \n");
        }
        System.out.println("");
        System.out.println("Enter 1: Purchase Dragon ");
        System.out.println("Enter 2: Purchase Basilisk");
        System.out.println("Enter 3: Purchase Hydra");
        System.out.println("Enter 4: Purchase Pheonix");
        System.out.println("Enter 5: Purchase pegasus");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentUser.getMythicalCreatures().add(User.getDragon());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getDragon().getPrice());
                UserService.updateFile();
                System.out.println("Dragon Added Successfully!");
                purchaseTroops();
                break;

            case 2:
                currentUser.getMythicalCreatures().add(User.getBasilisk());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getBasilisk().getPrice());
                UserService.updateFile();
                System.out.println("Basilisk Added Successfully!");
                purchaseTroops();
                break;

            case 3:
                currentUser.getMythicalCreatures().add(User.getHydra());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getHydra().getPrice());
                UserService.updateFile();
                System.out.println("Hydra Added Successfully!");
                purchaseTroops();
                break;

            case 4:
                currentUser.getMythicalCreatures().add(User.getPhoenix());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getPhoenix().getPrice());
                UserService.updateFile();
                System.out.println("Phoenix Added Successfully!");
                purchaseTroops();
                break;

            case 5:
                currentUser.getMythicalCreatures().add(User.getPegasus());
                currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getPegasus().getPrice());
                UserService.updateFile();
                System.out.println("Pegasus Added Successfully!");
                purchaseTroops();
                break;

            case 6:
                purchaseTroops();
                break;
        }

    }

    //_______________________________________________________________________________________________________________

    public static void sellTroops(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Sell Archer ");
        System.out.println("Enter 2: Sell Knight");
        System.out.println("Enter 3: Sell Mage");
        System.out.println("Enter 4: Sell Healer");
        System.out.println("Enter 5: Sell Mythical Creature");
        System.out.println("Enter 6: Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sellArcher();
                UserService.updateFile();
                break;

            case 2:
                sellKnight();
                UserService.updateFile();
                break;

            case 3:
                sellMage();
                UserService.updateFile();
                break;

            case 4:
                sellHealer();
                UserService.updateFile();
                break;

            case 5:
                sellMythicalCreature();
                UserService.updateFile();
                break;

            case 6:
                customizeTroops();
                break;
        }

    }

    private static <T extends Character> void removeCharacter(ArrayList<T> currentCharacterType, String name) {
        boolean found = false;
        Iterator<T> iterator = currentCharacterType.iterator();
        while (iterator.hasNext()) {
            T currentCharacter = iterator.next();
            if (currentCharacter.getName().equals(name)) {
                found = true;
                currentUser.setGoldCoins(currentUser.getGoldCoins() + sellingPrice(currentCharacter));
                iterator.remove(); // Safely remove the currentCharacter
                System.out.println(name + " Sold Successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("You don't have this character in your inventory");
        }
        UserService.updateFile();
        sellTroops();
    }


    public static void sellArcher(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Archer> allArchers = User.getAllArchers();
        for (Archer archer : allArchers) {
            System.out.print(archer.toString() + " \n");
        }
        System.out.println();
        System.out.println("Enter 1: Sell Shooter ");
        System.out.println("Enter 2: Sell Ranger");
        System.out.println("Enter 3: Sell Sunfire");
        System.out.println("Enter 4: Sell Zing");
        System.out.println("Enter 5: Sell Saggitarius");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        ArrayList<Archer> current_archers = currentUser.getArchers();
        switch (choice) {
            case 1:
                removeCharacter(current_archers, "Shooter");
                UserService.updateFile();
                break;

            case 2:
                removeCharacter(current_archers, "Ranger");
                UserService.updateFile();
                break;

            case 3:
                removeCharacter(current_archers, "Sunfire");
                UserService.updateFile();
                break;

            case 4:
                removeCharacter(current_archers, "Zing");
                UserService.updateFile();
                break;

            case 5:
                removeCharacter(current_archers, "Saggitarius");
                UserService.updateFile();
                break;

            case 6:
                sellTroops();
                break;
        }

    }
    public static void sellKnight(){

            Scanner scanner = new Scanner(System.in);
            ArrayList<Knight> allKnights = User.getAllKnights();
            for (Knight knight : allKnights) {
                System.out.print(knight.toString() + " \n");
            }
            System.out.println();
            System.out.println("Enter 1: Sell Squire ");
            System.out.println("Enter 2: Sell Cavalier");
            System.out.println("Enter 3: Sell Templar");
            System.out.println("Enter 4: Sell Zoro");
            System.out.println("Enter 5: Sell SwiftBlade");
            System.out.println("Enter 6: Back");
            int choice = scanner.nextInt();
            ArrayList<Knight> current_knights = currentUser.getKnights();
            boolean found = false;
            switch (choice) {
                case 1:
                    removeCharacter(current_knights, "Squire");
                    UserService.updateFile();
                    break;

                case 2:
                    removeCharacter(current_knights, "Cavalier");
                    UserService.updateFile();
                    break;

                case 3:
                    removeCharacter(current_knights, "Templar");
                    UserService.updateFile();
                    break;

                case 4:
                    removeCharacter(current_knights, "Zoro");
                    UserService.updateFile();
                    break;

                case 5:
                    removeCharacter(current_knights, "SwiftBlade");
                    UserService.updateFile();
                    break;

                case 6:
                    sellTroops();
                    break;
            }
    }

    public static void sellMage(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mage> allMages = User.getAllMages();
        for (Mage mage : allMages) {
            System.out.print(mage.toString() + " \n");
        }
        System.out.println();
        System.out.println("Enter 1: Sell Warlock");
        System.out.println("Enter 2: Sell Illusionist");
        System.out.println("Enter 3: Sell Enchanter");
        System.out.println("Enter 4: Sell Conjurer");
        System.out.println("Enter 5: Sell Eldritch");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        ArrayList<Mage> current_mages = currentUser.getMages();
        switch (choice) {
            case 1:
                removeCharacter(current_mages, "Warlock");
                UserService.updateFile();
                break;

            case 2:
                removeCharacter(current_mages, "Illusionist");
                UserService.updateFile();
                break;

            case 3:
                removeCharacter(current_mages, "Enchanter");
                UserService.updateFile();
                break;

            case 4:
                removeCharacter(current_mages, "Conjurer");
                UserService.updateFile();
                break;

            case 5:
                removeCharacter(current_mages, "Eldritch");
                UserService.updateFile();
                break;

            case 6:
                sellTroops();
                break;
        }
    }
    public static void sellHealer(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Healer> allHealer = User.getAllHealers();
        for (Healer healer : allHealer) {
            System.out.print(healer.toString() + " \n");
        }
        System.out.println();
        System.out.println("Enter 1: Sell Soother ");
        System.out.println("Enter 2: Sell Medic");
        System.out.println("Enter 3: Sell Alchemist");
        System.out.println("Enter 4: Sell Saint");
        System.out.println("Enter 5: Sell Lightbringer");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        ArrayList<Healer> current_healers = currentUser.getHealers();
        switch (choice) {
            case 1:
                removeCharacter(current_healers, "Soother");
                UserService.updateFile();
                break;

            case 2:
                removeCharacter(current_healers, "Medic");
                UserService.updateFile();
                break;

            case 3:
                removeCharacter(current_healers, "Alchemist");
                UserService.updateFile();
                break;

            case 4:
                removeCharacter(current_healers, "Saint");
                UserService.updateFile();
                break;

            case 5:
                removeCharacter(current_healers, "Lightbringer");
                UserService.updateFile();
                break;

            case 6:
                sellTroops();
                break;
        }
    }
    public static void sellMythicalCreature() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MythicalCreature> allMythicalCreatures = User.getAllMythicalCreatures();
        for (MythicalCreature mythicalCreature : allMythicalCreatures) {
            System.out.print(mythicalCreature.toString() + " \n");
        }
        System.out.println();


        System.out.println("Enter 3: Sell Hydra");
        System.out.println("Enter 4: Sell Pheonix");
        System.out.println("Enter 5: Sell pegasus");
        System.out.println("Enter 6: Back");
        int choice = scanner.nextInt();
        ArrayList<MythicalCreature> current_mythicalCreatures = currentUser.getMythicalCreatures();
        switch (choice) {
            case 1:
                removeCharacter(current_mythicalCreatures, "Dragon");
                UserService.updateFile();
                break;

            case 2:
                removeCharacter(current_mythicalCreatures, "Basillisk");
                UserService.updateFile();
                break;

            case 3:
                removeCharacter(current_mythicalCreatures, "Hydra");
                UserService.updateFile();
                break;

            case 4:
                removeCharacter(current_mythicalCreatures, "Pheonix");
                UserService.updateFile();
                break;

            case 5:
                removeCharacter(current_mythicalCreatures, "Pegasus");
                UserService.updateFile();
                break;

            case 6:
                sellTroops();
                break;
        }

    }

    //_______________________________________________________________________________________________________________________

    public static int sellingPrice(Character character){
        int price = character.getPrice();
        return (int) (price*0.9);
    }

    public static void selectOponent(){
        Scanner scanner=new Scanner(System.in);
        int skip =0;

        System.out.println("Select your opponent");
        System.out.println("If you want to battle enter 1\n If you want to skip enter 2");


         while ( skip !=1 ){
             try{
                 UserService.selectRandomPlayer();
                 skip = scanner.nextInt();
             } catch (InputMismatchException e){
                 System.out.println("InputMismatchException: Please enter a valid integer.");
             }
         }
    }
}



