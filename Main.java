import Characters.Categories.*;
import Characters.Character;
import Characters.Archers.*;
import Characters.Healers.*;
import Characters.Knights.*;
import Characters.Mages.*;
import Characters.MythicalCreatures.*;
import Equipment.*;
import login_signup.*;

import java.util.*;

//main class
public class Main {

    public static User currentUser, opponentPlayer;

    private static ArrayList<Character> challengerBySpeed = new ArrayList<>();
    private static ArrayList<Character> challengerByDefence = new ArrayList<>();
    private static ArrayList<Character> opponentBySpeed;
    private static ArrayList<Character> opponentByDefence;
    private static ArrayList<User> userList = UserService.getUserList();
    private static ArrayList<Character> armyToBattle = new ArrayList<>(), opponentArmy = new ArrayList<>();
    private static ArrayList<Character> copyOfAttackerArmy = new ArrayList<>(), copyOfOpponentArmy = new ArrayList<>();
    private static ArrayList<Archer> archers = new ArrayList<>(), opponentArchers = new ArrayList<>();
    private static ArrayList<Knight> knights = new ArrayList<>(), opponentKnights = new ArrayList<>();
    private static ArrayList<Mage> mages = new ArrayList<>(), opponentMages = new ArrayList<>();
    private static ArrayList<Healer> healers = new ArrayList<>(), opponentHealers = new ArrayList<>();
    private static ArrayList<MythicalCreature> mythicalCreatures = new ArrayList<>(), opponentMythicalCreatures = new ArrayList<>();

    private static Archer challengerArcher = null, opponentArcher = null;
    private static Knight challengerKnight = null, opponentKnight = null;
    private static Mage challengerMage = null, opponentMage = null;
    private static Healer challengerHealer = null, opponentHealer = null;
    private static MythicalCreature challengerMythicalCreature = null, opponentMythicalCreature = null;

//    challengerBySpeed = new ArrayList<>();
//    challengerByDefence = new ArrayList<>();
//    opponentBySpeed = new ArrayList<>();
//    opponentByDefence = new ArrayList<>();

//    challengerBySpeed = new ArrayList<>();
//    challengerByDefence = new ArrayList<>();
//    opponentBySpeed = new ArrayList<>();
//    opponentByDefence = new ArrayList<>();
//    userList = UserService.getUserList();
//    armyToBattle = new ArrayList<>();
//    opponentArmy = new ArrayList<>();
//    copyOfAttackerArmy = new ArrayList<>();
//    copyOfOpponentArmy = new ArrayList<>();
//    archers = new ArrayList<>();
//    opponentArchers = new ArrayList<>();
//    knights = new ArrayList<>();
//    opponentKnights = new ArrayList<>();
//    mages = new ArrayList<>();
//    opponentMages = new ArrayList<>();
//    healers = new ArrayList<>();
//    opponentHealers = new ArrayList<>();
//    mythicalCreatures = new ArrayList<>();
//    opponentMythicalCreatures = new ArrayList<>();


    private static Vector<Character> generateAttackerQue(Vector<Character> aliveList){

        Vector<Character> result = new Vector<>();
        float highestSpeed ;
        int start, end;

        while (!aliveList.isEmpty()){
            start = result.size();
            highestSpeed = aliveList.getFirst().getSpeed();
            for (int i = 0; i < aliveList.size(); i++){
                if(highestSpeed < aliveList.get(i).getSpeed()){
                    highestSpeed = aliveList.get(i).getSpeed();
                }
            }


            for (int i = 0; i < aliveList.size(); i++){
                if(highestSpeed == aliveList.get(i).getSpeed()){
                    result.add(aliveList.get(i));
//                    aliveList.remove(aliveList.get(i));
                }
            }

            for(int i = start; i < result.size(); i++){
                aliveList.remove(result.get(i));
            }
            end = result.size() -1;

            sortByPriority(result,start,end);
        }

        return result;
    }

    private static void sortByPriority(Vector<Character> arr,int start, int end){
        Vector<Character> temp = new Vector<>();

        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Archer){
                temp.add(arr.get(i));
            }
        }

        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Knight){
                temp.add(arr.get(i));
            }

        }
        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof MythicalCreature){
                temp.add(arr.get(i));
            }
        }
        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Mage){
                temp.add(arr.get(i));
            }
        }
        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Healer){
                temp.add(arr.get(i));
            }
        }
        for (int i = start; i <= end; i++){
            arr.set(i,temp.get(i-start));
        }
    }
 private static Vector<Character> generateDefenceQue(Vector<Character> aliveList){

        Vector<Character> result = new Vector<>();
        float highestSpeed ;
        int start, end;

        while (!aliveList.isEmpty()){
            start = result.size();
            highestSpeed = aliveList.getFirst().getDefence();
            for (int i = 0; i < aliveList.size(); i++){
                if(highestSpeed < aliveList.get(i).getDefence()){
                    highestSpeed = aliveList.get(i).getDefence();
                }
            }

            for (int i = 0; i < aliveList.size(); i++){
                if(highestSpeed == aliveList.get(i).getDefence()){
                    result.add(aliveList.get(i));
//                    aliveList.remove(aliveList.get(i));
                }
            }

            for(int i = start; i < result.size(); i++){
                aliveList.remove(result.get(i));
            }
            end = result.size() -1;

            sortByPriorityDefence(result,start,end);
        }

        return result;
    }

    private static void sortByPriorityDefence(Vector<Character> arr,int start, int end){
        Vector<Character> temp = new Vector<>();

        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Healer){
                temp.add(arr.get(i));
            }
        }

        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof MythicalCreature){
                temp.add(arr.get(i));
            }

        }
        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Archer){
                temp.add(arr.get(i));
            }
        }
        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Knight){
                temp.add(arr.get(i));
            }
        }
        for (int i = start; i <= end; i++){
            if(arr.get(i) instanceof Mage){
                temp.add(arr.get(i));
            }
        }
        for (int i = start; i <= end; i++){
            arr.set(i,temp.get(i-start));
        }
    }



