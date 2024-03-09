package Characters.Mages;

import Characters.Categories.Category;
import Characters.Character;

public class Mage extends Character {
    public Mage(String name, double price, int attack, int defence, int health, int speed, Category category) {
        super(name, price, attack, defence, health, speed,category);
    }
}
