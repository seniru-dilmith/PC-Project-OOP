package Equipment;

public class Armour {
    String name;
    double price;
    int attack;
    int defence;
    int health;
    int speed;

    public Armour(String name, double price, int attack, int defence, int health, int speed) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }

    public static Armour chainmail = new Armour("Chainmail", 70, 0, 1, 0, -1);
    public static Armour regalia = new Armour("Regalia", 105, 0, 1, 0, 0);
    public static Armour fleece = new Armour("Fleece", 150, 0, 1, 0, -1);

    // Optional: Static method to get an array of all instances
    public static Armour[] getAllArmours() {
        return new Armour[]{chainmail, regalia, fleece};
    }
}
