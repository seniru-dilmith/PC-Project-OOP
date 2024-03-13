package Characters.Archers;

import Characters.Categories.Highlander;

public class Shooter extends Archer implements Highlander {

    public static Shooter shooter;

    public Shooter() {
        super("Shooter", 80, 11, 4, 6, 9);
    }

    public static Shooter getInstance() {
        if (shooter == null) {
            shooter = new Shooter();
        }
        return shooter;
    }


}
