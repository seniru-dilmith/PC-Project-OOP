package Characters.MythicalCreatures;

import Characters.Categories.SunChildren;

public class Dragon extends MythicalCreature implements SunChildren {

    public static Dragon dragon;
    public Dragon() {

        super("Dragon", 120, 12, 14, 15, 8);
    }

    public static Dragon getInstance() {
        if (dragon == null) {
            dragon = new Dragon();
        }
        return dragon;
    }

}
