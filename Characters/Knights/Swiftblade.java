package Characters.Knights;

import Characters.Categories.Marshlander;

public class Swiftblade extends Knight implements Marshlander {
    public static Swiftblade swiftblade;
    private Swiftblade(){
        super("Swiftblade",250,18,20,17,13);
    }

    public static Swiftblade getInstance(){
        if (swiftblade == null){
            swiftblade= new Swiftblade();
        }
        return swiftblade;
    }
}
