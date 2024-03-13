package Characters.Archers;

import Characters.Categories.Mystics;

public class Saggitarius extends Archer implements Mystics {

    public static Saggitarius saggitarius;

    public Saggitarius(){
        super("Saggitarius",230,18,7,12,17);
    }

    public static Saggitarius getInstance() {
        if (saggitarius == null) {
            saggitarius = new Saggitarius();
        }
        return saggitarius;
    }

}
