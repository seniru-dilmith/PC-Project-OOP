package Characters.Healers;

import Characters.Categories.Highlander;
import Characters.Categories.Marshlander;

public class Medic extends Healer implements Highlander {
    public static Medic medic;
    public Medic() {
        super("Medic", 125, 12, 9, 10, 7);
    }

    public static Medic getInstance() {
        if (medic == null) {
            medic = new Medic();
        }
        return medic;
    }

}
