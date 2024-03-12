package Characters.MythicalCreatures;

import Characters.Categories.Marshlander;
import Characters.Mages.Eldritch;

public class Hydra extends MythicalCreatures implements Marshlander {

    public static Hydra hydra;
    private Hydra() {
        super("Hydra", 205, 12, 16, 15, 11);
    }

    public static Hydra getInstance() {
        if (hydra == null) {
            hydra = new Hydra();
        }
        return hydra;
    }

}
