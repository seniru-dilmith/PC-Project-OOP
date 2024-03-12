package Characters.Mages;

import Characters.Categories.Marshlander;

public class Warlock extends Mage implements Marshlander {

    public static Warlock warlock;
    private Warlock() {

        super("Warlock", 100, 12, 7, 10, 12);
    }
    public static Warlock getInstance() {
        if (warlock == null) {
            warlock = new Warlock();
        }
        return warlock;
    }

}
