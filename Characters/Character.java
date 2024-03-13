package Characters;

import Equipment.Armour;
import Equipment.Artefact;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

public class Character implements Serializable {
    private String name;
    private int price;
    private int attack;
    private int defence;
    private double health;
    private int speed;
    private Armour armour = null;
    private Artefact artefact = null;

    public Character(String name, int price, int attack, int defence, double health, int speed) {
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

    public void adjustStatsByArtefact(){
        if (this.artefact != null){
            if (Objects.equals(this.artefact.toString(), "Amulet")){
                health += Artefact.Amulet.getHealth();
                attack += Artefact.Amulet.getAttack();
                defence += Artefact.Amulet.getDefence();
                speed += Artefact.Amulet.getSpeed();
            } else if (Objects.equals(this.artefact.toString(), "Excalibur")){
                health += Artefact.Excalibur.getHealth();
                attack += Artefact.Excalibur.getAttack();
                defence += Artefact.Excalibur.getDefence();
                speed += Artefact.Excalibur.getSpeed();
            } else if (Objects.equals(this.artefact.toString(), "Crystal")){
                health += Artefact.Crystal.getHealth();
                attack += Artefact.Crystal.getAttack();
                defence += Artefact.Crystal.getDefence();
                speed += Artefact.Crystal.getSpeed();

            }
        }
    }

    public void adjustStatsByArmour(){
        if (this.armour != null)  {
            if (Objects.equals(this.armour.toString(), "Chainmail")){
                health += Armour.chainmail.getHealth();
                attack += Armour.chainmail.getAttack();
                defence += Armour.chainmail.getDefence();
                speed += Armour.chainmail.getSpeed();
            } else if (Objects.equals(this.armour.toString(), "Regalia")){
                health += Armour.regalia.getHealth();
                attack += Armour.regalia.getAttack();
                defence += Armour.regalia.getDefence();
                speed += Armour.regalia.getSpeed();
            } else if (Objects.equals(this.armour.toString(), "Fleece")){
                health += Armour.fleece.getHealth();
                attack += Armour.fleece.getAttack();
                defence += Armour.fleece.getDefence();
                speed += Armour.fleece.getSpeed();
            }
        }
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
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
        return String.format("| %-25s | %-10s | %-10s | %-10s | %-10s | %-10s |",
                getName() ,getPrice(), getAttack(), getDefence(), getHealth(), getSpeed());
    }
}


