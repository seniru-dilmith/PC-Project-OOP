package Characters.Mages;

import Characters.Categories.Mystics;

public class Illusionist extends Mage implements Mystics {

    public static Illusionist illusionist;
    private Illusionist() {

        super("Illusionist", 120.0, 13, 8, 12, 14);
    }

    public static Illusionist getInstance() {
        if (illusionist == null) {
            illusionist = new Illusionist();
        }
        return illusionist;
    }


}
