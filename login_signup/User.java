package login_signup;

import java.io.Serializable;

public class User implements Serializable {
    private static int count = 0;
    private int ID ;
    private String username;
    private String password;
    private int XP;
    private double goldCoins;
    private Army army;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.ID = ++count;
        this.XP = 1;
        this.goldCoins = 500;

    }

    private class Army {
        private static Archer archers;
        private static Healer healers;
        private static Knight knights;
        private static Mage mages;
        private static MythicalCreature mythicalCreatures;

        private class Archer {
            public static int shooters = 0, rangers = 0, sunfires = 0, zings = 0, saggitariuses = 0;
        }

        private class Healer{
            public static int alchemists = 0, lightbringers = 0, medics = 0, saints = 0, soothers = 0;
        }

        private class Knight{
            public static int squires = 0, cavaliers = 0, templars = 0, zoros = 0, swiftblades = 0;
        }

        private class Mage{
            public static int conjurers = 0, eldritches = 0, enchanters = 0, illusionists = 0, warlocks = 0;
        }

        private class MythicalCreature{
            public static int basilliks = 0, dragons = 0, hydras = 0, pegasuses = 0, pheonixes = 0;
        }
    }



//    Username: whitewolf
//    XP: 32
//    Gold coins: 215
//    Homeground: Marshland
//    Archer: Ranger + Chainmail
//    Knight: Squire
//    Mage: Warlock
//    Healer: Medic + Amulet
//    Mythical Creature: Dragon

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
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
        return  "ID: " + ID +
                "\nusername: " + username +
                "\nXP: " + XP +
                "\ngoldCoins: " + goldCoins;
    }
}

