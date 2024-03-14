package Characters.Healers;

import Characters.Categories.SunChildren;

public class Lightbringer extends Healer implements SunChildren {

    public static Lightbringer lightbringer;
    public Lightbringer() {
        super("Lightbringer", 260, 17, 15, 19, 12);
    }

    public static Lightbringer getInstance() {
        if (lightbringer == null) {
            lightbringer = new Lightbringer();
        }
        return lightbringer;
    }

}
