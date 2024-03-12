package Characters.MythicalCreatures;

import Characters.Categories.Marshlander;

public class Basilisk extends MythicalCreature implements Marshlander {

    public static Basilisk basilisk;
    private  Basilisk() {

        super("Basilisk", 165, 15, 11, 10, 12);
    }

    public static Basilisk getInstance() {
        if (basilisk == null) {
            basilisk = new Basilisk();
        }
        return basilisk;
    }

}
