package Characters.MythicalCreatures;

import Characters.Categories.SunChildren;
import Characters.Mages.Eldritch;

public class Phoenix extends MythicalCreatures implements SunChildren {

    public static Phoenix phoenix;
    private Phoenix() {
        super("Phoenix", 275, 17, 13, 17, 19);
    }

    public static Phoenix getInstance() {
        if (phoenix == null) {
            phoenix = new Phoenix();
        }
        return phoenix;
    }

}

