package Characters.Mages;

import Characters.Categories.Mystics;

public class Eldritch extends Mage implements Mystics {

    public static Eldritch eldritch;
    public Eldritch() {

        super("Eldritch", 270, 19, 17, 18, 14);
    }

    public static Eldritch getInstance() {
        if (eldritch == null) {
            eldritch = new Eldritch();
        }
        return eldritch;
    }


}
