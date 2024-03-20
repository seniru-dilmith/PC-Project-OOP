package login_signup;

import Characters.Archers.*;
import Characters.Character;
import Characters.Healers.*;
import Characters.Knights.*;
import Characters.Mages.*;
import Characters.MythicalCreatures.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class User implements Serializable {
    private int ID;
    private final String username;
    private final String password;
    private int XP;
    private int goldCoins;
    private String name;
    private HomeGround homeGround;
    private static final Archer
            ranger = new Ranger(),
            saggitarus = new Saggitarius(),
            shooter = new Shooter(),
            sunfire = new Sunfire(),
            zing = new Zing();
    private static Healer
            alchemist = new Alchemist(),
            lightBringer = new Lightbringer(),
            medic = new Medic(),
            saint = new Saint(),
            soother = new Soother();
    private static Knight
            cavalier = new Cavalier(),
            squire = new Squire(),
            templar = new Templar(),
            swiftblade = new Swiftblade(),
            zoro = new Zoro();
    private static Mage
            conjurer = new Conjurer(),
            eldritch = new Eldritch(),
            enchanter = new Enchanter(),
            illusionist = new Illusionist(),
            warlock = new Warlock();
    private static MythicalCreature
            basilisk = new Basilisk(),
            dragon = new Dragon(),
            hydra = new Hydra(),
            pegasus = new Pegasus(),
            phoenix = new Phoenix();

    private ArrayList<Archer> archers = new ArrayList<>();
    private ArrayList<Healer> healers = new ArrayList<>();
    private ArrayList<Knight> knights = new ArrayList<>();
    private ArrayList<Mage> mages = new ArrayList<>();
    private ArrayList<MythicalCreature> mythicalCreatures = new ArrayList<>();
    private static ArrayList<Archer> allArchers = new ArrayList<>(Arrays.asList(shooter, ranger, sunfire, zing, saggitarus)) ;

    private static ArrayList<Healer> allHealers = new ArrayList<>(Arrays.asList(soother, medic, alchemist, saint, lightBringer));
    private static ArrayList<Knight> allKnights = new ArrayList<>(Arrays.asList(squire, cavalier, templar, zoro, swiftblade));
    private static ArrayList<Mage> allMages = new ArrayList<>(Arrays.asList(warlock, illusionist, enchanter, conjurer, eldritch));
    private static ArrayList<MythicalCreature> allMythicalCreatures = new ArrayList<>(Arrays.asList(dragon, basilisk, hydra, phoenix, pegasus));

    public User(String username, String name, String password) {
        this.username = username;
        this.password = password;

        this.XP = 1;
        this.goldCoins = 5000;
        this.name = name;
        this.homeGround = null;
    }

    public User(String username, String name, String password, int number) {
        this.username = username;
        this.password = password;

        this.XP = 32;
        this.goldCoins = 1030;
        this.name = name;
        this.homeGround = null;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Archer> getAllArchers() {
        System.out.printf("| %-25s | %-10s | %-10s | %-10s | %-10s | %-10s |%n%n",
                "Name", "Price(gc)", "Attack", "Defence", "Health", "Speed");
        return allArchers;
    }

    public static ArrayList<Healer> getAllHealers() {
        System.out.printf("| %-25s | %-10s | %-10s | %-10s | %-10s | %-10s |%n%n",
                "Name", "Price(gc)", "Attack", "Defence", "Health", "Speed");
        return allHealers;
    }

    public static ArrayList<Knight> getAllKnights() {
        System.out.printf("| %-25s | %-10s | %-10s | %-10s | %-10s | %-10s |%n%n",
                "Name", "Price(gc)", "Attack", "Defence", "Health", "Speed");
        return allKnights;
    }

    public static ArrayList<Mage> getAllMages() {
        System.out.printf("| %-25s | %-10s | %-10s | %-10s | %-10s | %-10s |%n%n",
                "Name", "Price(gc)", "Attack", "Defence", "Health", "Speed");
        return allMages;
    }

    public static ArrayList<MythicalCreature> getAllMythicalCreatures() {
        System.out.printf("| %-25s | %-10s | %-10s | %-10s | %-10s | %-10s |%n%n",
                "Name", "Price(gc)", "Attack", "Defence", "Health", "Speed");
        return allMythicalCreatures;
    }



    public boolean armyIsReady(){
        boolean isArcher=archers.size()==0;
        boolean isHealer=healers.size()==0;
        boolean isMage=mages.size()==0;
        boolean isMythicalCreature=mythicalCreatures.size()==0;
        boolean isKnight=knights.size()==0;
        return (!(isKnight || isHealer || isArcher || isMythicalCreature||isMage));
    }

    private static Archer cloneArcher(Archer archer){ //clone archer to send
        Archer clonedArcher = null;
        if(archer instanceof Shooter){
            clonedArcher = new Shooter();
            clonedArcher.copy(archer);
        } else if(archer instanceof Ranger){
            clonedArcher = new Ranger();
            clonedArcher.copy(archer);
        }else if(archer instanceof Sunfire){
            clonedArcher = new Sunfire();
            clonedArcher.copy(archer);
        }else if(archer instanceof Zing){
            clonedArcher = new Zing();
            clonedArcher.copy(archer);
        }else if(archer instanceof Saggitarius){
            clonedArcher = new Saggitarius();
            clonedArcher.copy(archer);
        }
        return clonedArcher;
    }

    private static MythicalCreature cloneCreature(MythicalCreature mythicalCreature){ //clone archer to send
        MythicalCreature clonedCreature = null;
        if(mythicalCreature instanceof Dragon){
            clonedCreature = new Dragon();
            clonedCreature.copy(mythicalCreature);
        } else if(mythicalCreature instanceof Basilisk){
            clonedCreature = new Basilisk();
            clonedCreature.copy(mythicalCreature);
        }else if(mythicalCreature instanceof Hydra){
            clonedCreature = new Hydra();
            clonedCreature.copy(mythicalCreature);
        }else if(mythicalCreature instanceof Phoenix){
            clonedCreature = new Phoenix();
            clonedCreature.copy(mythicalCreature);
        }else if(mythicalCreature instanceof Pegasus){
            clonedCreature = new Pegasus();
            clonedCreature.copy(mythicalCreature);
        }
        return clonedCreature;
    }

    private static Healer cloneHealer(Healer healer){ //clone archer to send
        Healer clonedHealer = null;
        if(healer instanceof Soother){
            clonedHealer = new Soother();
            clonedHealer.copy(healer);
        } else if(healer instanceof Medic){
            clonedHealer = new Medic();
            clonedHealer.copy(healer);
        }else if(healer instanceof Alchemist){
            clonedHealer = new Alchemist();
            clonedHealer.copy(healer);
        }else if(healer instanceof Saint){
            clonedHealer = new Saint();
            clonedHealer.copy(healer);
        }else if(healer instanceof Lightbringer){
            clonedHealer = new Lightbringer();
            clonedHealer.copy(healer);
        }
        return clonedHealer;
    }

    private static Mage cloneMage(Mage mage){ //clone archer to send
        Mage clonedMage = null;
        if(mage instanceof Warlock){
            clonedMage = new Warlock();
            clonedMage.copy(mage);
        } else if(mage instanceof Illusionist){
            clonedMage = new Illusionist();
            clonedMage.copy(mage);
        }else if(mage instanceof Enchanter){
            clonedMage = new Enchanter();
            clonedMage.copy(mage);
        }else if(mage instanceof Conjurer){
            clonedMage = new Conjurer();
            clonedMage.copy(mage);
        }else if(mage instanceof Eldritch){
            clonedMage = new Eldritch();
            clonedMage.copy(mage);
        }
        return clonedMage;
    }

    private static Knight cloneKnight(Knight knight){ //clone archer to send
        Knight clonedKnight = null;
        if(knight instanceof Squire){
            clonedKnight = new Squire();
            clonedKnight.copy(knight);
        } else if(knight instanceof Cavalier){
            clonedKnight = new Cavalier();
            clonedKnight.copy(knight);
        }else if(knight instanceof Templar){
            clonedKnight = new Templar();
            clonedKnight.copy(knight);
        }else if(knight instanceof Zoro){
            clonedKnight = new Zoro();
            clonedKnight.copy(knight);
        }else if(knight instanceof Swiftblade){
            clonedKnight = new Swiftblade();
            clonedKnight.copy(knight);
        }
        return clonedKnight;
    }


    public Vector<Character> getBattleArmy(){
        Vector<Character> army=new Vector<>();
        if (!archers.isEmpty()){
            army.add(cloneArcher(archers.getLast()));
        }

        if (!healers.isEmpty()){
            army.add(cloneHealer(healers.getLast()));
        }
        if (!mages.isEmpty()){
            army.add(cloneMage(mages.getLast()));
        }
        if (!mythicalCreatures.isEmpty()){
            army.add(cloneCreature(mythicalCreatures.getLast()));
        }
        if (!knights.isEmpty()){
            army.add(cloneKnight(knights.getLast()));
        }
        return army;
    }

    public ArrayList<Archer> getArchers() {
        return archers;
    }

    public ArrayList<Healer> getHealers() {
        return healers;
    }

    public ArrayList<Knight> getKnights() {
        return knights;
    }

    public ArrayList<Mage> getMages() {
        return mages;
    }

    public ArrayList<MythicalCreature> getMythicalCreatures() {
        return mythicalCreatures;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setHomeGround(HomeGround homeGround) {
        this.homeGround = homeGround;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public int getXP() {
        return XP;
    }
    public void incrementXP(int XP) {
        this.XP += XP;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = Math.round(goldCoins);
    }

    // archer getters
    public static Archer getRanger() {
        return ranger;
    }

    public static Archer getSaggitarus() {
        return saggitarus;
    }

    public static Archer getShooter() {
        return shooter;
    }

    public static Archer getSunfire() {
        return sunfire;
    }

    public static Archer getZing() {
        return zing;
    }

    // healer getters
    public static Healer getAlchemist() {
        return alchemist;
    }

    public static Healer getLightBringer() {
        return lightBringer;
    }

    public static Healer getMedic() {
        return medic;
    }

    public static Healer getSaint() {
        return saint;
    }

    public static Healer getSoother() {
        return soother;
    }

    // knight getters

    public static Knight getCavalier() {
        return cavalier;
    }

    public static Knight getSquire() {
        return squire;
    }

    public static Knight getTemplar() {
        return templar;
    }

    public static Knight getSwiftblade() {
        return swiftblade;
    }

    public static Knight getZoro() {
        return zoro;
    }

    // mage getters
    public static Mage getConjurer() {
        return conjurer;
    }

    public static Mage getEldritch() {
        return eldritch;
    }

    public static Mage getEnchanter() {
        return enchanter;
    }

    public static Mage getIllusionist() {
        return illusionist;
    }

    public static Mage getWarlock() {
        return warlock;
    }

    //mythical creature getters
    public static MythicalCreature getBasilisk() {
        return basilisk;
    }

    public static MythicalCreature getDragon() {
        return dragon;
    }

    public static MythicalCreature getHydra() {
        return hydra;
    }

    public static MythicalCreature getPegasus() {
        return pegasus;
    }

    public static MythicalCreature getPhoenix() {
        return phoenix;
    }

    public HomeGround getHomeGround() {
        return homeGround;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printCurrentArmy(){
        System.out.println("----------------------------------------------Current Army----------------------------------------------");
        System.out.println(String.format("| %-35s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "Name", "Price(gc)", "Attack", "Defence", "Health", "Speed"));

        System.out.println("Archers : ");
        for (Archer archer : archers){
            System.out.println(String.format("| %-35s | %-10s | %-10s | %-10s | %-10s | %-10s |",
                    archer.getName() +
                            ((archer.getArmour() != null) ? (" + " + archer.getArmour().toString()) : "") +
                            ((archer.getArtefact() != null) ? (" + " + archer.getArtefact().toString()) : ""),
                    archer.getPrice(), archer.getAttack(), archer.getDefence(),archer.getHealth(),archer.getSpeed()));
        }
        System.out.println();

        System.out.println("Knights : ");
        for (Knight knight : knights){
            System.out.println(String.format("| %-35s | %-10s | %-10s | %-10s | %-10s | %-10s |",
                    knight.getName() +
                            ((knight.getArmour() != null) ? (" + " + knight.getArmour().toString()) : "") +
                            ((knight.getArtefact() != null) ? (" + " + knight.getArtefact().toString()) : ""),
                    knight.getPrice(),knight.getAttack(), knight.getDefence(),knight.getHealth(),knight.getSpeed()));
        }
        System.out.println();

        System.out.println("Mages : ");
        for (Mage mage : mages){
            System.out.println(String.format("| %-35s | %-10s | %-10s | %-10s | %-10s | %-10s |",
                    mage.getName() +
                            ((mage.getArmour() != null) ? (" + " + mage.getArmour().toString()) : "") +
                            ((mage.getArtefact() != null) ? (" + " + mage.getArtefact().toString()) : ""),
                    mage.getPrice(), mage.getAttack(), mage.getDefence(),mage.getHealth(),mage.getSpeed()));
        }
        System.out.println();

        System.out.println("Healers : ");
        for (Healer healer : healers) {
            System.out.println(String.format("| %-35s | %-10s | %-10s | %-10s | %-10s | %-10s |",
                    healer.getName() +
                            ((healer.getArmour() != null) ? (" + " + healer.getArmour().toString()) : "") +
                            ((healer.getArtefact() != null) ? (" + " + healer.getArtefact().toString()) : ""),
                    healer.getPrice(), healer.getAttack(), healer.getDefence(), healer.getHealth(), healer.getSpeed()));
        }
        System.out.println();

        System.out.println("Mythical Creatures : ");
        for (MythicalCreature mythicalCreature : mythicalCreatures){
            System.out.println(String.format("| %-35s | %-10s | %-10s | %-10s | %-10s | %-10s |",
                    mythicalCreature.getName() +
                            ((mythicalCreature.getArmour() != null) ? (" + " + mythicalCreature.getArmour().toString()) : "") +
                            ((mythicalCreature.getArtefact() != null) ? (" + " + mythicalCreature.getArtefact().toString()) : ""),
                    mythicalCreature.getPrice(), mythicalCreature.getAttack(), mythicalCreature.getDefence(),mythicalCreature.getHealth(),mythicalCreature.getSpeed()));
        }


    }
    @Override
    public String toString() {
        return  "---------------------------------------------Player Details---------------------------------------------\n" +
                "=>ID: " + ID +
                "\n=>Name: " + name +
                "\n=>Username: " + username +
                "\n=>XP: " + XP +
                "\n=>Gold Coins: " + goldCoins + "gc" +
                "\n=>Home Ground: " + ((homeGround == null) ? "Not decided yet" : homeGround.toString()) +
                "\n--------------------------------------------------------------------------------------------------------";
    }
}

