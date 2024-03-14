package Characters.Mages;

import Characters.Archers.Ranger;
import Characters.Categories.Highlander;

public class Conjurer extends Mage implements Highlander {

    public static Conjurer conjurer;

    public Conjurer() {

        super("Conjurer", 195, 18, 15, 14, 12);
    }
    public static Conjurer getInstance() {
        if (conjurer == null) {
            conjurer = new Conjurer();
        }
        return conjurer;
    }


}

