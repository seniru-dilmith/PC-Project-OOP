package login_signup;

import Characters.Archers.Archer;
import Characters.Archers.Ranger;
import Characters.Healers.Healer;
import Characters.Knights.Knight;
import Characters.Mages.Mage;
import Characters.MythicalCreatures.MythicalCreature;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static int count = 0;
    private int ID;
    private String username;
    private String password;
    private int XP;
    private double goldCoins;
    private String name;
    private HomeGround homeGround;
    private Archer ranger = new Ranger(), saggitarus, shooter, sunfire, zing;
    private Healer alchemist, lightBringer, medic, saint, soother;
    private Knight cavalier, squires, templar, swiftblade, zoro;
    private Mage conjurer, eldritch, enchanter, illusionist, warlock;
    private MythicalCreature basilisk, dragon, hydra, pegasus, phoenix;

    private ArrayList<Archer> archers = new ArrayList<>();
    private ArrayList<Healer> healers = new ArrayList<>();
    private ArrayList<Knight> knights = new ArrayList<>();
    private ArrayList<Mage> mages = new ArrayList<>();
    private ArrayList<MythicalCreature> mythicalCreatures = new ArrayList<>();

    private static ArrayList<Archer> allArchers = new ArrayList<>();
    private static ArrayList<Healer> allHealers = new ArrayList<>();
    private static ArrayList<Knight> allKnights = new ArrayList<>();
    private static ArrayList<Mage> allMages = new ArrayList<>();
    private static ArrayList<MythicalCreature> allMythicalCreatures = new ArrayList<>();

    public ArrayList<Archer> getAllArchers() {
        allArchers.add(ranger);
        allArchers.add(saggitarus);
        allArchers.add(shooter);
        allArchers.add(sunfire);
        allArchers.add(zing);
        return allArchers;
    }

    public ArrayList<Healer> getAllHealers() {
        allHealers.add(alchemist);
        allHealers.add(lightBringer);
        allHealers.add(medic);
        allHealers.add(saint);
        allHealers.add(soother);
        return allHealers;
    }

    public ArrayList<Knight> getAllKnights() {
        allKnights.add(cavalier);
        allKnights.add(squires);
        allKnights.add(templar);
        allKnights.add(swiftblade);
        allKnights.add(zoro);
        return allKnights;
    }

    public ArrayList<Mage> getAllMages() {
        allMages.add(conjurer);
        allMages.add(eldritch);
        allMages.add(enchanter);
        allMages.add(illusionist);
        allMages.add(warlock);
        return allMages;
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

    public User(String username, String name, String password) {
        this.username = username;
        this.password = password;

        this.XP = 1;
        this.goldCoins = 500;
        this.name = name;
        this.homeGround = null;
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

    public double getGoldCoins() {
        return goldCoins;
    }

    @Override
    public String toString() {
        return  "----------------------------------Player Details----------------------------------\n" +
                "=>ID: " + ID +
                "\n=>Name: " + name +
                "\n=>Username: " + username +
                "\n=>XP: " + XP +
                "\n=>Gold Coins: " + goldCoins + "gp" +
                "\n=>Home Ground: " + ((homeGround == null) ? "Not decided yet" : homeGround.toString()) +
                "\n---------------------------------------------------------------------------------";
    }

    public Archer getRanger() {
        return ranger;
    }

    public Archer getSaggitarus() {
        return saggitarus;
    }

    public Archer getShooter() {
        return shooter;
    }

    public Archer getSunfire() {
        return sunfire;
    }

    public Archer getZing() {
        return zing;
    }

    public Healer getAlchemist() {
        return alchemist;
    }

    public Healer getLightBringer() {
        return lightBringer;
    }

    public Healer getMedic() {
        return medic;
    }

    public Healer getSaint() {
        return saint;
    }

    public Healer getSoother() {
        return soother;
    }

    public Knight getCavalier() {
        return cavalier;
    }

    public Knight getSquires() {
        return squires;
    }

    public Knight getTemplar() {
        return templar;
    }

    public Knight getSwiftblade() {
        return swiftblade;
    }

    public Knight getZoro() {
        return zoro;
    }

    public Mage getConjurer() {
        return conjurer;
    }

    public Mage getEldritch() {
        return eldritch;
    }

    public Mage getEnchanter() {
        return enchanter;
    }

    public Mage getIllusionist() {
        return illusionist;
    }

    public Mage getWarlock() {
        return warlock;
    }

    public MythicalCreature getBasilisk() {
        return basilisk;
    }

    public MythicalCreature getDragon() {
        return dragon;
    }

    public MythicalCreature getHydra() {
        return hydra;
    }

    public MythicalCreature getPegasus() {
        return pegasus;
    }

    public MythicalCreature getPhoenix() {
        return phoenix;
    }
}

