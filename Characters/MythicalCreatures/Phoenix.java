package Characters.MythicalCreatures;

import Characters.Categories.SunChildren;

public class Phoenix extends MythicalCreature implements SunChildren {

    public static Phoenix phoenix;
    public Phoenix() {
        super("Phoenix", 275, 17, 13, 17, 19);
    }

    public static Phoenix getInstance() {
        if (phoenix == null) {
            phoenix = new Phoenix();
        }
        return phoenix;
    }

}

