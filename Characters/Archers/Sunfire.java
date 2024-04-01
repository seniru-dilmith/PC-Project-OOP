package Characters.Archers;

import Characters.Categories.SunChildren;

public class Sunfire extends Archer implements SunChildren {

    public static Sunfire sunfire;

    public Sunfire(){
        super("Sunfire", 160, 15, 5, 7,14);
    }

    public static Sunfire getInstance() {
        if (sunfire == null) {
            sunfire = new Sunfire();
        }
        return sunfire;
    }


}
