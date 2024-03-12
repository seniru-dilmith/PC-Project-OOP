package Characters.Healers;

import Characters.Categories.SunChildren;

public class Soother extends Healer implements SunChildren {

    public static Soother soother;
    private Soother() {
        super("Soother", 95, 10, 8, 9, 6);
    }

    public static Soother getInstance() {
        if (soother == null) {
            soother = new Soother();
        }
        return soother;
    }

}
