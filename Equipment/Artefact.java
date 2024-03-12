package Equipment;

public class
Artefact {
    String name;
    double price;
    int attack;
    int defence;
    int health;
    int speed;

    public Artefact(String name, double price, int attack, int defence, int health, int speed) {
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


    public static Artefact[] getAllArtefacts() {
        return new Artefact[]{Excalibur, Amulet, Crystal};
    }
}
