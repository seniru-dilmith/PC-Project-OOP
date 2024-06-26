package Equipment;

import java.io.Serializable;

public class Armour implements Serializable, Equipments {
    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;

    public Armour(String name, int price, int attack, int defence, int health, int speed) {
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

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String viewDetails() {
        return "\t(Price: " + price +
                " Attack: " + attack +
                " Defence: " + defence +
                " Health: " + health +
                " Speed: " + speed + ")";
    }
}
