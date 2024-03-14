package Equipment;

import java.io.Serializable;

public class Artefact implements Serializable, Equipments {
    String name;
    int price;
    int attack;
    int defence;
    int health;
    int speed;

    public Artefact(String name, int price, int attack, int defence, int health, int speed) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }

    public static Artefact Excalibur = new Artefact("Excalibur", 150, 2, 0, 0, 0);
    public static Artefact Amulet = new Artefact("Amulet", 200, 1, -1, 1, 1);
    public static Artefact Crystal = new Artefact("Crystal", 210, 2, 1, -1, -1);

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
