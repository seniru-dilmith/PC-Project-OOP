package Characters.Mages;

import Characters.Categories.Highlander;

public class Enchanter extends Mage implements Highlander {

    public static Enchanter enchanter;
    public Enchanter() {

        super("Enchanter", 160, 16, 10, 13, 16);
    }

    public static Enchanter getInstance() {
        if ( enchanter== null) {
            enchanter = new Enchanter();
        }
        return enchanter;
    }

}
