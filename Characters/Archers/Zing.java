package Characters.Archers;

import Characters.Categories.SunChildren;

public class Zing extends Archer implements SunChildren {
    public static Zing zing;
    public Zing(){
        super("Zing",200,16,9,11,14);
    }

    public static Zing getInstance(){
        if (zing == null){
            zing = new Zing();
        }
        return zing;
    }
}
