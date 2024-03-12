package Characters.Healers;

import Characters.Categories.Marshlander;

public class Alchemist extends Healer implements Marshlander {

    public static Alchemist alchemist;
    private Alchemist() {
        super("Alchemist", 150, 13, 13, 13, 13);
    }

    public static Healer getInstance() {
        if (alchemist == null) {
            alchemist = new Alchemist();
        }
        return alchemist;
    }
}
