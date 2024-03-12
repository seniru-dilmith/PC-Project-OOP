package Characters;

import Equipment.Armour;
import Equipment.Artefact;

public class Character {
    private String name;
    private double price;
    private int attack;
    private int defence;
    private int health;
    private int speed;
    private Armour armour = null;
    private Artefact artefact = null;

    public Character(String name, double price, int attack, int defence, int health, int speed) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        armour = armour;
    }

    public Artefact getArtefact() {
        return artefact;
    }

    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "Price: " + getPrice() +
                "Attack: " + getAttack() +
                "Defence: " + getDefence() +
                "Health: " + getHealth() +
                "Speed: " + getSpeed();
    }
}