//    public static boolean isArmyReady() {
    public static boolean isChallengerReady() {
        boolean ready = false;

        archers = currentUser.getArchers();
        knights = currentUser.getKnights();
        mages = currentUser.getMages();
        healers = currentUser.getHealers();
        mythicalCreatures = currentUser.getMythicalCreatures();

        try {
            armyToBattle = new ArrayList<>();
            copyOfAttackerArmy = new ArrayList<>();

//            challengerArcher = archers.get(archers.size() - 1);
//            armyToBattle.add(challengerArcher);
//            copyOfAttackerArmy.add(cloneArcher(challengerArcher));
//            armyToBattle.add(archers.get(archers.size() - 1));

//            challengerKnight = knights.get(knights.size() - 1);
//            armyToBattle.add(challengerKnight);
//            copyOfAttackerArmy.add(cloneKnight(challengerKnight));
//            armyToBattle.add(knights.get(knights.size() - 1));

//            challengerMage = mages.get(mages.size() - 1);
//            armyToBattle.add(challengerMage);
//            copyOfAttackerArmy.add(cloneMage(challengerMage));
//            armyToBattle.add(mages.get(mages.size() - 1));

//            challengerHealer = healers.get(healers.size() - 1);
//            armyToBattle.add(challengerHealer);
//            copyOfAttackerArmy.add(cloneHealer(challengerHealer));
//            armyToBattle.add(healers.get(healers.size() - 1));

//            challengerMythicalCreature = mythicalCreatures.get(mythicalCreatures.size() - 1);
//            armyToBattle.add(challengerMythicalCreature);
//            copyOfAttackerArmy.add(cloneCreature(challengerMythicalCreature));

//            armyToBattle.add(mythicalCreatures.get(mythicalCreatures.size() - 1));



            ready = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("You need to have at least one of each character type to battle!");
            customizeTroops();
        }
        return ready;
    }

    public static boolean isOpponentReady() {
        boolean ready = false;

        opponentArchers = opponentPlayer.getArchers();
        opponentKnights = opponentPlayer.getKnights();
        opponentMages = opponentPlayer.getMages();
        opponentHealers = opponentPlayer.getHealers();
        opponentMythicalCreatures = opponentPlayer.getMythicalCreatures();

        try {
            opponentArmy = new ArrayList<>();
            copyOfOpponentArmy = new ArrayList<>();

//            opponentArcher = opponentArchers.get(opponentArchers.size() - 1);
//            opponentArmy.add(opponentArcher);
//            copyOfOpponentArmy.add(cloneArcher(opponentArcher));
//            opponentArmy.add(opponentArchers.get(opponentArchers.size() - 1));

//            opponentKnight = opponentKnights.get(opponentKnights.size() - 1);
//            opponentArmy.add(opponentKnight);
//            copyOfOpponentArmy.add(cloneKnight(opponentKnight));
//            opponentArmy.add(opponentKnights.get(opponentKnights.size() - 1));

//            opponentMage = opponentMages.get(opponentMages.size() - 1);
//            opponentArmy.add(opponentMage);
//            copyOfOpponentArmy.add(cloneMage(opponentMage));
//            opponentArmy.add(opponentMages.get(opponentMages.size() - 1));

//            opponentHealer = opponentHealers.get(opponentHealers.size() - 1);
//            opponentArmy.add(opponentHealer);
//            copyOfOpponentArmy.add(cloneHealer(opponentHealer));
//            opponentArmy.add(opponentHealers.get(opponentHealers.size() - 1));

//            opponentMythicalCreature = opponentMythicalCreatures.get(opponentMythicalCreatures.size() - 1);
//            opponentArmy.add(opponentMythicalCreature);
//            copyOfOpponentArmy.add(cloneCreature(opponentMythicalCreature));
//            opponentArmy.add(opponentMythicalCreatures.get(opponentMythicalCreatures.size() - 1));
            ready = true;
        } catch (IndexOutOfBoundsException e) {
            ready = false;
        }
        return ready;

    }

    public static void main(String[] args) {
        firstScreen();
        gameFlow();

    }

    public static void firstScreen() {
        resetArrays();

        Scanner scanner = new Scanner(System.in);  // scanner object to read inputs from user
        // welocme message
        System.out.println(Design.mysticMayhem);
        System.out.println("Enter 1: Login");
        System.out.println("Enter 2: Signup");
        System.out.println("Enter 3: Exit");

        // read user choice
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                currentUser = UserService.login();
                if (currentUser == null) {
                    firstScreen();
                }
                userList = UserService.getUserList();
                break;
            case "2":
                if (UserService.signUp()) {
                    firstScreen();
                }
                userList = UserService.getUserList();
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
                if (currentUser.armyIsReady()) {
                    System.out.println(Design.battleBegins);
                    //selectHomeGround();
                    User openUser = selectRandomPlayer();

                    Vector<Character> currentArmy = currentUser.getBattleArmy();
                    Vector<Character> openArmy = openUser.getBattleArmy();


//                    challengerBySpeed = generateAttackerQue(currentArmy).reversed();
//                    opponentBySpeed = generateAttackerQue(openArmy).reversed();
//                    challengerByDefence = ArrayList<>(generateDefenceQue(currentArmy);
//                    opponentByDefence = ArrayList<>(generateDefenceQue(openArmy);

                    Vector<Character> tempCurrSpeed = currentUser.getBattleArmy();
                    Vector<Character> tempOppSpeed = openUser.getBattleArmy();

                    ArrayList<Character> curr = new ArrayList<>(tempCurrSpeed);
                    ArrayList<Character> opp = new ArrayList<>(tempOppSpeed);

                    homegroundFeatures(curr,opp);

                    Vector<Character> tempCurrDef = new Vector<>();
                    Vector<Character> tempOppDef = new Vector<>();

                    for(Character ch : tempCurrSpeed) tempCurrDef.add(ch);
                    for(Character ch : tempOppSpeed) tempOppDef.add(ch);



                    Vector<Character> currSpeed = generateAttackerQue(tempCurrSpeed);
                    Vector<Character> oppSpeed = generateAttackerQue(tempOppSpeed);
                    Vector<Character> currDef = generateDefenceQue(tempCurrDef);
                    Vector<Character> oppDef = generateDefenceQue(tempOppDef);



                    for (int i = 0 ; i < currSpeed.size() ; i++) challengerBySpeed.add(currSpeed.get(i));
                    for (int i = currDef.size() -1 ; i >= 0 ; i--) challengerByDefence.add(currDef.get(i));
                    for (int i = 0 ; i < oppSpeed.size() ; i++) opponentBySpeed.add(oppSpeed.get(i));
                    for (int i = oppDef.size() -1  ; i >=0 ; i--) opponentByDefence.add(oppDef.get(i));

//                    System.out.println(generateAttackerQue(currentArmy));
//                    copyOfAttackerArmy = new ArrayList<>(armyToBattle);
//                    copyOfOpponentArmy = new ArrayList<>(opponentArmy);



                    //battle(copyOfAttackerArmy, copyOfOpponentArmy);

                    battleBegin();
                    System.out.println(Design.BLUE+"              Battle is over. Returning to previous menu...                        ");
                    System.out.println("***********************************************************************************"+Design.RESET);
//                    userList = null;
                    gameFlow();
                    firstScreen();
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

    public static void selectHomeGround() {
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
        System.out.println("Enter 2: Change Your Name");
        System.out.println("Enter 3: Customize Troops");
        System.out.println("Enter 4: Customize Equipments");
        System.out.println("Enter 5: Back");


        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println(Design.inventory);
                User user = UserService.getCurrentUser();
                System.out.println(user.toString());
                System.out.println();
                user.printCurrentArmy();
                System.out.println();
                System.out.println("Enter Any Key: Back");
                String back0 = scanner.nextLine();
                battleOptions();
                break;

            case "2":
                System.out.println("Your Current Name: " + currentUser.getName());
                System.out.println("Input New Name:");
                String newName = scanner.nextLine();
                currentUser.setName(newName);
                System.out.println("Name Updated, New Name: " + currentUser.getName());
                System.out.println();
                System.out.println("Enter Any Key: Back");
                String back1 = scanner.nextLine();
                battleOptions();


            case "3":
                customizeTroops();
                break;
            case "4":
                customizeEquipments();
                break;

            case "5":
                gameFlow();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                battleOptions();
                break;
        }
    }

    public static void customizeEquipments() {
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

    public static void purchaseArmour() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Chainmail" + Armour.chainmail.viewDetails());
        System.out.println("Enter 2: Purchase Regalia" + Armour.regalia.viewDetails());
        System.out.println("Enter 3: Purchase Fleece" + Armour.fleece.viewDetails());
        System.out.println("Enter 4: Back" + Armour.fleece.toString());
        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                Character character = selectCharacter();
                assert character != null;
                if (character.getArmour() != null) {
                    System.out.println("You already have an armour equipped!\n" +
                            "It will be replaced with the new chainmail!");
                    if (currentUser.getGoldCoins() >= Armour.chainmail.getPrice()) {
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - Armour.chainmail.getPrice());
                        character.setArmour(Armour.chainmail);
                        character.setPrice(Armour.chainmail.getPrice() + (int) (Armour.chainmail.getPrice() * 0.2));
                        character.adjustStatsByArmour();
                        UserService.updateFile();
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                    purchaseArmour();
                }
                if (currentUser.getGoldCoins() >= Armour.chainmail.getPrice()) {
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - Armour.chainmail.getPrice());
                    character.setArmour(Armour.chainmail);
                    character.IncrementPrice((int) (Armour.chainmail.getPrice() * 0.2));
                    character.adjustStatsByArmour();
                    UserService.updateFile();
                } else {
                    System.out.println("Not Enough Gold Coins!");
                }
                customizeEquipments();
                break;

            case "2":
                character = selectCharacter();
                assert character != null;
                if (character.getArmour() != null) {
                    System.out.println("You already have an armour equipped!\n" +
                            "It will be replaced with the new Regalia!");
                    handleDuplicatesForReglia(character);
                    purchaseArmour();
                }
                handleDuplicatesForReglia(character);
                customizeEquipments();
                break;

            case "3":
                character = selectCharacter();
                assert character != null;
                if (character.getArmour() != null) {
                    System.out.println("You already have an armour equipped!" +
                            "It will be replaced with the new Fleece");
                    handleDuplicatesForFleece(character);
                    purchaseArmour();
                }
                handleDuplicatesForFleece(character);
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

    private static void handleDuplicatesForReglia(Character character) {
        if (currentUser.getGoldCoins() >= Armour.regalia.getPrice()) {
            currentUser.setGoldCoins(currentUser.getGoldCoins() - Armour.regalia.getPrice());
            character.setArmour(Armour.regalia);
            character.IncrementPrice((int) (Armour.regalia.getPrice() * 0.2));
            character.adjustStatsByArmour();
            UserService.updateFile();
        } else {
            System.out.println("Not Enough Gold Coins!");

        }
    }

    private static void handleDuplicatesForFleece(Character character) {
        if (currentUser.getGoldCoins() >= Armour.fleece.getPrice()) {
            currentUser.setGoldCoins(currentUser.getGoldCoins() - Armour.fleece.getPrice());
            character.setArmour(Armour.fleece);
            character.IncrementPrice((int) (Armour.fleece.getPrice() * 0.2));
            character.adjustStatsByArmour();
            UserService.updateFile();
        } else {
            System.out.println("Not Enough Gold Coins!");

        }
    }

    public static void purchaseArtefacts() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Excalibur" + Artefact.Excalibur.viewDetails());
        System.out.println("Enter 2: Purchase Amulet" + Artefact.Amulet.viewDetails());
        System.out.println("Enter 3: Purchase Crystal" + Artefact.Crystal.viewDetails());
        System.out.println("Enter 4: Back");
        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                Character character = selectCharacter();
                assert character != null;
                if (character.getArtefact() != null) {
                    System.out.println("You already have an artefact equipped!" +
                            "It will be replaced with the new Excalibur");
                    handleDuplicatesForExcalibur(character);
                    purchaseArtefacts();
                }
                handleDuplicatesForExcalibur(character);

                customizeEquipments();
                break;

            case "2":
                character = selectCharacter();
                assert character != null;
                if (character.getArtefact() == null) {
                    System.out.println("You already have an artefact equipped!" +
                            "It will be updated with the new Amulet");
                    handleDuplicatesForAmulet(character);
                    purchaseArtefacts();
                }
                handleDuplicatesForAmulet(character);
                customizeEquipments();
                break;

            case "3":
                character = selectCharacter();
                assert character != null;
                if (character.getArtefact() == null) {
                    System.out.println("You already have an artefact equipped!" +
                            "It will be updated with the new Crystal");
                    handleDuplicatesForCrystal(character);
                    purchaseArtefacts();
                }
                handleDuplicatesForCrystal(character);
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

    private static void handleDuplicatesForExcalibur(Character character) {
        if (currentUser.getGoldCoins() >= Artefact.Excalibur.getPrice()) {
            currentUser.setGoldCoins(currentUser.getGoldCoins() - Artefact.Excalibur.getPrice());
            character.setArtefact(Artefact.Excalibur);
            character.IncrementPrice((int) (Artefact.Excalibur.getPrice() * 0.2));
            character.adjustStatsByArtefact();
            UserService.updateFile();
        } else {
            System.out.println("Not Enough Gold Coins!");
        }
    }

    private static void handleDuplicatesForAmulet(Character character) {
        if (currentUser.getGoldCoins() >= Artefact.Amulet.getPrice()) {
            currentUser.setGoldCoins(currentUser.getGoldCoins() - Artefact.Amulet.getPrice());
            character.setArtefact(Artefact.Amulet);
            character.IncrementPrice((int) (Artefact.Amulet.getPrice() * 0.2));
            character.adjustStatsByArtefact();
            UserService.updateFile();
        } else {
            System.out.println("Not Enough Gold Coins!");

        }
    }

    private static void handleDuplicatesForCrystal(Character character) {
        if (currentUser.getGoldCoins() >= Artefact.Crystal.getPrice()) {
            currentUser.setGoldCoins(currentUser.getGoldCoins() - Artefact.Crystal.getPrice());
            character.setArtefact(Artefact.Crystal);
            character.IncrementPrice((int) (Artefact.Crystal.getPrice() * 0.2));
            character.adjustStatsByArtefact();
            UserService.updateFile();
        } else {
            System.out.println("Not Enough Gold Coins!");

        }
    }


    public static Character selectCharacter() {
        System.out.println("Select Character");
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("| Category             | Options (Select Character)                  |");
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("| Archers              | 1: Shooter    2: Ranger       3: Sunfire    |");
        System.out.println("|                      | 4: Zing       5: Saggitarius                |");
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("| Knights              | 6: Squire     7: Cavalier     8: Templar    |");
        System.out.println("|                      | 9: Zoro       10: Swiftblade                |");
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("| Mages                | 11: Warlock   12: Illusionist               |");
        System.out.println("|                      | 13: Enchanter 14: Conjurer    15: Eldritch  |");
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("| Healers              | 16: Soother   17: Medic       18: Alchemist |");
        System.out.println("|                      | 19: Saint     20: Lightbringer              |");
        System.out.println("|--------------------------------------------------------------------|");
        System.out.println("| Mythical Creatures   | 21: Dragon    22: Basilisk     23: Hydra    |");
        System.out.println("|                      | 24: Phoenix   25: Pegasus                   |");
        System.out.println("|--------------------------------------------------------------------|");

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


    public static void customizeTroops() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Troops");
        System.out.println("Enter 2: Sell Troops");
        System.out.println("Enter 3: Back");


        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                purchaseTroops();
                break;

            case "2":
                sellTroops();
                break;

            case "3":
                battleOptions();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                customizeTroops();
                break;
        }

    }

    public static void purchaseTroops() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Purchase Archer ");
        System.out.println("Enter 2: Purchase Knight");
        System.out.println("Enter 3: Purchase Mage");
        System.out.println("Enter 4: Purchase Healer");
        System.out.println("Enter 5: Purchase Mythical Creature");
        System.out.println("Enter 6: Back");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                purchaseArcher();
                break;

            case "2":
                purchaseKnight();
                break;

            case "3":
                purchaseMage();
                break;

            case "4":
                purchaseHealer();
                break;

            case "5":
                purchaseMythicalCreature();
                break;

            case "6":
                if (isChallengerReady()) {
                    selectHomeGround();
                } else {
                    customizeTroops();
                }
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseTroops();
                break;
        }

    }


    public static void purchaseArcher() {
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
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if (!currentUser.getArchers().contains(User.getShooter())) {
                    if (currentUser.getGoldCoins() >= User.getShooter().getPrice()) {
                        currentUser.getArchers().add(User.getShooter());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getShooter().getPrice());
                        UserService.updateFile();
                        System.out.println("Shooter Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Shooter!");
                }
                purchaseTroops();
                break;

            case "2":
                if (!currentUser.getArchers().contains(User.getRanger())) {
                    if (currentUser.getGoldCoins() >= User.getRanger().getPrice()) {
                        currentUser.getArchers().add(User.getRanger());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getRanger().getPrice());
                        UserService.updateFile();
                        System.out.println("Ranger Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Ranger!");
                }

                purchaseTroops();
                break;

            case "3":
                if (!currentUser.getArchers().contains(User.getSunfire())) {
                    if (currentUser.getGoldCoins() >= User.getSunfire().getPrice()) {
                        currentUser.getArchers().add(User.getSunfire());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSunfire().getPrice());
                        UserService.updateFile();
                        System.out.println("Sunfire Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Sunfire!");
                }
                purchaseTroops();
                break;

            case "4":
                if (!currentUser.getArchers().contains(User.getZing())) {
                    if (currentUser.getGoldCoins() >= User.getZing().getPrice()) {
                        currentUser.getArchers().add(User.getZing());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getZing().getPrice());
                        UserService.updateFile();
                        System.out.println("Zing Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Zing!");
                }
                purchaseTroops();
                break;

            case "5":
                if (!currentUser.getArchers().contains(User.getSaggitarus())) {
                    if (currentUser.getGoldCoins() >= User.getSaggitarus().getPrice()) {
                        currentUser.getArchers().add(User.getSaggitarus());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSaggitarus().getPrice());
                        UserService.updateFile();
                        System.out.println("Saggitarius Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Saggitarius!");
                }
                purchaseTroops();
                break;

            case "6":
                purchaseTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseArcher();
                break;
        }

    }


    public static void purchaseKnight() {

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
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if (!currentUser.getKnights().contains(User.getSquire())) {
                    if (currentUser.getGoldCoins() >= User.getSquire().getPrice()) {
                        currentUser.getKnights().add(User.getSquire());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSquire().getPrice());
                        UserService.updateFile();
                        System.out.println("Squire Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Squire!");
                }
                purchaseTroops();
                break;

            case "2":
                if (!currentUser.getKnights().contains(User.getCavalier())) {
                    currentUser.getKnights().add(User.getCavalier());
                    if (currentUser.getGoldCoins() >= User.getCavalier().getPrice()) {
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getCavalier().getPrice());
                        UserService.updateFile();
                        System.out.println("Cavalier Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Cavalier!");
                }
                purchaseTroops();
                break;

            case "3":
                if (!currentUser.getKnights().contains(User.getTemplar())) {
                    if (currentUser.getGoldCoins() >= User.getTemplar().getPrice()) {
                        currentUser.getKnights().add(User.getTemplar());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getTemplar().getPrice());
                        UserService.updateFile();
                        System.out.println("Templar Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Templar!");
                }
                purchaseTroops();
                break;

            case "4":
                if (!currentUser.getKnights().contains(User.getZoro())) {
                    if (currentUser.getGoldCoins() >= User.getZoro().getPrice()) {
                        currentUser.getKnights().add(User.getZoro());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getZoro().getPrice());
                        UserService.updateFile();
                        System.out.println("Zoro Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Zoro!");
                }
                purchaseTroops();
                break;

            case "5":
                if (!currentUser.getKnights().contains(User.getSwiftblade())) {
                    if (currentUser.getGoldCoins() >= User.getSwiftblade().getPrice()) {
                        currentUser.getKnights().add(User.getSwiftblade());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSwiftblade().getPrice());
                        UserService.updateFile();
                        System.out.println("Swiftblade Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Swiftblade!");
                }
                purchaseTroops();
                break;

            case "6":
                purchaseTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseKnight();
                break;
        }

    }

    public static void purchaseMage() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mage> allMages = User.getAllMages();
        for (Mage mage : allMages) {
            System.out.print(mage.toString() + " \n");
        }
        System.out.println();
        System.out.println("Enter 1: Purchase Warlock");
        System.out.println("Enter 2: Purchase Illusionist");
        System.out.println("Enter 3: Purchase Enchanter");
        System.out.println("Enter 4: Purchase Conjurer");
        System.out.println("Enter 5: Purchase Eldritch");
        System.out.println("Enter 6: Back");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":

                if (currentUser.getGoldCoins() >= User.getWarlock().getPrice()) {
                    currentUser.getMages().add(User.getWarlock());
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getWarlock().getPrice());
                    UserService.updateFile();
                    System.out.println("Warlock Added Successfully!");
                } else {
                    System.out.println("Not Enough Gold Coins!");
                }
                purchaseTroops();
                break;

            case "2":
                if (currentUser.getGoldCoins() >= User.getIllusionist().getPrice()) {
                    currentUser.getMages().add(User.getIllusionist());
                    currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getIllusionist().getPrice());
                    UserService.updateFile();
                    System.out.println("Illusionist Added Successfully!");
                } else {
                    System.out.println("Not Enough Gold Coins!");
                }
                purchaseTroops();
                break;

            case "3":
                if (!currentUser.getMages().contains(User.getEnchanter())) {
                    if (currentUser.getGoldCoins() >= User.getIllusionist().getPrice()) {
                        currentUser.getMages().add(User.getEnchanter());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getEnchanter().getPrice());
                        UserService.updateFile();
                        System.out.println("Enchanter Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have an Enchanter!");
                }
                purchaseTroops();
                break;

            case "4":
                if (!currentUser.getMages().contains(User.getConjurer())) {
                    if (currentUser.getGoldCoins() >= User.getConjurer().getPrice()) {
                        currentUser.getMages().add(User.getConjurer());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getConjurer().getPrice());
                        UserService.updateFile();
                        System.out.println("Conjurer Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Conjurer!");
                }
                purchaseTroops();
                break;

            case "5":
                if (!currentUser.getMages().contains(User.getEldritch())) {
                    if (currentUser.getGoldCoins() >= User.getEldritch().getPrice()) {
                        currentUser.getMages().add(User.getEldritch());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getEldritch().getPrice());
                        UserService.updateFile();
                        System.out.println("Eldritch Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have an Eldritch!");
                }
                purchaseTroops();
                break;

            case "6":
                purchaseTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseMage();
                break;
        }


    }

    public static void purchaseHealer() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Healer> allHealer = User.getAllHealers();
        for (Healer healer : allHealer) {
            System.out.print(healer.toString() + " \n");
        }
        System.out.println();
        System.out.println("Enter 1: Purchase Soother ");
        System.out.println("Enter 2: Purchase Medic");
        System.out.println("Enter 3: Purchase Alchemist");
        System.out.println("Enter 4: Purchase Saint");
        System.out.println("Enter 5: Purchase Lightbringer");
        System.out.println("Enter 6: Back");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if (!currentUser.getHealers().contains(User.getSoother())) {
                    if (currentUser.getGoldCoins() >= User.getSoother().getPrice()) {
                        currentUser.getHealers().add(User.getSoother());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSoother().getPrice());
                        UserService.updateFile();
                        System.out.println("Soother Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Soother!");
                }
                purchaseTroops();
                break;

            case "2":
                if (!currentUser.getHealers().contains(User.getMedic())) {
                    if (currentUser.getGoldCoins() >= User.getMedic().getPrice()) {
                        currentUser.getHealers().add(User.getMedic());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getMedic().getPrice());
                        UserService.updateFile();
                        System.out.println("Medic Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Medic!");
                }

                purchaseTroops();
                break;

            case "3":
                if (!currentUser.getHealers().contains(User.getAlchemist())) {
                    if (currentUser.getGoldCoins() >= User.getAlchemist().getPrice()) {
                        currentUser.getHealers().add(User.getAlchemist());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getAlchemist().getPrice());
                        UserService.updateFile();
                        System.out.println("Alchemist Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have an Alchemist!");
                }
                purchaseTroops();
                break;

            case "4":
                if (!currentUser.getHealers().contains(User.getSaint())) {
                    if (currentUser.getGoldCoins() >= User.getSaint().getPrice()) {
                        currentUser.getHealers().add(User.getSaint());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getSaint().getPrice());
                        UserService.updateFile();
                        System.out.println("Saint Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Saint!");
                }
                purchaseTroops();
                break;

            case "5":
                if (!currentUser.getHealers().contains(User.getLightBringer())) {
                    if (currentUser.getGoldCoins() >= User.getLightBringer().getPrice()) {
                        currentUser.getHealers().add(User.getLightBringer());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getLightBringer().getPrice());
                        UserService.updateFile();
                        System.out.println("Lightbringer Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Lightbringer!");
                }
                purchaseTroops();
                break;

            case "6":
                purchaseTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseHealer();
                break;
        }

    }

    public static void purchaseMythicalCreature() {

        Scanner scanner = new Scanner(System.in);
        ArrayList<MythicalCreature> allMythicalCreatures = User.getAllMythicalCreatures();
        for (MythicalCreature mythicalCreature : allMythicalCreatures) {
            System.out.print(mythicalCreature.toString() + " \n");
        }
        System.out.println();
        System.out.println("Enter 1: Purchase Dragon ");
        System.out.println("Enter 2: Purchase Basilisk");
        System.out.println("Enter 3: Purchase Hydra");
        System.out.println("Enter 4: Purchase Pheonix");
        System.out.println("Enter 5: Purchase pegasus");
        System.out.println("Enter 6: Back");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                if (!currentUser.getMythicalCreatures().contains(User.getDragon())) {
                    if (currentUser.getGoldCoins() >= User.getDragon().getPrice()) {
                        currentUser.getMythicalCreatures().add(User.getDragon());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getDragon().getPrice());
                        UserService.updateFile();
                        System.out.println("Dragon Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Dragon!");
                }
                purchaseTroops();
                break;

            case "2":
                if (!currentUser.getMythicalCreatures().contains(User.getBasilisk())) {
                    if (currentUser.getGoldCoins() >= User.getBasilisk().getPrice()) {
                        currentUser.getMythicalCreatures().add(User.getBasilisk());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getBasilisk().getPrice());
                        UserService.updateFile();
                        System.out.println("Basilisk Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Basilisk!");
                }
                purchaseTroops();
                break;

            case "3":
                if (!currentUser.getMythicalCreatures().contains(User.getHydra())) {
                    if (currentUser.getGoldCoins() >= User.getHydra().getPrice()) {
                        currentUser.getMythicalCreatures().add(User.getHydra());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getHydra().getPrice());
                        UserService.updateFile();
                        System.out.println("Hydra Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Hydra!");
                }
                purchaseTroops();
                break;

            case "4":
                if (!currentUser.getMythicalCreatures().contains(User.getPhoenix())) {
                    if (currentUser.getGoldCoins() >= User.getPhoenix().getPrice()) {
                        currentUser.getMythicalCreatures().add(User.getPhoenix());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getPhoenix().getPrice());
                        UserService.updateFile();
                        System.out.println("Phoenix Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Phoenix!");
                }
                purchaseTroops();
                break;

            case "5":
                if (!currentUser.getMythicalCreatures().contains(User.getPegasus())) {
                    if (currentUser.getGoldCoins() >= User.getPegasus().getPrice()) {
                        currentUser.getMythicalCreatures().add(User.getPegasus());
                        currentUser.setGoldCoins(currentUser.getGoldCoins() - User.getPegasus().getPrice());
                        UserService.updateFile();
                        System.out.println("Pegasus Added Successfully!");
                    } else {
                        System.out.println("Not Enough Gold Coins!");
                    }
                } else {
                    System.out.println("You already have a Pegasus!");
                }
                purchaseTroops();
                break;

            case "6":
                purchaseTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                purchaseMythicalCreature();
                break;
        }

    }

    //_______________________________________________________________________________________________________________

    public static void sellTroops() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1: Sell Archer ");
        System.out.println("Enter 2: Sell Knight");
        System.out.println("Enter 3: Sell Mage");
        System.out.println("Enter 4: Sell Healer");
        System.out.println("Enter 5: Sell Mythical Creature");
        System.out.println("Enter 6: Back");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                sellArcher();
                UserService.updateFile();
                break;

            case "2":
                sellKnight();
                UserService.updateFile();
                break;

            case "3":
                sellMage();
                UserService.updateFile();
                break;

            case "4":
                sellHealer();
                UserService.updateFile();
                break;

            case "5":
                sellMythicalCreature();
                UserService.updateFile();
                break;

            case "6":
                customizeTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                sellTroops();
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


    public static void sellArcher() {
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
        String choice = scanner.nextLine();
        ArrayList<Archer> current_archers = currentUser.getArchers();
        switch (choice) {
            case "1":
                removeCharacter(current_archers, "Shooter");
                UserService.updateFile();
                break;

            case "2":
                removeCharacter(current_archers, "Ranger");
                UserService.updateFile();
                break;

            case "3":
                removeCharacter(current_archers, "Sunfire");
                UserService.updateFile();
                break;

            case "4":
                removeCharacter(current_archers, "Zing");
                UserService.updateFile();
                break;

            case "5":
                removeCharacter(current_archers, "Saggitarius");
                UserService.updateFile();
                break;

            case "6":
                sellTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                sellArcher();
                break;
        }

    }

    public static void sellKnight() {

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
        String choice = scanner.nextLine();
        ArrayList<Knight> current_knights = currentUser.getKnights();
        boolean found = false;
        switch (choice) {
            case "1":
                removeCharacter(current_knights, "Squire");
                UserService.updateFile();
                break;

            case "2":
                removeCharacter(current_knights, "Cavalier");
                UserService.updateFile();
                break;

            case "3":
                removeCharacter(current_knights, "Templar");
                UserService.updateFile();
                break;

            case "4":
                removeCharacter(current_knights, "Zoro");
                UserService.updateFile();
                break;

            case "5":
                removeCharacter(current_knights, "SwiftBlade");
                UserService.updateFile();
                break;

            case "6":
                sellTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                sellKnight();
                break;
        }
    }

    public static void sellMage() {
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
        String choice = scanner.nextLine();
        ArrayList<Mage> current_mages = currentUser.getMages();
        switch (choice) {
            case "1":
                removeCharacter(current_mages, "Warlock");
                UserService.updateFile();
                break;

            case "2":
                removeCharacter(current_mages, "Illusionist");
                UserService.updateFile();
                break;

            case "3":
                removeCharacter(current_mages, "Enchanter");
                UserService.updateFile();
                break;

            case "4":
                removeCharacter(current_mages, "Conjurer");
                UserService.updateFile();
                break;

            case "5":
                removeCharacter(current_mages, "Eldritch");
                UserService.updateFile();
                break;

            case "6":
                sellTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                sellMage();
                break;
        }
    }

    public static void sellHealer() {
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
        String choice = scanner.nextLine();
        ArrayList<Healer> current_healers = currentUser.getHealers();
        switch (choice) {
            case "1":
                removeCharacter(current_healers, "Soother");
                UserService.updateFile();
                break;

            case "2":
                removeCharacter(current_healers, "Medic");
                UserService.updateFile();
                break;

            case "3":
                removeCharacter(current_healers, "Alchemist");
                UserService.updateFile();
                break;

            case "4":
                removeCharacter(current_healers, "Saint");
                UserService.updateFile();
                break;

            case "5":
                removeCharacter(current_healers, "Lightbringer");
                UserService.updateFile();
                break;

            case "6":
                sellTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                sellHealer();
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
        String choice = scanner.nextLine();
        ArrayList<MythicalCreature> current_mythicalCreatures = currentUser.getMythicalCreatures();
        switch (choice) {
            case "1":
                removeCharacter(current_mythicalCreatures, "Dragon");
                UserService.updateFile();
                break;

            case "2":
                removeCharacter(current_mythicalCreatures, "Basillisk");
                UserService.updateFile();
                break;

            case "3":
                removeCharacter(current_mythicalCreatures, "Hydra");
                UserService.updateFile();
                break;

            case "4":
                removeCharacter(current_mythicalCreatures, "Pheonix");
                UserService.updateFile();
                break;

            case "5":
                removeCharacter(current_mythicalCreatures, "Pegasus");
                UserService.updateFile();
                break;

            case "6":
                sellTroops();
                break;

            default:
                System.out.println("Invalid Input. Please Try Again!");
                sellMythicalCreature();
                break;
        }

    }

    //_______________________________________________________________________________________________________________________

    public static int sellingPrice(Character character) {
        int price = character.getPrice();
        return (int) (price * 0.9);
    }

    public static User selectRandomPlayer() {

        Random random = new Random();
        int randomIndex = random.nextInt(userList.size());
        opponentPlayer = userList.get(randomIndex);

        if(opponentPlayer != currentUser){

            if (isOpponentReady() ) {
                displayOpponentStats(opponentPlayer);

                selectOpponent(opponentPlayer);

            }
            return opponentPlayer;
        }
        else
            return selectRandomPlayer();
    }

    public static void displayOpponentStats(User user) {
        System.out.println("Name: " + user.getName());
        System.out.println("XP: " + user.getXP());
    }

    public static void selectOpponent(User opponent) {
        Scanner scanner = new Scanner(System.in);
        String canBattle;

        System.out.println("Select your opponent");
        System.out.println("If you want to battle enter 1\nIf you want to skip enter 2");


        canBattle = scanner.nextLine();

        if (Objects.equals(canBattle, "1")) {
            opponentPlayer = opponent;
        } else if (Objects.equals(canBattle, "2")) {
            resetArrays();
            selectRandomPlayer();
        } else {
            resetArrays();
            selectOpponent(opponent);
        }

//        do{
//            try {
//                skip = scanner.nextInt();
//                selectRandomPlayer();
//
//            } catch (InputMismatchException e) {
//                System.out.println("InputMismatchException: Please enter a valid integer.");
//            }
//
//        }while (skip != 1);


//        while (skip != 1) {
//            try {
//                skip = scanner.nextInt();
//                randomPlayer = selectRandomPlayer();
//
//            } catch (InputMismatchException e) {
//                System.out.println("InputMismatchException: Please enter a valid integer.");
//            }
//        }

    }

//    public static void battle(ArrayList<Character> challenger, ArrayList<Character> opponent) {
//
//        //Set the ascending order of speed of the challenger
//
//
//        Collections.sort(challenger, new Comparator<Character>() {
//            @Override
//            public int compare(Character c1, Character c2) {
//
//                return Integer.compare(c1.getSpeed(), c2.getSpeed());
//            }
//        });
//
//
//        challengerBySpeed.addAll(challenger);
//
//        //Recreate the array if there ara same speed characters according to their priority order
//
//        for (int i = 0; i < challengerBySpeed.size() - 1; ++i) {
//            Character currentCharacter = challengerBySpeed.get(i);
//            Character nextCharacter = challengerBySpeed.get(i + 1);
//            if (currentCharacter.getSpeed() == nextCharacter.getSpeed()) {
//                System.out.println("same speed;");
//                comparePrioritySpeed(i,i+1,challengerBySpeed);
//            }
//            System.out.println("array:");
//
//            System.out.println(currentCharacter.getName() + " " + currentCharacter.getSpeed());
//            System.out.println(nextCharacter.getName() + " " + nextCharacter.getSpeed());
//
//        }
//
//        //reverse the list
//        Collections.reverse(challengerBySpeed);
//
//
//        //Set the ascending order of defence of the challenger
//
//        Collections.sort(challenger, new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return Integer.compare(o1.getDefence(), o2.getDefence());
//            }
//        });
//
//        //Recreate the array if there ara same defence characters according to their priority order
//
//        challengerByDefence.addAll(challenger);
//        for (int i = 0; i < challengerByDefence.size() - 1; ++i) {
//            Character currentCharacter = challengerByDefence.get(i);
//            Character nextCharacter = challengerByDefence.get(i + 1);
//            if (currentCharacter.getDefence() == nextCharacter.getDefence()) {
//                comparePriorityDefence(i,i=1,challengerByDefence);
//            }
//        }
//
//
//        //Set the ascending order of speed of opponent
//
//        Collections.sort(opponent, new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return Integer.compare(o1.getSpeed(), o2.getSpeed());
//            }
//        });
//
//        opponentBySpeed.addAll(opponent);
//        for (int i = 0; i < opponentBySpeed.size() - 1; ++i) {
//            Character currentCharacter = opponentBySpeed.get(i);
//            Character nextCharacter = opponentBySpeed.get(i + 1);
//            if (currentCharacter.getSpeed() == nextCharacter.getSpeed()) {
//                comparePrioritySpeed(i, i+1,opponentBySpeed);
//            }
//        }
//        //reverse the arrayList
//        Collections.reverse(opponentBySpeed);
//
//
//        //Set the ascending order of defence of opponent
//
//        Collections.sort(opponent, new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return Integer.compare(o1.getDefence(), o2.getDefence());
//            }
//        });
//
//        opponentByDefence.addAll(opponent);
//        for (int i = 0; i < opponentByDefence.size() - 1; ++i) {
//            Character currentCharacter = opponentByDefence.get(i);
//            Character nextCharacter = opponentByDefence.get(i + 1);
//            if (currentCharacter.getDefence() == nextCharacter.getDefence()) {
//                comparePriorityDefence(i,i+1,opponentByDefence);
//            }}
//
//
//    }

//    public static void comparePrioritySpeed(int int1, int int2, ArrayList<Character> challenger) {
//        Character c1 = challenger.get(int1);
//        Character c2 = challenger.get(int2);
//        if (c1 instanceof Archer || c2 instanceof Archer) {
//            if (c1 instanceof Archer) {
//                challenger.set(int1, c1);
//                challenger.set(int2, c2);
//            } else {
//                challenger.set(int1, c2);
//                challenger.set(int2, c1);
//            }
//
//
//        } else if (c1 instanceof Knight || c2 instanceof Knight) {
//            if (c1 instanceof Knight) {
//                challenger.set(int1, c1);
//                challenger.set(int2, c2);
//            } else {
//                challenger.set(int1, c2);
//                challenger.set(int2, c1);
//            }
//
//        } else if (c1 instanceof MythicalCreature || c2 instanceof MythicalCreature) {
//            if (c1 instanceof MythicalCreature) {
//                challenger.set(int1, c1);
//                challenger.set(int2, c2);
//            } else {
//                challenger.set(int1, c2);
//                challenger.set(int2, c1);
//            }
//
//        } else if (c1 instanceof Mage || c2 instanceof Mage) {
//            if (c1 instanceof Mage) {
//                challenger.set(int1, c1);
//                challenger.set(int2, c2);
//            } else {
//                challenger.set(int1, c2);
//                challenger.set(int2, c1);
//            }
//
//        } else if (c1 instanceof Healer || c2 instanceof Healer) {
//            if (c1 instanceof Healer) {
//                challenger.set(int1, c1);
//                challenger.set(int2, c2);
//            } else {
//                challenger.set(int1, c2);
//                challenger.set(int2, c1);
//            }
//
//        }
//    }
//    public static void comparePriorityDefence(int int1, int int2, ArrayList<Character> challenger) {
        // Define the priority order

//        // Define the priority order
//        String priorityOrder = "Mage Knight Archer MythicalCreature Healer";
//
//        // Get the index of each character in the priority order
//        int index1 = priorityOrder.indexOf(c1.getClass().getSimpleName());
//        int index2 = priorityOrder.indexOf(c2.getClass().getSimpleName());
//
//        // Compare the indices to determine priority
//        return Integer.compare(index1, index2);
//        Character c1=challenger.get(int1);
//        Character c2=challenger.get(int2);
//       if (c1 instanceof Healer || c2 instanceof Healer) {
//           if (c1 instanceof Healer){
//               challenger.set(int1,c1);
//               challenger.set(int2,c2);
//           }
//           else{
//               challenger.set(int1,c2);
//               challenger.set(int2,c1);
//           }
//       }
//
//       else if (c1 instanceof MythicalCreature || c2 instanceof MythicalCreature) {
//           if (c1 instanceof MythicalCreature){
//               challenger.set(int1,c1);
//               challenger.set(int2,c2);
//           }
//           else{
//               challenger.set(int1,c2);
//               challenger.set(int2,c1);
//           }
//       }
//
//       else if (c1 instanceof Archer || c2 instanceof Archer) {
//           if (c1 instanceof Archer){
//               challenger.set(int1,c1);
//               challenger.set(int2,c2);
//           }
//           else{
//               challenger.set(int1,c2);
//               challenger.set(int2,c1);
//           }
//       }
//
//       else if (c1 instanceof Knight || c2 instanceof Knight) {
//           if (c1 instanceof Knight){
//               challenger.set(int1,c1);
//               challenger.set(int2,c2);
//           }
//           else{
//               challenger.set(int1,c2);
//               challenger.set(int2,c1);
//           }
//       }
//
//       else if (c1 instanceof Mage || c2 instanceof Mage) {
//           if (c1 instanceof Mage){
//               challenger.set(int1,c1);
//               challenger.set(int2,c2);
//           }
//           else{
//               challenger.set(int1,c2);
//               challenger.set(int2,c1);
//           }
//
//       }
//
//    }

    public static void homegroundFeatures(ArrayList<Character> player_1, ArrayList<Character> player_2) {

        // attacker_attack, attacker_defence, attacker_speed, opponent_attack, opponent_defence, opponent_speed
        if (opponentPlayer.getHomeGround().equals(HomeGround.Hilcrest)) {
            for (Character character_1 : player_1) {
                if (character_1 instanceof Highlander) {
                    character_1.setAttack(character_1.getAttack() + 1);
                    character_1.setDefence(character_1.getDefence() + 1);
                } else if (character_1 instanceof Marshlander || character_1 instanceof SunChildren) {
                    character_1.setSpeed(character_1.getSpeed() - 1);
                }

            }
            for (Character character_2 : player_2) {
                if (character_2 instanceof Highlander) {
                    character_2.setAttack(character_2.getAttack() + 1);
                    character_2.setDefence(character_2.getDefence() + 1);
                } else if (character_2 instanceof Marshlander || character_2 instanceof SunChildren) {
                    character_2.setSpeed(character_2.getSpeed() - 1);
                }
            }
        }


        if (opponentPlayer.getHomeGround().equals(HomeGround.Marshland)) {
            for (Character character_1 : player_1) {
                if (character_1 instanceof Marshlander) {
                    character_1.setDefence(character_1.getDefence() + 2);
                } else if (character_1 instanceof SunChildren) {
                    character_1.setAttack(character_1.getAttack() - 1);
                } else if (character_1 instanceof Mystics) {
                    character_1.setSpeed(character_1.getSpeed() - 1);
                }

            }
            for (Character character_2 : player_2) {
                if (character_2 instanceof Marshlander) {
                    character_2.setDefence(character_2.getDefence() + 2);
                } else if (character_2 instanceof SunChildren) {
                    character_2.setAttack(character_2.getAttack() - 1);
                } else if (character_2 instanceof Mystics) {
                    character_2.setSpeed(character_2.getSpeed() - 1);
                }

            }

        }

        if (opponentPlayer.getHomeGround().equals(HomeGround.Desert)) {
            for (Character character_1 : player_1) {
                if (character_1 instanceof SunChildren) {
                    character_1.setAttack(character_1.getAttack() + 1);
                } else if (character_1 instanceof Marshlander) {
                    character_1.setHealth(character_1.getHealth() - 1);
                }
            }
            for (Character character_2 : player_2) {
                if (character_2 instanceof SunChildren) {
                    character_2.setAttack(character_2.getAttack() + 1);
                } else if (character_2 instanceof Marshlander) {
                    character_2.setHealth(character_2.getHealth() - 1);
                }

            }
        }

        if (opponentPlayer.getHomeGround().equals(HomeGround.Arcane)) {
            for (Character character_1 : player_1) {
                if (character_1 instanceof Mystics) {
                    character_1.setAttack(character_1.getAttack() + 2);
                } else if (character_1 instanceof Marshlander || character_1 instanceof Highlander) {
                    character_1.setDefence(character_1.getDefence() - 1);
                }

            }
            for (Character character_2 : player_2) {
                if (character_2 instanceof Mystics) {
                    character_2.setAttack(character_2.getAttack() + 2);
                } else if (character_2 instanceof Marshlander || character_2 instanceof Highlander) {
                    character_2.setDefence(character_2.getDefence() - 1);
                    character_2.setSpeed(character_2.getSpeed() - 1);
                }

            }
        }

    }


    public static void normalAttack(Character A, Character B) {
        double healthAfterDecrease = B.getHealth() - (A.getAttack() * 0.5 - B.getDefence() * 0.1);
        B.setHealth(healthAfterDecrease);
    }

    public static void HighLanderHillcrestNormalAttack(Character A, Character B) {
        double healthAfterDecrease = B.getHealth() - (A.getAttack() * 0.5 * 0.2 - B.getDefence() * 0.1);
        B.setHealth(healthAfterDecrease);
    }

    public static void HighlanderHillcrestHealerAttack(Character A, Character B) {
        double healthAfterDecrease = B.getHealth() + (A.getAttack() * 0.1 * 0.2);
        B.setHealth(healthAfterDecrease);
    }

    public static void healerAttack(Character A, Character B) {
        double healthAfterDecrease = B.getHealth() + (A.getAttack() * 0.1);
        B.setHealth(healthAfterDecrease);
    }

    public static void increaseHealth(Character character) {
        double healthAfterIncrease = character.getHealth() + (character.getHealth() * 0.1);
        character.setHealth(healthAfterIncrease);
    }

    public static Character minimumHealthCharacter(ArrayList<Character> characters) {

        for (Character character : characters) {
            if (character.getHealth() == 0) {
                continue;
            }
            return character;
        }
       return null;
    }

    public static void battleBegin() {
        int countPlayerAttack = 0;
        int countPlayerDefence = 0;
        int countOpponentAttack = 0;
        int countOpponentDefence = 0;
        int countPlayerAttackloop = 5;
        int countOpponentAttackloop = 5;

        System.out.println("challengerBySpeed: ");

        for (Character ch : challengerBySpeed) {
            System.out.print(ch.getName() + " ");
        }
        System.out.println("\nChallengerByDefence: ");

        for (Character ch: challengerByDefence){
            System.out.print(ch.getName() + " ");
        }
        System.out.println("\nopponentBySpeed");

        for (Character ch : opponentBySpeed) {
            System.out.print(ch.getName()  + " ");
        }
        System.out.println("\nOpponentByDefence: ");

        for (Character ch: opponentByDefence){
            System.out.print(ch.getName() + " ");
        }
        System.out.println();



        for (int i = 1; i < 12; i++) {

            if (countPlayerDefence == 5) {
                System.out.println(Design.GREEN+opponentPlayer.getName() + " won!"+Design.RESET);
                opponentPlayer.incrementXP(1);
                opponentPlayer.setGoldCoins(opponentPlayer.getGoldCoins() + (int) (currentUser.getGoldCoins() * 0.1));
                currentUser.setGoldCoins(currentUser.getGoldCoins() - (int) (currentUser.getGoldCoins() * 0.1));
                UserService.updateFile();
                resetArrays();
                break;
            }
            if (countOpponentDefence == 5) {
                System.out.println(Design.GREEN+currentUser.getName() + " won!"+Design.RESET);
                currentUser.incrementXP(1);
                currentUser.setGoldCoins(currentUser.getGoldCoins() + (int) (opponentPlayer.getGoldCoins() * 0.1));
                opponentPlayer.setGoldCoins(opponentPlayer.getGoldCoins() - (int) (opponentPlayer.getGoldCoins() * 0.1));
                UserService.updateFile();
                resetArrays();
                break;
            }
            if ((countPlayerDefence < 5 && countOpponentDefence < 5) && i == 11 ) {
                System.out.println(Design.BLUE+"***********************************************************************************");
                System.out.println("                                    Draw               "+Design.RESET);
                resetArrays();
                break;
            }


            if (opponentPlayer.getHomeGround().equals(HomeGround.Hilcrest)) {
                if (challengerBySpeed.get(countPlayerAttack) instanceof Highlander && opponentBySpeed.get(countOpponentAttack) instanceof Highlander) {
                    if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                            healerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                            HighlanderHillcrestHealerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                        }
                        if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            healerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                            HighlanderHillcrestHealerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                        }
                    } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                            healerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                            HighlanderHillcrestHealerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                            HighLanderHillcrestNormalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                            Character character2 = challengerByDefence.get(countPlayerDefence);

                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET +"\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+ Design.RESET) : "") + "\n");

                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");

                            changeList(challengerBySpeed);
                            changeList(opponentBySpeed);
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);

                                countPlayerDefence++;
                            }
                            continue;
                        }
                        if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            healerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                            HighlanderHillcrestHealerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            HighLanderHillcrestNormalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            Character character1 = opponentByDefence.get(countOpponentDefence);

                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);

                                countOpponentDefence++;
                            }
                        }
                    }


                    if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                        normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                        HighLanderHillcrestNormalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                        Character character1 = opponentByDefence.get(countOpponentDefence);
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        if (character1.getHealth() <= 0) {
                            opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);

                            countOpponentDefence++;
                        }

                        normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                        HighLanderHillcrestNormalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                        Character character2 = challengerByDefence.get(countPlayerDefence);
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        if (character2.getHealth() <= 0) {
                            challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlaye
                            countPlayerDefence++;
                        }
                    }

                } else if (challengerBySpeed.get(countPlayerAttack) instanceof Highlander || opponentBySpeed.get(countOpponentAttack) instanceof Highlander) {
                    if (challengerBySpeed.get(countPlayerAttack) instanceof Highlander) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                                healerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                                HighlanderHillcrestHealerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                            }
                            if (opponentBySpeed.get(countOpponentAttack) instanceof Healer)
                                healerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                        } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                                healerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                                HighlanderHillcrestHealerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                                normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                                Character character2 = challengerByDefence.get(countPlayerDefence);
                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                        opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                        ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");

                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                        challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                        ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                if (character2.getHealth() <= 0) {
                                    challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));

                                    countPlayerDefence++;
                                }
                            }
                            if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                                healerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                                normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                                HighLanderHillcrestNormalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                                Character character1 = opponentByDefence.get(countOpponentDefence);
                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                        opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                        ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");

                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                        challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                        ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                if (character1.getHealth() <= 0) {
                                    opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));

                                    countOpponentDefence++;
                                }
                            }
                        }

                        if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            HighLanderHillcrestNormalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            Character character1 = opponentByDefence.get(countOpponentDefence);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));

                                countOpponentDefence++;
                            }

                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                            Character character2 = challengerByDefence.get(countPlayerDefence);
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));


                                countPlayerDefence++;
                            }
                        }
                    }
                    if (opponentBySpeed.get(countOpponentAttack) instanceof Highlander) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            if (challengerBySpeed.get(countPlayerAttack) instanceof Healer)
                                healerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                            if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                                healerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                                HighlanderHillcrestHealerAttack(opponentBySpeed.get(countOpponentAttack), minimumHealthCharacter(opponentByDefence));
                            }
                        } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                                healerAttack(challengerBySpeed.get(countPlayerAttack), minimumHealthCharacter(challengerByDefence));
                                normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                                HighLanderHillcrestNormalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                                Character character2 = challengerByDefence.get(countPlayerDefence);
                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                        opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                        ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");

                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                        challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                        ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                if (character2.getHealth() <= 0) {
                                    challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));

                                    countPlayerDefence++;
                                }
                            }
                            if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                                normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                                Character character1 = opponentByDefence.get(countOpponentDefence);
                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                        opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                        ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                changeList(challengerBySpeed);
                                if (character1.getHealth() <= 0) {
                                    opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                    //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                    countOpponentDefence++;
                                }


                                Character c2 = minimumHealthCharacter(opponentByDefence);
                                healerAttack(opponentBySpeed.get(countOpponentAttack), c2);
                                HighlanderHillcrestHealerAttack(opponentBySpeed.get(countOpponentAttack), c2);
                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c2.getName() + "\n" +
                                        c2.getName() + "'s health: " + c2.getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");


                                changeList(opponentBySpeed);
                                continue;
                            }
                            continue;
                        }


                        if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));

                            Character character1 = opponentByDefence.get(countOpponentDefence);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countOpponentDefence++;
                            }

                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                            HighLanderHillcrestNormalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));

                            Character character2 = challengerByDefence.get(countPlayerDefence);
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(opponentBySpeed);
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countPlayerDefence++;
                            }
                            continue;
                        }
                        continue;
                    }
                    continue;
                }

                if (!(challengerBySpeed.get(countPlayerAttack) instanceof Highlander && opponentBySpeed.get(countOpponentAttack) instanceof Highlander)) {
                    if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {

                        Character c3 = minimumHealthCharacter(challengerByDefence);
                        healerAttack(challengerBySpeed.get(countPlayerAttack), c3);
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c3.getName() + "\n" +
                                c3.getName() + "'s health: " + c3.getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");
                        changeList(challengerBySpeed);

                        Character c4 = minimumHealthCharacter(opponentByDefence);
                        healerAttack(opponentBySpeed.get(countOpponentAttack), c4);
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c4.getName() + "\n" +
                                c4.getName() + "'s health: " + c4.getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");
                        changeList(opponentBySpeed);

                        continue;

                    } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                            Character c1 = minimumHealthCharacter(challengerByDefence);
                            healerAttack(challengerBySpeed.get(countPlayerAttack), c1);
                            Character character2 = challengerByDefence.get(countPlayerDefence);

                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c1.getName() + "\n" +
                                    c1.getName() + "'s health: " + c1.getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");

                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));


                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            changeList(opponentBySpeed);
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countPlayerDefence++;
                            }
                            continue;
                        }
                        if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            Character character1 = opponentByDefence.get(countOpponentDefence);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countOpponentDefence++;
                            }
                        }
                        continue;
                    }


                    if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                        normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));

                        Character character1 = opponentByDefence.get(countOpponentDefence);
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(challengerBySpeed);
                        if (character1.getHealth() <= 0) {
                            opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countOpponentDefence++;
                        }

                        normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));

                        Character character2 = challengerByDefence.get(countPlayerDefence);
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(opponentBySpeed);
                        if (character2.getHealth() <= 0) {
                            challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countPlayerDefence++;
                        }
                    }
                }






























            } else if (opponentPlayer.getHomeGround().equals(HomeGround.Arcane)) {

                if (challengerBySpeed.get(countPlayerAttack) instanceof Mystics && opponentBySpeed.get(countOpponentAttack) instanceof Mystics) {
                    if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {

                        Character c3 = minimumHealthCharacter(challengerByDefence);
                        healerAttack(challengerBySpeed.get(countPlayerAttack), c3);
                        increaseHealth(challengerBySpeed.get(countPlayerAttack));
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c3.getName() + "\n" +
                                c3.getName() + "'s health: " + c3.getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");
                        changeList(challengerBySpeed);

                        Character c4 = minimumHealthCharacter(opponentByDefence);
                        healerAttack(opponentBySpeed.get(countOpponentAttack), c4);
                        increaseHealth(opponentBySpeed.get(countOpponentAttack));
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c4.getName() + "\n" +
                                c4.getName() + "'s health: " + c4.getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");
                        changeList(opponentBySpeed);

                        continue;

                    } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                            Character c1 = minimumHealthCharacter(challengerByDefence);
                            healerAttack(challengerBySpeed.get(countPlayerAttack), c1);
                            increaseHealth(challengerBySpeed.get(countPlayerAttack));
                            Character character2 = challengerByDefence.get(countPlayerDefence);

                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c1.getName() + "\n" +
                                    c1.getName() + "'s health: " + c1.getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");

                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                            increaseHealth(opponentBySpeed.get(countOpponentAttack));


                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            changeList(opponentBySpeed);
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countPlayerDefence++;
                            }
                            continue;
                        }
                        if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            increaseHealth(challengerBySpeed.get(countPlayerAttack));
                            Character character1 = opponentByDefence.get(countOpponentDefence);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countOpponentDefence++;
                            }


                            Character c2 = minimumHealthCharacter(opponentByDefence);
                            healerAttack(opponentBySpeed.get(countOpponentAttack), c2);
                            increaseHealth(opponentBySpeed.get(countOpponentAttack));
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c2.getName() + "\n" +
                                    c2.getName() + "'s health: " + c2.getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");


                            changeList(opponentBySpeed);
                            continue;
                        }
                        continue;
                    }


                    if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                        normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                        increaseHealth(challengerBySpeed.get(countPlayerAttack));

                        Character character1 = opponentByDefence.get(countOpponentDefence);
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(challengerBySpeed);
                        if (character1.getHealth() <= 0) {
                            opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countOpponentDefence++;
                        }

                        normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                        increaseHealth(opponentBySpeed.get(countOpponentAttack));

                        Character character2 = challengerByDefence.get(countPlayerDefence);
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(opponentBySpeed);
                        if (character2.getHealth() <= 0) {
                            challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countPlayerDefence++;
                        }
                        continue;
                    }
                    continue;


                } else if (challengerBySpeed.get(countPlayerAttack) instanceof Mystics || opponentBySpeed.get(countOpponentAttack) instanceof Mystics) {
                    if (challengerBySpeed.get(countPlayerAttack) instanceof Mystics) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {

                            Character c3 = minimumHealthCharacter(challengerByDefence);
                            healerAttack(challengerBySpeed.get(countPlayerAttack), c3);
                            increaseHealth(challengerBySpeed.get(countPlayerAttack));
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c3.getName() + "\n" +
                                    c3.getName() + "'s health: " + c3.getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");
                            changeList(challengerBySpeed);

                            Character c4 = minimumHealthCharacter(opponentByDefence);
                            healerAttack(opponentBySpeed.get(countOpponentAttack), c4);
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c4.getName() + "\n" +
                                    c4.getName() + "'s health: " + c4.getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");
                            changeList(opponentBySpeed);

                            continue;

                        } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                                Character c1 = minimumHealthCharacter(challengerByDefence);
                                healerAttack(challengerBySpeed.get(countPlayerAttack), c1);
                                increaseHealth(challengerBySpeed.get(countPlayerAttack));
                                Character character2 = challengerByDefence.get(countPlayerDefence);

                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c1.getName() + "\n" +
                                        c1.getName() + "'s health: " + c1.getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");

                                normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));


                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                        challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth() +Design.RESET+ "\n" +
                                        ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                changeList(challengerBySpeed);
                                changeList(opponentBySpeed);
                                if (character2.getHealth() <= 0) {
                                    challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                    //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                    countPlayerDefence++;
                                }
                                continue;
                            }
                            if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                                normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                                increaseHealth(challengerBySpeed.get(countPlayerAttack));
                                Character character1 = opponentByDefence.get(countOpponentDefence);
                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                        opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                        ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                changeList(challengerBySpeed);
                                if (character1.getHealth() <= 0) {
                                    opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                    //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                    countOpponentDefence++;
                                }


                                Character c2 = minimumHealthCharacter(opponentByDefence);
                                healerAttack(opponentBySpeed.get(countOpponentAttack), c2);
                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c2.getName() + "\n" +
                                        c2.getName() + "'s health: " + c2.getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");


                                changeList(opponentBySpeed);
                                continue;
                            }
                            continue;
                        }


                        if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            increaseHealth(challengerBySpeed.get(countPlayerAttack));

                            Character character1 = opponentByDefence.get(countOpponentDefence);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countOpponentDefence++;
                            }

                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));

                            Character character2 = challengerByDefence.get(countPlayerDefence);
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(opponentBySpeed);
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countPlayerDefence++;
                            }
                            continue;
                        }
                        continue;
                    }
                    if (opponentBySpeed.get(countOpponentAttack) instanceof Mystics) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {

                            Character c3 = minimumHealthCharacter(challengerByDefence);
                            healerAttack(challengerBySpeed.get(countPlayerAttack), c3);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c3.getName() + "\n" +
                                    c3.getName() + "'s health: " + c3.getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");
                            changeList(challengerBySpeed);

                            Character c4 = minimumHealthCharacter(opponentByDefence);
                            healerAttack(opponentBySpeed.get(countOpponentAttack), c4);
                            increaseHealth(opponentBySpeed.get(countOpponentAttack));
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c4.getName() + "\n" +
                                    c4.getName() + "'s health: " + c4.getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");
                            changeList(opponentBySpeed);

                            continue;

                        } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                                Character c1 = minimumHealthCharacter(challengerByDefence);
                                healerAttack(challengerBySpeed.get(countPlayerAttack), c1);
                                Character character2 = challengerByDefence.get(countPlayerDefence);

                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c1.getName() + "\n" +
                                        c1.getName() + "'s health: " + c1.getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");

                                normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                                increaseHealth(opponentBySpeed.get(countOpponentAttack));

                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                        challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                        ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                changeList(challengerBySpeed);
                                changeList(opponentBySpeed);
                                if (character2.getHealth() <= 0) {
                                    challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                    //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                    countPlayerDefence++;
                                }
                                continue;
                            }
                            if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                                normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                                Character character1 = opponentByDefence.get(countOpponentDefence);
                                System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                        Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                        opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                        challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                        ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                                changeList(challengerBySpeed);
                                if (character1.getHealth() <= 0) {
                                    opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                    //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                    countOpponentDefence++;
                                }


                                Character c2 = minimumHealthCharacter(opponentByDefence);
                                healerAttack(opponentBySpeed.get(countOpponentAttack), c2);
                                increaseHealth(opponentBySpeed.get(countOpponentAttack));
                                System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                        Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c2.getName() + "\n" +
                                        c2.getName() + "'s health: " + c2.getHealth() + "\n" +
                                        opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");


                                changeList(opponentBySpeed);
                                continue;
                            }
                            continue;
                        }


                        if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));

                            Character character1 = opponentByDefence.get(countOpponentDefence);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countOpponentDefence++;
                            }

                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));
                            increaseHealth(opponentBySpeed.get(countOpponentAttack));

                            Character character2 = challengerByDefence.get(countPlayerDefence);
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(opponentBySpeed);
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countPlayerDefence++;
                            }
                            continue;
                        }
                        continue;
                    }
                    continue;
                }

                if (!(challengerBySpeed.get(countPlayerAttack) instanceof Mystics && opponentBySpeed.get(countOpponentAttack) instanceof Mystics)) {
                    if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {

                        Character c3 = minimumHealthCharacter(challengerByDefence);
                        healerAttack(challengerBySpeed.get(countPlayerAttack), c3);
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c3.getName() + "\n" +
                                c3.getName() + "'s health: " + c3.getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");
                        changeList(challengerBySpeed);

                        Character c4 = minimumHealthCharacter(opponentByDefence);
                        healerAttack(opponentBySpeed.get(countOpponentAttack), c4);
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c4.getName() + "\n" +
                                c4.getName() + "'s health: " + c4.getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");
                        changeList(opponentBySpeed);

                        continue;

                    } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                        if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                            Character c1 = minimumHealthCharacter(challengerByDefence);
                            healerAttack(challengerBySpeed.get(countPlayerAttack), c1);
                            Character character2 = challengerByDefence.get(countPlayerDefence);

                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c1.getName() + "\n" +
                                    c1.getName() + "'s health: " + c1.getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");

                            normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));


                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                    challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                    ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            changeList(opponentBySpeed);
                            if (character2.getHealth() <= 0) {
                                challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countPlayerDefence++;
                            }
                            continue;
                        }
                        if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                            normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                            Character character1 = opponentByDefence.get(countOpponentDefence);
                            System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                    Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                    opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                    challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                    ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                            changeList(challengerBySpeed);
                            if (character1.getHealth() <= 0) {
                                opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                                //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                                countOpponentDefence++;
                            }


                            Character c2 = minimumHealthCharacter(opponentByDefence);
                            healerAttack(opponentBySpeed.get(countOpponentAttack), c2);
                            System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                    Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c2.getName() + "\n" +
                                    c2.getName() + "'s health: " + c2.getHealth() + "\n" +
                                    opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");


                            changeList(opponentBySpeed);
                            continue;
                        }
                        continue;
                    }


                    if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                        normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));

                        Character character1 = opponentByDefence.get(countOpponentDefence);
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(challengerBySpeed);
                        if (character1.getHealth() <= 0) {
                            opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countOpponentDefence++;
                        }

                        normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));

                        Character character2 = challengerByDefence.get(countPlayerDefence);
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(opponentBySpeed);
                        if (character2.getHealth() <= 0) {
                            challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countPlayerDefence++;
                        }
                        continue;
                    }
                    continue;
                }






















            } else {
                if (challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer) {

                    Character c3 = minimumHealthCharacter(challengerByDefence);
                    healerAttack(challengerBySpeed.get(countPlayerAttack), c3);
                    System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                            Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c3.getName() + "\n" +
                            c3.getName() + "'s health: " + c3.getHealth() + "\n" +
                            challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");
                    changeList(challengerBySpeed);

                    Character c4 = minimumHealthCharacter(opponentByDefence);
                    healerAttack(opponentBySpeed.get(countOpponentAttack), c4);
                    System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                            Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c4.getName() + "\n" +
                            c4.getName() + "'s health: " + c4.getHealth() + "\n" +
                            opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");
                    changeList(opponentBySpeed);

                continue;

                } else if (challengerBySpeed.get(countPlayerAttack) instanceof Healer || opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                    if (challengerBySpeed.get(countPlayerAttack) instanceof Healer) {
                        Character c1 = minimumHealthCharacter(challengerByDefence);
                        healerAttack(challengerBySpeed.get(countPlayerAttack), c1);
                        Character character2 = challengerByDefence.get(countPlayerDefence);

                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + c1.getName() + "\n" +
                                c1.getName() + "'s health: " + c1.getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n");

                        normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));


                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                                challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                                ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(challengerBySpeed);
                        changeList(opponentBySpeed);
                        if (character2.getHealth() <= 0) {
                            challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countPlayerDefence++;
                        }
                        continue;
                    }
                    if (opponentBySpeed.get(countOpponentAttack) instanceof Healer) {
                        normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));
                        Character character1 = opponentByDefence.get(countOpponentDefence);
                        System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                                Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                                opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                                challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                                ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                        changeList(challengerBySpeed);
                        if (character1.getHealth() <= 0) {
                            opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                            //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                            countOpponentDefence++;
                        }


                        Character c2 = minimumHealthCharacter(opponentByDefence);
                        healerAttack(opponentBySpeed.get(countOpponentAttack), c2);
                        System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                                Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + c2.getName() + "\n" +
                                c2.getName() + "'s health: " + c2.getHealth() + "\n" +
                                opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n");


                        changeList(opponentBySpeed);
                        continue;
                    }
                    continue;
                }


                if (!(challengerBySpeed.get(countPlayerAttack) instanceof Healer && opponentBySpeed.get(countOpponentAttack) instanceof Healer)) {
                    normalAttack(challengerBySpeed.get(countPlayerAttack), opponentByDefence.get(countOpponentDefence));

                    Character character1 = opponentByDefence.get(countOpponentDefence);
                    System.out.println("Turn " + i + ": " + currentUser.getName() + "\n" +
                            Design.GREEN+challengerBySpeed.get(countPlayerAttack).getName() + " attacks " + opponentByDefence.get(countOpponentDefence).getName() + "\n" +
                            opponentByDefence.get(countOpponentDefence).getName() + "'s health: " + opponentByDefence.get(countOpponentDefence).getHealth() + "\n" +
                            challengerBySpeed.get(countPlayerAttack).getName() + "'s health: " + challengerBySpeed.get(countPlayerAttack).getHealth()+Design.RESET + "\n" +
                            ((opponentByDefence.get(countOpponentDefence).getHealth() <= 0) ? (Design.RED+opponentByDefence.get(countOpponentDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                    changeList(challengerBySpeed);
                    if (character1.getHealth() <= 0) {
                        opponentBySpeed.removeIf(item -> item.getName().equals(character1.getName()));
                        //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                        countOpponentDefence++;
                    }

                    normalAttack(opponentBySpeed.get(countOpponentAttack), challengerByDefence.get(countPlayerDefence));

                    Character character2 = challengerByDefence.get(countPlayerDefence);
                    System.out.println("Turn " + i + ": " + opponentPlayer.getName() + "\n" +
                            Design.GREEN+opponentBySpeed.get(countOpponentAttack).getName() + " attacks " + challengerByDefence.get(countPlayerDefence).getName() + "\n" +
                            challengerByDefence.get(countPlayerDefence).getName() + "'s health: " + challengerByDefence.get(countPlayerDefence).getHealth() + "\n" +
                            opponentBySpeed.get(countOpponentAttack).getName() + "'s health: " + opponentBySpeed.get(countOpponentAttack).getHealth()+Design.RESET + "\n" +
                            ((challengerByDefence.get(countPlayerDefence).getHealth() <= 0) ? (Design.RED+challengerByDefence.get(countPlayerDefence).getName() + " died!"+Design.RESET) : "") + "\n");
                    changeList(opponentBySpeed);
                    if (character2.getHealth() <= 0) {
                        challengerBySpeed.removeIf(item -> item.getName().equals(character2.getName()));
                        //printStats(i,challengerBySpeed,opponentBySpeed,challengerByDefence,opponentByDefence,countPlayerAttack,countPlayerDefence,countOpponentAttack,countPlayerDefence);
                        countPlayerDefence++;
                    }
                    continue;
                }
            }





            copyOfAttackerArmy = new ArrayList<>();
            copyOfOpponentArmy = new ArrayList<>();



        }


    }




    public  static void ChangeInHealth(Character character){
        if (character.getHealth() < 0){
            character.setHealth(0);
        }

    }

    private static void resetArrays() {

        opponentArmy = new ArrayList<>();
        copyOfOpponentArmy = new ArrayList<>();
        opponentBySpeed = new ArrayList<>();
        opponentByDefence = new ArrayList<>();
        copyOfAttackerArmy = new ArrayList<>();
        challengerBySpeed = new ArrayList<>();

        challengerByDefence = new ArrayList<>();
        armyToBattle = new ArrayList<>();
    }

    public static void changeList(ArrayList<Character> list){
        Character temp=list.get(0);
        for (int i=0;i<list.size()-1;i++){
            list.set(i,list.get(i+1));
        }
        list.set(list.size()-1,temp);
    }



}




