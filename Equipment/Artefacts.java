package Equipment;

public class
Artefacts {
    String name;
    double price;
    int attack;
    int defence;
    int health;
    int speed;

    public Artefacts(String name, double price, int attack, int defence, int health, int speed) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
    }

    public static Artefacts Excalibur = new Artefacts("Excalibur", 150, 2, 0, 0, 0);
    public static Artefacts Amulet = new Artefacts("Amulet", 200, 1, -1, 1, 1);
    public static Artefacts Crystal = new Artefacts("Crystal", 210, 2, 1, -1, -1);


    public static Artefacts[] getAllArtefacts() {
        return new Artefacts[]{Excalibur, Amulet, Crystal};
    }
}
