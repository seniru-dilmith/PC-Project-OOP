package Characters.Healers;

import Characters.Categories.Mystics;

public class Saint extends Healer implements Mystics {

    public static Saint saint;
    public Saint() {
        super("Saint", 200, 16, 14, 17, 9);
    }

    public static Saint getInstance() {
        if (saint == null) {
            saint = new Saint();
        }
        return saint;
    }
}
