package Characters.MythicalCreatures;

import Characters.Categories.Marshlander;

public class Hydra extends MythicalCreature implements Marshlander {

    public static Hydra hydra;
    public Hydra() {
        super("Hydra", 205, 12, 16, 15, 11);
    }

    public static Hydra getInstance() {
        if (hydra == null) {
            hydra = new Hydra();
        }
        return hydra;
    }

}
