package Characters.MythicalCreatures;

import Characters.Categories.SunChildren;
import Characters.Mages.Eldritch;

public class Dragon extends MythicalCreatures implements SunChildren {

    public static Dragon dragon;
    private Dragon() {

        super("Dragon", 120, 12, 14, 15, 8);
    }

    public static Dragon getInstance() {
        if (dragon == null) {
            dragon = new Dragon();
        }
        return dragon;
    }

}
