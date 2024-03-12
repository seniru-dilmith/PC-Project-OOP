package Characters.MythicalCreatures;

import Characters.Categories.Mystics;
import Characters.Mages.Eldritch;

public class Pegasus extends MythicalCreatures implements Mystics {

    public static Pegasus pegasus;

    private Pegasus() {
        super("Pegasus", 340, 14, 18, 20, 20);
    }


    public static Pegasus getInstance() {
        if (pegasus == null) {
            pegasus = new Pegasus();
        }
        return pegasus;
    }
}

