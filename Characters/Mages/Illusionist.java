package Characters.Mages;

import Characters.Categories.Mystics;

public class Illusionist extends Mage implements Mystics {

    public static Illusionist illusionist;
    public Illusionist() {

        super("Illusionist", 120, 13, 8, 12, 14);
    }

    public static Illusionist getInstance() {
        if (illusionist == null) {
            illusionist = new Illusionist();
        }
        return illusionist;
    }


}
