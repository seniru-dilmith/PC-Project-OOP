package Characters.Archers;

import Characters.Categories.Highlander;

public class Ranger extends Archer implements Highlander {

    public static Ranger ranger;
    public Ranger() {
        super("Ranger", 115, 14, 5, 8,10);
    }
    public static Ranger getInstance() {
        if (ranger == null) {
            ranger = new Ranger();
        }
        return ranger;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
